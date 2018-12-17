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

import org.bytemechanics.testdrive.adapter.EvaluationId;

/**
 * Exception thrown when try to evaluate a test that is not accessible by the test runner
 * @see RuntimeException
 * @author afarre
 * @since 0.4.0
 */
public class EvaluationNotAccessible extends EvaluationException{

	/**
	 * Constructor for this evaluation
	 * @param _evaluation identifier where error happened
	 * @param _cause cause of this exception
	 */
	public EvaluationNotAccessible(final EvaluationId _evaluation,final Throwable _cause){
		super("{}, not accessible to instantiate {}","", _evaluation,_cause);
	}
}
