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

import org.bytemechanics.testdrive.assertions.ArrayAssertions;
import org.bytemechanics.testdrive.assertions.ObjectAssertions;
import org.bytemechanics.testdrive.assertions.PrimitiveAssertions;
import org.bytemechanics.testdrive.exceptions.AssertException;

/**
 * Assertion class to put all inbuild assertions under the same class
 * @see ArrayAssertions
 * @see ObjectAssertions
 * @see PrimitiveAssertions
 * @author afarre
 * @since 0.3.0
 */
public class Assert extends ArrayAssertions{
	
	/**
	 * Force assertion failure
	 */
	public static void fail(){
		Assert.fail("Force assertion failure");
	}
	/**
	 * Force assertion failure
	 * @param _message message to show
	 */
	public static void fail(final String _message){
		throw new AssertException(_message);
	}
}
