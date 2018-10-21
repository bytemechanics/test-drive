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
import org.bytemechanics.testdrive.Specification;
import org.bytemechanics.testdrive.internal.commons.string.SimpleFormat;

/**
 * Exception thrown when failed trying to instantiate an specification
 * @see RuntimeException
 * @see Specification
 * @author afarre
 * @since 1.0.0
 */
public class SpecificationNotInstantiable extends RuntimeException{

	private final Class<? extends Specification> specification;
	
	/**
	 * Test not accessible exception constructor
	 * @param _specification specification class 
	 */
	public SpecificationNotInstantiable(final Class<? extends Specification> _specification) {
		this(_specification,null);
	}
	/**
	 * Test not accessible exception constructor
	 * @param _specification specification class 
	 * @param _cause exception cause
	 */
	public SpecificationNotInstantiable(final Class<? extends Specification> _specification,final Throwable _cause) {
		super(SimpleFormat.format("Specification {} is not instantiable, verify exist a public constructor without parameters", _specification.getSimpleName()),_cause);
		this.specification=_specification;
	}

	/**
	 * Retrieve the specification where exception happens
	 * @return class where the exception happen
	 */
	public Class<? extends Specification> getSpecification() {
		return specification;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 47 * hash + Objects.hashCode(this.specification);
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
		final SpecificationNotInstantiable other = (SpecificationNotInstantiable) obj;
		return Objects.equals(this.specification, other.specification);
	}

}
