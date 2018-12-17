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
package org.bytemechanics.testdrive;

import java.lang.reflect.Method;
import java.util.stream.Stream;
import org.bytemechanics.testdrive.adapter.Result;
import org.bytemechanics.testdrive.listeners.ExecutionListener;

/**
 * Test drive runner
 * @author afarre
 * @since 0.3.0
 */
public interface TestDriveRunner {
	
	/**
	 * Register a listener for the test drive execution
	 * @param _listener ExecutionListener to register
	 * @param <T> type of the listener that must extend ExecutionListener
	 * @see ExecutionListener
	 */
	public <T extends ExecutionListener> void registerListener(final T _listener);

	/**
	 * Evaluate the given _specification class
	 * @param _specificationClass class to evaluate
	 * @return Evaluation result
	 * @see Result 
	 * @see Specification
	 */
	public Result evaluateSpecification(final Class<? extends Specification> _specificationClass);
	/**
	 * Evaluate the given _method of the given _specification class
	 * @param _specificationClass class to evaluate
	 * @param _method method to evaluate
	 * @return Evaluation result
	 * @see Result 
	 * @see Specification
	 */
	public Result evaluateSpecificationTest(final Class<? extends Specification> _specificationClass,final Method _method);
	/**
	 * Complete the stream with a mapping to convert the _specifications into results
	 * @param _specifications stream of Specification classes to evaluate
	 * @return Stream of results evaluated
	 * @see Specification
	 */
	public Stream<Result> completeStream(Stream<Class<? extends Specification>> _specifications);
}
