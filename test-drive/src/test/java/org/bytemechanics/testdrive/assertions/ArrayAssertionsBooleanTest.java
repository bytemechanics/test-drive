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
public class ArrayAssertionsBooleanTest {
	
	@Test
	public void testIsEmpty() {
		System.out.println("ArrayAssertionsBooleanTest >>> testIsEmpty");
		Assert.assertTrue(ArrayAssertions.isEmpty(new boolean[0]));
		Assert.assertFalse(ArrayAssertions.isEmpty(new boolean[1]));
	}

	@Test
	public void testAssertEmpty() {
		System.out.println("ArrayAssertionsBooleanTest >>> testAssertEmpty");
		ArrayAssertions.assertEmpty(new boolean[0]);
	}
	@Test
	public void testAssertEmpty_failed() {
		System.out.println("ArrayAssertionsBooleanTest >>> testAssertEmpty_failed");
		try{
			ArrayAssertions.assertEmpty(new boolean[1]);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.length=0):\n\tActual:\t\t1\n\tExpected:\t.length=0", e.getMessage());
		}
	}

	@Test
	public void testAssertEmpty_Message() {
		System.out.println("ArrayAssertionsBooleanTest >>> testAssertEmpty_Message");
		ArrayAssertions.assertEmpty(new boolean[0],"Message");
	}
	@Test
	public void testAssertEmpty_Message_failed() {
		System.out.println("ArrayAssertionsBooleanTest >>> testAssertEmpty_Message_failed");
		try{
			ArrayAssertions.assertEmpty(new boolean[1],"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.length=0):\n\tActual:\t\t1\n\tExpected:\t.length=0", e.getMessage());
		}
	}

	@Test
	public void testAssertNotEmpty() {
		System.out.println("ArrayAssertionsBooleanTest >>> testAssertNotEmpty");
		ArrayAssertions.assertNotEmpty(new boolean[1]);
	}
	@Test
	public void testAssertNotEmpty_failed() {
		System.out.println("ArrayAssertionsBooleanTest >>> testAssertNotEmpty_failed");
		try{
			ArrayAssertions.assertNotEmpty(new boolean[0]);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(0.length>0):\n\tActual:\t\t0\n\tExpected:\t.length>0", e.getMessage());
		}
	}

	@Test
	public void testAssertNotEmpty_Message() {
		System.out.println("ArrayAssertionsBooleanTest >>> testAssertNotEmpty_Message");
		ArrayAssertions.assertNotEmpty(new boolean[1],"Message");
	}
	@Test
	public void testAssertNotEmpty_Message_failed() {
		System.out.println("ArrayAssertionsBooleanTest >>> testAssertNotEmpty_Message_failed");
		try{
			ArrayAssertions.assertNotEmpty(new boolean[0],"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(0.length>0):\n\tActual:\t\t0\n\tExpected:\t.length>0", e.getMessage());
		}
	}

	@Test
	public void testIsSame() {
		System.out.println("ArrayAssertionsBooleanTest >>> testIsSame");
		boolean[] expected = new boolean[]{true};
		Assert.assertTrue(ArrayAssertions.isSame((boolean[])null,(boolean[]) null));
		Assert.assertTrue(ArrayAssertions.isSame(expected, expected));
		Assert.assertFalse(ArrayAssertions.isSame(new boolean[1], new boolean[1]));
	}

	@Test
	public void testAssertSame() {
		System.out.println("ArrayAssertionsBooleanTest >>> testAssertSame");
		boolean[] expected = new boolean[]{true};
		ArrayAssertions.assertSame(expected, expected);
	}
	@Test
	public void testAssertSame_failed() {
		System.out.println("ArrayAssertionsBooleanTest >>> testAssertSame_failed");
		try{
			ArrayAssertions.assertSame(new boolean[]{true}, new boolean[]{true});
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([true]=[true]):\n\tActual:\t\t[true]\n\tExpected:\t=[true]", e.getMessage());
		}
	}
	@Test
	public void testAssertSame_Message() {
		System.out.println("ArrayAssertionsBooleanTest >>> testAssertSame_Message");
		boolean[] expected = new boolean[]{true};
		ArrayAssertions.assertSame(expected, expected,"Message");
	}
	@Test
	public void testAssertSame_Message_failed() {
		System.out.println("ArrayAssertionsBooleanTest >>> testAssertSame_Message_failed");
		try{
			ArrayAssertions.assertSame(new boolean[]{true}, new boolean[]{true},"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([true]=[true]):\n\tActual:\t\t[true]\n\tExpected:\t=[true]", e.getMessage());
		}
	}

	@Test
	public void testAssertNotSame() {
		System.out.println("ArrayAssertionsBooleanTest >>> testAssertNotSame");
		ArrayAssertions.assertNotSame(new boolean[]{true}, new boolean[]{true});
	}
	@Test
	public void testAssertNotSame_failed() {
		System.out.println("ArrayAssertionsBooleanTest >>> testAssertNotSame_failed");
		try{
			boolean[] expected = new boolean[]{true};
			ArrayAssertions.assertNotSame(expected,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([true]!=[true]):\n\tActual:\t\t[true]\n\tExpected:\t!=[true]", e.getMessage());
		}
	}

	@Test
	public void testAssertNotSame_Message() {
		System.out.println("ArrayAssertionsBooleanTest >>> testAssertNotSame_Message");
		ArrayAssertions.assertNotSame(new boolean[]{true}, new boolean[]{true},"Message");
	}
	@Test
	public void testAssertNotSame_Message_failed() {
		System.out.println("ArrayAssertionsBooleanTest >>> testAssertNotSame_Message_failed");
		try{
			boolean[] expected = new boolean[]{true};
			ArrayAssertions.assertNotSame(expected,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([true]!=[true]):\n\tActual:\t\t[true]\n\tExpected:\t!=[true]", e.getMessage());
		}
	}

	@Test
	public void testIsEqual() {
		System.out.println("ArrayAssertionsBooleanTest >>> testIsEqual");
		Assert.assertTrue(ArrayAssertions.equals((boolean[])null,(boolean[]) null));
		boolean[] expected = new boolean[]{true};
		Assert.assertTrue(ArrayAssertions.equals(expected, expected));
		Assert.assertTrue(ArrayAssertions.equals(new boolean[]{true,false}, new boolean[]{true,false}));
		Assert.assertFalse(ArrayAssertions.equals(new boolean[]{true,false}, new boolean[]{false,true}));
		Assert.assertFalse(ArrayAssertions.equals(new boolean[]{true}, new boolean[]{false,true}));
	}

	@Test
	public void testAssertEquals() {
		System.out.println("ArrayAssertionsBooleanTest >>> testAssertEquals");
		ArrayAssertions.assertEquals((boolean[])null,(boolean[])null);
		boolean[] expected = new boolean[]{true};
		ArrayAssertions.assertEquals(expected, expected);
		ArrayAssertions.assertEquals(new boolean[]{true,false}, new boolean[]{true,false});
	}
	@Test
	public void testAssertEquals_failed() {
		System.out.println("ArrayAssertionsBooleanTest >>> testAssertEquals_failed");
		try{
			ArrayAssertions.assertEquals(new boolean[]{true,false}, new boolean[]{false,true});
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([true, false]~[false, true]):\n\tActual:\t\t[true, false]\n\tExpected:\t~[false, true]", e.getMessage());
		}
		try{
			ArrayAssertions.assertEquals(new boolean[]{true}, new boolean[]{false,true});
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([true]~[false, true]):\n\tActual:\t\t[true]\n\tExpected:\t~[false, true]", e.getMessage());
		}
	}
	@Test
	public void testAssertEquals_Message() {
		System.out.println("ArrayAssertionsBooleanTest >>> testAssertEquals_Message");
		ArrayAssertions.assertEquals((boolean[])null,(boolean[])null,"Message");
		boolean[] expected = new boolean[]{true};
		ArrayAssertions.assertEquals(expected, expected,"Message");
		ArrayAssertions.assertEquals(new boolean[]{true,false}, new boolean[]{true,false},"Message");
	}
	@Test
	public void testAssertEquals_Message_failed() {
		System.out.println("ArrayAssertionsBooleanTest >>> testAssertEquals_Message_failed");
		try{
			ArrayAssertions.assertEquals(new boolean[]{true,false}, new boolean[]{false,true},"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([true, false]~[false, true]):\n\tActual:\t\t[true, false]\n\tExpected:\t~[false, true]", e.getMessage());
		}
		try{
			ArrayAssertions.assertEquals(new boolean[]{true}, new boolean[]{false,true},"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([true]~[false, true]):\n\tActual:\t\t[true]\n\tExpected:\t~[false, true]", e.getMessage());
		}
	}

	@Test
	public void testAssertNotEquals() {
		System.out.println("ArrayAssertionsBooleanTest >>> testAssertNotEquals");
		ArrayAssertions.assertNotEquals(new boolean[]{true,false}, new boolean[]{false,true});
		ArrayAssertions.assertNotEquals(new boolean[]{true}, new boolean[]{false,true});
	}
	@Test
	public void testAssertNotEquals_failed() {
		System.out.println("ArrayAssertionsBooleanTest >>> testAssertNotEquals_failed");
		try{
			ArrayAssertions.assertNotEquals((boolean[])null,(boolean[])null);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(null!~null):\n\tActual:\t\tnull\n\tExpected:\t!~null", e.getMessage());
		}
		try{
			boolean[] expected = new boolean[]{true};
			ArrayAssertions.assertNotEquals(expected, expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([true]!~[true]):\n\tActual:\t\t[true]\n\tExpected:\t!~[true]", e.getMessage());
		}
		try{
			ArrayAssertions.assertNotEquals(new boolean[]{true,false}, new boolean[]{true,false});
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([true, false]!~[true, false]):\n\tActual:\t\t[true, false]\n\tExpected:\t!~[true, false]", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_Message() {
		System.out.println("ArrayAssertionsBooleanTest >>> testAssertNotEquals_Message");
		ArrayAssertions.assertNotEquals(new boolean[]{true,false}, new boolean[]{false,true},"Message");
		ArrayAssertions.assertNotEquals(new boolean[]{true}, new boolean[]{false,true},"Message");
	}
	@Test
	public void testAssertNotEquals_Message_failed() {
		System.out.println("ArrayAssertionsBooleanTest >>> testAssertNotEquals_Message_failed");
		try{
			ArrayAssertions.assertNotEquals((boolean[])null,(boolean[])null,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(null!~null):\n\tActual:\t\tnull\n\tExpected:\t!~null", e.getMessage());
		}
		try{
			boolean[] expected = new boolean[]{true};
			ArrayAssertions.assertNotEquals(expected, expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([true]!~[true]):\n\tActual:\t\t[true]\n\tExpected:\t!~[true]", e.getMessage());
		}
		try{
			ArrayAssertions.assertNotEquals(new boolean[]{true,false}, new boolean[]{true,false},"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([true, false]!~[true, false]):\n\tActual:\t\t[true, false]\n\tExpected:\t!~[true, false]", e.getMessage());
		}
	}	
}