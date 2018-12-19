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
public class ArrayAssertionFloatTest {
	
	@Test
	public void testIsEmpty() {
		System.out.println("ArrayAssertionFloatTest >>> testIsEmpty");
		Assert.assertTrue(ArrayAssertions.isEmpty(new float[0]));
		Assert.assertFalse(ArrayAssertions.isEmpty(new float[1]));
	}

	@Test
	public void testAssertEmpty() {
		System.out.println("ArrayAssertionFloatTest >>> testAssertEmpty");
		ArrayAssertions.assertEmpty(new float[0]);
	}
	@Test
	public void testAssertEmpty_failed() {
		System.out.println("ArrayAssertionFloatTest >>> testAssertEmpty_failed");
		try{
			ArrayAssertions.assertEmpty(new float[1]);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.length=0):\n\tActual:\t\t1\n\tExpected:\t.length=0", e.getMessage());
		}
	}

	@Test
	public void testAssertEmpty_Message() {
		System.out.println("ArrayAssertionFloatTest >>> testAssertEmpty_Message");
		ArrayAssertions.assertEmpty(new float[0],"Message");
	}
	@Test
	public void testAssertEmpty_Message_failed() {
		System.out.println("ArrayAssertionFloatTest >>> testAssertEmpty_Message_failed");
		try{
			ArrayAssertions.assertEmpty(new float[1],"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.length=0):\n\tActual:\t\t1\n\tExpected:\t.length=0", e.getMessage());
		}
	}

	@Test
	public void testAssertNotEmpty() {
		System.out.println("ArrayAssertionFloatTest >>> testAssertNotEmpty");
		ArrayAssertions.assertNotEmpty(new float[1]);
	}
	@Test
	public void testAssertNotEmpty_failed() {
		System.out.println("ArrayAssertionFloatTest >>> testAssertNotEmpty_failed");
		try{
			ArrayAssertions.assertNotEmpty(new float[0]);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(0.length>0):\n\tActual:\t\t0\n\tExpected:\t.length>0", e.getMessage());
		}
	}

	@Test
	public void testAssertNotEmpty_Message() {
		System.out.println("ArrayAssertionFloatTest >>> testAssertNotEmpty_Message");
		ArrayAssertions.assertNotEmpty(new float[1],"Message");
	}
	@Test
	public void testAssertNotEmpty_Message_failed() {
		System.out.println("ArrayAssertionFloatTest >>> testAssertNotEmpty_Message_failed");
		try{
			ArrayAssertions.assertNotEmpty(new float[0],"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(0.length>0):\n\tActual:\t\t0\n\tExpected:\t.length>0", e.getMessage());
		}
	}

	@Test
	public void testIsSame() {
		System.out.println("ArrayAssertionFloatTest >>> testIsSame");
		float[] expected = new float[]{1.0f};
		Assert.assertTrue(ArrayAssertions.isSame((float[])null,(float[]) null));
		Assert.assertTrue(ArrayAssertions.isSame(expected, expected));
		Assert.assertFalse(ArrayAssertions.isSame(new float[1], new float[1]));
	}

	@Test
	public void testAssertSame() {
		System.out.println("ArrayAssertionFloatTest >>> testAssertSame");
		float[] expected = new float[]{1.0f};
		ArrayAssertions.assertSame(expected, expected);
	}
	@Test
	public void testAssertSame_failed() {
		System.out.println("ArrayAssertionFloatTest >>> testAssertSame_failed");
		try{
			ArrayAssertions.assertSame(new float[]{1.0f}, new float[]{1.0f});
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([1.0]=[1.0]):\n\tActual:\t\t[1.0]\n\tExpected:\t=[1.0]", e.getMessage());
		}
	}
	@Test
	public void testAssertSame_Message() {
		System.out.println("ArrayAssertionFloatTest >>> testAssertSame_Message");
		float[] expected = new float[]{1.0f};
		ArrayAssertions.assertSame(expected, expected,"Message");
	}
	@Test
	public void testAssertSame_Message_failed() {
		System.out.println("ArrayAssertionFloatTest >>> testAssertSame_Message_failed");
		try{
			ArrayAssertions.assertSame(new float[]{1.0f}, new float[]{1.0f},"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([1.0]=[1.0]):\n\tActual:\t\t[1.0]\n\tExpected:\t=[1.0]", e.getMessage());
		}
	}

	@Test
	public void testAssertNotSame() {
		System.out.println("ArrayAssertionFloatTest >>> testAssertNotSame");
		ArrayAssertions.assertNotSame(new float[]{1.0f}, new float[]{1.0f});
	}
	@Test
	public void testAssertNotSame_failed() {
		System.out.println("ArrayAssertionFloatTest >>> testAssertNotSame_failed");
		try{
			float[] expected = new float[]{1.0f};
			ArrayAssertions.assertNotSame(expected,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([1.0]!=[1.0]):\n\tActual:\t\t[1.0]\n\tExpected:\t!=[1.0]", e.getMessage());
		}
	}

	@Test
	public void testAssertNotSame_Message() {
		System.out.println("ArrayAssertionFloatTest >>> testAssertNotSame_Message");
		ArrayAssertions.assertNotSame(new float[]{1.0f}, new float[]{1.0f},"Message");
	}
	@Test
	public void testAssertNotSame_Message_failed() {
		System.out.println("ArrayAssertionFloatTest >>> testAssertNotSame_Message_failed");
		try{
			float[] expected = new float[]{1.0f};
			ArrayAssertions.assertNotSame(expected,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([1.0]!=[1.0]):\n\tActual:\t\t[1.0]\n\tExpected:\t!=[1.0]", e.getMessage());
		}
	}

	@Test
	public void testIsEqual() {
		System.out.println("ArrayAssertionFloatTest >>> testIsEqual");
		Assert.assertTrue(ArrayAssertions.equals((float[])null,(float[]) null));
		float[] expected = new float[]{1.0f};
		Assert.assertTrue(ArrayAssertions.equals(expected, expected));
		Assert.assertTrue(ArrayAssertions.equals(new float[]{1.0f,2.0f}, new float[]{1.0f,2.0f}));
		Assert.assertFalse(ArrayAssertions.equals(new float[]{1.0f,2.0f}, new float[]{2.0f,1.0f}));
		Assert.assertFalse(ArrayAssertions.equals(new float[]{1.0f}, new float[]{2.0f,1.0f}));
	}

	@Test
	public void testAssertEquals() {
		System.out.println("ArrayAssertionFloatTest >>> testAssertEquals");
		ArrayAssertions.assertEquals((float[])null,(float[])null);
		float[] expected = new float[]{1.0f};
		ArrayAssertions.assertEquals(expected, expected);
		ArrayAssertions.assertEquals(new float[]{1.0f,2.0f}, new float[]{1.0f,2.0f});
	}
	@Test
	public void testAssertEquals_failed() {
		System.out.println("ArrayAssertionFloatTest >>> testAssertEquals_failed");
		try{
			ArrayAssertions.assertEquals(new float[]{1.0f,2.0f}, new float[]{2.0f,1.0f});
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([1.0, 2.0]~[2.0, 1.0]):\n\tActual:\t\t[1.0, 2.0]\n\tExpected:\t~[2.0, 1.0]", e.getMessage());
		}
		try{
			ArrayAssertions.assertEquals(new float[]{1.0f}, new float[]{2.0f,1.0f});
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([1.0]~[2.0, 1.0]):\n\tActual:\t\t[1.0]\n\tExpected:\t~[2.0, 1.0]", e.getMessage());
		}
	}
	@Test
	public void testAssertEquals_Message() {
		System.out.println("ArrayAssertionFloatTest >>> testAssertEquals_Message");
		ArrayAssertions.assertEquals((float[])null,(float[])null,"Message");
		float[] expected = new float[]{1.0f};
		ArrayAssertions.assertEquals(expected, expected,"Message");
		ArrayAssertions.assertEquals(new float[]{1.0f,2.0f}, new float[]{1.0f,2.0f},"Message");
	}
	@Test
	public void testAssertEquals_Message_failed() {
		System.out.println("ArrayAssertionFloatTest >>> testAssertEquals_Message_failed");
		try{
			ArrayAssertions.assertEquals(new float[]{1.0f,2.0f}, new float[]{2.0f,1.0f},"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([1.0, 2.0]~[2.0, 1.0]):\n\tActual:\t\t[1.0, 2.0]\n\tExpected:\t~[2.0, 1.0]", e.getMessage());
		}
		try{
			ArrayAssertions.assertEquals(new float[]{1.0f}, new float[]{2.0f,1.0f},"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([1.0]~[2.0, 1.0]):\n\tActual:\t\t[1.0]\n\tExpected:\t~[2.0, 1.0]", e.getMessage());
		}
	}

	@Test
	public void testAssertNotEquals() {
		System.out.println("ArrayAssertionFloatTest >>> testAssertNotEquals");
		ArrayAssertions.assertNotEquals(new float[]{1.0f,2.0f}, new float[]{2.0f,1.0f});
		ArrayAssertions.assertNotEquals(new float[]{1.0f}, new float[]{2.0f,1.0f});
	}
	@Test
	public void testAssertNotEquals_failed() {
		System.out.println("ArrayAssertionFloatTest >>> testAssertNotEquals_failed");
		try{
			ArrayAssertions.assertNotEquals((float[])null,(float[])null);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(null!~null):\n\tActual:\t\tnull\n\tExpected:\t!~null", e.getMessage());
		}
		try{
			float[] expected = new float[]{1.0f};
			ArrayAssertions.assertNotEquals(expected, expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([1.0]!~[1.0]):\n\tActual:\t\t[1.0]\n\tExpected:\t!~[1.0]", e.getMessage());
		}
		try{
			ArrayAssertions.assertNotEquals(new float[]{1.0f,2.0f}, new float[]{1.0f,2.0f});
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([1.0, 2.0]!~[1.0, 2.0]):\n\tActual:\t\t[1.0, 2.0]\n\tExpected:\t!~[1.0, 2.0]", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_Message() {
		System.out.println("ArrayAssertionFloatTest >>> testAssertNotEquals_Message");
		ArrayAssertions.assertNotEquals(new float[]{1.0f,2.0f}, new float[]{2.0f,1.0f},"Message");
		ArrayAssertions.assertNotEquals(new float[]{1.0f}, new float[]{2.0f,1.0f},"Message");
	}
	@Test
	public void testAssertNotEquals_Message_failed() {
		System.out.println("ArrayAssertionFloatTest >>> testAssertNotEquals_Message_failed");
		try{
			ArrayAssertions.assertNotEquals((float[])null,(float[])null,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(null!~null):\n\tActual:\t\tnull\n\tExpected:\t!~null", e.getMessage());
		}
		try{
			float[] expected = new float[]{1.0f};
			ArrayAssertions.assertNotEquals(expected, expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([1.0]!~[1.0]):\n\tActual:\t\t[1.0]\n\tExpected:\t!~[1.0]", e.getMessage());
		}
		try{
			ArrayAssertions.assertNotEquals(new float[]{1.0f,2.0f}, new float[]{1.0f,2.0f},"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([1.0, 2.0]!~[1.0, 2.0]):\n\tActual:\t\t[1.0, 2.0]\n\tExpected:\t!~[1.0, 2.0]", e.getMessage());
		}
	}	
}
