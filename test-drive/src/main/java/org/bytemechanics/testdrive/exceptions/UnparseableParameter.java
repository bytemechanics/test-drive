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

import org.bytemechanics.testdrive.internal.commons.string.SimpleFormat;

/**
 * Exception to identify a non parseable parameter to the necessary class
 * @author afarre
 */
public class UnparseableParameter extends RuntimeException{

	/**
	 * Test parameters not match exception constructor
	 * @param _parameter
	 * @param _toClass
	 * @param _value
	 */
	public UnparseableParameter(final int _parameter,final Class _toClass,final String _value) {
		super(SimpleFormat.format("Unparseable parameter {} with value {} to class {}", _parameter,_value,_toClass));
	}
}
