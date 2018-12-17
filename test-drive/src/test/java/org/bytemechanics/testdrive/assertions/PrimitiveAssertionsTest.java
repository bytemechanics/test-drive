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
public class PrimitiveAssertionsTest {
	
	@Test
	public void testIsTrue() {
		System.out.println("PrimitiveAssertionsTest >>> testIsTrue");
		Assert.assertTrue(PrimitiveAssertions.isTrue(true));
		Assert.assertFalse(PrimitiveAssertions.isTrue(false));
	}

	@Test
	public void testAssertTrue_boolean() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertTrue_boolean");
		PrimitiveAssertions.assertTrue(true);
	}
	@Test()
	public void testAssertTrue_boolean_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertTrue_boolean_failed");
		try{
			PrimitiveAssertions.assertTrue(false);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(false=true):\n\tActual=\t\tfalse\n\tExpected=\ttrue", e.getMessage());
		}
	}
	@Test
	public void testAssertTrue_boolean_String() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertTrue_boolean_String");
		PrimitiveAssertions.assertTrue(true,"message");
	}
	@Test
	public void testAssertTrue_boolean_String_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertTrue_boolean_String_failed");
		try{
			PrimitiveAssertions.assertTrue(false,"message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("message(false=true):\n\tActual=\t\tfalse\n\tExpected=\ttrue", e.getMessage());
		}
	}
	@Test
	public void testAssertFalse_boolean() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertFalse_boolean");
		PrimitiveAssertions.assertFalse(false);
	}
	@Test
	public void testAssertFalse_boolean_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertTrue_boolean_failed");
		try{
			PrimitiveAssertions.assertFalse(true);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(true=false):\n\tActual=\t\ttrue\n\tExpected=\tfalse", e.getMessage());
		}
	}
	@Test
	public void testAssertFalse_boolean_String() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertTrue_boolean_String");
		PrimitiveAssertions.assertFalse(false,"message");
	}
	@Test
	public void testAssertFalse_boolean_String_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertTrue_boolean_String_failed");
		try{
			PrimitiveAssertions.assertFalse(true,"message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("message(true=false):\n\tActual=\t\ttrue\n\tExpected=\tfalse", e.getMessage());
		}
	}
	@Test
	public void testIsEqual_boolean_boolean() {
		System.out.println("PrimitiveAssertionsTest >>> testIsEqual_boolean_boolean");
		Assert.assertTrue(PrimitiveAssertions.isEqual(false, false));
		Assert.assertTrue(PrimitiveAssertions.isEqual(true, true));
		Assert.assertFalse(PrimitiveAssertions.isEqual(true, false));
		Assert.assertFalse(PrimitiveAssertions.isEqual(false, true));
	}
	@Test
	public void testAssertEquals_boolean_boolean() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertEquals_boolean_boolean");
		PrimitiveAssertions.assertEquals(true, true);
		PrimitiveAssertions.assertEquals(false, false);
	}
	@Test
	public void testAssertEquals_boolean_boolean_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertEquals_boolean_boolean_failed");
		try{
			PrimitiveAssertions.assertEquals(true, false);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(true=false):\n\tActual=\t\ttrue\n\tExpected=\tfalse", e.getMessage());
		}
		try{
			PrimitiveAssertions.assertEquals(false,true);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(false=true):\n\tActual=\t\tfalse\n\tExpected=\ttrue", e.getMessage());
		}
	}
	@Test
	public void testAssertEquals_boolean_boolean_message() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertEquals_boolean_boolean_message");
		PrimitiveAssertions.assertEquals(true, true,"Message");
		PrimitiveAssertions.assertEquals(false, false,"Message");
	}
	@Test
	public void testAssertEquals_boolean_boolean_message_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertEquals_boolean_boolean_message_failed");
		try{
			PrimitiveAssertions.assertEquals(true, false,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(true=false):\n\tActual=\t\ttrue\n\tExpected=\tfalse", e.getMessage());
		}
		try{
			PrimitiveAssertions.assertEquals(false,true,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(false=true):\n\tActual=\t\tfalse\n\tExpected=\ttrue", e.getMessage());
		}
	}
		@Test
	public void testAssertNotEquals_boolean_boolean() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertNotEquals_boolean_boolean");
		PrimitiveAssertions.assertNotEquals(false, true);
		PrimitiveAssertions.assertNotEquals(true, false);
	}
	@Test
	public void testAssertNotEquals_boolean_boolean_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertNotEquals_boolean_boolean_failed");
		try{
			PrimitiveAssertions.assertNotEquals(true, true);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(true!=true):\n\tActual=\t\ttrue\n\tExpected!=\ttrue", e.getMessage());
		}
		try{
			PrimitiveAssertions.assertNotEquals(false,false);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(false!=false):\n\tActual=\t\tfalse\n\tExpected!=\tfalse", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_boolean_boolean_message() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertNotEquals_boolean_boolean_message");
		PrimitiveAssertions.assertNotEquals(false, true,"Message");
		PrimitiveAssertions.assertNotEquals(true, false,"Message");
	}
	@Test
	public void testAssertNotEquals_boolean_boolean_message_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertNotEquals_boolean_boolean_message_failed");
		try{
			PrimitiveAssertions.assertNotEquals(true, true,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(true!=true):\n\tActual=\t\ttrue\n\tExpected!=\ttrue", e.getMessage());
		}
		try{
			PrimitiveAssertions.assertNotEquals(false,false,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(false!=false):\n\tActual=\t\tfalse\n\tExpected!=\tfalse", e.getMessage());
		}
	}
/*
	@Test
	public void testIsEqual_byte_byte() {
		System.out.println("PrimitiveAssertionsTest >>> isEqual");
		byte _actual = 0;
		byte _expected = 0;
		boolean expResult = false;
		boolean result = PrimitiveAssertions.isEqual(_actual, _expected);
		assertEquals(expResult, result);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertEquals_byte_byte() {
		System.out.println("PrimitiveAssertionsTest >>> assertEquals");
		byte _actual = 0;
		byte _expected = 0;
		PrimitiveAssertions.assertEquals(_actual, _expected);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertEquals_3args_2() {
		System.out.println("PrimitiveAssertionsTest >>> assertEquals");
		byte _actual = 0;
		byte _expected = 0;
		String _message = "";
		PrimitiveAssertions.assertEquals(_actual, _expected, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertNotEquals_byte_byte() {
		System.out.println("PrimitiveAssertionsTest >>> assertNotEquals");
		byte _actual = 0;
		byte _expected = 0;
		PrimitiveAssertions.assertNotEquals(_actual, _expected);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertNotEquals_3args_2() {
		System.out.println("PrimitiveAssertionsTest >>> assertNotEquals");
		byte _actual = 0;
		byte _expected = 0;
		String _message = "";
		PrimitiveAssertions.assertNotEquals(_actual, _expected, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testIsEqual_char_char() {
		System.out.println("PrimitiveAssertionsTest >>> isEqual");
		char _actual = ' ';
		char _expected = ' ';
		boolean expResult = false;
		boolean result = PrimitiveAssertions.isEqual(_actual, _expected);
		assertEquals(expResult, result);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertEquals_char_char() {
		System.out.println("PrimitiveAssertionsTest >>> assertEquals");
		char _actual = ' ';
		char _expected = ' ';
		PrimitiveAssertions.assertEquals(_actual, _expected);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertEquals_3args_3() {
		System.out.println("PrimitiveAssertionsTest >>> assertEquals");
		char _actual = ' ';
		char _expected = ' ';
		String _message = "";
		PrimitiveAssertions.assertEquals(_actual, _expected, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertNotEquals_char_char() {
		System.out.println("PrimitiveAssertionsTest >>> assertNotEquals");
		char _actual = ' ';
		char _expected = ' ';
		PrimitiveAssertions.assertNotEquals(_actual, _expected);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertNotEquals_3args_3() {
		System.out.println("PrimitiveAssertionsTest >>> assertNotEquals");
		char _actual = ' ';
		char _expected = ' ';
		String _message = "";
		PrimitiveAssertions.assertNotEquals(_actual, _expected, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testIsZero_short() {
		System.out.println("PrimitiveAssertionsTest >>> isZero");
		short _actual = 0;
		boolean expResult = false;
		boolean result = PrimitiveAssertions.isZero(_actual);
		assertEquals(expResult, result);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertZero_short() {
		System.out.println("assertZero");
		short _actual = 0;
		PrimitiveAssertions.assertZero(_actual);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertZero_short_String() {
		System.out.println("PrimitiveAssertionsTest >>> assertZero");
		short _actual = 0;
		String _message = "";
		PrimitiveAssertions.assertZero(_actual, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testIsEqual_short_short() {
		System.out.println("PrimitiveAssertionsTest >>> isEqual");
		short _actual = 0;
		short _expected = 0;
		boolean expResult = false;
		boolean result = PrimitiveAssertions.isEqual(_actual, _expected);
		assertEquals(expResult, result);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertEquals_short_short() {
		System.out.println("PrimitiveAssertionsTest >>> assertEquals");
		short _actual = 0;
		short _expected = 0;
		PrimitiveAssertions.assertEquals(_actual, _expected);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertEquals_3args_4() {
		System.out.println("PrimitiveAssertionsTest >>> assertEquals");
		short _actual = 0;
		short _expected = 0;
		String _message = "";
		PrimitiveAssertions.assertEquals(_actual, _expected, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertNotEquals_short_short() {
		System.out.println("PrimitiveAssertionsTest >>> assertNotEquals");
		short _actual = 0;
		short _expected = 0;
		PrimitiveAssertions.assertNotEquals(_actual, _expected);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertNotEquals_3args_4() {
		System.out.println("PrimitiveAssertionsTest >>> assertNotEquals");
		short _actual = 0;
		short _expected = 0;
		String _message = "";
		PrimitiveAssertions.assertNotEquals(_actual, _expected, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testIsGreater_short_short() {
		System.out.println("PrimitiveAssertionsTest >>> isGreater");
		short _actual = 0;
		short _limit = 0;
		boolean expResult = false;
		boolean result = PrimitiveAssertions.isGreater(_actual, _limit);
		assertEquals(expResult, result);
		fail("The test case is a prototype.");
	}

	@Test
	public void testIsGreaterOrEqual_short_short() {
		System.out.println("PrimitiveAssertionsTest >>> isGreaterOrEqual");
		short _actual = 0;
		short _limit = 0;
		boolean expResult = false;
		boolean result = PrimitiveAssertions.isGreaterOrEqual(_actual, _limit);
		assertEquals(expResult, result);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertGreater_short_short() {
		System.out.println("PrimitiveAssertionsTest >>> assertGreater");
		short _actual = 0;
		short _limit = 0;
		PrimitiveAssertions.assertGreater(_actual, _limit);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertGreater_3args_1() {
		System.out.println("PrimitiveAssertionsTest >>> assertGreater");
		short _actual = 0;
		short _limit = 0;
		String _message = "";
		PrimitiveAssertions.assertGreater(_actual, _limit, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertGreaterOrEqual_short_short() {
		System.out.println("PrimitiveAssertionsTest >>> assertGreaterOrEqual");
		short _actual = 0;
		short _limit = 0;
		PrimitiveAssertions.assertGreaterOrEqual(_actual, _limit);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertGreaterOrEqual_3args_1() {
		System.out.println("PrimitiveAssertionsTest >>> assertGreaterOrEqual");
		short _actual = 0;
		short _limit = 0;
		String _message = "";
		PrimitiveAssertions.assertGreaterOrEqual(_actual, _limit, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertSmaller_short_short() {
		System.out.println("PrimitiveAssertionsTest >>> assertSmaller");
		short _actual = 0;
		short _limit = 0;
		PrimitiveAssertions.assertSmaller(_actual, _limit);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertSmaller_3args_1() {
		System.out.println("PrimitiveAssertionsTest >>> assertSmaller");
		short _actual = 0;
		short _limit = 0;
		String _message = "";
		PrimitiveAssertions.assertSmaller(_actual, _limit, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertSmallerOrEqual_short_short() {
		System.out.println("assertSmallerOrEqual");
		short _actual = 0;
		short _limit = 0;
		PrimitiveAssertions.assertSmallerOrEqual(_actual, _limit);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertSmallerOrEqual_3args_1() {
		System.out.println("PrimitiveAssertionsTest >>> assertSmallerOrEqual");
		short _actual = 0;
		short _limit = 0;
		String _message = "";
		PrimitiveAssertions.assertSmallerOrEqual(_actual, _limit, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testIsZero_int() {
		System.out.println("PrimitiveAssertionsTest >>> isZero");
		int _actual = 0;
		boolean expResult = false;
		boolean result = PrimitiveAssertions.isZero(_actual);
		assertEquals(expResult, result);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertZero_int() {
		System.out.println("PrimitiveAssertionsTest >>> assertZero");
		int _actual = 0;
		PrimitiveAssertions.assertZero(_actual);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertZero_int_String() {
		System.out.println("PrimitiveAssertionsTest >>> assertZero");
		int _actual = 0;
		String _message = "";
		PrimitiveAssertions.assertZero(_actual, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testIsEqual_int_int() {
		System.out.println("PrimitiveAssertionsTest >>> isEqual");
		int _actual = 0;
		int _expected = 0;
		boolean expResult = false;
		boolean result = PrimitiveAssertions.isEqual(_actual, _expected);
		assertEquals(expResult, result);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertEquals_int_int() {
		System.out.println("PrimitiveAssertionsTest >>> assertEquals");
		int _actual = 0;
		int _expected = 0;
		PrimitiveAssertions.assertEquals(_actual, _expected);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertEquals_3args_5() {
		System.out.println("PrimitiveAssertionsTest >>> assertEquals");
		int _actual = 0;
		int _expected = 0;
		String _message = "";
		PrimitiveAssertions.assertEquals(_actual, _expected, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertNotEquals_int_int() {
		System.out.println("PrimitiveAssertionsTest >>> assertNotEquals");
		int _actual = 0;
		int _expected = 0;
		PrimitiveAssertions.assertNotEquals(_actual, _expected);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertNotEquals_3args_5() {
		System.out.println("PrimitiveAssertionsTest >>> assertNotEquals");
		int _actual = 0;
		int _expected = 0;
		String _message = "";
		PrimitiveAssertions.assertNotEquals(_actual, _expected, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testIsGreater_int_int() {
		System.out.println("PrimitiveAssertionsTest >>> isGreater");
		int _actual = 0;
		int _limit = 0;
		boolean expResult = false;
		boolean result = PrimitiveAssertions.isGreater(_actual, _limit);
		assertEquals(expResult, result);
		fail("The test case is a prototype.");
	}

	@Test
	public void testIsGreaterOrEqual_int_int() {
		System.out.println("PrimitiveAssertionsTest >>> isGreaterOrEqual");
		int _actual = 0;
		int _limit = 0;
		boolean expResult = false;
		boolean result = PrimitiveAssertions.isGreaterOrEqual(_actual, _limit);
		assertEquals(expResult, result);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertGreater_int_int() {
		System.out.println("PrimitiveAssertionsTest >>> assertGreater");
		int _actual = 0;
		int _limit = 0;
		PrimitiveAssertions.assertGreater(_actual, _limit);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertGreater_3args_2() {
		System.out.println("PrimitiveAssertionsTest >>> assertGreater");
		int _actual = 0;
		int _limit = 0;
		String _message = "";
		PrimitiveAssertions.assertGreater(_actual, _limit, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertGreaterOrEqual_int_int() {
		System.out.println("PrimitiveAssertionsTest >>> assertGreaterOrEqual");
		int _actual = 0;
		int _limit = 0;
		PrimitiveAssertions.assertGreaterOrEqual(_actual, _limit);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertGreaterOrEqual_3args_2() {
		System.out.println("PrimitiveAssertionsTest >>> assertGreaterOrEqual");
		int _actual = 0;
		int _limit = 0;
		String _message = "";
		PrimitiveAssertions.assertGreaterOrEqual(_actual, _limit, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertSmaller_int_int() {
		System.out.println("PrimitiveAssertionsTest >>> assertSmaller");
		int _actual = 0;
		int _limit = 0;
		PrimitiveAssertions.assertSmaller(_actual, _limit);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertSmaller_3args_2() {
		System.out.println("PrimitiveAssertionsTest >>> assertSmaller");
		int _actual = 0;
		int _limit = 0;
		String _message = "";
		PrimitiveAssertions.assertSmaller(_actual, _limit, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertSmallerOrEqual_int_int() {
		System.out.println("PrimitiveAssertionsTest >>> assertSmallerOrEqual");
		int _actual = 0;
		int _limit = 0;
		PrimitiveAssertions.assertSmallerOrEqual(_actual, _limit);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertSmallerOrEqual_3args_2() {
		System.out.println("PrimitiveAssertionsTest >>> assertSmallerOrEqual");
		int _actual = 0;
		int _limit = 0;
		String _message = "";
		PrimitiveAssertions.assertSmallerOrEqual(_actual, _limit, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testIsZero_long() {
		System.out.println("PrimitiveAssertionsTest >>> isZero");
		long _actual = 0L;
		boolean expResult = false;
		boolean result = PrimitiveAssertions.isZero(_actual);
		assertEquals(expResult, result);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertZero_long() {
		System.out.println("PrimitiveAssertionsTest >>> assertZero");
		long _actual = 0L;
		PrimitiveAssertions.assertZero(_actual);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertZero_long_String() {
		System.out.println("PrimitiveAssertionsTest >>> assertZero");
		long _actual = 0L;
		String _message = "";
		PrimitiveAssertions.assertZero(_actual, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testIsEqual_long_long() {
		System.out.println("PrimitiveAssertionsTest >>> isEqual");
		long _actual = 0L;
		long _expected = 0L;
		boolean expResult = false;
		boolean result = PrimitiveAssertions.isEqual(_actual, _expected);
		assertEquals(expResult, result);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertEquals_long_long() {
		System.out.println("PrimitiveAssertionsTest >>> assertEquals");
		long _actual = 0L;
		long _expected = 0L;
		PrimitiveAssertions.assertEquals(_actual, _expected);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertEquals_3args_6() {
		System.out.println("PrimitiveAssertionsTest >>> assertEquals");
		long _actual = 0L;
		long _expected = 0L;
		String _message = "";
		PrimitiveAssertions.assertEquals(_actual, _expected, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertNotEquals_long_long() {
		System.out.println("PrimitiveAssertionsTest >>> assertNotEquals");
		long _actual = 0L;
		long _expected = 0L;
		PrimitiveAssertions.assertNotEquals(_actual, _expected);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertNotEquals_3args_6() {
		System.out.println("PrimitiveAssertionsTest >>> assertNotEquals");
		long _actual = 0L;
		long _expected = 0L;
		String _message = "";
		PrimitiveAssertions.assertNotEquals(_actual, _expected, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testIsGreater_long_long() {
		System.out.println("PrimitiveAssertionsTest >>> isGreater");
		long _actual = 0L;
		long _limit = 0L;
		boolean expResult = false;
		boolean result = PrimitiveAssertions.isGreater(_actual, _limit);
		assertEquals(expResult, result);
		fail("The test case is a prototype.");
	}

	@Test
	public void testIsGreaterOrEqual_long_long() {
		System.out.println("PrimitiveAssertionsTest >>> isGreaterOrEqual");
		long _actual = 0L;
		long _limit = 0L;
		boolean expResult = false;
		boolean result = PrimitiveAssertions.isGreaterOrEqual(_actual, _limit);
		assertEquals(expResult, result);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertGreater_long_long() {
		System.out.println("PrimitiveAssertionsTest >>> assertGreater");
		long _actual = 0L;
		long _limit = 0L;
		PrimitiveAssertions.assertGreater(_actual, _limit);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertGreater_3args_3() {
		System.out.println("PrimitiveAssertionsTest >>> assertGreater");
		long _actual = 0L;
		long _limit = 0L;
		String _message = "";
		PrimitiveAssertions.assertGreater(_actual, _limit, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertGreaterOrEqual_long_long() {
		System.out.println("PrimitiveAssertionsTest >>> assertGreaterOrEqual");
		long _actual = 0L;
		long _limit = 0L;
		PrimitiveAssertions.assertGreaterOrEqual(_actual, _limit);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertGreaterOrEqual_3args_3() {
		System.out.println("PrimitiveAssertionsTest >>> assertGreaterOrEqual");
		long _actual = 0L;
		long _limit = 0L;
		String _message = "";
		PrimitiveAssertions.assertGreaterOrEqual(_actual, _limit, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertSmaller_long_long() {
		System.out.println("PrimitiveAssertionsTest >>> assertSmaller");
		long _actual = 0L;
		long _limit = 0L;
		PrimitiveAssertions.assertSmaller(_actual, _limit);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertSmaller_3args_3() {
		System.out.println("PrimitiveAssertionsTest >>> assertSmaller");
		long _actual = 0L;
		long _limit = 0L;
		String _message = "";
		PrimitiveAssertions.assertSmaller(_actual, _limit, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertSmallerOrEqual_long_long() {
		System.out.println("PrimitiveAssertionsTest >>> assertSmallerOrEqual");
		long _actual = 0L;
		long _limit = 0L;
		PrimitiveAssertions.assertSmallerOrEqual(_actual, _limit);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertSmallerOrEqual_3args_3() {
		System.out.println("PrimitiveAssertionsTest >>> assertSmallerOrEqual");
		long _actual = 0L;
		long _limit = 0L;
		String _message = "";
		PrimitiveAssertions.assertSmallerOrEqual(_actual, _limit, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testIsZero_float() {
		System.out.println("PrimitiveAssertionsTest >>> isZero");
		float _actual = 0.0F;
		boolean expResult = false;
		boolean result = PrimitiveAssertions.isZero(_actual);
		assertEquals(expResult, result);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertZero_float() {
		System.out.println("PrimitiveAssertionsTest >>> assertZero");
		float _actual = 0.0F;
		PrimitiveAssertions.assertZero(_actual);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertZero_float_String() {
		System.out.println("PrimitiveAssertionsTest >>> assertZero");
		float _actual = 0.0F;
		String _message = "";
		PrimitiveAssertions.assertZero(_actual, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testIsEqual_float_float() {
		System.out.println("PrimitiveAssertionsTest >>> isEqual");
		float _actual = 0.0F;
		float _expected = 0.0F;
		boolean expResult = false;
		boolean result = PrimitiveAssertions.isEqual(_actual, _expected);
		assertEquals(expResult, result);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertEquals_float_float() {
		System.out.println("PrimitiveAssertionsTest >>> assertEquals");
		float _actual = 0.0F;
		float _expected = 0.0F;
		PrimitiveAssertions.assertEquals(_actual, _expected);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertEquals_3args_7() {
		System.out.println("PrimitiveAssertionsTest >>> assertEquals");
		float _actual = 0.0F;
		float _expected = 0.0F;
		String _message = "";
		PrimitiveAssertions.assertEquals(_actual, _expected, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertNotEquals_float_float() {
		System.out.println("PrimitiveAssertionsTest >>> assertNotEquals");
		float _actual = 0.0F;
		float _expected = 0.0F;
		PrimitiveAssertions.assertNotEquals(_actual, _expected);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertNotEquals_3args_7() {
		System.out.println("PrimitiveAssertionsTest >>> assertNotEquals");
		float _actual = 0.0F;
		float _expected = 0.0F;
		String _message = "";
		PrimitiveAssertions.assertNotEquals(_actual, _expected, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testIsGreater_float_float() {
		System.out.println("PrimitiveAssertionsTest >>> isGreater");
		float _actual = 0.0F;
		float _limit = 0.0F;
		boolean expResult = false;
		boolean result = PrimitiveAssertions.isGreater(_actual, _limit);
		assertEquals(expResult, result);
		fail("The test case is a prototype.");
	}

	@Test
	public void testIsGreaterOrEqual_float_float() {
		System.out.println("PrimitiveAssertionsTest >>> isGreaterOrEqual");
		float _actual = 0.0F;
		float _limit = 0.0F;
		boolean expResult = false;
		boolean result = PrimitiveAssertions.isGreaterOrEqual(_actual, _limit);
		assertEquals(expResult, result);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertGreater_float_float() {
		System.out.println("PrimitiveAssertionsTest >>> assertGreater");
		float _actual = 0.0F;
		float _limit = 0.0F;
		PrimitiveAssertions.assertGreater(_actual, _limit);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertGreater_3args_4() {
		System.out.println("PrimitiveAssertionsTest >>> assertGreater");
		float _actual = 0.0F;
		float _limit = 0.0F;
		String _message = "";
		PrimitiveAssertions.assertGreater(_actual, _limit, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertGreaterOrEqual_float_float() {
		System.out.println("PrimitiveAssertionsTest >>> assertGreaterOrEqual");
		float _actual = 0.0F;
		float _limit = 0.0F;
		PrimitiveAssertions.assertGreaterOrEqual(_actual, _limit);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertGreaterOrEqual_3args_4() {
		System.out.println("PrimitiveAssertionsTest >>> assertGreaterOrEqual");
		float _actual = 0.0F;
		float _limit = 0.0F;
		String _message = "";
		PrimitiveAssertions.assertGreaterOrEqual(_actual, _limit, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertSmaller_float_float() {
		System.out.println("PrimitiveAssertionsTest >>> assertSmaller");
		float _actual = 0.0F;
		float _limit = 0.0F;
		PrimitiveAssertions.assertSmaller(_actual, _limit);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertSmaller_3args_4() {
		System.out.println("PrimitiveAssertionsTest >>> assertSmaller");
		float _actual = 0.0F;
		float _limit = 0.0F;
		String _message = "";
		PrimitiveAssertions.assertSmaller(_actual, _limit, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertSmallerOrEqual_float_float() {
		System.out.println("PrimitiveAssertionsTest >>> assertSmallerOrEqual");
		float _actual = 0.0F;
		float _limit = 0.0F;
		PrimitiveAssertions.assertSmallerOrEqual(_actual, _limit);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertSmallerOrEqual_3args_4() {
		System.out.println("PrimitiveAssertionsTest >>> assertSmallerOrEqual");
		float _actual = 0.0F;
		float _limit = 0.0F;
		String _message = "";
		PrimitiveAssertions.assertSmallerOrEqual(_actual, _limit, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testIsZero_double() {
		System.out.println("PrimitiveAssertionsTest >>> isZero");
		double _actual = 0.0;
		boolean expResult = false;
		boolean result = PrimitiveAssertions.isZero(_actual);
		assertEquals(expResult, result);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertZero_double() {
		System.out.println("PrimitiveAssertionsTest >>> assertZero");
		double _actual = 0.0;
		PrimitiveAssertions.assertZero(_actual);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertZero_double_String() {
		System.out.println("PrimitiveAssertionsTest >>> assertZero");
		double _actual = 0.0;
		String _message = "";
		PrimitiveAssertions.assertZero(_actual, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testIsEqual_double_double() {
		System.out.println("PrimitiveAssertionsTest >>> isEqual");
		double _actual = 0.0;
		double _expected = 0.0;
		boolean expResult = false;
		boolean result = PrimitiveAssertions.isEqual(_actual, _expected);
		assertEquals(expResult, result);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertEquals_double_double() {
		System.out.println("PrimitiveAssertionsTest >>> assertEquals");
		double _actual = 0.0;
		double _expected = 0.0;
		PrimitiveAssertions.assertEquals(_actual, _expected);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertEquals_3args_8() {
		System.out.println("PrimitiveAssertionsTest >>> assertEquals");
		double _actual = 0.0;
		double _expected = 0.0;
		String _message = "";
		PrimitiveAssertions.assertEquals(_actual, _expected, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertNotEquals_double_double() {
		System.out.println("PrimitiveAssertionsTest >>> assertNotEquals");
		double _actual = 0.0;
		double _expected = 0.0;
		PrimitiveAssertions.assertNotEquals(_actual, _expected);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertNotEquals_3args_8() {
		System.out.println("PrimitiveAssertionsTest >>> assertNotEquals");
		double _actual = 0.0;
		double _expected = 0.0;
		String _message = "";
		PrimitiveAssertions.assertNotEquals(_actual, _expected, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testIsGreater_double_double() {
		System.out.println("PrimitiveAssertionsTest >>> isGreater");
		double _actual = 0.0;
		double _limit = 0.0;
		boolean expResult = false;
		boolean result = PrimitiveAssertions.isGreater(_actual, _limit);
		assertEquals(expResult, result);
		fail("The test case is a prototype.");
	}

	@Test
	public void testIsGreaterOrEqual_double_double() {
		System.out.println("PrimitiveAssertionsTest >>> isGreaterOrEqual");
		double _actual = 0.0;
		double _limit = 0.0;
		boolean expResult = false;
		boolean result = PrimitiveAssertions.isGreaterOrEqual(_actual, _limit);
		assertEquals(expResult, result);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertGreater_double_double() {
		System.out.println("PrimitiveAssertionsTest >>> assertGreater");
		double _actual = 0.0;
		double _limit = 0.0;
		PrimitiveAssertions.assertGreater(_actual, _limit);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertGreater_3args_5() {
		System.out.println("PrimitiveAssertionsTest >>> assertGreater");
		double _actual = 0.0;
		double _limit = 0.0;
		String _message = "";
		PrimitiveAssertions.assertGreater(_actual, _limit, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertGreaterOrEqual_double_double() {
		System.out.println("PrimitiveAssertionsTest >>> assertGreaterOrEqual");
		double _actual = 0.0;
		double _limit = 0.0;
		PrimitiveAssertions.assertGreaterOrEqual(_actual, _limit);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertGreaterOrEqual_3args_5() {
		System.out.println("PrimitiveAssertionsTest >>> assertGreaterOrEqual");
		double _actual = 0.0;
		double _limit = 0.0;
		String _message = "";
		PrimitiveAssertions.assertGreaterOrEqual(_actual, _limit, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertSmaller_double_double() {
		System.out.println("PrimitiveAssertionsTest >>> assertSmaller");
		double _actual = 0.0;
		double _limit = 0.0;
		PrimitiveAssertions.assertSmaller(_actual, _limit);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertSmaller_3args_5() {
		System.out.println("PrimitiveAssertionsTest >>> assertSmaller");
		double _actual = 0.0;
		double _limit = 0.0;
		String _message = "";
		PrimitiveAssertions.assertSmaller(_actual, _limit, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertSmallerOrEqual_double_double() {
		System.out.println("PrimitiveAssertionsTest >>> assertSmallerOrEqual");
		double _actual = 0.0;
		double _limit = 0.0;
		PrimitiveAssertions.assertSmallerOrEqual(_actual, _limit);
		fail("The test case is a prototype.");
	}

	@Test
	public void testAssertSmallerOrEqual_3args_5() {
		System.out.println("PrimitiveAssertionsTest >>> assertSmallerOrEqual");
		double _actual = 0.0;
		double _limit = 0.0;
		String _message = "";
		PrimitiveAssertions.assertSmallerOrEqual(_actual, _limit, _message);
		fail("The test case is a prototype.");
	}
*/	
}
