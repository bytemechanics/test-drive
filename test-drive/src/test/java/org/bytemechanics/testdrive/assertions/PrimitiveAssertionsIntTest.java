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
public class PrimitiveAssertionsIntTest {
	
	@Test
	public void testIsZero_int() {
		System.out.println("PrimitiveAssertionsTest >>> testIsZero_int");
		int actual = 0;
		Assert.assertTrue(PrimitiveAssertions.isZero(actual));
		actual = 2;
		Assert.assertFalse(PrimitiveAssertions.isZero(actual));
		actual = 10;
		Assert.assertFalse(PrimitiveAssertions.isZero(actual));
	}
	@Test
	public void testAssertZero_int() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertZero_int");
		int actual = 0;
		PrimitiveAssertions.assertZero(actual);
	}
	@Test
	public void testAssertZero_int_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertZero_int_failed");
		try{
			int actual=1;
			PrimitiveAssertions.assertZero(actual);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1=0):\n\tActual:\t\t1\n\tExpected:\t=0", e.getMessage());
		}
	}
	@Test
	public void testAssertZero_int_message() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertZero_int_message");
		int actual = 0;
		PrimitiveAssertions.assertZero(actual,"Message");
	}
	@Test
	public void testAssertZero_int_message_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertZero_int_message_failed");
		try{
			int actual=1;
			PrimitiveAssertions.assertZero(actual,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1=0):\n\tActual:\t\t1\n\tExpected:\t=0", e.getMessage());
		}
	}
	@Test
	public void testIsEqual_int_int() {
		System.out.println("PrimitiveAssertionsTest >>> testIsEqual_int_int");
		int actual=0;
		int expected=0;
		Assert.assertTrue(PrimitiveAssertions.isEqual(actual, expected));
		actual=1;
		expected=1;
		Assert.assertTrue(PrimitiveAssertions.isEqual(actual, expected));
		actual=0;
		expected=1;
		Assert.assertFalse(PrimitiveAssertions.isEqual(actual, expected));
	}
	@Test
	public void testAssertEquals_int_int() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertEquals_int_int");
		int actual=0;
		int expected=0;
		PrimitiveAssertions.assertEquals(actual,expected);
		actual=1;
		expected=1;
		PrimitiveAssertions.assertEquals(actual,expected);
	}
	@Test
	public void testAssertEquals_int_int_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertEquals_int_int_failed");
		try{
			int actual=1;
			int expected=0;
			PrimitiveAssertions.assertEquals(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1=0):\n\tActual:\t\t1\n\tExpected:\t=0", e.getMessage());
		}
	}
	@Test
	public void testAssertEquals_int_int_message() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertEquals_int_int");
		int actual=0;
		int expected=0;
		PrimitiveAssertions.assertEquals(actual,expected,"Message");
		actual=1;
		expected=1;
		PrimitiveAssertions.assertEquals(actual,expected,"Message");
	}
	@Test
	public void testAssertEquals_int_int_message_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertEquals_int_int_failed");
		try{
			int actual=1;
			int expected=0;
			PrimitiveAssertions.assertEquals(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1=0):\n\tActual:\t\t1\n\tExpected:\t=0", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_int_int() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertNotEquals_int_int");
		int actual=1;
		int expected=0;
		PrimitiveAssertions.assertNotEquals(actual,expected);
		actual=0;
		expected=1;
		PrimitiveAssertions.assertNotEquals(actual,expected);
	}
	@Test
	public void testAssertNotEquals_int_int_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertNotEquals_int_int_failed");
		try{
			int actual=1;
			int expected=1;
			PrimitiveAssertions.assertNotEquals(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1!=1):\n\tActual:\t\t1\n\tExpected:\t!=1", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_int_int_message() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertNotEquals_int_int_message");
		int actual=0;
		int expected=1;
		PrimitiveAssertions.assertNotEquals(actual,expected,"Message");
		actual=1;
		expected=0;
		PrimitiveAssertions.assertNotEquals(actual,expected);
	}
	@Test
	public void testAssertNotEquals_int_int_message_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertNotEquals_int_int_message_failed");
		try{
			int actual=1;
			int expected=1;
			PrimitiveAssertions.assertNotEquals(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1!=1):\n\tActual:\t\t1\n\tExpected:\t!=1", e.getMessage());
		}
	}	
	@Test
	public void testIsGreater_int_int() {
		System.out.println("PrimitiveAssertionsTest >>> testIsGreater_int_int");
		int actual=1;
		int expected=0;
		Assert.assertTrue(PrimitiveAssertions.isGreater(actual, expected));
		actual=10;
		expected=1;
		Assert.assertTrue(PrimitiveAssertions.isGreater(actual, expected));
		actual=1;
		expected=1;
		Assert.assertFalse(PrimitiveAssertions.isGreater(actual, expected));
		actual=0;
		expected=1;
		Assert.assertFalse(PrimitiveAssertions.isGreater(actual, expected));
	}
	@Test
	public void testAssertGreater_int_int() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertGreater_int_int");
		int actual=10;
		int expected=1;
		PrimitiveAssertions.assertGreater(actual,expected);
		actual=1;
		expected=0;
		PrimitiveAssertions.assertGreater(actual,expected);
	}
	@Test
	public void testAssertGreater_int_int_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertGreater_int_int_failed");
		try{
			int actual=1;
			int expected=1;
			PrimitiveAssertions.assertGreater(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1>1):\n\tActual:\t\t1\n\tExpected:\t>1", e.getMessage());
		}
		try{
			int actual=0;
			int expected=1;
			PrimitiveAssertions.assertGreater(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(0>1):\n\tActual:\t\t0\n\tExpected:\t>1", e.getMessage());
		}
	}	
	@Test
	public void testAssertGreater_int_int_message() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertGreater_int_int_message");
		int actual=10;
		int expected=1;
		PrimitiveAssertions.assertGreater(actual,expected,"Message");
		actual=1;
		expected=0;
		PrimitiveAssertions.assertGreater(actual,expected,"Message");
	}
	@Test
	public void testAssertGreater_int_int_message_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertGreater_int_int_message_failed");
		try{
			int actual=1;
			int expected=1;
			PrimitiveAssertions.assertGreater(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1>1):\n\tActual:\t\t1\n\tExpected:\t>1", e.getMessage());
		}
		try{
			int actual=0;
			int expected=1;
			PrimitiveAssertions.assertGreater(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(0>1):\n\tActual:\t\t0\n\tExpected:\t>1", e.getMessage());
		}
	}	
	@Test
	public void testIsGreaterOrEqual_int_int() {
		System.out.println("PrimitiveAssertionsTest >>> testIsGreaterOrEqual_int_int");
		int actual=1;
		int expected=0;
		Assert.assertTrue(PrimitiveAssertions.isGreaterOrEqual(actual, expected));
		actual=10;
		expected=1;
		Assert.assertTrue(PrimitiveAssertions.isGreaterOrEqual(actual, expected));
		actual=1;
		expected=1;
		Assert.assertTrue(PrimitiveAssertions.isGreaterOrEqual(actual, expected));
		actual=0;
		expected=1;
		Assert.assertFalse(PrimitiveAssertions.isGreaterOrEqual(actual, expected));
	}
	@Test
	public void testAssertGreaterOrEqual_int_int() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertGreaterOrEqual_int_int");
		int actual=10;
		int expected=1;
		PrimitiveAssertions.assertGreaterOrEqual(actual,expected);
		actual=1;
		expected=1;
		PrimitiveAssertions.assertGreaterOrEqual(actual,expected);
	}
	@Test
	public void testAssertGreaterOrEqual_int_int_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertGreaterOrEqual_int_int_failed");
		try{
			int actual=0;
			int expected=1;
			PrimitiveAssertions.assertGreaterOrEqual(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(0>=1):\n\tActual:\t\t0\n\tExpected:\t>=1", e.getMessage());
		}
	}	
	@Test
	public void testAssertGreaterOrEqual_int_int_message() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertGreaterOrEqual_int_int_message");
		int actual=10;
		int expected=1;
		PrimitiveAssertions.assertGreaterOrEqual(actual,expected,"Message");
		actual=1;
		expected=1;
		PrimitiveAssertions.assertGreaterOrEqual(actual,expected,"Message");
	}
	@Test
	public void testAssertGreaterOrEqual_int_int_message_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertGreaterOrEqual_int_int_message_failed");
		try{
			int actual=0;
			int expected=1;
			PrimitiveAssertions.assertGreaterOrEqual(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(0>=1):\n\tActual:\t\t0\n\tExpected:\t>=1", e.getMessage());
		}
	}	
	@Test
	public void testAssertSmaller_int_int() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertSmaller_int_int");
		int actual=1;
		int expected=10;
		PrimitiveAssertions.assertSmaller(actual,expected);
		actual=0;
		expected=1;
		PrimitiveAssertions.assertSmaller(actual,expected);
	}
	@Test
	public void testAssertSmaller_int_int_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertSmaller_int_int_failed");
		try{
			int actual=1;
			int expected=1;
			PrimitiveAssertions.assertSmaller(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1<1):\n\tActual:\t\t1\n\tExpected:\t<1", e.getMessage());
		}
		try{
			int actual=1;
			int expected=0;
			PrimitiveAssertions.assertSmaller(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1<0):\n\tActual:\t\t1\n\tExpected:\t<0", e.getMessage());
		}
	}	
	@Test
	public void testAssertSmaller_int_int_message() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertSmaller_int_int_message");
		int actual=1;
		int expected=10;
		PrimitiveAssertions.assertSmaller(actual,expected,"Message");
		actual=0;
		expected=1;
		PrimitiveAssertions.assertSmaller(actual,expected,"Message");
	}
	@Test
	public void testAssertSmaller_int_int_message_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertSmaller_int_int_message_failed");
		try{
			int actual=1;
			int expected=1;
			PrimitiveAssertions.assertSmaller(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1<1):\n\tActual:\t\t1\n\tExpected:\t<1", e.getMessage());
		}
		try{
			int actual=1;
			int expected=0;
			PrimitiveAssertions.assertSmaller(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1<0):\n\tActual:\t\t1\n\tExpected:\t<0", e.getMessage());
		}
	}	
	@Test
	public void testAssertSmallerOrEqual_int_int() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertSmallerOrEqual_int_int");
		int actual=1;
		int expected=10;
		PrimitiveAssertions.assertSmallerOrEqual(actual,expected);
		actual=1;
		expected=1;
		PrimitiveAssertions.assertSmallerOrEqual(actual,expected);
	}
	@Test
	public void testAssertSmallerOrEqual_int_int_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertSmallerOrEqual_int_int_failed");
		try{
			int actual=1;
			int expected=0;
			PrimitiveAssertions.assertSmallerOrEqual(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1<=0):\n\tActual:\t\t1\n\tExpected:\t<=0", e.getMessage());
		}
	}	
	@Test
	public void testAssertSmallerOrEqual_int_int_message() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertSmallerOrEqual_int_int_message");
		int actual=1;
		int expected=10;
		PrimitiveAssertions.assertSmallerOrEqual(actual,expected,"Message");
		actual=1;
		expected=1;
		PrimitiveAssertions.assertSmallerOrEqual(actual,expected,"Message");
	}
	@Test
	public void testAssertSmallerOrEqual_int_int_message_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertSmallerOrEqual_int_int_message_failed");
		try{
			int actual=1;
			int expected=0;
			PrimitiveAssertions.assertSmallerOrEqual(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1<=0):\n\tActual:\t\t1\n\tExpected:\t<=0", e.getMessage());
		}
	}	
}