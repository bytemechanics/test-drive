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
 * Driven test clean phase unexpected exception
 * @author afarre
 * @since 0.3.0
 */
public class DrivenTestCleanException extends DrivenTestException{
	
	/**
	 * Constructor for this evaluation
	 * @param _evaluation identifier where error happened
	 * @param _cause cause of this exception
	 */
	public DrivenTestCleanException(final EvaluationId _evaluation,final Throwable _cause){
		super("{}, failed during driven test \"clean\" phase by {}",_evaluation,_cause);
	}
}
