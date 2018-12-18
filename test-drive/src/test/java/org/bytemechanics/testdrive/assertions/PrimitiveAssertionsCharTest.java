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
 * @author afarre
 */
public class PrimitiveAssertionsCharTest {
		
	@Test
	public void testIsEqual_char_char() {
		System.out.println("PrimitiveAssertionsTest >>> testIsEqual_char_char");
		char actual='s';
		char expected='s';
		Assert.assertTrue(PrimitiveAssertions.isEqual(actual, expected));
		actual='a';
		expected='a';
		Assert.assertTrue(PrimitiveAssertions.isEqual(actual, expected));
		actual='t';
		expected='f';
		Assert.assertFalse(PrimitiveAssertions.isEqual(actual, expected));
	}
	@Test
	public void testAssertEquals_char_char() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertEquals_char_char");
		char actual='s';
		char expected='s';
		PrimitiveAssertions.assertEquals(actual,expected);
		actual='f';
		expected='f';
		PrimitiveAssertions.assertEquals(actual,expected);
	}
	@Test
	public void testAssertEquals_char_char_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertEquals_char_char_failed");
		try{
			char actual='f';
			char expected='s';
			PrimitiveAssertions.assertEquals(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(f=s):\n\tActual:\t\tf\n\tExpected:\t=s", e.getMessage());
		}
	}
	@Test
	public void testAssertEquals_char_char_message() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertEquals_char_char");
		char actual='s';
		char expected='s';
		PrimitiveAssertions.assertEquals(actual,expected,"Message");
		actual='f';
		expected='f';
		PrimitiveAssertions.assertEquals(actual,expected,"Message");
	}
	@Test
	public void testAssertEquals_char_char_message_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertEquals_char_char_failed");
		try{
			char actual='f';
			char expected='s';
			PrimitiveAssertions.assertEquals(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(f=s):\n\tActual:\t\tf\n\tExpected:\t=s", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_char_char() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertNotEquals_char_char");
		char actual='f';
		char expected='s';
		PrimitiveAssertions.assertNotEquals(actual,expected);
		actual='s';
		expected='f';
		PrimitiveAssertions.assertNotEquals(actual,expected);
	}
	@Test
	public void testAssertNotEquals_char_char_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertNotEquals_char_char_failed");
		try{
			char actual='f';
			char expected='f';
			PrimitiveAssertions.assertNotEquals(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(f!=f):\n\tActual:\t\tf\n\tExpected:\t!=f", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_char_char_message() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertNotEquals_char_char_message");
		char actual='s';
		char expected='f';
		PrimitiveAssertions.assertNotEquals(actual,expected,"Message");
		actual='f';
		expected='s';
		PrimitiveAssertions.assertNotEquals(actual,expected,"Message");
	}
	@Test
	public void testAssertNotEquals_char_char_message_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertNotEquals_char_char_message_failed");
		try{
			char actual='f';
			char expected='f';
			PrimitiveAssertions.assertNotEquals(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(f!=f):\n\tActual:\t\tf\n\tExpected:\t!=f", e.getMessage());
		}
	}
}
