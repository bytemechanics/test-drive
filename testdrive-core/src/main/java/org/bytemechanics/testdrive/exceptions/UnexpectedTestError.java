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
import org.bytemechanics.testdrive.internal.commons.string.SimpleFormat;

/**
 * Exception thrown when try to execute a test and is not an assert exception
 * @see RuntimeException
 * @author afarre
 * @since 1.0.0
 */
public class UnexpectedTestError extends RuntimeException{

	private final Class testUnit;
	private final Method test;
	
	/**
	 * Unexpected test error constructor
	 * @param _testUnit test unit where the exception happen
	 * @param _test test method where the exception happen
	 * @param _cause exception cause
	 */
	public UnexpectedTestError(final Class _testUnit,final Method _test,final Throwable _cause) {
		super(SimpleFormat.format("TestUnit {}, test {} launch an unexpected {}:\n\t{}", _testUnit.getSimpleName(),_test.getName(),_test.getParameterTypes(),_cause.getClass(),_cause.getMessage()),_cause);
		this.testUnit=_testUnit;
		this.test=_test;
	}

	/**
	 * Retrieve the test unit where exception happens
	 * @return class where the exception happen
	 */
	public Class getTestUnit() {
		return testUnit;
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
		hash = 89 * hash + Objects.hashCode(this.testUnit);
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
		final UnexpectedTestError other = (UnexpectedTestError) obj;
		if (!Objects.equals(this.testUnit, other.testUnit)) {
			return false;
		}
		return Objects.equals(this.test, other.test);
	}
}
