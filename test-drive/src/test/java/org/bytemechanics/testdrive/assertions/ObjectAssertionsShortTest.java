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
public class ObjectAssertionsShortTest {
	
	
	@Test
	public void testIsZero_Short() {
		System.out.println("ObjectAssertionsShortTest >>> testIsZero_Short");
		Short actual = 0;
		Assert.assertTrue(ObjectAssertions.isZero(actual));
		actual = 2;
		Assert.assertFalse(ObjectAssertions.isZero(actual));
		actual = 10;
		Assert.assertFalse(ObjectAssertions.isZero(actual));
	}
	@Test
	public void testAssertZero_Short() {
		System.out.println("ObjectAssertionsShortTest >>> testAssertZero_Short");
		Short actual = 0;
		ObjectAssertions.assertZero(actual);
	}
	@Test
	public void testAssertZero_Short_failed() {
		System.out.println("ObjectAssertionsShortTest >>> testAssertZero_Short_failed");
		try{
			Short actual=1;
			ObjectAssertions.assertZero(actual);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1=0):\n\tActual:\t\t1\n\tExpected:\t=0", e.getMessage());
		}
	}
	@Test
	public void testAssertZero_Short_message() {
		System.out.println("ObjectAssertionsShortTest >>> testAssertZero_Short_message");
		Short actual = 0;
		ObjectAssertions.assertZero(actual,"Message");
	}
	@Test
	public void testAssertZero_Short_message_failed() {
		System.out.println("ObjectAssertionsShortTest >>> testAssertZero_Short_message_failed");
		try{
			Short actual=1;
			ObjectAssertions.assertZero(actual,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1=0):\n\tActual:\t\t1\n\tExpected:\t=0", e.getMessage());
		}
	}
	@Test
	public void testIsEqual_Short_Short() {
		System.out.println("ObjectAssertionsShortTest >>> testIsEqual_Short_Short");
		Short actual=0;
		Short expected=0;
		Assert.assertTrue(ObjectAssertions.isEqual(actual, expected));
		actual=1;
		expected=1;
		Assert.assertTrue(ObjectAssertions.isEqual(actual, expected));
		actual=0;
		expected=1;
		Assert.assertFalse(ObjectAssertions.isEqual(actual, expected));
	}
	@Test
	public void testAssertEquals_Short_Short() {
		System.out.println("ObjectAssertionsShortTest >>> testAssertEquals_Short_Short");
		Short actual=0;
		Short expected=0;
		ObjectAssertions.assertEquals(actual,expected);
		actual=1;
		expected=1;
		ObjectAssertions.assertEquals(actual,expected);
	}
	@Test
	public void testAssertEquals_Short_Short_failed() {
		System.out.println("ObjectAssertionsShortTest >>> testAssertEquals_Short_Short_failed");
		try{
			Short actual=1;
			Short expected=0;
			ObjectAssertions.assertEquals(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1~0):\n\tActual:\t\t1\n\tExpected:\t~0", e.getMessage());
		}
	}
	@Test
	public void testAssertEquals_Short_Short_message() {
		System.out.println("ObjectAssertionsShortTest >>> testAssertEquals_Short_Short");
		Short actual=0;
		Short expected=0;
		ObjectAssertions.assertEquals(actual,expected,"Message");
		actual=1;
		expected=1;
		ObjectAssertions.assertEquals(actual,expected,"Message");
	}
	@Test
	public void testAssertEquals_Short_Short_message_failed() {
		System.out.println("ObjectAssertionsShortTest >>> testAssertEquals_Short_Short_failed");
		try{
			Short actual=1;
			Short expected=0;
			ObjectAssertions.assertEquals(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1~0):\n\tActual:\t\t1\n\tExpected:\t~0", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_Short_Short() {
		System.out.println("ObjectAssertionsShortTest >>> testAssertNotEquals_Short_Short");
		Short actual=1;
		Short expected=0;
		ObjectAssertions.assertNotEquals(actual,expected);
		actual=0;
		expected=1;
		ObjectAssertions.assertNotEquals(actual,expected);
	}
	@Test
	public void testAssertNotEquals_Short_Short_failed() {
		System.out.println("ObjectAssertionsShortTest >>> testAssertNotEquals_Short_Short_failed");
		try{
			Short actual=1;
			Short expected=1;
			ObjectAssertions.assertNotEquals(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1!~1):\n\tActual:\t\t1\n\tExpected:\t!~1", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_Short_Short_message() {
		System.out.println("ObjectAssertionsShortTest >>> testAssertNotEquals_Short_Short_message");
		Short actual=0;
		Short expected=1;
		ObjectAssertions.assertNotEquals(actual,expected,"Message");
		actual=1;
		expected=0;
		ObjectAssertions.assertNotEquals(actual,expected);
	}
	@Test
	public void testAssertNotEquals_Short_Short_message_failed() {
		System.out.println("ObjectAssertionsShortTest >>> testAssertNotEquals_Short_Short_message_failed");
		try{
			Short actual=1;
			Short expected=1;
			ObjectAssertions.assertNotEquals(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1!~1):\n\tActual:\t\t1\n\tExpected:\t!~1", e.getMessage());
		}
	}	
	@Test
	public void testIsGreater_Short_Short() {
		System.out.println("ObjectAssertionsShortTest >>> testIsGreater_Short_Short");
		Short actual=1;
		Short expected=0;
		Assert.assertTrue(ObjectAssertions.isGreater(actual, expected));
		actual=10;
		expected=1;
		Assert.assertTrue(ObjectAssertions.isGreater(actual, expected));
		actual=1;
		expected=1;
		Assert.assertFalse(ObjectAssertions.isGreater(actual, expected));
		actual=0;
		expected=1;
		Assert.assertFalse(ObjectAssertions.isGreater(actual, expected));
	}
	@Test
	public void testAssertGreater_Short_Short() {
		System.out.println("ObjectAssertionsShortTest >>> testAssertGreater_Short_Short");
		Short actual=10;
		Short expected=1;
		ObjectAssertions.assertGreater(actual,expected);
		actual=1;
		expected=0;
		ObjectAssertions.assertGreater(actual,expected);
	}
	@Test
	public void testAssertGreater_Short_Short_failed() {
		System.out.println("ObjectAssertionsShortTest >>> testAssertGreater_Short_Short_failed");
		try{
			Short actual=1;
			Short expected=1;
			ObjectAssertions.assertGreater(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1>1):\n\tActual:\t\t1\n\tExpected:\t>1", e.getMessage());
		}
		try{
			Short actual=0;
			Short expected=1;
			ObjectAssertions.assertGreater(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(0>1):\n\tActual:\t\t0\n\tExpected:\t>1", e.getMessage());
		}
	}	
	@Test
	public void testAssertGreater_Short_Short_message() {
		System.out.println("ObjectAssertionsShortTest >>> testAssertGreater_Short_Short_message");
		Short actual=10;
		Short expected=1;
		ObjectAssertions.assertGreater(actual,expected,"Message");
		actual=1;
		expected=0;
		ObjectAssertions.assertGreater(actual,expected,"Message");
	}
	@Test
	public void testAssertGreater_Short_Short_message_failed() {
		System.out.println("ObjectAssertionsShortTest >>> testAssertGreater_Short_Short_message_failed");
		try{
			Short actual=1;
			Short expected=1;
			ObjectAssertions.assertGreater(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1>1):\n\tActual:\t\t1\n\tExpected:\t>1", e.getMessage());
		}
		try{
			Short actual=0;
			Short expected=1;
			ObjectAssertions.assertGreater(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(0>1):\n\tActual:\t\t0\n\tExpected:\t>1", e.getMessage());
		}
	}	
	@Test
	public void testIsGreaterOrEqual_Short_Short() {
		System.out.println("ObjectAssertionsShortTest >>> testIsGreaterOrEqual_Short_Short");
		Short actual=1;
		Short expected=0;
		Assert.assertTrue(ObjectAssertions.isGreaterOrEqual(actual, expected));
		actual=10;
		expected=1;
		Assert.assertTrue(ObjectAssertions.isGreaterOrEqual(actual, expected));
		actual=1;
		expected=1;
		Assert.assertTrue(ObjectAssertions.isGreaterOrEqual(actual, expected));
		actual=0;
		expected=1;
		Assert.assertFalse(ObjectAssertions.isGreaterOrEqual(actual, expected));
	}
	@Test
	public void testAssertGreaterOrEqual_Short_Short() {
		System.out.println("ObjectAssertionsShortTest >>> testAssertGreaterOrEqual_Short_Short");
		Short actual=10;
		Short expected=1;
		ObjectAssertions.assertGreaterOrEqual(actual,expected);
		actual=1;
		expected=1;
		ObjectAssertions.assertGreaterOrEqual(actual,expected);
	}
	@Test
	public void testAssertGreaterOrEqual_Short_Short_failed() {
		System.out.println("ObjectAssertionsShortTest >>> testAssertGreaterOrEqual_Short_Short_failed");
		try{
			Short actual=0;
			Short expected=1;
			ObjectAssertions.assertGreaterOrEqual(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(0>=1):\n\tActual:\t\t0\n\tExpected:\t>=1", e.getMessage());
		}
	}	
	@Test
	public void testAssertGreaterOrEqual_Short_Short_message() {
		System.out.println("ObjectAssertionsShortTest >>> testAssertGreaterOrEqual_Short_Short_message");
		Short actual=10;
		Short expected=1;
		ObjectAssertions.assertGreaterOrEqual(actual,expected,"Message");
		actual=1;
		expected=1;
		ObjectAssertions.assertGreaterOrEqual(actual,expected,"Message");
	}
	@Test
	public void testAssertGreaterOrEqual_Short_Short_message_failed() {
		System.out.println("ObjectAssertionsShortTest >>> testAssertGreaterOrEqual_Short_Short_message_failed");
		try{
			Short actual=0;
			Short expected=1;
			ObjectAssertions.assertGreaterOrEqual(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(0>=1):\n\tActual:\t\t0\n\tExpected:\t>=1", e.getMessage());
		}
	}	
	@Test
	public void testAssertSmaller_Short_Short() {
		System.out.println("ObjectAssertionsShortTest >>> testAssertSmaller_Short_Short");
		Short actual=1;
		Short expected=10;
		ObjectAssertions.assertSmaller(actual,expected);
		actual=0;
		expected=1;
		ObjectAssertions.assertSmaller(actual,expected);
	}
	@Test
	public void testAssertSmaller_Short_Short_failed() {
		System.out.println("ObjectAssertionsShortTest >>> testAssertSmaller_Short_Short_failed");
		try{
			Short actual=1;
			Short expected=1;
			ObjectAssertions.assertSmaller(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1<1):\n\tActual:\t\t1\n\tExpected:\t<1", e.getMessage());
		}
		try{
			Short actual=1;
			Short expected=0;
			ObjectAssertions.assertSmaller(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1<0):\n\tActual:\t\t1\n\tExpected:\t<0", e.getMessage());
		}
	}	
	@Test
	public void testAssertSmaller_Short_Short_message() {
		System.out.println("ObjectAssertionsShortTest >>> testAssertSmaller_Short_Short_message");
		Short actual=1;
		Short expected=10;
		ObjectAssertions.assertSmaller(actual,expected,"Message");
		actual=0;
		expected=1;
		ObjectAssertions.assertSmaller(actual,expected,"Message");
	}
	@Test
	public void testAssertSmaller_Short_Short_message_failed() {
		System.out.println("ObjectAssertionsShortTest >>> testAssertSmaller_Short_Short_message_failed");
		try{
			Short actual=1;
			Short expected=1;
			ObjectAssertions.assertSmaller(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1<1):\n\tActual:\t\t1\n\tExpected:\t<1", e.getMessage());
		}
		try{
			Short actual=1;
			Short expected=0;
			ObjectAssertions.assertSmaller(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1<0):\n\tActual:\t\t1\n\tExpected:\t<0", e.getMessage());
		}
	}	
	@Test
	public void testAssertSmallerOrEqual_Short_Short() {
		System.out.println("ObjectAssertionsShortTest >>> testAssertSmallerOrEqual_Short_Short");
		Short actual=1;
		Short expected=10;
		ObjectAssertions.assertSmallerOrEqual(actual,expected);
		actual=1;
		expected=1;
		ObjectAssertions.assertSmallerOrEqual(actual,expected);
	}
	@Test
	public void testAssertSmallerOrEqual_Short_Short_failed() {
		System.out.println("ObjectAssertionsShortTest >>> testAssertSmallerOrEqual_Short_Short_failed");
		try{
			Short actual=1;
			Short expected=0;
			ObjectAssertions.assertSmallerOrEqual(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1<=0):\n\tActual:\t\t1\n\tExpected:\t<=0", e.getMessage());
		}
	}	
	@Test
	public void testAssertSmallerOrEqual_Short_Short_message() {
		System.out.println("ObjectAssertionsShortTest >>> testAssertSmallerOrEqual_Short_Short_message");
		Short actual=1;
		Short expected=10;
		ObjectAssertions.assertSmallerOrEqual(actual,expected,"Message");
		actual=1;
		expected=1;
		ObjectAssertions.assertSmallerOrEqual(actual,expected,"Message");
	}
	@Test
	public void testAssertSmallerOrEqual_Short_Short_message_failed() {
		System.out.println("ObjectAssertionsShortTest >>> testAssertSmallerOrEqual_Short_Short_message_failed");
		try{
			Short actual=1;
			Short expected=0;
			ObjectAssertions.assertSmallerOrEqual(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1<=0):\n\tActual:\t\t1\n\tExpected:\t<=0", e.getMessage());
		}
	}
}
