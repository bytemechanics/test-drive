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

import java.util.Arrays;
import org.bytemechanics.testdrive.adapter.EvaluationId;
import org.bytemechanics.testdrive.internal.commons.string.SimpleFormat;

/**
 * Exception thrown when try to execute a test without the necessary parameters
 * @see RuntimeException
 * @author afarre
 * @since 0.4.0
 */
public class EvaluationParametersNotMatch extends EvaluationException{

	private final Object[] provided;
	
	/**
	 * Test parameters not match exception constructor
	 * @param _evaluation evaluation failed
	 * @param _provided Received parameters
	 */
	public EvaluationParametersNotMatch(final EvaluationId _evaluation,final Object[] _provided) {
		this(_evaluation,_provided,null);
	}
	/**
	 * Test parameters not match exception constructor
	 * @param _evaluation evaluation failed
	 * @param _provided Received parameters
	 * @param _cause exception cause
	 */
	public EvaluationParametersNotMatch(final EvaluationId _evaluation,final Object[] _provided,final Throwable _cause) {
		super("{} can not be instantiated.",SimpleFormat.format("Has not the necessary parameters.\n\t\tExpected: {}\n\t\tFound: {}",_evaluation.getTestMethod().getParameterTypes(),_provided), _evaluation,_cause);
		this.provided=_provided;
	}

	/**
	 * Retrieve the receiced object parameters
	 * @return array of the received object parameters
	 */
	public Object[] getProvided() {
		return provided;
	}

	/** @see Object#hashCode()  */
	@Override
	public int hashCode() {
		int hash = super.hashCode();
		hash = 11 * hash + Arrays.deepHashCode(this.provided);
		return hash;
	}

	/** @see Object#equals(java.lang.Object)  */
	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			final EvaluationParametersNotMatch other = (EvaluationParametersNotMatch) obj;
			return Arrays.deepEquals(this.provided, other.provided);
		}else return false;
	}
}
