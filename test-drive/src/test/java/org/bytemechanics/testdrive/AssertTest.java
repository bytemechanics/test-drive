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
import org.junit.Test;

/**
 *
 * @author afarre
 */
public class AssertTest {
	
	@Test
	public void testFail() {
		System.out.println("AssertTest >>> testFail");
		try{
			Assert.fail();
			org.junit.Assert.fail();
		}catch(AssertException e){
			org.junit.Assert.assertEquals("Force assertion failure", e.getMessage());
		}
	}

	@Test
	public void testFail_message() {
		System.out.println("AssertTest >>> testFail_message");
		try{
			Assert.fail("Message");
			org.junit.Assert.fail();
		}catch(AssertException e){
			org.junit.Assert.assertEquals("Message", e.getMessage());
		}
	}
	
}
