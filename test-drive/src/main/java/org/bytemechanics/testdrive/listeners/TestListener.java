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
 * Test listener interface
 * @author afarre
 * @since 0.3.0
 * @see ExecutionListener
 * @see TestId
 */
public interface TestListener extends ExecutionListener{

	/**
	 * Test evaluation start event method
	 * @param <T> evaluation identifier implementing TestId interface
	 * @param _specification test
	 */
	public <T extends TestId> void startTest(final T _specification);
	/**
	 * Test evaluation start setup phase event method
	 * @param <T> evaluation identifier implementing TestId interface
	 * @param _specification test
	 */
	public <T extends TestId> void startTestSetup(final T _specification);
	/**
	 * Test evaluation end setup phase event method
	 * @param <T> evaluation identifier implementing TestId interface
	 * @param _specification test
	 */
	public <T extends TestId> void endTestSetup(final T _specification);
	/**
	 * Test evaluation start cleanup phase event method
	 * @param <T> evaluation identifier implementing TestId interface
	 * @param _specification test
	 */
	public <T extends TestId> void startTestCleanup(final T _specification);
	/**
	 * Test evaluation end cleanup phase event method
	 * @param <T> evaluation identifier implementing TestId interface
	 * @param _specification test
	 */
	public <T extends TestId> void endTestCleanup(final T _specification);
	/**
	 * Test evaluation end event method
	 * @param <T> evaluation identifier implementing TestId interface
	 * @param _specification test
	 * @param _result test result
	 */
	public <T extends TestId> void endTest(final T _specification,final Result _result);	
}
