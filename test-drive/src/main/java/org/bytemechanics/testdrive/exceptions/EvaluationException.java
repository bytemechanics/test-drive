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

import java.util.Optional;
import org.bytemechanics.testdrive.adapter.EvaluationId;
import org.bytemechanics.testdrive.internal.commons.string.SimpleFormat;

/**
 * Exception raised during test evaluation
 * @see RuntimeException
 * @author afarre
 * @since 0.4.0
 */
public class EvaluationException extends RuntimeException{
	
	private final EvaluationId evaluation;

	/**
	 * Builds test evaluation exception
	 * @param _message message pattern with two parameters _evaluation.name() and _cause.getMessage() to show
	 * @param _messageSuffix suffix to the message
	 * @param _evaluation evaluation failed
	 * @param _cause cause of failure
	 */
	protected EvaluationException(final String _message,final String _messageSuffix,final EvaluationId _evaluation,final Throwable _cause){
		super(SimpleFormat.format(_message,_evaluation.name(),_cause.getMessage())+Optional.ofNullable(_messageSuffix).orElse(""),_cause);
		this.evaluation=_evaluation;
	}
	/**
	 * Builds test evaluation exception
	 * @param _evaluation evaluation failed
	 * @param _cause cause of failure
	 */
	public EvaluationException(final EvaluationId _evaluation,final Throwable _cause){
		this("{}, failed by {}","",_evaluation,_cause);
	}

	/**
	 * Returns the test evaluation identifier of the test failed
	 * @return test evaluation identifier
	 * @see EvaluationId
	 */
	public EvaluationId getEvaluation() {
		return evaluation;
	}
}
