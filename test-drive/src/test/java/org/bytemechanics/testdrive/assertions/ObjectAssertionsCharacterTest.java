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
package org.bytemechanics.testdrive.assertions;

import org.bytemechanics.testdrive.exceptions.AssertException;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author afarre
 */
public class ObjectAssertionsCharacterTest {

@Test
	public void testIsEqual_Character_Character() {
		System.out.println("ObjectAssertionsCharTest >>> testIsEqual_Character_Character");
		Character actual='s';
		Character expected='s';
		Assert.assertTrue(ObjectAssertions.equals(actual, expected));
		actual='a';
		expected='a';
		Assert.assertTrue(ObjectAssertions.equals(actual, expected));
		actual='t';
		expected='f';
		Assert.assertFalse(ObjectAssertions.equals(actual, expected));
	}
	@Test
	public void testAssertEquals_Character_Character() {
		System.out.println("ObjectAssertionsCharTest >>> testAssertEquals_Character_Character");
		Character actual='s';
		Character expected='s';
		ObjectAssertions.assertEquals(actual,expected);
		actual='f';
		expected='f';
		ObjectAssertions.assertEquals(actual,expected);
	}
	@Test
	public void testAssertEquals_Character_Character_failed() {
		System.out.println("ObjectAssertionsCharTest >>> testAssertEquals_Character_Character_failed");
		try{
			Character actual='f';
			Character expected='s';
			ObjectAssertions.assertEquals(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(f~s):\n\tActual:\t\tf\n\tExpected:\t~s", e.getMessage());
		}
	}
	@Test
	public void testAssertEquals_Character_Character_message() {
		System.out.println("ObjectAssertionsCharTest >>> testAssertEquals_Character_Character");
		Character actual='s';
		Character expected='s';
		ObjectAssertions.assertEquals(actual,expected,"Message");
		actual='f';
		expected='f';
		ObjectAssertions.assertEquals(actual,expected,"Message");
	}
	@Test
	public void testAssertEquals_Character_Character_message_failed() {
		System.out.println("ObjectAssertionsCharTest >>> testAssertEquals_Character_Character_failed");
		try{
			Character actual='f';
			Character expected='s';
			ObjectAssertions.assertEquals(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(f~s):\n\tActual:\t\tf\n\tExpected:\t~s", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_Character_Character() {
		System.out.println("ObjectAssertionsCharTest >>> testAssertNotEquals_Character_Character");
		Character actual='f';
		Character expected='s';
		ObjectAssertions.assertNotEquals(actual,expected);
		actual='s';
		expected='f';
		ObjectAssertions.assertNotEquals(actual,expected);
	}
	@Test
	public void testAssertNotEquals_Character_Character_failed() {
		System.out.println("ObjectAssertionsCharTest >>> testAssertNotEquals_Character_Character_failed");
		try{
			Character actual='f';
			Character expected='f';
			ObjectAssertions.assertNotEquals(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(f!~f):\n\tActual:\t\tf\n\tExpected:\t!~f", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_Character_Character_message() {
		System.out.println("ObjectAssertionsCharTest >>> testAssertNotEquals_Character_Character_message");
		Character actual='s';
		Character expected='f';
		ObjectAssertions.assertNotEquals(actual,expected,"Message");
		actual='f';
		expected='s';
		ObjectAssertions.assertNotEquals(actual,expected,"Message");
	}
	@Test
	public void testAssertNotEquals_Character_Character_message_failed() {
		System.out.println("ObjectAssertionsCharTest >>> testAssertNotEquals_Character_Character_message_failed");
		try{
			Character actual='f';
			Character expected='f';
			ObjectAssertions.assertNotEquals(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(f!~f):\n\tActual:\t\tf\n\tExpected:\t!~f", e.getMessage());
		}
	}	
}
