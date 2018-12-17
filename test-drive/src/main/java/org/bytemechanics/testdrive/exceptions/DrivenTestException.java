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
 * Driven test unexpected exception
 * @author afarre
 * @since 0.4.0
 */
public class DrivenTestException extends EvaluationException{
	
	/**
	 * Constructor for this driven test evaluation
	 * @param _message message pattern with two parameters _evaluation.name() and _cause.getMessage() to show
	 * @param _messageSuffix suffix to the message
	 * @param _evaluation identifier where error happened
	 * @param _cause cause of this exception
	 */
	protected DrivenTestException(final String _message,final String _messageSuffix,final EvaluationId _evaluation,final Throwable _cause){
		super(_message,_messageSuffix,_evaluation,_cause);
	}
	/**
	 * Constructor for this driven test evaluation
	 * @param _message message to show with this error
	 * @param _evaluation identifier where error happened
	 * @param _cause cause of this exception
	 */
	protected DrivenTestException(final String _message,final EvaluationId _evaluation,final Throwable _cause){
		super(_message,"",_evaluation,_cause);
	}
	/**
	 * Builds driven test exception
	 * @param _evaluation evaluation failed
	 * @param _cause cause of failure
	 */
	public DrivenTestException(final EvaluationId _evaluation,final Throwable _cause){
		this("{}, failed by {}",_evaluation,_cause);
	}
}
