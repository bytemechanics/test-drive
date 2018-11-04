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
package org.bytemechanics.testdrive.exceptions;

import java.lang.reflect.Method;
import java.util.Objects;
import org.bytemechanics.testdrive.Specification;
import org.bytemechanics.testdrive.internal.commons.string.SimpleFormat;

/**
 * Exception thrown when try to execute a test that is not accessible by the test runner
 * @see RuntimeException
 * @author afarre
 * @since 1.0.0
 */
public class TestNotAccessible extends RuntimeException{

	private final Class<? extends Specification> specification;
	private final Method test;
	
	/**
	 * Test not accessible exception constructor
	 * @param _specification specification where the exception happen
	 * @param _test test method where the exception happen
	 * @param _cause exception cause
	 */
	public TestNotAccessible(final Class<? extends Specification> _specification,final Method _test,final Throwable _cause) {
		super(SimpleFormat.format("Specification {}, test {} is not accessible", _specification.getSimpleName(),_test.getName(),_test.getParameterTypes()),_cause);
		this.specification=_specification;
		this.test=_test;
	}

	/**
	 * Retrieve the specification where exception happens
	 * @return class where the exception happen
	 */
	public Class<? extends Specification> getSpecification() {
		return specification;
	}
	/**
	 * Retrieve the test where exception happens
	 * @return method where the exception happen
	 */
	public Method getTest() {
		return test;
	}

	/** @see Object#hashCode()  */
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 89 * hash + Objects.hashCode(this.specification);
		hash = 89 * hash + Objects.hashCode(this.test);
		return hash;
	}

	/** @see Object#equals(java.lang.Object)  */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final TestNotAccessible other = (TestNotAccessible) obj;
		if (!Objects.equals(this.specification, other.specification)) {
			return false;
		}
		return Objects.equals(this.test, other.test);
	}
}
