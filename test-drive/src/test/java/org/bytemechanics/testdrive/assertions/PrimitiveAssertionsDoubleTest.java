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
public class PrimitiveAssertionsDoubleTest {
		
	@Test
	public void testIsZero_double() {
		System.out.println("PrimitiveAssertionsTest >>> testIsZero_double");
		double actual = 0.0d;
		Assert.assertTrue(PrimitiveAssertions.isZero(actual));
		actual = 2.0d;
		Assert.assertFalse(PrimitiveAssertions.isZero(actual));
		actual = 10.0d;
		Assert.assertFalse(PrimitiveAssertions.isZero(actual));
	}
	@Test
	public void testAssertZero_double() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertZero_double");
		double actual = 0.0d;
		PrimitiveAssertions.assertZero(actual);
	}
	@Test
	public void testAssertZero_double_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertZero_double_failed");
		try{
			double actual=1.0d;
			PrimitiveAssertions.assertZero(actual);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.0=0.0):\n\tActual:\t\t1.0\n\tExpected:\t=0.0", e.getMessage());
		}
	}
	@Test
	public void testAssertZero_double_message() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertZero_double_message");
		double actual = 0.0d;
		PrimitiveAssertions.assertZero(actual,"Message");
	}
	@Test
	public void testAssertZero_double_message_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertZero_double_message_failed");
		try{
			double actual=1.0d;
			PrimitiveAssertions.assertZero(actual,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.0=0.0):\n\tActual:\t\t1.0\n\tExpected:\t=0.0", e.getMessage());
		}
	}
	@Test
	public void testIsEqual_double_double() {
		System.out.println("PrimitiveAssertionsTest >>> testIsEqual_double_double");
		double actual=0.0d;
		double expected=0.0d;
		Assert.assertTrue(PrimitiveAssertions.isEqual(actual, expected));
		actual=1.0d;
		expected=1.0d;
		Assert.assertTrue(PrimitiveAssertions.isEqual(actual, expected));
		actual=0.0d;
		expected=1.0d;
		Assert.assertFalse(PrimitiveAssertions.isEqual(actual, expected));
	}
	@Test
	public void testAssertEquals_double_double() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertEquals_double_double");
		double actual=0.0d;
		double expected=0.0d;
		PrimitiveAssertions.assertEquals(actual,expected);
		actual=1.0d;
		expected=1.0d;
		PrimitiveAssertions.assertEquals(actual,expected);
	}
	@Test
	public void testAssertEquals_double_double_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertEquals_double_double_failed");
		try{
			double actual=1.0d;
			double expected=0.0d;
			PrimitiveAssertions.assertEquals(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.0=0.0):\n\tActual:\t\t1.0\n\tExpected:\t=0.0", e.getMessage());
		}
	}
	@Test
	public void testAssertEquals_double_double_message() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertEquals_double_double");
		double actual=0.0d;
		double expected=0.0d;
		PrimitiveAssertions.assertEquals(actual,expected,"Message");
		actual=1.0d;
		expected=1.0d;
		PrimitiveAssertions.assertEquals(actual,expected,"Message");
	}
	@Test
	public void testAssertEquals_double_double_message_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertEquals_double_double_failed");
		try{
			double actual=1.0d;
			double expected=0.0d;
			PrimitiveAssertions.assertEquals(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.0=0.0):\n\tActual:\t\t1.0\n\tExpected:\t=0.0", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_double_double() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertNotEquals_double_double");
		double actual=1.0d;
		double expected=0.0d;
		PrimitiveAssertions.assertNotEquals(actual,expected);
		actual=0.0d;
		expected=1.0d;
		PrimitiveAssertions.assertNotEquals(actual,expected);
	}
	@Test
	public void testAssertNotEquals_double_double_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertNotEquals_double_double_failed");
		try{
			double actual=1.0d;
			double expected=1.0d;
			PrimitiveAssertions.assertNotEquals(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.0!=1.0):\n\tActual:\t\t1.0\n\tExpected:\t!=1.0", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_double_double_message() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertNotEquals_double_double_message");
		double actual=0.0d;
		double expected=1.0d;
		PrimitiveAssertions.assertNotEquals(actual,expected,"Message");
		actual=1.0d;
		expected=0.0d;
		PrimitiveAssertions.assertNotEquals(actual,expected);
	}
	@Test
	public void testAssertNotEquals_double_double_message_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertNotEquals_double_double_message_failed");
		try{
			double actual=1.0d;
			double expected=1.0d;
			PrimitiveAssertions.assertNotEquals(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.0!=1.0):\n\tActual:\t\t1.0\n\tExpected:\t!=1.0", e.getMessage());
		}
	}	
	@Test
	public void testIsGreater_double_double() {
		System.out.println("PrimitiveAssertionsTest >>> testIsGreater_double_double");
		double actual=1.0d;
		double expected=0.0d;
		Assert.assertTrue(PrimitiveAssertions.isGreater(actual, expected));
		actual=10.0d;
		expected=1.0d;
		Assert.assertTrue(PrimitiveAssertions.isGreater(actual, expected));
		actual=1.0d;
		expected=1.0d;
		Assert.assertFalse(PrimitiveAssertions.isGreater(actual, expected));
		actual=0.0d;
		expected=1.0d;
		Assert.assertFalse(PrimitiveAssertions.isGreater(actual, expected));
	}
	@Test
	public void testAssertGreater_double_double() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertGreater_double_double");
		double actual=10.0d;
		double expected=1.0d;
		PrimitiveAssertions.assertGreater(actual,expected);
		actual=1.0d;
		expected=0.0d;
		PrimitiveAssertions.assertGreater(actual,expected);
	}
	@Test
	public void testAssertGreater_double_double_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertGreater_double_double_failed");
		try{
			double actual=1.0d;
			double expected=1.0d;
			PrimitiveAssertions.assertGreater(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.0>1.0):\n\tActual:\t\t1.0\n\tExpected:\t>1.0", e.getMessage());
		}
		try{
			double actual=0.0d;
			double expected=1.0d;
			PrimitiveAssertions.assertGreater(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(0.0>1.0):\n\tActual:\t\t0.0\n\tExpected:\t>1.0", e.getMessage());
		}
	}	
	@Test
	public void testAssertGreater_double_double_message() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertGreater_double_double_message");
		double actual=10.0d;
		double expected=1.0d;
		PrimitiveAssertions.assertGreater(actual,expected,"Message");
		actual=1.0d;
		expected=0.0d;
		PrimitiveAssertions.assertGreater(actual,expected,"Message");
	}
	@Test
	public void testAssertGreater_double_double_message_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertGreater_double_double_message_failed");
		try{
			double actual=1.0d;
			double expected=1.0d;
			PrimitiveAssertions.assertGreater(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.0>1.0):\n\tActual:\t\t1.0\n\tExpected:\t>1.0", e.getMessage());
		}
		try{
			double actual=0.0d;
			double expected=1.0d;
			PrimitiveAssertions.assertGreater(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(0.0>1.0):\n\tActual:\t\t0.0\n\tExpected:\t>1.0", e.getMessage());
		}
	}	
	@Test
	public void testIsGreaterOrEqual_double_double() {
		System.out.println("PrimitiveAssertionsTest >>> testIsGreaterOrEqual_double_double");
		double actual=1.0d;
		double expected=0.0d;
		Assert.assertTrue(PrimitiveAssertions.isGreaterOrEqual(actual, expected));
		actual=10.0d;
		expected=1.0d;
		Assert.assertTrue(PrimitiveAssertions.isGreaterOrEqual(actual, expected));
		actual=1.0d;
		expected=1.0d;
		Assert.assertTrue(PrimitiveAssertions.isGreaterOrEqual(actual, expected));
		actual=0.0d;
		expected=1.0d;
		Assert.assertFalse(PrimitiveAssertions.isGreaterOrEqual(actual, expected));
	}
	@Test
	public void testAssertGreaterOrEqual_double_double() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertGreaterOrEqual_double_double");
		double actual=10.0d;
		double expected=1.0d;
		PrimitiveAssertions.assertGreaterOrEqual(actual,expected);
		actual=1.0d;
		expected=1.0d;
		PrimitiveAssertions.assertGreaterOrEqual(actual,expected);
	}
	@Test
	public void testAssertGreaterOrEqual_double_double_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertGreaterOrEqual_double_double_failed");
		try{
			double actual=0.0d;
			double expected=1.0d;
			PrimitiveAssertions.assertGreaterOrEqual(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(0.0>=1.0):\n\tActual:\t\t0.0\n\tExpected:\t>=1.0", e.getMessage());
		}
	}	
	@Test
	public void testAssertGreaterOrEqual_double_double_message() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertGreaterOrEqual_double_double_message");
		double actual=10.0d;
		double expected=1.0d;
		PrimitiveAssertions.assertGreaterOrEqual(actual,expected,"Message");
		actual=1.0d;
		expected=1.0d;
		PrimitiveAssertions.assertGreaterOrEqual(actual,expected,"Message");
	}
	@Test
	public void testAssertGreaterOrEqual_double_double_message_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertGreaterOrEqual_double_double_message_failed");
		try{
			double actual=0.0d;
			double expected=1.0d;
			PrimitiveAssertions.assertGreaterOrEqual(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(0.0>=1.0):\n\tActual:\t\t0.0\n\tExpected:\t>=1.0", e.getMessage());
		}
	}	
	@Test
	public void testAssertSmaller_double_double() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertSmaller_double_double");
		double actual=1.0d;
		double expected=10.0d;
		PrimitiveAssertions.assertSmaller(actual,expected);
		actual=0.0d;
		expected=1.0d;
		PrimitiveAssertions.assertSmaller(actual,expected);
	}
	@Test
	public void testAssertSmaller_double_double_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertSmaller_double_double_failed");
		try{
			double actual=1.0d;
			double expected=1.0d;
			PrimitiveAssertions.assertSmaller(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.0<1.0):\n\tActual:\t\t1.0\n\tExpected:\t<1.0", e.getMessage());
		}
		try{
			double actual=1.0d;
			double expected=0.0d;
			PrimitiveAssertions.assertSmaller(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.0<0.0):\n\tActual:\t\t1.0\n\tExpected:\t<0.0", e.getMessage());
		}
	}	
	@Test
	public void testAssertSmaller_double_double_message() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertSmaller_double_double_message");
		double actual=1.0d;
		double expected=10.0d;
		PrimitiveAssertions.assertSmaller(actual,expected,"Message");
		actual=0.0d;
		expected=1.0d;
		PrimitiveAssertions.assertSmaller(actual,expected,"Message");
	}
	@Test
	public void testAssertSmaller_double_double_message_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertSmaller_double_double_message_failed");
		try{
			double actual=1.0d;
			double expected=1.0d;
			PrimitiveAssertions.assertSmaller(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.0<1.0):\n\tActual:\t\t1.0\n\tExpected:\t<1.0", e.getMessage());
		}
		try{
			double actual=1.0d;
			double expected=0.0d;
			PrimitiveAssertions.assertSmaller(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.0<0.0):\n\tActual:\t\t1.0\n\tExpected:\t<0.0", e.getMessage());
		}
	}	
	@Test
	public void testAssertSmallerOrEqual_double_double() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertSmallerOrEqual_double_double");
		double actual=1.0d;
		double expected=10.0d;
		PrimitiveAssertions.assertSmallerOrEqual(actual,expected);
		actual=1.0d;
		expected=1.0d;
		PrimitiveAssertions.assertSmallerOrEqual(actual,expected);
	}
	@Test
	public void testAssertSmallerOrEqual_double_double_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertSmallerOrEqual_double_double_failed");
		try{
			double actual=1.0d;
			double expected=0.0d;
			PrimitiveAssertions.assertSmallerOrEqual(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.0<=0.0):\n\tActual:\t\t1.0\n\tExpected:\t<=0.0", e.getMessage());
		}
	}	
	@Test
	public void testAssertSmallerOrEqual_double_double_message() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertSmallerOrEqual_double_double_message");
		double actual=1.0d;
		double expected=10.0d;
		PrimitiveAssertions.assertSmallerOrEqual(actual,expected,"Message");
		actual=1.0d;
		expected=1.0d;
		PrimitiveAssertions.assertSmallerOrEqual(actual,expected,"Message");
	}
	@Test
	public void testAssertSmallerOrEqual_double_double_message_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertSmallerOrEqual_double_double_message_failed");
		try{
			double actual=1.0d;
			double expected=0.0d;
			PrimitiveAssertions.assertSmallerOrEqual(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.0<=0.0):\n\tActual:\t\t1.0\n\tExpected:\t<=0.0", e.getMessage());
		}
	}	
}
