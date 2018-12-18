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
public class ObjectAssertionsObjectTest {

	@Test
	public void testIsNull() {
		System.out.println("ObjectAssertionsObjectTest >>> testIsNull");
		Assert.assertTrue(ObjectAssertions.isNull(null));
		Assert.assertFalse(ObjectAssertions.isNull(""));
		Assert.assertFalse(ObjectAssertions.isNull(12));
	}
	
	@Test
	public void testAssertNull() {
		System.out.println("ObjectAssertionsObjectTest >>> testAssertNull");
		ObjectAssertions.assertNull(null);
	}
	@Test
	public void testAssertNull_failed() {
		System.out.println("ObjectAssertionsObjectTest >>> testAssertNull_failed");
		try{
			ObjectAssertions.assertNull("a");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(a=null):\n\tActual:\t\ta\n\tExpected:\t=null", e.getMessage());
		}
	}

	@Test
	public void testAssertNull_message() {
		System.out.println("ObjectAssertionsObjectTest >>> testAssertNull_message");
		ObjectAssertions.assertNull(null,"Message");
	}
	@Test
	public void testAssertNull_failed_message() {
		System.out.println("ObjectAssertionsObjectTest >>> testAssertNull_failed_message");
		try{
			ObjectAssertions.assertNull("a","Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(a=null):\n\tActual:\t\ta\n\tExpected:\t=null", e.getMessage());
		}
	}

	@Test
	public void testAssertNotNull() {
		System.out.println("ObjectAssertionsObjectTest >>> testAssertNotNull");
		ObjectAssertions.assertNotNull("a");
	}
	@Test
	public void testAssertNotNull_failed() {
		System.out.println("ObjectAssertionsObjectTest >>> testAssertNotNull_failed");
		try{
			ObjectAssertions.assertNotNull(null);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(null!=null):\n\tActual:\t\tnull\n\tExpected:\t!=null", e.getMessage());
		}
	}

	@Test
	public void testAssertNotNull_message() {
		System.out.println("ObjectAssertionsObjectTest >>> testAssertNotNull_message");
		ObjectAssertions.assertNotNull("a","Message");
	}
	@Test
	public void testAssertNotNull_failed_message() {
		System.out.println("ObjectAssertionsObjectTest >>> testAssertNotNull_failed_message");
		try{
			ObjectAssertions.assertNotNull(null,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(null!=null):\n\tActual:\t\tnull\n\tExpected:\t!=null", e.getMessage());
		}
	}

	@Test
	public void testIsEqual() {
		System.out.println("ObjectAssertionsObjectTest >>> testIsEqual");
		Assert.assertTrue(ObjectAssertions.isEqual("",""));
		Assert.assertTrue(ObjectAssertions.isEqual("b","b"));
		Assert.assertTrue(ObjectAssertions.isEqual(null,null));
		Assert.assertFalse(ObjectAssertions.isEqual(12,null));
		Assert.assertFalse(ObjectAssertions.isEqual(null,""));
		Assert.assertFalse(ObjectAssertions.isEqual(12,""));
		Assert.assertFalse(ObjectAssertions.isEqual("a",""));
	}
	
	@Test
	public void testEquals() {
		System.out.println("ObjectAssertionsObjectTest >>> testEquals");
		ObjectAssertions.equals("","");
		ObjectAssertions.equals("b","b");
		ObjectAssertions.equals(null,null);
	}
	@Test
	public void testEquals_failed() {
		System.out.println("ObjectAssertionsObjectTest >>> testEquals_failed");
		try{
			ObjectAssertions.equals(12,"b");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(12~b):\n\tActual:\t\t12\n\tExpected:\t~b", e.getMessage());
		}
		try{
			ObjectAssertions.equals("a","b");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(a~b):\n\tActual:\t\ta\n\tExpected:\t~b", e.getMessage());
		}
		try{
			ObjectAssertions.equals("a",null);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(a~null):\n\tActual:\t\ta\n\tExpected:\t~null", e.getMessage());
		}
	}
	@Test
	public void testEquals_message() {
		System.out.println("ObjectAssertionsObjectTest >>> testEquals_message");
		ObjectAssertions.equals("","","Message");
		ObjectAssertions.equals("b","b","Message");
		ObjectAssertions.equals(null,null,"Message");
	}
	@Test
	public void testEquals_message_failed() {
		System.out.println("ObjectAssertionsObjectTest >>> testEquals_message_failed");
		try{
			ObjectAssertions.equals(12,"b","Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(12~b):\n\tActual:\t\t12\n\tExpected:\t~b", e.getMessage());
		}
		try{
			ObjectAssertions.equals("a","b","Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(a~b):\n\tActual:\t\ta\n\tExpected:\t~b", e.getMessage());
		}
		try{
			ObjectAssertions.equals("a",null,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(a~null):\n\tActual:\t\ta\n\tExpected:\t~null", e.getMessage());
		}
	}

	@Test
	public void testNotEquals() {
		System.out.println("ObjectAssertionsObjectTest >>> testNotEquals");
		ObjectAssertions.notEquals(12,null);
		ObjectAssertions.notEquals(null,"");
		ObjectAssertions.notEquals(12,"");
		ObjectAssertions.notEquals("a","");
	}
	@Test
	public void testNotEquals_failed() {
		System.out.println("ObjectAssertionsObjectTest >>> testNotEquals_failed");
		try{
			ObjectAssertions.notEquals("b","b");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(b!~b):\n\tActual:\t\tb\n\tExpected:\t!~b", e.getMessage());
		}
		try{
			ObjectAssertions.notEquals(null,null);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(null!~null):\n\tActual:\t\tnull\n\tExpected:\t!~null", e.getMessage());
		}
	}
	@Test
	public void testNotEquals_message() {
		System.out.println("ObjectAssertionsObjectTest >>> testNotEquals_message");
		ObjectAssertions.notEquals(12,null,"Message");
		ObjectAssertions.notEquals(null,"","Message");
		ObjectAssertions.notEquals(12,"","Message");
		ObjectAssertions.notEquals("a","","Message");
	}
	@Test
	public void testNotEquals_message_failed() {
		System.out.println("ObjectAssertionsObjectTest >>> testNotEquals_message_failed");
		try{
			ObjectAssertions.notEquals("b","b","Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(b!~b):\n\tActual:\t\tb\n\tExpected:\t!~b", e.getMessage());
		}
		try{
			ObjectAssertions.notEquals(null,null,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(null!~null):\n\tActual:\t\tnull\n\tExpected:\t!~null", e.getMessage());
		}
	}


	@Test
	@SuppressWarnings({"RedundantStringConstructorCall", "UnnecessaryBoxing"})
	public void testIsSame() {
		System.out.println("ObjectAssertionsObjectTest >>> testIsSame");
		String actual="",expected=actual;
		Assert.assertTrue(ObjectAssertions.isSame(actual,expected));
		Assert.assertTrue(ObjectAssertions.isSame(null,null));
		Assert.assertFalse(ObjectAssertions.isSame(12,null));
		Assert.assertFalse(ObjectAssertions.isSame(null,""));
		Assert.assertFalse(ObjectAssertions.isSame(12,""));
		Assert.assertFalse(ObjectAssertions.isSame(new Integer(12),new Integer(12)));
		Assert.assertFalse(ObjectAssertions.isSame(new String(""),new String("")));
	}
	
	@Test
	public void testSame() {
		System.out.println("ObjectAssertionsObjectTest >>> testSame");
		String actual="",expected=actual;
		ObjectAssertions.same(actual,expected);
		ObjectAssertions.same(null,null);
	}
	@Test
	@SuppressWarnings("UnnecessaryBoxing")
	public void testSame_failed() {
		System.out.println("ObjectAssertionsObjectTest >>> testSame_failed");
		try{
			ObjectAssertions.same(12,"b");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(12==b):\n\tActual:\t\t12\n\tExpected:\t==b", e.getMessage());
		}
		try{
			ObjectAssertions.same("a","b");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(a==b):\n\tActual:\t\ta\n\tExpected:\t==b", e.getMessage());
		}
		try{
			ObjectAssertions.same(new Integer(12),new Integer(12));
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(12==12):\n\tActual:\t\t12\n\tExpected:\t==12", e.getMessage());
		}
	}
	@Test
	public void testSame_message() {
		System.out.println("ObjectAssertionsObjectTest >>> testSame_message");
		ObjectAssertions.same("","","Message");
		ObjectAssertions.same("b","b","Message");
		ObjectAssertions.same(null,null,"Message");
	}
	@Test
	@SuppressWarnings("UnnecessaryBoxing")
	public void testSame_message_failed() {
		System.out.println("ObjectAssertionsObjectTest >>> testSame_message_failed");
		try{
			ObjectAssertions.same(12,"b","Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(12==b):\n\tActual:\t\t12\n\tExpected:\t==b", e.getMessage());
		}
		try{
			ObjectAssertions.same("a","b","Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(a==b):\n\tActual:\t\ta\n\tExpected:\t==b", e.getMessage());
		}
		try{
			ObjectAssertions.same(new Integer(12),new Integer(12),"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(12==12):\n\tActual:\t\t12\n\tExpected:\t==12", e.getMessage());
		}
	}

	@Test
	@SuppressWarnings({"RedundantStringConstructorCall", "UnnecessaryBoxing"})
	public void testNotSame() {
		System.out.println("ObjectAssertionsObjectTest >>> testNotSame");
		ObjectAssertions.notSame(12,null);
		ObjectAssertions.notSame(null,"");
		ObjectAssertions.notSame(12,"");
		ObjectAssertions.notSame(new Integer(12),new Integer(12));
		ObjectAssertions.notSame(new String(""),new String(""));
	}
	@Test
	public void testNotSame_failed() {
		System.out.println("ObjectAssertionsObjectTest >>> testNotSame_failed");
		try{
			String actual="b",expected=actual;
			ObjectAssertions.notSame(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(b!==b):\n\tActual:\t\tb\n\tExpected:\t!==b", e.getMessage());
		}
		try{
			String actual=null,expected=null;
			ObjectAssertions.notSame(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(null!==null):\n\tActual:\t\tnull\n\tExpected:\t!==null", e.getMessage());
		}
	}
	@Test
	@SuppressWarnings("UnnecessaryBoxing")
	public void testNotSame_message() {
		System.out.println("ObjectAssertionsObjectTest >>> testNotSame_message");
		ObjectAssertions.notSame(12,null,"Message");
		ObjectAssertions.notSame(null,"","Message");
		ObjectAssertions.notSame(12,"","Message");
		ObjectAssertions.notSame(new Integer(12),new Integer(12),"Message");
	}
	@Test
	public void testNotSame_message_failed() {
		System.out.println("ObjectAssertionsObjectTest >>> testNotSame_message_failed");
		try{
			String actual="b",expected=actual;
			ObjectAssertions.notSame(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(b!==b):\n\tActual:\t\tb\n\tExpected:\t!==b", e.getMessage());
		}
		try{
			String actual=null,expected=null;
			ObjectAssertions.notSame(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(null!==null):\n\tActual:\t\tnull\n\tExpected:\t!==null", e.getMessage());
		}
	}

	/*

	

	@Test
	public void testIsSame() {
		System.out.println("isSame");
		Object _actual = null;
		Object _expected = null;
		boolean expResult = false;
		boolean result = ObjectAssertions.isSame(_actual, _expected);
		assertEquals(expResult, result);
		fail("The test case is a prototype.");
	}

	@Test
	public void testSame_GenericType_GenericType() {
		System.out.println("same");
		Object _actual = null;
		Object _expected = null;
		ObjectAssertions.same(_actual, _expected);
		fail("The test case is a prototype.");
	}

	@Test
	public void testSame_3args() {
		System.out.println("same");
		Object _actual = null;
		Object _expected = null;
		String _message = "";
		ObjectAssertions.same(_actual, _expected, _message);
		fail("The test case is a prototype.");
	}

	@Test
	public void testNotSame_GenericType_GenericType() {
		System.out.println("notSame");
		Object _actual = null;
		Object _expected = null;
		ObjectAssertions.notSame(_actual, _expected);
		fail("The test case is a prototype.");
	}

	@Test
	public void testNotSame_3args() {
		System.out.println("notSame");
		Object _actual = null;
		Object _expected = null;
		String _message = "";
		ObjectAssertions.notSame(_actual, _expected, _message);
		fail("The test case is a prototype.");
	}
	*/
}
