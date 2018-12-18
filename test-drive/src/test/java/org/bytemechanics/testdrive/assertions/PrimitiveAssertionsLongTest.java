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
public class PrimitiveAssertionsLongTest {
	
	@Test
	public void testIsZero_long() {
		System.out.println("PrimitiveAssertionsLongTest >>> testIsZero_long");
		long actual = 0l;
		Assert.assertTrue(PrimitiveAssertions.isZero(actual));
		actual = 2;
		Assert.assertFalse(PrimitiveAssertions.isZero(actual));
		actual = 10;
		Assert.assertFalse(PrimitiveAssertions.isZero(actual));
	}
	@Test
	public void testAssertZero_long() {
		System.out.println("PrimitiveAssertionsLongTest >>> testAssertZero_long");
		long actual = 0l;
		PrimitiveAssertions.assertZero(actual);
	}
	@Test
	public void testAssertZero_long_failed() {
		System.out.println("PrimitiveAssertionsLongTest >>> testAssertZero_long_failed");
		try{
			long actual=1l;
			PrimitiveAssertions.assertZero(actual);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1=0):\n\tActual:\t\t1\n\tExpected:\t=0", e.getMessage());
		}
	}
	@Test
	public void testAssertZero_long_message() {
		System.out.println("PrimitiveAssertionsLongTest >>> testAssertZero_long_message");
		long actual = 0l;
		PrimitiveAssertions.assertZero(actual,"Message");
	}
	@Test
	public void testAssertZero_long_message_failed() {
		System.out.println("PrimitiveAssertionsLongTest >>> testAssertZero_long_message_failed");
		try{
			long actual=1l;
			PrimitiveAssertions.assertZero(actual,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1=0):\n\tActual:\t\t1\n\tExpected:\t=0", e.getMessage());
		}
	}
	@Test
	public void testIsEqual_long_long() {
		System.out.println("PrimitiveAssertionsLongTest >>> testIsEqual_long_long");
		long actual=0l;
		long expected=0l;
		Assert.assertTrue(PrimitiveAssertions.isEqual(actual, expected));
		actual=1l;
		expected=1l;
		Assert.assertTrue(PrimitiveAssertions.isEqual(actual, expected));
		actual=0l;
		expected=1l;
		Assert.assertFalse(PrimitiveAssertions.isEqual(actual, expected));
	}
	@Test
	public void testAssertEquals_long_long() {
		System.out.println("PrimitiveAssertionsLongTest >>> testAssertEquals_long_long");
		long actual=0l;
		long expected=0l;
		PrimitiveAssertions.assertEquals(actual,expected);
		actual=1l;
		expected=1l;
		PrimitiveAssertions.assertEquals(actual,expected);
	}
	@Test
	public void testAssertEquals_long_long_failed() {
		System.out.println("PrimitiveAssertionsLongTest >>> testAssertEquals_long_long_failed");
		try{
			long actual=1l;
			long expected=0l;
			PrimitiveAssertions.assertEquals(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1=0):\n\tActual:\t\t1\n\tExpected:\t=0", e.getMessage());
		}
	}
	@Test
	public void testAssertEquals_long_long_message() {
		System.out.println("PrimitiveAssertionsLongTest >>> testAssertEquals_long_long");
		long actual=0l;
		long expected=0l;
		PrimitiveAssertions.assertEquals(actual,expected,"Message");
		actual=1l;
		expected=1l;
		PrimitiveAssertions.assertEquals(actual,expected,"Message");
	}
	@Test
	public void testAssertEquals_long_long_message_failed() {
		System.out.println("PrimitiveAssertionsLongTest >>> testAssertEquals_long_long_failed");
		try{
			long actual=1l;
			long expected=0l;
			PrimitiveAssertions.assertEquals(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1=0):\n\tActual:\t\t1\n\tExpected:\t=0", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_long_long() {
		System.out.println("PrimitiveAssertionsLongTest >>> testAssertNotEquals_long_long");
		long actual=1l;
		long expected=0l;
		PrimitiveAssertions.assertNotEquals(actual,expected);
		actual=0l;
		expected=1l;
		PrimitiveAssertions.assertNotEquals(actual,expected);
	}
	@Test
	public void testAssertNotEquals_long_long_failed() {
		System.out.println("PrimitiveAssertionsLongTest >>> testAssertNotEquals_long_long_failed");
		try{
			long actual=1l;
			long expected=1l;
			PrimitiveAssertions.assertNotEquals(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1!=1):\n\tActual:\t\t1\n\tExpected:\t!=1", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_long_long_message() {
		System.out.println("PrimitiveAssertionsLongTest >>> testAssertNotEquals_long_long_message");
		long actual=0l;
		long expected=1l;
		PrimitiveAssertions.assertNotEquals(actual,expected,"Message");
		actual=1l;
		expected=0l;
		PrimitiveAssertions.assertNotEquals(actual,expected);
	}
	@Test
	public void testAssertNotEquals_long_long_message_failed() {
		System.out.println("PrimitiveAssertionsLongTest >>> testAssertNotEquals_long_long_message_failed");
		try{
			long actual=1l;
			long expected=1l;
			PrimitiveAssertions.assertNotEquals(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1!=1):\n\tActual:\t\t1\n\tExpected:\t!=1", e.getMessage());
		}
	}	
	@Test
	public void testIsGreater_long_long() {
		System.out.println("PrimitiveAssertionsLongTest >>> testIsGreater_long_long");
		long actual=1l;
		long expected=0l;
		Assert.assertTrue(PrimitiveAssertions.isGreater(actual, expected));
		actual=10l;
		expected=1l;
		Assert.assertTrue(PrimitiveAssertions.isGreater(actual, expected));
		actual=1l;
		expected=1l;
		Assert.assertFalse(PrimitiveAssertions.isGreater(actual, expected));
		actual=0l;
		expected=1l;
		Assert.assertFalse(PrimitiveAssertions.isGreater(actual, expected));
	}
	@Test
	public void testAssertGreater_long_long() {
		System.out.println("PrimitiveAssertionsLongTest >>> testAssertGreater_long_long");
		long actual=10l;
		long expected=1l;
		PrimitiveAssertions.assertGreater(actual,expected);
		actual=1l;
		expected=0l;
		PrimitiveAssertions.assertGreater(actual,expected);
	}
	@Test
	public void testAssertGreater_long_long_failed() {
		System.out.println("PrimitiveAssertionsLongTest >>> testAssertGreater_long_long_failed");
		try{
			long actual=1l;
			long expected=1l;
			PrimitiveAssertions.assertGreater(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1>1):\n\tActual:\t\t1\n\tExpected:\t>1", e.getMessage());
		}
		try{
			long actual=0;
			long expected=1;
			PrimitiveAssertions.assertGreater(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(0>1):\n\tActual:\t\t0\n\tExpected:\t>1", e.getMessage());
		}
	}	
	@Test
	public void testAssertGreater_long_long_message() {
		System.out.println("PrimitiveAssertionsLongTest >>> testAssertGreater_long_long_message");
		long actual=10l;
		long expected=1l;
		PrimitiveAssertions.assertGreater(actual,expected,"Message");
		actual=1l;
		expected=0l;
		PrimitiveAssertions.assertGreater(actual,expected,"Message");
	}
	@Test
	public void testAssertGreater_long_long_message_failed() {
		System.out.println("PrimitiveAssertionsLongTest >>> testAssertGreater_long_long_message_failed");
		try{
			long actual=1l;
			long expected=1l;
			PrimitiveAssertions.assertGreater(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1>1):\n\tActual:\t\t1\n\tExpected:\t>1", e.getMessage());
		}
		try{
			long actual=0l;
			long expected=1l;
			PrimitiveAssertions.assertGreater(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(0>1):\n\tActual:\t\t0\n\tExpected:\t>1", e.getMessage());
		}
	}	
	@Test
	public void testIsGreaterOrEqual_long_long() {
		System.out.println("PrimitiveAssertionsLongTest >>> testIsGreaterOrEqual_long_long");
		long actual=1l;
		long expected=0l;
		Assert.assertTrue(PrimitiveAssertions.isGreaterOrEqual(actual, expected));
		actual=10l;
		expected=1l;
		Assert.assertTrue(PrimitiveAssertions.isGreaterOrEqual(actual, expected));
		actual=1l;
		expected=1l;
		Assert.assertTrue(PrimitiveAssertions.isGreaterOrEqual(actual, expected));
		actual=0l;
		expected=1l;
		Assert.assertFalse(PrimitiveAssertions.isGreaterOrEqual(actual, expected));
	}
	@Test
	public void testAssertGreaterOrEqual_long_long() {
		System.out.println("PrimitiveAssertionsLongTest >>> testAssertGreaterOrEqual_long_long");
		long actual=10l;
		long expected=1l;
		PrimitiveAssertions.assertGreaterOrEqual(actual,expected);
		actual=1l;
		expected=1l;
		PrimitiveAssertions.assertGreaterOrEqual(actual,expected);
	}
	@Test
	public void testAssertGreaterOrEqual_long_long_failed() {
		System.out.println("PrimitiveAssertionsLongTest >>> testAssertGreaterOrEqual_long_long_failed");
		try{
			long actual=0l;
			long expected=1l;
			PrimitiveAssertions.assertGreaterOrEqual(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(0>=1):\n\tActual:\t\t0\n\tExpected:\t>=1", e.getMessage());
		}
	}	
	@Test
	public void testAssertGreaterOrEqual_long_long_message() {
		System.out.println("PrimitiveAssertionsLongTest >>> testAssertGreaterOrEqual_long_long_message");
		long actual=10l;
		long expected=1l;
		PrimitiveAssertions.assertGreaterOrEqual(actual,expected,"Message");
		actual=1l;
		expected=1l;
		PrimitiveAssertions.assertGreaterOrEqual(actual,expected,"Message");
	}
	@Test
	public void testAssertGreaterOrEqual_long_long_message_failed() {
		System.out.println("PrimitiveAssertionsLongTest >>> testAssertGreaterOrEqual_long_long_message_failed");
		try{
			long actual=0l;
			long expected=1l;
			PrimitiveAssertions.assertGreaterOrEqual(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(0>=1):\n\tActual:\t\t0\n\tExpected:\t>=1", e.getMessage());
		}
	}	
	@Test
	public void testAssertSmaller_long_long() {
		System.out.println("PrimitiveAssertionsLongTest >>> testAssertSmaller_long_long");
		long actual=1l;
		long expected=10l;
		PrimitiveAssertions.assertSmaller(actual,expected);
		actual=0l;
		expected=1l;
		PrimitiveAssertions.assertSmaller(actual,expected);
	}
	@Test
	public void testAssertSmaller_long_long_failed() {
		System.out.println("PrimitiveAssertionsLongTest >>> testAssertSmaller_long_long_failed");
		try{
			long actual=1l;
			long expected=1l;
			PrimitiveAssertions.assertSmaller(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1<1):\n\tActual:\t\t1\n\tExpected:\t<1", e.getMessage());
		}
		try{
			long actual=1l;
			long expected=0l;
			PrimitiveAssertions.assertSmaller(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1<0):\n\tActual:\t\t1\n\tExpected:\t<0", e.getMessage());
		}
	}	
	@Test
	public void testAssertSmaller_long_long_message() {
		System.out.println("PrimitiveAssertionsLongTest >>> testAssertSmaller_long_long_message");
		long actual=1l;
		long expected=10l;
		PrimitiveAssertions.assertSmaller(actual,expected,"Message");
		actual=0l;
		expected=1l;
		PrimitiveAssertions.assertSmaller(actual,expected,"Message");
	}
	@Test
	public void testAssertSmaller_long_long_message_failed() {
		System.out.println("PrimitiveAssertionsLongTest >>> testAssertSmaller_long_long_message_failed");
		try{
			long actual=1l;
			long expected=1l;
			PrimitiveAssertions.assertSmaller(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1<1):\n\tActual:\t\t1\n\tExpected:\t<1", e.getMessage());
		}
		try{
			long actual=1l;
			long expected=0l;
			PrimitiveAssertions.assertSmaller(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1<0):\n\tActual:\t\t1\n\tExpected:\t<0", e.getMessage());
		}
	}	
	@Test
	public void testAssertSmallerOrEqual_long_long() {
		System.out.println("PrimitiveAssertionsLongTest >>> testAssertSmallerOrEqual_long_long");
		long actual=1l;
		long expected=10l;
		PrimitiveAssertions.assertSmallerOrEqual(actual,expected);
		actual=1;
		expected=1;
		PrimitiveAssertions.assertSmallerOrEqual(actual,expected);
	}
	@Test
	public void testAssertSmallerOrEqual_long_long_failed() {
		System.out.println("PrimitiveAssertionsLongTest >>> testAssertSmallerOrEqual_long_long_failed");
		try{
			long actual=1l;
			long expected=0l;
			PrimitiveAssertions.assertSmallerOrEqual(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1<=0):\n\tActual:\t\t1\n\tExpected:\t<=0", e.getMessage());
		}
	}	
	@Test
	public void testAssertSmallerOrEqual_long_long_message() {
		System.out.println("PrimitiveAssertionsLongTest >>> testAssertSmallerOrEqual_long_long_message");
		long actual=1l;
		long expected=10l;
		PrimitiveAssertions.assertSmallerOrEqual(actual,expected,"Message");
		actual=1l;
		expected=1l;
		PrimitiveAssertions.assertSmallerOrEqual(actual,expected,"Message");
	}
	@Test
	public void testAssertSmallerOrEqual_long_long_message_failed() {
		System.out.println("PrimitiveAssertionsLongTest >>> testAssertSmallerOrEqual_long_long_message_failed");
		try{
			long actual=1l;
			long expected=0l;
			PrimitiveAssertions.assertSmallerOrEqual(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1<=0):\n\tActual:\t\t1\n\tExpected:\t<=0", e.getMessage());
		}
	}	
}
