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
import org.bytemechanics.testdrive.listeners.ExecutionListener;

/**
 *
 * @author afarre
 */
public interface TestDriveRunner {
	
	public <T extends ExecutionListener> void registerListener(final T _listener);
	
	public void evaluateSpecification(final Class<? extends Specification> _specificationClass);
	public void evaluateSpecificationTest(final Class<? extends Specification> _specificationClass,final Method _method);
	public void evaluateStream(Stream<Class<? extends Specification>> _specifications);
}
