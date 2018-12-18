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
public class ObjectAssertionsLongTest {
	
	
	@Test
	public void testIsZero_Long() {
		System.out.println("ObjectAssertionsLongTest >>> testIsZero_Long");
		Long actual = 0l;
		Assert.assertTrue(ObjectAssertions.isZero(actual));
		actual = 2l;
		Assert.assertFalse(ObjectAssertions.isZero(actual));
		actual = 10l;
		Assert.assertFalse(ObjectAssertions.isZero(actual));
	}
	@Test
	public void testAssertZero_Long() {
		System.out.println("ObjectAssertionsLongTest >>> testAssertZero_Long");
		Long actual = 0l;
		ObjectAssertions.assertZero(actual);
	}
	@Test
	public void testAssertZero_Long_failed() {
		System.out.println("ObjectAssertionsLongTest >>> testAssertZero_Long_failed");
		try{
			Long actual=1l;
			ObjectAssertions.assertZero(actual);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1=0):\n\tActual:\t\t1\n\tExpected:\t=0", e.getMessage());
		}
	}
	@Test
	public void testAssertZero_Long_message() {
		System.out.println("ObjectAssertionsLongTest >>> testAssertZero_Long_message");
		Long actual = 0l;
		ObjectAssertions.assertZero(actual,"Message");
	}
	@Test
	public void testAssertZero_Long_message_failed() {
		System.out.println("ObjectAssertionsLongTest >>> testAssertZero_Long_message_failed");
		try{
			Long actual=1l;
			ObjectAssertions.assertZero(actual,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1=0):\n\tActual:\t\t1\n\tExpected:\t=0", e.getMessage());
		}
	}
	@Test
	public void testIsEqual_Long_Long() {
		System.out.println("ObjectAssertionsLongTest >>> testIsEqual_Long_Long");
		Long actual=0l;
		Long expected=0l;
		Assert.assertTrue(ObjectAssertions.isEqual(actual, expected));
		actual=1l;
		expected=1l;
		Assert.assertTrue(ObjectAssertions.isEqual(actual, expected));
		actual=0l;
		expected=1l;
		Assert.assertFalse(ObjectAssertions.isEqual(actual, expected));
	}
	@Test
	public void testAssertEquals_Long_Long() {
		System.out.println("ObjectAssertionsLongTest >>> testAssertEquals_Long_Long");
		Long actual=0l;
		Long expected=0l;
		ObjectAssertions.assertEquals(actual,expected);
		actual=1l;
		expected=1l;
		ObjectAssertions.assertEquals(actual,expected);
	}
	@Test
	public void testAssertEquals_Long_Long_failed() {
		System.out.println("ObjectAssertionsLongTest >>> testAssertEquals_Long_Long_failed");
		try{
			Long actual=1l;
			Long expected=0l;
			ObjectAssertions.assertEquals(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1~0):\n\tActual:\t\t1\n\tExpected:\t~0", e.getMessage());
		}
	}
	@Test
	public void testAssertEquals_Long_Long_message() {
		System.out.println("ObjectAssertionsLongTest >>> testAssertEquals_Long_Long");
		Long actual=0l;
		Long expected=0l;
		ObjectAssertions.assertEquals(actual,expected,"Message");
		actual=1l;
		expected=1l;
		ObjectAssertions.assertEquals(actual,expected,"Message");
	}
	@Test
	public void testAssertEquals_Long_Long_message_failed() {
		System.out.println("ObjectAssertionsLongTest >>> testAssertEquals_Long_Long_failed");
		try{
			Long actual=1l;
			Long expected=0l;
			ObjectAssertions.assertEquals(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1~0):\n\tActual:\t\t1\n\tExpected:\t~0", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_Long_Long() {
		System.out.println("ObjectAssertionsLongTest >>> testAssertNotEquals_Long_Long");
		Long actual=1l;
		Long expected=0l;
		ObjectAssertions.assertNotEquals(actual,expected);
		actual=0l;
		expected=1l;
		ObjectAssertions.assertNotEquals(actual,expected);
	}
	@Test
	public void testAssertNotEquals_Long_Long_failed() {
		System.out.println("ObjectAssertionsLongTest >>> testAssertNotEquals_Long_Long_failed");
		try{
			Long actual=1l;
			Long expected=1l;
			ObjectAssertions.assertNotEquals(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1!~1):\n\tActual:\t\t1\n\tExpected:\t!~1", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_Long_Long_message() {
		System.out.println("ObjectAssertionsLongTest >>> testAssertNotEquals_Long_Long_message");
		Long actual=0l;
		Long expected=1l;
		ObjectAssertions.assertNotEquals(actual,expected,"Message");
		actual=1l;
		expected=0l;
		ObjectAssertions.assertNotEquals(actual,expected);
	}
	@Test
	public void testAssertNotEquals_Long_Long_message_failed() {
		System.out.println("ObjectAssertionsLongTest >>> testAssertNotEquals_Long_Long_message_failed");
		try{
			Long actual=1l;
			Long expected=1l;
			ObjectAssertions.assertNotEquals(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1!~1):\n\tActual:\t\t1\n\tExpected:\t!~1", e.getMessage());
		}
	}	
	@Test
	public void testIsGreater_Long_Long() {
		System.out.println("ObjectAssertionsLongTest >>> testIsGreater_Long_Long");
		Long actual=1l;
		Long expected=0l;
		Assert.assertTrue(ObjectAssertions.isGreater(actual, expected));
		actual=10l;
		expected=1l;
		Assert.assertTrue(ObjectAssertions.isGreater(actual, expected));
		actual=1l;
		expected=1l;
		Assert.assertFalse(ObjectAssertions.isGreater(actual, expected));
		actual=0l;
		expected=1l;
		Assert.assertFalse(ObjectAssertions.isGreater(actual, expected));
	}
	@Test
	public void testAssertGreater_Long_Long() {
		System.out.println("ObjectAssertionsLongTest >>> testAssertGreater_Long_Long");
		Long actual=10l;
		Long expected=1l;
		ObjectAssertions.assertGreater(actual,expected);
		actual=1l;
		expected=0l;
		ObjectAssertions.assertGreater(actual,expected);
	}
	@Test
	public void testAssertGreater_Long_Long_failed() {
		System.out.println("ObjectAssertionsLongTest >>> testAssertGreater_Long_Long_failed");
		try{
			Long actual=1l;
			Long expected=1l;
			ObjectAssertions.assertGreater(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1>1):\n\tActual:\t\t1\n\tExpected:\t>1", e.getMessage());
		}
		try{
			Long actual=0l;
			Long expected=1l;
			ObjectAssertions.assertGreater(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(0>1):\n\tActual:\t\t0\n\tExpected:\t>1", e.getMessage());
		}
	}	
	@Test
	public void testAssertGreater_Long_Long_message() {
		System.out.println("ObjectAssertionsLongTest >>> testAssertGreater_Long_Long_message");
		Long actual=10l;
		Long expected=1l;
		ObjectAssertions.assertGreater(actual,expected,"Message");
		actual=1l;
		expected=0l;
		ObjectAssertions.assertGreater(actual,expected,"Message");
	}
	@Test
	public void testAssertGreater_Long_Long_message_failed() {
		System.out.println("ObjectAssertionsLongTest >>> testAssertGreater_Long_Long_message_failed");
		try{
			Long actual=1l;
			Long expected=1l;
			ObjectAssertions.assertGreater(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1>1):\n\tActual:\t\t1\n\tExpected:\t>1", e.getMessage());
		}
		try{
			Long actual=0l;
			Long expected=1l;
			ObjectAssertions.assertGreater(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(0>1):\n\tActual:\t\t0\n\tExpected:\t>1", e.getMessage());
		}
	}	
	@Test
	public void testIsGreaterOrEqual_Long_Long() {
		System.out.println("ObjectAssertionsLongTest >>> testIsGreaterOrEqual_Long_Long");
		Long actual=1l;
		Long expected=0l;
		Assert.assertTrue(ObjectAssertions.isGreaterOrEqual(actual, expected));
		actual=10l;
		expected=1l;
		Assert.assertTrue(ObjectAssertions.isGreaterOrEqual(actual, expected));
		actual=1l;
		expected=1l;
		Assert.assertTrue(ObjectAssertions.isGreaterOrEqual(actual, expected));
		actual=0l;
		expected=1l;
		Assert.assertFalse(ObjectAssertions.isGreaterOrEqual(actual, expected));
	}
	@Test
	public void testAssertGreaterOrEqual_Long_Long() {
		System.out.println("ObjectAssertionsLongTest >>> testAssertGreaterOrEqual_Long_Long");
		Long actual=10l;
		Long expected=1l;
		ObjectAssertions.assertGreaterOrEqual(actual,expected);
		actual=1l;
		expected=1l;
		ObjectAssertions.assertGreaterOrEqual(actual,expected);
	}
	@Test
	public void testAssertGreaterOrEqual_Long_Long_failed() {
		System.out.println("ObjectAssertionsLongTest >>> testAssertGreaterOrEqual_Long_Long_failed");
		try{
			Long actual=0l;
			Long expected=1l;
			ObjectAssertions.assertGreaterOrEqual(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(0>=1):\n\tActual:\t\t0\n\tExpected:\t>=1", e.getMessage());
		}
	}	
	@Test
	public void testAssertGreaterOrEqual_Long_Long_message() {
		System.out.println("ObjectAssertionsLongTest >>> testAssertGreaterOrEqual_Long_Long_message");
		Long actual=10l;
		Long expected=1l;
		ObjectAssertions.assertGreaterOrEqual(actual,expected,"Message");
		actual=1l;
		expected=1l;
		ObjectAssertions.assertGreaterOrEqual(actual,expected,"Message");
	}
	@Test
	public void testAssertGreaterOrEqual_Long_Long_message_failed() {
		System.out.println("ObjectAssertionsLongTest >>> testAssertGreaterOrEqual_Long_Long_message_failed");
		try{
			Long actual=0l;
			Long expected=1l;
			ObjectAssertions.assertGreaterOrEqual(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(0>=1):\n\tActual:\t\t0\n\tExpected:\t>=1", e.getMessage());
		}
	}	
	@Test
	public void testAssertSmaller_Long_Long() {
		System.out.println("ObjectAssertionsLongTest >>> testAssertSmaller_Long_Long");
		Long actual=1l;
		Long expected=10l;
		ObjectAssertions.assertSmaller(actual,expected);
		actual=0l;
		expected=1l;
		ObjectAssertions.assertSmaller(actual,expected);
	}
	@Test
	public void testAssertSmaller_Long_Long_failed() {
		System.out.println("ObjectAssertionsLongTest >>> testAssertSmaller_Long_Long_failed");
		try{
			Long actual=1l;
			Long expected=1l;
			ObjectAssertions.assertSmaller(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1<1):\n\tActual:\t\t1\n\tExpected:\t<1", e.getMessage());
		}
		try{
			Long actual=1l;
			Long expected=0l;
			ObjectAssertions.assertSmaller(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1<0):\n\tActual:\t\t1\n\tExpected:\t<0", e.getMessage());
		}
	}	
	@Test
	public void testAssertSmaller_Long_Long_message() {
		System.out.println("ObjectAssertionsLongTest >>> testAssertSmaller_Long_Long_message");
		Long actual=1l;
		Long expected=10l;
		ObjectAssertions.assertSmaller(actual,expected,"Message");
		actual=0l;
		expected=1l;
		ObjectAssertions.assertSmaller(actual,expected,"Message");
	}
	@Test
	public void testAssertSmaller_Long_Long_message_failed() {
		System.out.println("ObjectAssertionsLongTest >>> testAssertSmaller_Long_Long_message_failed");
		try{
			Long actual=1l;
			Long expected=1l;
			ObjectAssertions.assertSmaller(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1<1):\n\tActual:\t\t1\n\tExpected:\t<1", e.getMessage());
		}
		try{
			Long actual=1l;
			Long expected=0l;
			ObjectAssertions.assertSmaller(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1<0):\n\tActual:\t\t1\n\tExpected:\t<0", e.getMessage());
		}
	}	
	@Test
	public void testAssertSmallerOrEqual_Long_Long() {
		System.out.println("ObjectAssertionsLongTest >>> testAssertSmallerOrEqual_Long_Long");
		Long actual=1l;
		Long expected=10l;
		ObjectAssertions.assertSmallerOrEqual(actual,expected);
		actual=1l;
		expected=1l;
		ObjectAssertions.assertSmallerOrEqual(actual,expected);
	}
	@Test
	public void testAssertSmallerOrEqual_Long_Long_failed() {
		System.out.println("ObjectAssertionsLongTest >>> testAssertSmallerOrEqual_Long_Long_failed");
		try{
			Long actual=1l;
			Long expected=0l;
			ObjectAssertions.assertSmallerOrEqual(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1<=0):\n\tActual:\t\t1\n\tExpected:\t<=0", e.getMessage());
		}
	}	
	@Test
	public void testAssertSmallerOrEqual_Long_Long_message() {
		System.out.println("ObjectAssertionsLongTest >>> testAssertSmallerOrEqual_Long_Long_message");
		Long actual=1l;
		Long expected=10l;
		ObjectAssertions.assertSmallerOrEqual(actual,expected,"Message");
		actual=1l;
		expected=1l;
		ObjectAssertions.assertSmallerOrEqual(actual,expected,"Message");
	}
	@Test
	public void testAssertSmallerOrEqual_Long_Long_message_failed() {
		System.out.println("ObjectAssertionsLongTest >>> testAssertSmallerOrEqual_Long_Long_message_failed");
		try{
			Long actual=1l;
			Long expected=0l;
			ObjectAssertions.assertSmallerOrEqual(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1<=0):\n\tActual:\t\t1\n\tExpected:\t<=0", e.getMessage());
		}
	}
}
