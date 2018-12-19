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
public class ArrayAssertionDoubleTest {
	
	@Test
	public void testIsEmpty() {
		System.out.println("ArrayAssertionDoubleTest >>> testIsEmpty");
		Assert.assertTrue(ArrayAssertions.isEmpty(new double[0]));
		Assert.assertFalse(ArrayAssertions.isEmpty(new double[1]));
	}

	@Test
	public void testAssertEmpty() {
		System.out.println("ArrayAssertionDoubleTest >>> testAssertEmpty");
		ArrayAssertions.assertEmpty(new double[0]);
	}
	@Test
	public void testAssertEmpty_failed() {
		System.out.println("ArrayAssertionDoubleTest >>> testAssertEmpty_failed");
		try{
			ArrayAssertions.assertEmpty(new double[1]);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.length=0):\n\tActual:\t\t1\n\tExpected:\t.length=0", e.getMessage());
		}
	}

	@Test
	public void testAssertEmpty_Message() {
		System.out.println("ArrayAssertionDoubleTest >>> testAssertEmpty_Message");
		ArrayAssertions.assertEmpty(new double[0],"Message");
	}
	@Test
	public void testAssertEmpty_Message_failed() {
		System.out.println("ArrayAssertionDoubleTest >>> testAssertEmpty_Message_failed");
		try{
			ArrayAssertions.assertEmpty(new double[1],"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.length=0):\n\tActual:\t\t1\n\tExpected:\t.length=0", e.getMessage());
		}
	}

	@Test
	public void testAssertNotEmpty() {
		System.out.println("ArrayAssertionDoubleTest >>> testAssertNotEmpty");
		ArrayAssertions.assertNotEmpty(new double[1]);
	}
	@Test
	public void testAssertNotEmpty_failed() {
		System.out.println("ArrayAssertionDoubleTest >>> testAssertNotEmpty_failed");
		try{
			ArrayAssertions.assertNotEmpty(new double[0]);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(0.length>0):\n\tActual:\t\t0\n\tExpected:\t.length>0", e.getMessage());
		}
	}

	@Test
	public void testAssertNotEmpty_Message() {
		System.out.println("ArrayAssertionDoubleTest >>> testAssertNotEmpty_Message");
		ArrayAssertions.assertNotEmpty(new double[1],"Message");
	}
	@Test
	public void testAssertNotEmpty_Message_failed() {
		System.out.println("ArrayAssertionDoubleTest >>> testAssertNotEmpty_Message_failed");
		try{
			ArrayAssertions.assertNotEmpty(new double[0],"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(0.length>0):\n\tActual:\t\t0\n\tExpected:\t.length>0", e.getMessage());
		}
	}

	@Test
	public void testIsSame() {
		System.out.println("ArrayAssertionDoubleTest >>> testIsSame");
		double[] expected = new double[]{1.0d};
		Assert.assertTrue(ArrayAssertions.isSame((double[])null,(double[]) null));
		Assert.assertTrue(ArrayAssertions.isSame(expected, expected));
		Assert.assertFalse(ArrayAssertions.isSame(new double[1], new double[1]));
	}

	@Test
	public void testAssertSame() {
		System.out.println("ArrayAssertionDoubleTest >>> testAssertSame");
		double[] expected = new double[]{1.0d};
		ArrayAssertions.assertSame(expected, expected);
	}
	@Test
	public void testAssertSame_failed() {
		System.out.println("ArrayAssertionDoubleTest >>> testAssertSame_failed");
		try{
			ArrayAssertions.assertSame(new double[]{1.0d}, new double[]{1.0d});
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([1.0]=[1.0]):\n\tActual:\t\t[1.0]\n\tExpected:\t=[1.0]", e.getMessage());
		}
	}
	@Test
	public void testAssertSame_Message() {
		System.out.println("ArrayAssertionDoubleTest >>> testAssertSame_Message");
		double[] expected = new double[]{1.0d};
		ArrayAssertions.assertSame(expected, expected,"Message");
	}
	@Test
	public void testAssertSame_Message_failed() {
		System.out.println("ArrayAssertionDoubleTest >>> testAssertSame_Message_failed");
		try{
			ArrayAssertions.assertSame(new double[]{1.0d}, new double[]{1.0d},"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([1.0]=[1.0]):\n\tActual:\t\t[1.0]\n\tExpected:\t=[1.0]", e.getMessage());
		}
	}

	@Test
	public void testAssertNotSame() {
		System.out.println("ArrayAssertionDoubleTest >>> testAssertNotSame");
		ArrayAssertions.assertNotSame(new double[]{1.0d}, new double[]{1.0d});
	}
	@Test
	public void testAssertNotSame_failed() {
		System.out.println("ArrayAssertionDoubleTest >>> testAssertNotSame_failed");
		try{
			double[] expected = new double[]{1.0d};
			ArrayAssertions.assertNotSame(expected,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([1.0]!=[1.0]):\n\tActual:\t\t[1.0]\n\tExpected:\t!=[1.0]", e.getMessage());
		}
	}

	@Test
	public void testAssertNotSame_Message() {
		System.out.println("ArrayAssertionDoubleTest >>> testAssertNotSame_Message");
		ArrayAssertions.assertNotSame(new double[]{1.0d}, new double[]{1.0d},"Message");
	}
	@Test
	public void testAssertNotSame_Message_failed() {
		System.out.println("ArrayAssertionDoubleTest >>> testAssertNotSame_Message_failed");
		try{
			double[] expected = new double[]{1.0d};
			ArrayAssertions.assertNotSame(expected,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([1.0]!=[1.0]):\n\tActual:\t\t[1.0]\n\tExpected:\t!=[1.0]", e.getMessage());
		}
	}

	@Test
	public void testIsEqual() {
		System.out.println("ArrayAssertionDoubleTest >>> testIsEqual");
		Assert.assertTrue(ArrayAssertions.equals((double[])null,(double[]) null));
		double[] expected = new double[]{1.0d};
		Assert.assertTrue(ArrayAssertions.equals(expected, expected));
		Assert.assertTrue(ArrayAssertions.equals(new double[]{1.0d,2.0d}, new double[]{1.0d,2.0d}));
		Assert.assertFalse(ArrayAssertions.equals(new double[]{1.0d,2.0d}, new double[]{2.0d,1.0d}));
		Assert.assertFalse(ArrayAssertions.equals(new double[]{1.0d}, new double[]{2.0d,1.0d}));
	}

	@Test
	public void testAssertEquals() {
		System.out.println("ArrayAssertionDoubleTest >>> testAssertEquals");
		ArrayAssertions.assertEquals((double[])null,(double[])null);
		double[] expected = new double[]{1.0d};
		ArrayAssertions.assertEquals(expected, expected);
		ArrayAssertions.assertEquals(new double[]{1.0d,2.0d}, new double[]{1.0d,2.0d});
	}
	@Test
	public void testAssertEquals_failed() {
		System.out.println("ArrayAssertionDoubleTest >>> testAssertEquals_failed");
		try{
			ArrayAssertions.assertEquals(new double[]{1.0d,2.0d}, new double[]{2.0d,1.0d});
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([1.0, 2.0]~[2.0, 1.0]):\n\tActual:\t\t[1.0, 2.0]\n\tExpected:\t~[2.0, 1.0]", e.getMessage());
		}
		try{
			ArrayAssertions.assertEquals(new double[]{1.0d}, new double[]{2.0d,1.0d});
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([1.0]~[2.0, 1.0]):\n\tActual:\t\t[1.0]\n\tExpected:\t~[2.0, 1.0]", e.getMessage());
		}
	}
	@Test
	public void testAssertEquals_Message() {
		System.out.println("ArrayAssertionDoubleTest >>> testAssertEquals_Message");
		ArrayAssertions.assertEquals((double[])null,(double[])null,"Message");
		double[] expected = new double[]{1.0d};
		ArrayAssertions.assertEquals(expected, expected,"Message");
		ArrayAssertions.assertEquals(new double[]{1.0d,2.0d}, new double[]{1.0d,2.0d},"Message");
	}
	@Test
	public void testAssertEquals_Message_failed() {
		System.out.println("ArrayAssertionDoubleTest >>> testAssertEquals_Message_failed");
		try{
			ArrayAssertions.assertEquals(new double[]{1.0d,2.0d}, new double[]{2.0d,1.0d},"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([1.0, 2.0]~[2.0, 1.0]):\n\tActual:\t\t[1.0, 2.0]\n\tExpected:\t~[2.0, 1.0]", e.getMessage());
		}
		try{
			ArrayAssertions.assertEquals(new double[]{1.0d}, new double[]{2.0d,1.0d},"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([1.0]~[2.0, 1.0]):\n\tActual:\t\t[1.0]\n\tExpected:\t~[2.0, 1.0]", e.getMessage());
		}
	}

	@Test
	public void testAssertNotEquals() {
		System.out.println("ArrayAssertionDoubleTest >>> testAssertNotEquals");
		ArrayAssertions.assertNotEquals(new double[]{1.0d,2.0d}, new double[]{2.0d,1.0d});
		ArrayAssertions.assertNotEquals(new double[]{1.0d}, new double[]{2.0d,1.0d});
	}
	@Test
	public void testAssertNotEquals_failed() {
		System.out.println("ArrayAssertionDoubleTest >>> testAssertNotEquals_failed");
		try{
			ArrayAssertions.assertNotEquals((double[])null,(double[])null);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(null!~null):\n\tActual:\t\tnull\n\tExpected:\t!~null", e.getMessage());
		}
		try{
			double[] expected = new double[]{1.0d};
			ArrayAssertions.assertNotEquals(expected, expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([1.0]!~[1.0]):\n\tActual:\t\t[1.0]\n\tExpected:\t!~[1.0]", e.getMessage());
		}
		try{
			ArrayAssertions.assertNotEquals(new double[]{1.0d,2.0d}, new double[]{1.0d,2.0d});
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([1.0, 2.0]!~[1.0, 2.0]):\n\tActual:\t\t[1.0, 2.0]\n\tExpected:\t!~[1.0, 2.0]", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_Message() {
		System.out.println("ArrayAssertionDoubleTest >>> testAssertNotEquals_Message");
		ArrayAssertions.assertNotEquals(new double[]{1.0d,2.0d}, new double[]{2.0d,1.0d},"Message");
		ArrayAssertions.assertNotEquals(new double[]{1.0d}, new double[]{2.0d,1.0d},"Message");
	}
	@Test
	public void testAssertNotEquals_Message_failed() {
		System.out.println("ArrayAssertionDoubleTest >>> testAssertNotEquals_Message_failed");
		try{
			ArrayAssertions.assertNotEquals((double[])null,(double[])null,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(null!~null):\n\tActual:\t\tnull\n\tExpected:\t!~null", e.getMessage());
		}
		try{
			double[] expected = new double[]{1.0d};
			ArrayAssertions.assertNotEquals(expected, expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([1.0]!~[1.0]):\n\tActual:\t\t[1.0]\n\tExpected:\t!~[1.0]", e.getMessage());
		}
		try{
			ArrayAssertions.assertNotEquals(new double[]{1.0d,2.0d}, new double[]{1.0d,2.0d},"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([1.0, 2.0]!~[1.0, 2.0]):\n\tActual:\t\t[1.0, 2.0]\n\tExpected:\t!~[1.0, 2.0]", e.getMessage());
		}
	}	
}
