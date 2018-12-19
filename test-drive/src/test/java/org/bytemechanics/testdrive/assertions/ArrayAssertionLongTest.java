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
public class ArrayAssertionLongTest {
	
	@Test
	public void testIsEmpty() {
		System.out.println("ArrayAssertionLongTest >>> testIsEmpty");
		Assert.assertTrue(ArrayAssertions.isEmpty(new long[0]));
		Assert.assertFalse(ArrayAssertions.isEmpty(new long[1]));
	}

	@Test
	public void testAssertEmpty() {
		System.out.println("ArrayAssertionLongTest >>> testAssertEmpty");
		ArrayAssertions.assertEmpty(new long[0]);
	}
	@Test
	public void testAssertEmpty_failed() {
		System.out.println("ArrayAssertionLongTest >>> testAssertEmpty_failed");
		try{
			ArrayAssertions.assertEmpty(new long[1]);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.length=0):\n\tActual:\t\t1\n\tExpected:\t.length=0", e.getMessage());
		}
	}

	@Test
	public void testAssertEmpty_Message() {
		System.out.println("ArrayAssertionLongTest >>> testAssertEmpty_Message");
		ArrayAssertions.assertEmpty(new long[0],"Message");
	}
	@Test
	public void testAssertEmpty_Message_failed() {
		System.out.println("ArrayAssertionLongTest >>> testAssertEmpty_Message_failed");
		try{
			ArrayAssertions.assertEmpty(new long[1],"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.length=0):\n\tActual:\t\t1\n\tExpected:\t.length=0", e.getMessage());
		}
	}

	@Test
	public void testAssertNotEmpty() {
		System.out.println("ArrayAssertionLongTest >>> testAssertNotEmpty");
		ArrayAssertions.assertNotEmpty(new long[1]);
	}
	@Test
	public void testAssertNotEmpty_failed() {
		System.out.println("ArrayAssertionLongTest >>> testAssertNotEmpty_failed");
		try{
			ArrayAssertions.assertNotEmpty(new long[0]);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(0.length>0):\n\tActual:\t\t0\n\tExpected:\t.length>0", e.getMessage());
		}
	}

	@Test
	public void testAssertNotEmpty_Message() {
		System.out.println("ArrayAssertionLongTest >>> testAssertNotEmpty_Message");
		ArrayAssertions.assertNotEmpty(new long[1],"Message");
	}
	@Test
	public void testAssertNotEmpty_Message_failed() {
		System.out.println("ArrayAssertionLongTest >>> testAssertNotEmpty_Message_failed");
		try{
			ArrayAssertions.assertNotEmpty(new long[0],"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(0.length>0):\n\tActual:\t\t0\n\tExpected:\t.length>0", e.getMessage());
		}
	}

	@Test
	public void testIsSame() {
		System.out.println("ArrayAssertionLongTest >>> testIsSame");
		long[] expected = new long[]{1l};
		Assert.assertTrue(ArrayAssertions.isSame((long[])null,(long[]) null));
		Assert.assertTrue(ArrayAssertions.isSame(expected, expected));
		Assert.assertFalse(ArrayAssertions.isSame(new long[1], new long[1]));
	}

	@Test
	public void testAssertSame() {
		System.out.println("ArrayAssertionLongTest >>> testAssertSame");
		long[] expected = new long[]{1l};
		ArrayAssertions.assertSame(expected, expected);
	}
	@Test
	public void testAssertSame_failed() {
		System.out.println("ArrayAssertionLongTest >>> testAssertSame_failed");
		try{
			ArrayAssertions.assertSame(new long[]{1l}, new long[]{1l});
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([1]=[1]):\n\tActual:\t\t[1]\n\tExpected:\t=[1]", e.getMessage());
		}
	}
	@Test
	public void testAssertSame_Message() {
		System.out.println("ArrayAssertionLongTest >>> testAssertSame_Message");
		long[] expected = new long[]{1l};
		ArrayAssertions.assertSame(expected, expected,"Message");
	}
	@Test
	public void testAssertSame_Message_failed() {
		System.out.println("ArrayAssertionLongTest >>> testAssertSame_Message_failed");
		try{
			ArrayAssertions.assertSame(new long[]{1l}, new long[]{1l},"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([1]=[1]):\n\tActual:\t\t[1]\n\tExpected:\t=[1]", e.getMessage());
		}
	}

	@Test
	public void testAssertNotSame() {
		System.out.println("ArrayAssertionLongTest >>> testAssertNotSame");
		ArrayAssertions.assertNotSame(new long[]{1l}, new long[]{1l});
	}
	@Test
	public void testAssertNotSame_failed() {
		System.out.println("ArrayAssertionLongTest >>> testAssertNotSame_failed");
		try{
			long[] expected = new long[]{1l};
			ArrayAssertions.assertNotSame(expected,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([1]!=[1]):\n\tActual:\t\t[1]\n\tExpected:\t!=[1]", e.getMessage());
		}
	}

	@Test
	public void testAssertNotSame_Message() {
		System.out.println("ArrayAssertionLongTest >>> testAssertNotSame_Message");
		ArrayAssertions.assertNotSame(new long[]{1l}, new long[]{1l},"Message");
	}
	@Test
	public void testAssertNotSame_Message_failed() {
		System.out.println("ArrayAssertionLongTest >>> testAssertNotSame_Message_failed");
		try{
			long[] expected = new long[]{1l};
			ArrayAssertions.assertNotSame(expected,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([1]!=[1]):\n\tActual:\t\t[1]\n\tExpected:\t!=[1]", e.getMessage());
		}
	}

	@Test
	public void testIsEqual() {
		System.out.println("ArrayAssertionLongTest >>> testIsEqual");
		Assert.assertTrue(ArrayAssertions.equals((long[])null,(long[]) null));
		long[] expected = new long[]{1l};
		Assert.assertTrue(ArrayAssertions.equals(expected, expected));
		Assert.assertTrue(ArrayAssertions.equals(new long[]{1l,2l}, new long[]{1l,2l}));
		Assert.assertFalse(ArrayAssertions.equals(new long[]{1l,2l}, new long[]{2l,1l}));
		Assert.assertFalse(ArrayAssertions.equals(new long[]{1l}, new long[]{2l,1l}));
	}

	@Test
	public void testAssertEquals() {
		System.out.println("ArrayAssertionLongTest >>> testAssertEquals");
		ArrayAssertions.assertEquals((long[])null,(long[])null);
		long[] expected = new long[]{1l};
		ArrayAssertions.assertEquals(expected, expected);
		ArrayAssertions.assertEquals(new long[]{1l,2l}, new long[]{1l,2l});
	}
	@Test
	public void testAssertEquals_failed() {
		System.out.println("ArrayAssertionLongTest >>> testAssertEquals_failed");
		try{
			ArrayAssertions.assertEquals(new long[]{1l,2l}, new long[]{2l,1l});
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([1, 2]~[2, 1]):\n\tActual:\t\t[1, 2]\n\tExpected:\t~[2, 1]", e.getMessage());
		}
		try{
			ArrayAssertions.assertEquals(new long[]{1l}, new long[]{2l,1l});
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([1]~[2, 1]):\n\tActual:\t\t[1]\n\tExpected:\t~[2, 1]", e.getMessage());
		}
	}
	@Test
	public void testAssertEquals_Message() {
		System.out.println("ArrayAssertionLongTest >>> testAssertEquals_Message");
		ArrayAssertions.assertEquals((long[])null,(long[])null,"Message");
		long[] expected = new long[]{1l};
		ArrayAssertions.assertEquals(expected, expected,"Message");
		ArrayAssertions.assertEquals(new long[]{1l,2l}, new long[]{1l,2l},"Message");
	}
	@Test
	public void testAssertEquals_Message_failed() {
		System.out.println("ArrayAssertionLongTest >>> testAssertEquals_Message_failed");
		try{
			ArrayAssertions.assertEquals(new long[]{1l,2l}, new long[]{2l,1l},"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([1, 2]~[2, 1]):\n\tActual:\t\t[1, 2]\n\tExpected:\t~[2, 1]", e.getMessage());
		}
		try{
			ArrayAssertions.assertEquals(new long[]{1l}, new long[]{2l,1l},"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([1]~[2, 1]):\n\tActual:\t\t[1]\n\tExpected:\t~[2, 1]", e.getMessage());
		}
	}

	@Test
	public void testAssertNotEquals() {
		System.out.println("ArrayAssertionLongTest >>> testAssertNotEquals");
		ArrayAssertions.assertNotEquals(new long[]{1l,2l}, new long[]{2l,1l});
		ArrayAssertions.assertNotEquals(new long[]{1l}, new long[]{2l,1l});
	}
	@Test
	public void testAssertNotEquals_failed() {
		System.out.println("ArrayAssertionLongTest >>> testAssertNotEquals_failed");
		try{
			ArrayAssertions.assertNotEquals((long[])null,(long[])null);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(null!~null):\n\tActual:\t\tnull\n\tExpected:\t!~null", e.getMessage());
		}
		try{
			long[] expected = new long[]{1l};
			ArrayAssertions.assertNotEquals(expected, expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([1]!~[1]):\n\tActual:\t\t[1]\n\tExpected:\t!~[1]", e.getMessage());
		}
		try{
			ArrayAssertions.assertNotEquals(new long[]{1l,2l}, new long[]{1l,2l});
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([1, 2]!~[1, 2]):\n\tActual:\t\t[1, 2]\n\tExpected:\t!~[1, 2]", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_Message() {
		System.out.println("ArrayAssertionLongTest >>> testAssertNotEquals_Message");
		ArrayAssertions.assertNotEquals(new long[]{1l,2l}, new long[]{2l,1l},"Message");
		ArrayAssertions.assertNotEquals(new long[]{1l}, new long[]{2l,1l},"Message");
	}
	@Test
	public void testAssertNotEquals_Message_failed() {
		System.out.println("ArrayAssertionLongTest >>> testAssertNotEquals_Message_failed");
		try{
			ArrayAssertions.assertNotEquals((long[])null,(long[])null,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(null!~null):\n\tActual:\t\tnull\n\tExpected:\t!~null", e.getMessage());
		}
		try{
			long[] expected = new long[]{1l};
			ArrayAssertions.assertNotEquals(expected, expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([1]!~[1]):\n\tActual:\t\t[1]\n\tExpected:\t!~[1]", e.getMessage());
		}
		try{
			ArrayAssertions.assertNotEquals(new long[]{1l,2l}, new long[]{1l,2l},"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([1, 2]!~[1, 2]):\n\tActual:\t\t[1, 2]\n\tExpected:\t!~[1, 2]", e.getMessage());
		}
	}	
}
