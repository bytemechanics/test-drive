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
 * Exception thrown when some assertion fail
 * @see RuntimeException
 * @author afarre
 * @since 1.0.0
 */
public class AssertException extends RuntimeException{

	private final Class<? extends Specification> specification;
	private final Method test;
	private final String assertion;
	private final Object expected;
	private final Object actual;
	
	/**
	 * Assertion failure exception constructor
	 * @param _specification specification where the exception happen
	 * @param _test test method where the exception happen
	 * @param _assertion Failed assertion
	 * @param _expected expected result
	 * @param _actual actual result
	 * @param _cause exception cause
	 */
	public AssertException(final Class<? extends Specification> _specification,final Method _test,final String _assertion,final Object _expected,final Object _actual,final Throwable _cause) {
		super(SimpleFormat.format("Specification {}, test {}, assertion {} failed:\n\tExpected:\t{}\n\tActual:\t{}", _specification.getSimpleName(),_test.getName(),_test.getParameterTypes(),_assertion,_expected,_actual),_cause);
		this.specification=_specification;
		this.test=_test;
		this.assertion=_assertion;
		this.expected=_expected;
		this.actual=_actual;
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
	/**
	 * Retrieve the test assertion failed
	 * @return assertion name that failed
	 */
	public String getAssertion() {
		return assertion;
	}
	/**
	 * Retrieve the test assertion expectation
	 * @return assertion expectation
	 */
	public Object getExpected() {
		return expected;
	}
	/**
	 * Retrieve the test assertion result
	 * @return assertion result
	 */
	public Object getActual() {
		return actual;
	}

	/** @see Object#hashCode()  */
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 43 * hash + Objects.hashCode(this.specification);
		hash = 43 * hash + Objects.hashCode(this.test);
		hash = 43 * hash + Objects.hashCode(this.assertion);
		hash = 43 * hash + Objects.hashCode(this.expected);
		hash = 43 * hash + Objects.hashCode(this.actual);
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
		final AssertException other = (AssertException) obj;
		if (!Objects.equals(this.assertion, other.assertion)) {
			return false;
		}
		if (!Objects.equals(this.specification, other.specification)) {
			return false;
		}
		if (!Objects.equals(this.test, other.test)) {
			return false;
		}
		if (!Objects.equals(this.expected, other.expected)) {
			return false;
		}
		return Objects.equals(this.actual, other.actual);
	}
}
