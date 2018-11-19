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

import java.util.Objects;
import org.bytemechanics.testdrive.internal.commons.string.SimpleFormat;

/**
 * Exception thrown when some assertion fail
 * @see RuntimeException
 * @author afarre
 * @since 1.0.0
 */
public class AssertException extends RuntimeException{

	private final String evaluation;
	private final String assertion;
	private final Object expected;
	private final Object actual;
	private final String description;

	/**
	 * Assertion failure exception constructor
	 * @param _evaluation evaluation
	 * @param _cause Assertion error cause
	 */
	public AssertException(final String _evaluation,final AssertionError _cause) {
		super(SimpleFormat.format("evaluation {}, line {}: {}", _evaluation,_cause.getStackTrace()[0].getLineNumber(),_cause.getMessage()),_cause);
		this.evaluation=_evaluation;
		this.assertion=null;
		this.expected=null;
		this.actual=null;
		this.description=_cause.getMessage();
	}
	
	/**
	 * Assertion failure exception constructor
	 * @param _evaluation evaluation
	 * @param _cause Assertion exception cause
	 */
	public AssertException(final String _evaluation,final AssertException _cause) {
		super(SimpleFormat.format("evaluation {}, line {} ({}):\n\tExpected:\t{}\n\tActual:\t{}", _evaluation,_cause.getStackTrace()[0].getLineNumber(),_cause.getAssertion(),_cause.getExpected(),_cause.getActual(),_cause.getCause().getMessage()),_cause);
		this.evaluation=_evaluation;
		this.assertion=_cause.getAssertion();
		this.expected=_cause.getExpected();
		this.actual=_cause.getActual();
		this.description=_cause.getDescription();
	}

	/**
	 * Assertion failure exception constructor
	 * @param _assertion Failed assertion
	 * @param _expected expected result
	 * @param _actual actual result
	 * @param _description assertion failure message
	 */
	public AssertException(final String _assertion,final Object _expected,final Object _actual,final String _description) {
		super(SimpleFormat.format("{}({}):\n\tExpected:\t{}\n\tActual:\t{}",(_description!=null)? _description : "",_assertion,_expected,_actual));
		this.evaluation=null;
		this.assertion=_assertion;
		this.expected=_expected;
		this.actual=_actual;
		this.description=_description;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public String getDescription() {
		return description;
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

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 97 * hash + Objects.hashCode(this.evaluation);
		hash = 97 * hash + Objects.hashCode(this.assertion);
		hash = 97 * hash + Objects.hashCode(this.expected);
		hash = 97 * hash + Objects.hashCode(this.actual);
		return hash;
	}

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
		if (!Objects.equals(this.evaluation, other.evaluation)) {
			return false;
		}
		if (!Objects.equals(this.assertion, other.assertion)) {
			return false;
		}
		if (!Objects.equals(this.expected, other.expected)) {
			return false;
		}
		return Objects.equals(this.actual, other.actual);
	}

}
