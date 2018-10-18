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
package org.bytemechanics.testdrive.beans;

import java.util.Objects;
import org.bytemechanics.testdrive.Specification;

/**
 * Bean to idenfity the one particular specification 
 * @author afarre
 * @since 1.0.0
 */
public class SpecificationId {
	
	private final Class<? extends Specification> specificationClass;
	private final String specificationName;
	private final String specificationGroup;

	public SpecificationId(final Class<? extends Specification> _class,final String _name,final String _group) {
		this.specificationClass = _class;
		this.specificationName = _name;
		this.specificationGroup = _group;
	}

	public Class<? extends Specification> getSpecificationClass() {
		return specificationClass;
	}
	public String getSpecificationName() {
		return specificationName;
	}
	public String getSpecificationGroup() {
		return specificationGroup;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 73 * hash + Objects.hashCode(this.specificationClass);
		hash = 73 * hash + Objects.hashCode(this.specificationName);
		hash = 73 * hash + Objects.hashCode(this.specificationGroup);
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
		final SpecificationId other = (SpecificationId) obj;
		if (!Objects.equals(this.specificationName, other.specificationName)) {
			return false;
		}
		if (!Objects.equals(this.specificationGroup, other.specificationGroup)) {
			return false;
		}
		return Objects.equals(this.specificationClass, other.specificationClass);
	}
}
