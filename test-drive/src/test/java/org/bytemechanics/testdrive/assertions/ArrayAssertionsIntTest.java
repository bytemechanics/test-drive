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
public class ArrayAssertionsIntTest {
	
	@Test
	public void testIsEmpty() {
		System.out.println("ArrayAssertionsIntTest >>> testIsEmpty");
		Assert.assertTrue(ArrayAssertions.isEmpty(new int[0]));
		Assert.assertFalse(ArrayAssertions.isEmpty(new int[1]));
	}

	@Test
	public void testAssertEmpty() {
		System.out.println("ArrayAssertionsIntTest >>> testAssertEmpty");
		ArrayAssertions.assertEmpty(new int[0]);
	}
	@Test
	public void testAssertEmpty_failed() {
		System.out.println("ArrayAssertionsIntTest >>> testAssertEmpty_failed");
		try{
			ArrayAssertions.assertEmpty(new int[1]);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.length=0):\n\tActual:\t\t1\n\tExpected:\t.length=0", e.getMessage());
		}
	}

	@Test
	public void testAssertEmpty_Message() {
		System.out.println("ArrayAssertionsIntTest >>> testAssertEmpty_Message");
		ArrayAssertions.assertEmpty(new int[0],"Message");
	}
	@Test
	public void testAssertEmpty_Message_failed() {
		System.out.println("ArrayAssertionsIntTest >>> testAssertEmpty_Message_failed");
		try{
			ArrayAssertions.assertEmpty(new int[1],"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.length=0):\n\tActual:\t\t1\n\tExpected:\t.length=0", e.getMessage());
		}
	}

	@Test
	public void testAssertNotEmpty() {
		System.out.println("ArrayAssertionsIntTest >>> testAssertNotEmpty");
		ArrayAssertions.assertNotEmpty(new int[1]);
	}
	@Test
	public void testAssertNotEmpty_failed() {
		System.out.println("ArrayAssertionsIntTest >>> testAssertNotEmpty_failed");
		try{
			ArrayAssertions.assertNotEmpty(new int[0]);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(0.length>0):\n\tActual:\t\t0\n\tExpected:\t.length>0", e.getMessage());
		}
	}

	@Test
	public void testAssertNotEmpty_Message() {
		System.out.println("ArrayAssertionsIntTest >>> testAssertNotEmpty_Message");
		ArrayAssertions.assertNotEmpty(new int[1],"Message");
	}
	@Test
	public void testAssertNotEmpty_Message_failed() {
		System.out.println("ArrayAssertionsIntTest >>> testAssertNotEmpty_Message_failed");
		try{
			ArrayAssertions.assertNotEmpty(new int[0],"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(0.length>0):\n\tActual:\t\t0\n\tExpected:\t.length>0", e.getMessage());
		}
	}

	@Test
	public void testIsSame() {
		System.out.println("ArrayAssertionsIntTest >>> testIsSame");
		int[] expected = new int[]{1};
		Assert.assertTrue(ArrayAssertions.isSame((int[])null,(int[]) null));
		Assert.assertTrue(ArrayAssertions.isSame(expected, expected));
		Assert.assertFalse(ArrayAssertions.isSame(new int[1], new int[1]));
	}

	@Test
	public void testAssertSame() {
		System.out.println("ArrayAssertionsIntTest >>> testAssertSame");
		int[] expected = new int[]{1};
		ArrayAssertions.assertSame(expected, expected);
	}
	@Test
	public void testAssertSame_failed() {
		System.out.println("ArrayAssertionsIntTest >>> testAssertSame_failed");
		try{
			ArrayAssertions.assertSame(new int[]{1}, new int[]{1});
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([1]=[1]):\n\tActual:\t\t[1]\n\tExpected:\t=[1]", e.getMessage());
		}
	}
	@Test
	public void testAssertSame_Message() {
		System.out.println("ArrayAssertionsIntTest >>> testAssertSame_Message");
		int[] expected = new int[]{1};
		ArrayAssertions.assertSame(expected, expected,"Message");
	}
	@Test
	public void testAssertSame_Message_failed() {
		System.out.println("ArrayAssertionsIntTest >>> testAssertSame_Message_failed");
		try{
			ArrayAssertions.assertSame(new int[]{1}, new int[]{1},"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([1]=[1]):\n\tActual:\t\t[1]\n\tExpected:\t=[1]", e.getMessage());
		}
	}

	@Test
	public void testAssertNotSame() {
		System.out.println("ArrayAssertionsIntTest >>> testAssertNotSame");
		ArrayAssertions.assertNotSame(new int[]{1}, new int[]{1});
	}
	@Test
	public void testAssertNotSame_failed() {
		System.out.println("ArrayAssertionsIntTest >>> testAssertNotSame_failed");
		try{
			int[] expected = new int[]{1};
			ArrayAssertions.assertNotSame(expected,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([1]!=[1]):\n\tActual:\t\t[1]\n\tExpected:\t!=[1]", e.getMessage());
		}
	}

	@Test
	public void testAssertNotSame_Message() {
		System.out.println("ArrayAssertionsIntTest >>> testAssertNotSame_Message");
		ArrayAssertions.assertNotSame(new int[]{1}, new int[]{1},"Message");
	}
	@Test
	public void testAssertNotSame_Message_failed() {
		System.out.println("ArrayAssertionsIntTest >>> testAssertNotSame_Message_failed");
		try{
			int[] expected = new int[]{1};
			ArrayAssertions.assertNotSame(expected,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([1]!=[1]):\n\tActual:\t\t[1]\n\tExpected:\t!=[1]", e.getMessage());
		}
	}

	@Test
	public void testIsEqual() {
		System.out.println("ArrayAssertionsIntTest >>> testIsEqual");
		Assert.assertTrue(ArrayAssertions.equals((int[])null,(int[]) null));
		int[] expected = new int[]{1};
		Assert.assertTrue(ArrayAssertions.equals(expected, expected));
		Assert.assertTrue(ArrayAssertions.equals(new int[]{1,2}, new int[]{1,2}));
		Assert.assertFalse(ArrayAssertions.equals(new int[]{1,2}, new int[]{2,1}));
		Assert.assertFalse(ArrayAssertions.equals(new int[]{1}, new int[]{2,1}));
	}

	@Test
	public void testAssertEquals() {
		System.out.println("ArrayAssertionsIntTest >>> testAssertEquals");
		ArrayAssertions.assertEquals((int[])null,(int[])null);
		int[] expected = new int[]{1};
		ArrayAssertions.assertEquals(expected, expected);
		ArrayAssertions.assertEquals(new int[]{1,2}, new int[]{1,2});
	}
	@Test
	public void testAssertEquals_failed() {
		System.out.println("ArrayAssertionsIntTest >>> testAssertEquals_failed");
		try{
			ArrayAssertions.assertEquals(new int[]{1,2}, new int[]{2,1});
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([1, 2]~[2, 1]):\n\tActual:\t\t[1, 2]\n\tExpected:\t~[2, 1]", e.getMessage());
		}
		try{
			ArrayAssertions.assertEquals(new int[]{1}, new int[]{2,1});
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([1]~[2, 1]):\n\tActual:\t\t[1]\n\tExpected:\t~[2, 1]", e.getMessage());
		}
	}
	@Test
	public void testAssertEquals_Message() {
		System.out.println("ArrayAssertionsIntTest >>> testAssertEquals_Message");
		ArrayAssertions.assertEquals((int[])null,(int[])null,"Message");
		int[] expected = new int[]{1};
		ArrayAssertions.assertEquals(expected, expected,"Message");
		ArrayAssertions.assertEquals(new int[]{1,2}, new int[]{1,2},"Message");
	}
	@Test
	public void testAssertEquals_Message_failed() {
		System.out.println("ArrayAssertionsIntTest >>> testAssertEquals_Message_failed");
		try{
			ArrayAssertions.assertEquals(new int[]{1,2}, new int[]{2,1},"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([1, 2]~[2, 1]):\n\tActual:\t\t[1, 2]\n\tExpected:\t~[2, 1]", e.getMessage());
		}
		try{
			ArrayAssertions.assertEquals(new int[]{1}, new int[]{2,1},"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([1]~[2, 1]):\n\tActual:\t\t[1]\n\tExpected:\t~[2, 1]", e.getMessage());
		}
	}

	@Test
	public void testAssertNotEquals() {
		System.out.println("ArrayAssertionsIntTest >>> testAssertNotEquals");
		ArrayAssertions.assertNotEquals(new int[]{1,2}, new int[]{2,1});
		ArrayAssertions.assertNotEquals(new int[]{1}, new int[]{2,1});
	}
	@Test
	public void testAssertNotEquals_failed() {
		System.out.println("ArrayAssertionsIntTest >>> testAssertNotEquals_failed");
		try{
			ArrayAssertions.assertNotEquals((int[])null,(int[])null);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(null!~null):\n\tActual:\t\tnull\n\tExpected:\t!~null", e.getMessage());
		}
		try{
			int[] expected = new int[]{1};
			ArrayAssertions.assertNotEquals(expected, expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([1]!~[1]):\n\tActual:\t\t[1]\n\tExpected:\t!~[1]", e.getMessage());
		}
		try{
			ArrayAssertions.assertNotEquals(new int[]{1,2}, new int[]{1,2});
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([1, 2]!~[1, 2]):\n\tActual:\t\t[1, 2]\n\tExpected:\t!~[1, 2]", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_Message() {
		System.out.println("ArrayAssertionsIntTest >>> testAssertNotEquals_Message");
		ArrayAssertions.assertNotEquals(new int[]{1,2}, new int[]{2,1},"Message");
		ArrayAssertions.assertNotEquals(new int[]{1}, new int[]{2,1},"Message");
	}
	@Test
	public void testAssertNotEquals_Message_failed() {
		System.out.println("ArrayAssertionsIntTest >>> testAssertNotEquals_Message_failed");
		try{
			ArrayAssertions.assertNotEquals((int[])null,(int[])null,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(null!~null):\n\tActual:\t\tnull\n\tExpected:\t!~null", e.getMessage());
		}
		try{
			int[] expected = new int[]{1};
			ArrayAssertions.assertNotEquals(expected, expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([1]!~[1]):\n\tActual:\t\t[1]\n\tExpected:\t!~[1]", e.getMessage());
		}
		try{
			ArrayAssertions.assertNotEquals(new int[]{1,2}, new int[]{1,2},"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([1, 2]!~[1, 2]):\n\tActual:\t\t[1, 2]\n\tExpected:\t!~[1, 2]", e.getMessage());
		}
	}	
}
