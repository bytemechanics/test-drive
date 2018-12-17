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

import org.bytemechanics.testdrive.adapter.TestId;
import org.bytemechanics.testdrive.internal.commons.string.SimpleFormat;

/**
 * Exception raised during test
 * @see RuntimeException
 * @author afarre
 * @since 0.3.0
 */
public class TestException extends RuntimeException{
	
	private final TestId test;

	/**
	 * Builds test exception
	 * @param _message message to show
	 * @param _test test failed
	 * @param _cause cause of failure
	 */
	protected TestException(final String _message,final TestId _test,final Throwable _cause){
		super(SimpleFormat.format(_message,_test.name(),_cause.getMessage()),_cause);
		this.test=_test;
	}
	/**
	 * Builds test exception
	 * @param _test test failed
	 * @param _cause cause of failure
	 */
	public TestException(final TestId _test,final Throwable _cause){
		this("{}, failed by {}",_test,_cause);
	}

	/**
	 * Returns the test identifier of the test failed
	 * @return test identifier
	 * @see TestId
	 */
	public TestId getTest() {
		return test;
	}
}
