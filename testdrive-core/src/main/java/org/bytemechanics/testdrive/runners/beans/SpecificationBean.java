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
package org.bytemechanics.testdrive.runners.beans;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;
import org.bytemechanics.testdrive.Specification;
import org.bytemechanics.testdrive.annotations.SpecificationInfo;
import org.bytemechanics.testdrive.beans.Result;
import org.bytemechanics.testdrive.beans.SpecificationId;
import org.bytemechanics.testdrive.internal.commons.reflection.ObjectFactory;

/**
 *
 * @author afarre
 */
public class SpecificationBean extends SpecificationId {
	
	private final Supplier<Optional<Specification>> specificationSupplier;
	private Result result;

	
	public SpecificationBean(Class<? extends Specification> _testClass) {
		super(_testClass, Optional.ofNullable(_testClass)
									.filter(clazz -> clazz.isAnnotationPresent(SpecificationInfo.class))
									.map(clazz -> clazz.getAnnotation(SpecificationInfo.class))
									.map(SpecificationInfo::name)
									.orElse(_testClass.getSimpleName())
						,Optional.ofNullable(_testClass)
									.filter(clazz -> clazz.isAnnotationPresent(SpecificationInfo.class))
									.map(clazz -> clazz.getAnnotation(SpecificationInfo.class))
									.map(SpecificationInfo::group)
									.orElse(_testClass.getSimpleName()));
		this.specificationSupplier=ObjectFactory.of(Specification.class)
												.supplier();
		this.result=null;
	}

	
	public Supplier<Optional<Specification>> getSpecification() {
		return specificationSupplier;
	}

	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public SpecificationBean withResult(Result result) {
		this.result = result;
		return this;
	}

	
	@Override
	public int hashCode() {
		int hash = super.hashCode();
		hash = 79 * hash + Objects.hashCode(this.specificationSupplier);
		hash = 79 * hash + Objects.hashCode(this.result);
		return hash;
	}

	@Override
	@SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
	public boolean equals(Object obj) {
		if (!super.equals(obj)) {
			return false;
		}
		final SpecificationBean other = (SpecificationBean) obj;
		if (!Objects.equals(this.specificationSupplier, other.specificationSupplier)) {
			return false;
		}
		return Objects.equals(this.result, other.result);
	}
}
