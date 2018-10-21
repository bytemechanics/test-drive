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
package org.bytemechanics.testdrive.listeners;

import org.bytemechanics.testdrive.adapter.Result;
import org.bytemechanics.testdrive.adapter.TestId;

/**
 *
 * @author afarre
 */
public interface TestListener extends ExecutionListener{

	public <T extends TestId> T startTest(final T _specificationTest);
	public <T extends TestId> T endTest(final T _specificationTest,final Result _result);	
}
