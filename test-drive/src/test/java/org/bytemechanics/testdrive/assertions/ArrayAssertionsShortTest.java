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
public class ArrayAssertionsShortTest {
	
	@Test
	public void testIsEmpty() {
		System.out.println("ArrayAssertionsShortTest >>> testIsEmpty");
		Assert.assertTrue(ArrayAssertions.isEmpty(new short[0]));
		Assert.assertFalse(ArrayAssertions.isEmpty(new short[1]));
	}

	@Test
	public void testAssertEmpty() {
		System.out.println("ArrayAssertionsShortTest >>> testAssertEmpty");
		ArrayAssertions.assertEmpty(new short[0]);
	}
	@Test
	public void testAssertEmpty_failed() {
		System.out.println("ArrayAssertionsShortTest >>> testAssertEmpty_failed");
		try{
			ArrayAssertions.assertEmpty(new short[1]);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.length=0):\n\tActual:\t\t1\n\tExpected:\t.length=0", e.getMessage());
		}
	}

	@Test
	public void testAssertEmpty_Message() {
		System.out.println("ArrayAssertionsShortTest >>> testAssertEmpty_Message");
		ArrayAssertions.assertEmpty(new short[0],"Message");
	}
	@Test
	public void testAssertEmpty_Message_failed() {
		System.out.println("ArrayAssertionsShortTest >>> testAssertEmpty_Message_failed");
		try{
			ArrayAssertions.assertEmpty(new short[1],"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.length=0):\n\tActual:\t\t1\n\tExpected:\t.length=0", e.getMessage());
		}
	}

	@Test
	public void testAssertNotEmpty() {
		System.out.println("ArrayAssertionsShortTest >>> testAssertNotEmpty");
		ArrayAssertions.assertNotEmpty(new short[1]);
	}
	@Test
	public void testAssertNotEmpty_failed() {
		System.out.println("ArrayAssertionsShortTest >>> testAssertNotEmpty_failed");
		try{
			ArrayAssertions.assertNotEmpty(new short[0]);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(0.length>0):\n\tActual:\t\t0\n\tExpected:\t.length>0", e.getMessage());
		}
	}

	@Test
	public void testAssertNotEmpty_Message() {
		System.out.println("ArrayAssertionsShortTest >>> testAssertNotEmpty_Message");
		ArrayAssertions.assertNotEmpty(new short[1],"Message");
	}
	@Test
	public void testAssertNotEmpty_Message_failed() {
		System.out.println("ArrayAssertionsShortTest >>> testAssertNotEmpty_Message_failed");
		try{
			ArrayAssertions.assertNotEmpty(new short[0],"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(0.length>0):\n\tActual:\t\t0\n\tExpected:\t.length>0", e.getMessage());
		}
	}

	@Test
	public void testIsSame() {
		System.out.println("ArrayAssertionsShortTest >>> testIsSame");
		short[] expected = new short[]{1};
		Assert.assertTrue(ArrayAssertions.isSame((short[])null,(short[]) null));
		Assert.assertTrue(ArrayAssertions.isSame(expected, expected));
		Assert.assertFalse(ArrayAssertions.isSame(new short[1], new short[1]));
	}

	@Test
	public void testAssertSame() {
		System.out.println("ArrayAssertionsShortTest >>> testAssertSame");
		short[] expected = new short[]{1};
		ArrayAssertions.assertSame(expected, expected);
	}
	@Test
	public void testAssertSame_failed() {
		System.out.println("ArrayAssertionsShortTest >>> testAssertSame_failed");
		try{
			ArrayAssertions.assertSame(new short[]{1}, new short[]{1});
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([1]=[1]):\n\tActual:\t\t[1]\n\tExpected:\t=[1]", e.getMessage());
		}
	}
	@Test
	public void testAssertSame_Message() {
		System.out.println("ArrayAssertionsShortTest >>> testAssertSame_Message");
		short[] expected = new short[]{1};
		ArrayAssertions.assertSame(expected, expected,"Message");
	}
	@Test
	public void testAssertSame_Message_failed() {
		System.out.println("ArrayAssertionsShortTest >>> testAssertSame_Message_failed");
		try{
			ArrayAssertions.assertSame(new short[]{1}, new short[]{1},"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([1]=[1]):\n\tActual:\t\t[1]\n\tExpected:\t=[1]", e.getMessage());
		}
	}

	@Test
	public void testAssertNotSame() {
		System.out.println("ArrayAssertionsShortTest >>> testAssertNotSame");
		ArrayAssertions.assertNotSame(new short[]{1}, new short[]{1});
	}
	@Test
	public void testAssertNotSame_failed() {
		System.out.println("ArrayAssertionsShortTest >>> testAssertNotSame_failed");
		try{
			short[] expected = new short[]{1};
			ArrayAssertions.assertNotSame(expected,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([1]!=[1]):\n\tActual:\t\t[1]\n\tExpected:\t!=[1]", e.getMessage());
		}
	}

	@Test
	public void testAssertNotSame_Message() {
		System.out.println("ArrayAssertionsShortTest >>> testAssertNotSame_Message");
		ArrayAssertions.assertNotSame(new short[]{1}, new short[]{1},"Message");
	}
	@Test
	public void testAssertNotSame_Message_failed() {
		System.out.println("ArrayAssertionsShortTest >>> testAssertNotSame_Message_failed");
		try{
			short[] expected = new short[]{1};
			ArrayAssertions.assertNotSame(expected,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([1]!=[1]):\n\tActual:\t\t[1]\n\tExpected:\t!=[1]", e.getMessage());
		}
	}

	@Test
	public void testIsEqual() {
		System.out.println("ArrayAssertionsShortTest >>> testIsEqual");
		Assert.assertTrue(ArrayAssertions.equals((short[])null,(short[]) null));
		short[] expected = new short[]{1};
		Assert.assertTrue(ArrayAssertions.equals(expected, expected));
		Assert.assertTrue(ArrayAssertions.equals(new short[]{1,2}, new short[]{1,2}));
		Assert.assertFalse(ArrayAssertions.equals(new short[]{1,2}, new short[]{2,1}));
		Assert.assertFalse(ArrayAssertions.equals(new short[]{1}, new short[]{2,1}));
	}

	@Test
	public void testAssertEquals() {
		System.out.println("ArrayAssertionsShortTest >>> testAssertEquals");
		ArrayAssertions.assertEquals((short[])null,(short[])null);
		short[] expected = new short[]{1};
		ArrayAssertions.assertEquals(expected, expected);
		ArrayAssertions.assertEquals(new short[]{1,2}, new short[]{1,2});
	}
	@Test
	public void testAssertEquals_failed() {
		System.out.println("ArrayAssertionsShortTest >>> testAssertEquals_failed");
		try{
			ArrayAssertions.assertEquals(new short[]{1,2}, new short[]{2,1});
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([1, 2]~[2, 1]):\n\tActual:\t\t[1, 2]\n\tExpected:\t~[2, 1]", e.getMessage());
		}
		try{
			ArrayAssertions.assertEquals(new short[]{1}, new short[]{2,1});
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([1]~[2, 1]):\n\tActual:\t\t[1]\n\tExpected:\t~[2, 1]", e.getMessage());
		}
	}
	@Test
	public void testAssertEquals_Message() {
		System.out.println("ArrayAssertionsShortTest >>> testAssertEquals_Message");
		ArrayAssertions.assertEquals((short[])null,(short[])null,"Message");
		short[] expected = new short[]{1};
		ArrayAssertions.assertEquals(expected, expected,"Message");
		ArrayAssertions.assertEquals(new short[]{1,2}, new short[]{1,2},"Message");
	}
	@Test
	public void testAssertEquals_Message_failed() {
		System.out.println("ArrayAssertionsShortTest >>> testAssertEquals_Message_failed");
		try{
			ArrayAssertions.assertEquals(new short[]{1,2}, new short[]{2,1},"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([1, 2]~[2, 1]):\n\tActual:\t\t[1, 2]\n\tExpected:\t~[2, 1]", e.getMessage());
		}
		try{
			ArrayAssertions.assertEquals(new short[]{1}, new short[]{2,1},"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([1]~[2, 1]):\n\tActual:\t\t[1]\n\tExpected:\t~[2, 1]", e.getMessage());
		}
	}

	@Test
	public void testAssertNotEquals() {
		System.out.println("ArrayAssertionsShortTest >>> testAssertNotEquals");
		ArrayAssertions.assertNotEquals(new short[]{1,2}, new short[]{2,1});
		ArrayAssertions.assertNotEquals(new short[]{1}, new short[]{2,1});
	}
	@Test
	public void testAssertNotEquals_failed() {
		System.out.println("ArrayAssertionsShortTest >>> testAssertNotEquals_failed");
		try{
			ArrayAssertions.assertNotEquals((short[])null,(short[])null);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(null!~null):\n\tActual:\t\tnull\n\tExpected:\t!~null", e.getMessage());
		}
		try{
			short[] expected = new short[]{1};
			ArrayAssertions.assertNotEquals(expected, expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([1]!~[1]):\n\tActual:\t\t[1]\n\tExpected:\t!~[1]", e.getMessage());
		}
		try{
			ArrayAssertions.assertNotEquals(new short[]{1,2}, new short[]{1,2});
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([1, 2]!~[1, 2]):\n\tActual:\t\t[1, 2]\n\tExpected:\t!~[1, 2]", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_Message() {
		System.out.println("ArrayAssertionsShortTest >>> testAssertNotEquals_Message");
		ArrayAssertions.assertNotEquals(new short[]{1,2}, new short[]{2,1},"Message");
		ArrayAssertions.assertNotEquals(new short[]{1}, new short[]{2,1},"Message");
	}
	@Test
	public void testAssertNotEquals_Message_failed() {
		System.out.println("ArrayAssertionsShortTest >>> testAssertNotEquals_Message_failed");
		try{
			ArrayAssertions.assertNotEquals((short[])null,(short[])null,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(null!~null):\n\tActual:\t\tnull\n\tExpected:\t!~null", e.getMessage());
		}
		try{
			short[] expected = new short[]{1};
			ArrayAssertions.assertNotEquals(expected, expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([1]!~[1]):\n\tActual:\t\t[1]\n\tExpected:\t!~[1]", e.getMessage());
		}
		try{
			ArrayAssertions.assertNotEquals(new short[]{1,2}, new short[]{1,2},"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([1, 2]!~[1, 2]):\n\tActual:\t\t[1, 2]\n\tExpected:\t!~[1, 2]", e.getMessage());
		}
	}	
}
