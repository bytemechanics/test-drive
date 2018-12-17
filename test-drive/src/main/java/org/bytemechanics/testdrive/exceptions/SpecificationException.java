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

import org.bytemechanics.testdrive.adapter.SpecificationId;
import org.bytemechanics.testdrive.adapter.TestId;
import org.bytemechanics.testdrive.internal.commons.string.SimpleFormat;

/**
 * Exception raised during specification
 * @see RuntimeException
 * @author afarre
 * @since 0.4.0
 */
public class SpecificationException extends RuntimeException{
	
	private final SpecificationId specification;

	/**
	 * Builds specification exception
	 * @param _message message to show
	 * @param _specification specification failed
	 * @param _cause cause of failure
	 */
	protected SpecificationException(final String _message,final SpecificationId _specification,final Throwable _cause){
		super(SimpleFormat.format(_message,_specification.name(),_cause.getMessage()),_cause);
		this.specification=_specification;
	}
	/**
	 * Builds specification exception
	 * @param _specification specification failed
	 * @param _cause cause of failure
	 */
	public SpecificationException(final SpecificationId _specification,final Throwable _cause){
		this("{}, failed by {}",_specification,_cause);
	}

	/**
	 * Returns the test identifier of the test failed
	 * @return test identifier
	 * @see TestId
	 */
	public SpecificationId getSpecification() {
		return specification;
	}
}
