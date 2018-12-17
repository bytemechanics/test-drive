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

/**
 * Exception raised during test clean phase
 * @see RuntimeException
 * @author afarre
 * @since 0.3.0
 * @see TestException
 */
public class TestCleanException extends TestException{
	
	/**
	 * Builds test clean exception
	 * @param _test test failed
	 * @param _cause cause of the clean phase
	 */
	public TestCleanException(final TestId _test,final Throwable _cause){
		super("{}, failed during test \"clean\" phase by {}",_test,_cause);
	}
}
