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
import java.util.Objects;
import java.util.Optional;
import org.bytemechanics.testdrive.annotations.Evaluation;
import org.bytemechanics.testdrive.annotations.Test;
import org.bytemechanics.testdrive.beans.Result;
import org.bytemechanics.testdrive.beans.TestId;

/**
 *
 * @author afarre
 */
public class TestBean extends TestId {
	
	private Result result;

	public TestBean(final SpecificationBean _specification,final Method _method) {
		super(_specification.getSpecificationClass()
				,_specification.getSpecificationName()
				,_specification.getSpecificationGroup()
				,_method, Optional.ofNullable(_method)
									.filter(clazz -> clazz.isAnnotationPresent(Test.class))
									.map(clazz -> clazz.getAnnotation(Test.class))
									.map(Test::name)
									.orElse(_method.getName()));
		this.result=null;
	}

	public Evaluation[] getEvaluations(){
		return Optional.ofNullable(getTestMethod())
						.map(method -> method.getAnnotation(Test.class))
						.map(Test::evaluations)
						.orElseGet(() -> new Evaluation[0]);
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public TestBean withResult(Result result) {
		this.result = result;
		return this;
	}

	
	@Override
	public int hashCode() {
		int hash = super.hashCode();
		hash = 37 * hash + Objects.hashCode(this.result);
		return hash;
	}

	@Override
	@SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
	public boolean equals(Object obj) {
		if (!super.equals(obj)) {
			return false;
		}
		final TestBean other = (TestBean) obj;
		return Objects.equals(this.result, other.result);
	}
}
