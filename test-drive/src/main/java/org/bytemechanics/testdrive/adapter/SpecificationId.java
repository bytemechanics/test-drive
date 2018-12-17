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
package org.bytemechanics.testdrive.adapter;

import java.util.Optional;
import org.bytemechanics.testdrive.Specification;
import org.bytemechanics.testdrive.annotations.SpecificationInfo;
import org.bytemechanics.testdrive.internal.commons.string.SimpleFormat;

/**
 * Interface to idenfity the one particular specification 
 * @author afarre
 * @since 0.3.0
 */
public interface SpecificationId {
	
	/**
	 * Returns the class of the specification
	 * @return specification class
	 * @see Specification
	 */
	public Class<? extends Specification> getSpecificationClass();
	/**
	 * Returns the name of the specification accordingly with the SpecificationInfo#name()
	 * @return specification name
	 * @see SpecificationInfo#name() 
	 */
	public String getSpecificationName();
	/**
	 * Returns the group of the specification accordingly with the SpecificationInfo#group()
	 * @return specification group
	 * @see SpecificationInfo#group() 
	 */
	public String getSpecificationGroup();

	/**
	 * Return the cannonical name of the specification
	 * @return an string representing the cannonical name of the specification
	 */
	public default String name(){
		return SimpleFormat.format("{}{}"
									,Optional.ofNullable(getSpecificationGroup())
												.map(String::trim)
												.filter(group -> !group.isEmpty())
												.map(group -> SimpleFormat.format("{}:", group))
												.orElse("")
									, Optional.ofNullable(getSpecificationName())
												.map(String::trim)
												.filter(name -> !name.isEmpty())
												.orElseGet(() -> getSpecificationClass().getSimpleName()));
	}
}
