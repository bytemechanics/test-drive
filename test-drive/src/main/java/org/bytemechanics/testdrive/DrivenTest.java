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

import org.bytemechanics.testdrive.exceptions.AssertException;
import org.bytemechanics.testdrive.exceptions.DrivenTestCleanException;
import org.bytemechanics.testdrive.exceptions.DrivenTestGivenException;
import org.bytemechanics.testdrive.exceptions.DrivenTestThenException;
import org.bytemechanics.testdrive.exceptions.DrivenTestWhenException;

/**
 * Driven test interface
 * @author afarre
 * @since 0.3.0
 */
public interface DrivenTest {
	
	/**
	 * Driven test step 1: prepare the test environment
	 * @throws DrivenTestGivenException if any error happens
	 */
	public default void given() { };
	/**
	 * Driven test step 2: action to test
	 * @throws DrivenTestWhenException if any error happens
	 */
	public void when();
	/**
	 * Driven test step 3: verify action result
	 * @throws DrivenTestThenException if any error happens not related with an assertion itself
	 * @throws AssertException if the assertion fails
	 */
	public void then() throws AssertException;
	/**
	 * Driven test step 4: Clean up environment in order to be able to execute another test with the same test instance
	 * @throws DrivenTestCleanException if any error happens
	 */
	public default void clean() { };
}
