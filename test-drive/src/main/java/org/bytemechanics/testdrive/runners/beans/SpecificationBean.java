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

import java.util.Optional;
import org.bytemechanics.testdrive.Specification;
import org.bytemechanics.testdrive.adapter.SpecificationId;
import org.bytemechanics.testdrive.annotations.SpecificationInfo;
import org.bytemechanics.testdrive.exceptions.SpecificationNotInstantiable;
import org.bytemechanics.testdrive.internal.commons.reflection.ObjectFactory;

/**
 *
 * @author afarre
 */
public class SpecificationBean implements SpecificationId {
	
	private final Class<? extends Specification> specificationClass;
	private final String specificationName;
	private final String specificationGroup;
	private final Specification specification;
	private ResultBean specificationResult;

	
	public SpecificationBean(final Class<? extends Specification> _testClass) {
		this.specificationClass=_testClass;
		this.specificationName=Optional.ofNullable(_testClass)
									.filter(clazz -> clazz.isAnnotationPresent(SpecificationInfo.class))
									.map(clazz -> clazz.getAnnotation(SpecificationInfo.class))
									.map(SpecificationInfo::name)
									.orElse(_testClass.getSimpleName());
		this.specificationGroup=Optional.ofNullable(_testClass)
									.filter(clazz -> clazz.isAnnotationPresent(SpecificationInfo.class))
									.map(clazz -> clazz.getAnnotation(SpecificationInfo.class))
									.map(SpecificationInfo::group)
									.orElse(_testClass.getSimpleName());
		this.specification=ObjectFactory.of(_testClass)
												.supplier()
													.get()
														.orElseThrow(() -> new SpecificationNotInstantiable(this.specificationClass));
		this.specificationResult=null;
	}
	public SpecificationBean(final SpecificationBean _spec) {
		this.specificationClass=_spec.getSpecificationClass();
		this.specificationName=_spec.getSpecificationName();
		this.specificationGroup=_spec.getSpecificationGroup();
		this.specification=_spec.getSpecification();
		this.specificationResult=_spec.getSpecificationResult();
	}

	
	public Specification getSpecification() {
		return specification;
	}
	@Override
	public Class<? extends Specification> getSpecificationClass() {
		return this.specificationClass;
	}
	@Override
	public String getSpecificationName() {
		return this.specificationName;
	}
	@Override
	public String getSpecificationGroup() {
		return this.specificationGroup;
	}
	public ResultBean getSpecificationResult() {
		return specificationResult;
	}
	public void setSpecificationResult(ResultBean result) {
		this.specificationResult = result;
	}
	

	@Override
	public int hashCode() {
		return getSpecificationClass().hashCode();
	}

	@Override
	@SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
	public boolean equals(Object obj) {
		return getSpecificationClass().equals(obj);
	}
}
