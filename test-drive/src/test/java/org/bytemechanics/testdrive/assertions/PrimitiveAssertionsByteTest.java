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
public class PrimitiveAssertionsByteTest {
		
	@Test
	public void testIsEqual_byte_byte() {
		System.out.println("PrimitiveAssertionsTest >>> testIsEqual_byte_byte");
		byte actual=0;
		byte expected=0;
		Assert.assertTrue(PrimitiveAssertions.isEqual(actual, expected));
		actual=1;
		expected=1;
		Assert.assertTrue(PrimitiveAssertions.isEqual(actual, expected));
		actual=0;
		expected=1;
		Assert.assertFalse(PrimitiveAssertions.isEqual(actual, expected));
	}
	@Test
	public void testAssertEquals_byte_byte() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertEquals_byte_byte");
		byte actual=0;
		byte expected=0;
		PrimitiveAssertions.assertEquals(actual,expected);
		actual=1;
		expected=1;
		PrimitiveAssertions.assertEquals(actual,expected);
	}
	@Test
	public void testAssertEquals_byte_byte_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertEquals_byte_byte_failed");
		try{
			byte actual=1;
			byte expected=0;
			PrimitiveAssertions.assertEquals(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1=0):\n\tActual:\t\t1\n\tExpected:\t=0", e.getMessage());
		}
	}
	@Test
	public void testAssertEquals_byte_byte_message() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertEquals_byte_byte");
		byte actual=0;
		byte expected=0;
		PrimitiveAssertions.assertEquals(actual,expected,"Message");
		actual=1;
		expected=1;
		PrimitiveAssertions.assertEquals(actual,expected,"Message");
	}
	@Test
	public void testAssertEquals_byte_byte_message_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertEquals_byte_byte_failed");
		try{
			byte actual=1;
			byte expected=0;
			PrimitiveAssertions.assertEquals(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1=0):\n\tActual:\t\t1\n\tExpected:\t=0", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_byte_byte() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertNotEquals_byte_byte");
		byte actual=1;
		byte expected=0;
		PrimitiveAssertions.assertNotEquals(actual,expected);
		actual=0;
		expected=1;
		PrimitiveAssertions.assertNotEquals(actual,expected);
	}
	@Test
	public void testAssertNotEquals_byte_byte_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertNotEquals_byte_byte_failed");
		try{
			byte actual=1;
			byte expected=1;
			PrimitiveAssertions.assertNotEquals(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1!=1):\n\tActual:\t\t1\n\tExpected:\t!=1", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_byte_byte_message() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertNotEquals_byte_byte_message");
		byte actual=0;
		byte expected=1;
		PrimitiveAssertions.assertNotEquals(actual,expected,"Message");
		actual=1;
		expected=0;
		PrimitiveAssertions.assertNotEquals(actual,expected,"Message");
	}
	@Test
	public void testAssertNotEquals_byte_byte_message_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertNotEquals_byte_byte_message_failed");
		try{
			byte actual=1;
			byte expected=1;
			PrimitiveAssertions.assertNotEquals(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1!=1):\n\tActual:\t\t1\n\tExpected:\t!=1", e.getMessage());
		}
	}
}
