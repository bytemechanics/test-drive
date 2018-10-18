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

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import org.bytemechanics.testdrive.Specification;

/**
 *
 * @author afarre
 */
public class EvaluationId extends TestId{
	
	private final int counter;
	private final String name;
	private final String[] arguments;

	public EvaluationId(final Class<? extends Specification> _specificationClass,final String _specificationName,final String _specificationGroup,final Method _testMethod,final String _testName,final int _counter,final String _name,final String[] _arguments) {
		super(_specificationClass,_specificationName, _specificationGroup, _testMethod, _testName);
		this.counter = _counter;
		this.name = _name;
		this.arguments = _arguments;
	}

	public int getCounter() {
		return counter;
	}
	public String getName() {
		return name;
	}
	public String[] getArguments() {
		return arguments;
	}

	@Override
	public int hashCode() {
		int hash = super.hashCode();
		hash = 19 * hash + this.counter;
		hash = 19 * hash + Objects.hashCode(this.name);
		hash = 19 * hash + Arrays.deepHashCode(this.arguments);
		return hash;
	}

	@Override
	@SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
	public boolean equals(Object obj) {
		if (!super.equals(obj)) {
			return false;
		}
		final EvaluationId other = (EvaluationId) obj;
		if (this.counter != other.counter) {
			return false;
		}
		if (!Objects.equals(this.name, other.name)) {
			return false;
		}
		return Arrays.deepEquals(this.arguments, other.arguments);
	}
	
}
