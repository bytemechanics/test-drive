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
package org.bytemechanics.testdrive.beans;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Optional;
import org.bytemechanics.testdrive.Specification;

/**
 * Bean to idenfity the one particular specification test
 * @author afarre
 * @since 1.0.0
 */
public class TestId extends SpecificationId{
	
	private final Method testMethod;
	private final String testName;
	private final Class[] testMethodParameters;

	public TestId(final Class<? extends Specification> _specificationClass,final String _specificationName,final String _specificationGroup,final Method _testMethod,final String _testName) {
		super(_specificationClass,_specificationName, _specificationGroup);
		this.testMethod = _testMethod;
		this.testName = _testName;
		this.testMethodParameters=Optional.ofNullable(_testMethod)
											.map(Method::getParameterTypes)
											.orElseGet(() -> new Class[0]);
	}

	public Method getTestMethod() {
		return testMethod;
	}
	public Class[] getTestMethodParameters() {
		return testMethodParameters;
	}
	public String getTestName() {
		return testName;
	}

	@Override
	public int hashCode() {
		int hash = super.hashCode();
		hash = 47 * hash + Objects.hashCode(this.testMethod);
		hash = 47 * hash + Objects.hashCode(this.testName);
		return hash;
	}

	@Override
	@SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
	public boolean equals(Object obj) {
		if (!super.equals(obj)) {
			return false;
		}
		final TestId other = (TestId) obj;
		if (!Objects.equals(this.testName, other.testName)) {
			return false;
		}
		return Objects.equals(this.testMethod, other.testMethod);
	}
}
