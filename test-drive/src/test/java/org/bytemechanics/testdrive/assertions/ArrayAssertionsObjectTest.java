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
public class ArrayAssertionsObjectTest {
	
	@Test
	public void testIsEmpty() {
		System.out.println("ArrayAssertionsObjectTest >>> testIsEmpty");
		Assert.assertTrue(ArrayAssertions.isEmpty(new String[0]));
		Assert.assertFalse(ArrayAssertions.isEmpty(new String[1]));
	}

	@Test
	public void testAssertEmpty() {
		System.out.println("ArrayAssertionsObjectTest >>> testAssertEmpty");
		ArrayAssertions.assertEmpty(new String[0]);
	}
	@Test
	public void testAssertEmpty_failed() {
		System.out.println("ArrayAssertionsObjectTest >>> testAssertEmpty_failed");
		try{
			ArrayAssertions.assertEmpty(new String[1]);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.length=0):\n\tActual:\t\t1\n\tExpected:\t.length=0", e.getMessage());
		}
	}

	@Test
	public void testAssertEmpty_Message() {
		System.out.println("ArrayAssertionsObjectTest >>> testAssertEmpty_Message");
		ArrayAssertions.assertEmpty(new String[0],"Message");
	}
	@Test
	public void testAssertEmpty_Message_failed() {
		System.out.println("ArrayAssertionsObjectTest >>> testAssertEmpty_Message_failed");
		try{
			ArrayAssertions.assertEmpty(new String[1],"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.length=0):\n\tActual:\t\t1\n\tExpected:\t.length=0", e.getMessage());
		}
	}

	@Test
	public void testAssertNotEmpty() {
		System.out.println("ArrayAssertionsObjectTest >>> testAssertNotEmpty");
		ArrayAssertions.assertNotEmpty(new String[1]);
	}
	@Test
	public void testAssertNotEmpty_failed() {
		System.out.println("ArrayAssertionsObjectTest >>> testAssertNotEmpty_failed");
		try{
			ArrayAssertions.assertNotEmpty(new String[0]);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(0.length>0):\n\tActual:\t\t0\n\tExpected:\t.length>0", e.getMessage());
		}
	}

	@Test
	public void testAssertNotEmpty_Message() {
		System.out.println("ArrayAssertionsObjectTest >>> testAssertNotEmpty_Message");
		ArrayAssertions.assertNotEmpty(new String[1],"Message");
	}
	@Test
	public void testAssertNotEmpty_Message_failed() {
		System.out.println("ArrayAssertionsObjectTest >>> testAssertNotEmpty_Message_failed");
		try{
			ArrayAssertions.assertNotEmpty(new String[0],"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(0.length>0):\n\tActual:\t\t0\n\tExpected:\t.length>0", e.getMessage());
		}
	}

	@Test
	public void testIsSame() {
		System.out.println("ArrayAssertionsObjectTest >>> testIsSame");
		String[] expected = new String[]{"true"};
		Assert.assertTrue(ArrayAssertions.isSame((String[])null,(String[]) null));
		Assert.assertTrue(ArrayAssertions.isSame(expected, expected));
		Assert.assertFalse(ArrayAssertions.isSame(new String[1], new String[1]));
	}

	@Test
	public void testAssertSame() {
		System.out.println("ArrayAssertionsObjectTest >>> testAssertSame");
		String[] expected = new String[]{"true"};
		ArrayAssertions.assertSame(expected, expected);
	}
	@Test
	public void testAssertSame_failed() {
		System.out.println("ArrayAssertionsObjectTest >>> testAssertSame_failed");
		try{
			ArrayAssertions.assertSame(new String[]{"true"}, new String[]{"true"});
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([true]=[true]):\n\tActual:\t\t[true]\n\tExpected:\t=[true]", e.getMessage());
		}
	}
	@Test
	public void testAssertSame_Message() {
		System.out.println("ArrayAssertionsObjectTest >>> testAssertSame_Message");
		String[] expected = new String[]{"true"};
		ArrayAssertions.assertSame(expected, expected,"Message");
	}
	@Test
	public void testAssertSame_Message_failed() {
		System.out.println("ArrayAssertionsObjectTest >>> testAssertSame_Message_failed");
		try{
			ArrayAssertions.assertSame(new String[]{"true"}, new String[]{"true"},"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([true]=[true]):\n\tActual:\t\t[true]\n\tExpected:\t=[true]", e.getMessage());
		}
	}

	@Test
	public void testAssertNotSame() {
		System.out.println("ArrayAssertionsObjectTest >>> testAssertNotSame");
		ArrayAssertions.assertNotSame(new String[]{"true"}, new String[]{"true"});
	}
	@Test
	public void testAssertNotSame_failed() {
		System.out.println("ArrayAssertionsObjectTest >>> testAssertNotSame_failed");
		try{
			String[] expected = new String[]{"true"};
			ArrayAssertions.assertNotSame(expected,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([true]!=[true]):\n\tActual:\t\t[true]\n\tExpected:\t!=[true]", e.getMessage());
		}
	}

	@Test
	public void testAssertNotSame_Message() {
		System.out.println("ArrayAssertionsObjectTest >>> testAssertNotSame_Message");
		ArrayAssertions.assertNotSame(new String[]{"true"}, new String[]{"true"},"Message");
	}
	@Test
	public void testAssertNotSame_Message_failed() {
		System.out.println("ArrayAssertionsObjectTest >>> testAssertNotSame_Message_failed");
		try{
			String[] expected = new String[]{"true"};
			ArrayAssertions.assertNotSame(expected,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([true]!=[true]):\n\tActual:\t\t[true]\n\tExpected:\t!=[true]", e.getMessage());
		}
	}

	@Test
	public void testIsEqual() {
		System.out.println("ArrayAssertionsObjectTest >>> testIsEqual");
		Assert.assertTrue(ArrayAssertions.equals((String[])null,(String[]) null));
		String[] expected = new String[]{"true"};
		Assert.assertTrue(ArrayAssertions.equals(expected, expected));
		Assert.assertTrue(ArrayAssertions.equals(new String[]{"true","false"}, new String[]{"true","false"}));
		Assert.assertFalse(ArrayAssertions.equals(new String[]{"true","false"}, new String[]{"false","true"}));
		Assert.assertFalse(ArrayAssertions.equals(new String[]{"true"}, new String[]{"false","true"}));
	}

	@Test
	public void testAssertEquals() {
		System.out.println("ArrayAssertionsObjectTest >>> testAssertEquals");
		ArrayAssertions.assertEquals((String[])null,(String[])null);
		String[] expected = new String[]{"true"};
		ArrayAssertions.assertEquals(expected, expected);
		ArrayAssertions.assertEquals(new String[]{"true","false"}, new String[]{"true","false"});
	}
	@Test
	public void testAssertEquals_failed() {
		System.out.println("ArrayAssertionsObjectTest >>> testAssertEquals_failed");
		try{
			ArrayAssertions.assertEquals(new String[]{"true","false"}, new String[]{"false","true"});
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([true, false]~[false, true]):\n\tActual:\t\t[true, false]\n\tExpected:\t~[false, true]", e.getMessage());
		}
		try{
			ArrayAssertions.assertEquals(new String[]{"true"}, new String[]{"false","true"});
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([true]~[false, true]):\n\tActual:\t\t[true]\n\tExpected:\t~[false, true]", e.getMessage());
		}
	}
	@Test
	public void testAssertEquals_Message() {
		System.out.println("ArrayAssertionsObjectTest >>> testAssertEquals_Message");
		ArrayAssertions.assertEquals((String[])null,(String[])null,"Message");
		String[] expected = new String[]{"true"};
		ArrayAssertions.assertEquals(expected, expected,"Message");
		ArrayAssertions.assertEquals(new String[]{"true","false"}, new String[]{"true","false"},"Message");
	}
	@Test
	public void testAssertEquals_Message_failed() {
		System.out.println("ArrayAssertionsObjectTest >>> testAssertEquals_Message_failed");
		try{
			ArrayAssertions.assertEquals(new String[]{"true","false"}, new String[]{"false","true"},"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([true, false]~[false, true]):\n\tActual:\t\t[true, false]\n\tExpected:\t~[false, true]", e.getMessage());
		}
		try{
			ArrayAssertions.assertEquals(new String[]{"true"}, new String[]{"false","true"},"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([true]~[false, true]):\n\tActual:\t\t[true]\n\tExpected:\t~[false, true]", e.getMessage());
		}
	}

	@Test
	public void testAssertNotEquals() {
		System.out.println("ArrayAssertionsObjectTest >>> testAssertNotEquals");
		ArrayAssertions.assertNotEquals(new String[]{"true","false"}, new String[]{"false","true"});
		ArrayAssertions.assertNotEquals(new String[]{"true"}, new String[]{"false","true"});
	}
	@Test
	public void testAssertNotEquals_failed() {
		System.out.println("ArrayAssertionsObjectTest >>> testAssertNotEquals_failed");
		try{
			ArrayAssertions.assertNotEquals((String[])null,(String[])null);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(null!~null):\n\tActual:\t\tnull\n\tExpected:\t!~null", e.getMessage());
		}
		try{
			String[] expected = new String[]{"true"};
			ArrayAssertions.assertNotEquals(expected, expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([true]!~[true]):\n\tActual:\t\t[true]\n\tExpected:\t!~[true]", e.getMessage());
		}
		try{
			ArrayAssertions.assertNotEquals(new String[]{"true","false"}, new String[]{"true","false"});
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([true, false]!~[true, false]):\n\tActual:\t\t[true, false]\n\tExpected:\t!~[true, false]", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_Message() {
		System.out.println("ArrayAssertionsObjectTest >>> testAssertNotEquals_Message");
		ArrayAssertions.assertNotEquals(new String[]{"true","false"}, new String[]{"false","true"},"Message");
		ArrayAssertions.assertNotEquals(new String[]{"true"}, new String[]{"false","true"},"Message");
	}
	@Test
	public void testAssertNotEquals_Message_failed() {
		System.out.println("ArrayAssertionsObjectTest >>> testAssertNotEquals_Message_failed");
		try{
			ArrayAssertions.assertNotEquals((String[])null,(String[])null,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(null!~null):\n\tActual:\t\tnull\n\tExpected:\t!~null", e.getMessage());
		}
		try{
			String[] expected = new String[]{"true"};
			ArrayAssertions.assertNotEquals(expected, expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([true]!~[true]):\n\tActual:\t\t[true]\n\tExpected:\t!~[true]", e.getMessage());
		}
		try{
			ArrayAssertions.assertNotEquals(new String[]{"true","false"}, new String[]{"true","false"},"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([true, false]!~[true, false]):\n\tActual:\t\t[true, false]\n\tExpected:\t!~[true, false]", e.getMessage());
		}
	}	
}
