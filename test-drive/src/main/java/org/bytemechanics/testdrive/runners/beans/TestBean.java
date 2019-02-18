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
import org.bytemechanics.testdrive.adapter.TestId;
import org.bytemechanics.testdrive.annotations.Evaluation;
import org.bytemechanics.testdrive.annotations.Test;

/**
 * Test bean
 * @author afarre
 * @since 0.3.0
 * @see SpecificationBean
 * @see TestId
 */
public class TestBean extends SpecificationBean implements TestId {
	
	private final Method testMethod;
	private final String testName;
	private final Class[] testMethodParameters;
	private ResultBean testResult;

	/**
	 * Builds test bean from SpecificationBean and method
	 * @param _specification specification where test is defined
	 * @param _method test method
	 * @see SpecificationBean
	 */
	public TestBean(final SpecificationBean _specification,final Method _method) {
		super(_specification);
		this.testMethod = _method;
		this.testName =  Optional.ofNullable(_method)
									.filter(clazz -> clazz.isAnnotationPresent(Test.class))
									.map(clazz -> clazz.getAnnotation(Test.class))
									.map(Test::name)
									.map(String::trim)
									.filter(name -> !name.isEmpty())
									.orElse(TestId.super.name());
		this.testMethodParameters=TestId.super.getTestMethodParameters();
		this.testResult=null;
	}

	/**
	 * Clone testbean from the given one
	 * @param _test testbean to clone
	 */
	public TestBean(final TestBean _test) {
		super(_test);
		this.testMethod = _test.getTestMethod();
		this.testName = _test.getTestName();
		this.testMethodParameters = _test.getTestMethodParameters();
		this.testResult = _test.getTestResult();
	}

	/** @see TestId#getTestMethod() */
	@Override
	public Method getTestMethod() {
		return testMethod;
	}
	/** @see TestId#getTestMethodParameters() */
	@Override
	public Class[] getTestMethodParameters() {
		return testMethodParameters;
	}
	/** @see TestId#getSpecificationGroup() */
	@Override
	public String getTestName() {
		return testName;
	}
	/**
	 * Returns the test result after executing the test represented by this bean
	 * @return test result after executing the test represented by this bean
	 */
	public ResultBean getTestResult() {
		return testResult;
	}
	/**
	 * Sets the test evaluation result
	 * @param _result result to register
	 */
	public void setTestResult(ResultBean _result) {
		this.testResult = _result;
	}

	/**
	 * Returns all evaluation instances on this test
	 * @return Array of evaluations
	 */
	public Evaluation[] getEvaluations(){
		return Optional.ofNullable(getTestMethod())
						.map(method -> method.getAnnotation(Test.class))
						.map(Test::evaluations)
						.orElseGet(() -> new Evaluation[0]);
	}

	/** @see Object#hashCode() */
	@Override
	public int hashCode() {
		int hash = super.hashCode();
		hash = 53 * hash + Objects.hashCode(this.testMethod);
		hash = 53 * hash + Objects.hashCode(this.testName);
		hash = 53 * hash + Arrays.deepHashCode(this.testMethodParameters);
		hash = 53 * hash + Objects.hashCode(this.testResult);
		return hash;
	}

	/** @see Object#equals(java.lang.Object) */
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
