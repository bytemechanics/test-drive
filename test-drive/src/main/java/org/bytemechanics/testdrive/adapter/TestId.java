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

import java.lang.reflect.Method;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.bytemechanics.testdrive.annotations.Test;
import org.bytemechanics.testdrive.internal.commons.string.SimpleFormat;

/**
 * Interface to idenfity the one particular specification test
 * @author afarre
 * @since 0.3.0
 * @see SpecificationId
 */
public interface TestId extends SpecificationId{
	
	/**
	 * Returns the test method
	 * @return the test method
	 */
	public Method getTestMethod();
	/**
	 * Returns the test method parameter classes
	 * @return parameter classes of the test method
	 */
	public default Class[] getTestMethodParameters(){
		return Optional.ofNullable(getTestMethod())
							.map(Method::getParameterTypes)
							.orElseGet(() -> new Class[0]);
	}
	/**
	 * Returns the name of the test accordingly with the Test#name()
	 * @return test name
	 * @see Test#name() 
	 */
	public String getTestName();

	
	/**
	 * Return the specification cannonical name of this test
	 * @return the specification cannonical name of this test
	 * @see SpecificationId#name() 
	 */
	public default String specName(){
		return SpecificationId.super.name();
	}

	/**
	 * Return the cannonical name of the test
	 * @return an string representing the cannonical name of the test
	 */
	@Override
	public default String name(){
		return Stream.of(getTestMethodParameters())
						.map(Class::getSimpleName)
						.collect(Collectors.joining(",",getTestMethod().getName()+"(", ")"));
	}
	/**
	 * Return the cannonical name of the test with the given parameters
	 * @param _args arguments
	 * @return an string representing the cannonical name of the test with the given parameters
	 */
	public default String name(final Object... _args){
		return SimpleFormat.format(Stream.of(getTestMethodParameters())
						.map(parameter -> "{}")
						.collect(Collectors.joining(",",getTestMethod().getName()+"(", ")")),(Object[])_args);
	}
}
