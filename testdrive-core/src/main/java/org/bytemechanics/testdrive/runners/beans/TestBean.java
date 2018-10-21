/*
 * Copyright 2018 Byte Mechanics.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.bytemechanics.testdrive.runners.beans;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import org.bytemechanics.testdrive.Specification;
import org.bytemechanics.testdrive.adapter.TestId;
import org.bytemechanics.testdrive.annotations.Evaluation;
import org.bytemechanics.testdrive.annotations.Test;
import org.bytemechanics.testdrive.exceptions.SpecificationNotInstantiable;

/**
 *
 * @author afarre
 */
public class TestBean extends SpecificationBean implements TestId {
	
	private final Specification specification;
	
	private final Method testMethod;
	private final String testName;
	private final Class[] testMethodParameters;
	private ResultBean testResult;

	public TestBean(final SpecificationBean _specification,final Method _method) {
		super(_specification);
		this.testMethod = _method;
		this.testName =  Optional.ofNullable(_method)
									.filter(clazz -> clazz.isAnnotationPresent(Test.class))
									.map(clazz -> clazz.getAnnotation(Test.class))
									.map(Test::name)
									.orElse(_method.getName());
		this.testMethodParameters=Optional.ofNullable(_method)
											.map(Method::getParameterTypes)
											.orElseGet(() -> new Class[0]);
		this.specification=_specification.getSpecificationSupplier()
											.get()
											.orElseThrow(() -> new SpecificationNotInstantiable(_specification.getSpecificationClass()));
		this.testResult=null;
	}

	public TestBean(final TestBean _test) {
		super(_test);
		this.testMethod = _test.getTestMethod();
		this.testName = _test.getTestName();
		this.testMethodParameters = _test.getTestMethodParameters();
		this.testResult = _test.getTestResult();
		this.specification=_test.getSpecification();
	}

	public Specification getSpecification() {
		return specification;
	}
	@Override
	public Method getTestMethod() {
		return testMethod;
	}
	@Override
	public Class[] getTestMethodParameters() {
		return testMethodParameters;
	}
	@Override
	public String getTestName() {
		return testName;
	}
	public ResultBean getTestResult() {
		return testResult;
	}
	public void setTestResult(ResultBean result) {
		this.testResult = result;
	}

	public Evaluation[] getEvaluations(){
		return Optional.ofNullable(getTestMethod())
						.map(method -> method.getAnnotation(Test.class))
						.map(Test::evaluations)
						.orElseGet(() -> new Evaluation[0]);
	}

	@Override
	public int hashCode() {
		int hash = super.hashCode();
		hash = 53 * hash + Objects.hashCode(this.testMethod);
		hash = 53 * hash + Objects.hashCode(this.testName);
		hash = 53 * hash + Arrays.deepHashCode(this.testMethodParameters);
		hash = 53 * hash + Objects.hashCode(this.testResult);
		return hash;
	}

	@Override
	@SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
	public boolean equals(Object obj) {
		if (!super.equals(obj)) {
			return false;
		}
		final TestBean other = (TestBean) obj;
		if (!Objects.equals(this.testName, other.testName)) {
			return false;
		}
		if (!Objects.equals(this.testMethod, other.testMethod)) {
			return false;
		}
		if (!Arrays.deepEquals(this.testMethodParameters, other.testMethodParameters)) {
			return false;
		}
		return Objects.equals(this.testResult, other.testResult);
	}
	
}
