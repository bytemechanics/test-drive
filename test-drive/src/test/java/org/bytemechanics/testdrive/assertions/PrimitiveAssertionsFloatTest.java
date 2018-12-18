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
public class PrimitiveAssertionsFloatTest {
	
	@Test
	public void testIsZero_float() {
		System.out.println("PrimitiveAssertionsFloatTest >>> testIsZero_float");
		float actual = 0.0f;
		Assert.assertTrue(PrimitiveAssertions.isZero(actual));
		actual = 2.0f;
		Assert.assertFalse(PrimitiveAssertions.isZero(actual));
		actual = 10.0f;
		Assert.assertFalse(PrimitiveAssertions.isZero(actual));
	}
	@Test
	public void testAssertZero_float() {
		System.out.println("PrimitiveAssertionsFloatTest >>> testAssertZero_float");
		float actual = 0.0f;
		PrimitiveAssertions.assertZero(actual);
	}
	@Test
	public void testAssertZero_float_failed() {
		System.out.println("PrimitiveAssertionsFloatTest >>> testAssertZero_float_failed");
		try{
			float actual=1.0f;
			PrimitiveAssertions.assertZero(actual);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.0=0.0):\n\tActual:\t\t1.0\n\tExpected:\t=0.0", e.getMessage());
		}
	}
	@Test
	public void testAssertZero_float_message() {
		System.out.println("PrimitiveAssertionsFloatTest >>> testAssertZero_float_message");
		float actual = 0.0f;
		PrimitiveAssertions.assertZero(actual,"Message");
	}
	@Test
	public void testAssertZero_float_message_failed() {
		System.out.println("PrimitiveAssertionsFloatTest >>> testAssertZero_float_message_failed");
		try{
			float actual=1.0f;
			PrimitiveAssertions.assertZero(actual,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.0=0.0):\n\tActual:\t\t1.0\n\tExpected:\t=0.0", e.getMessage());
		}
	}
	@Test
	public void testIsEqual_float_float() {
		System.out.println("PrimitiveAssertionsFloatTest >>> testIsEqual_float_float");
		float actual=0.0f;
		float expected=0.0f;
		Assert.assertTrue(PrimitiveAssertions.isEqual(actual, expected));
		actual=1.0f;
		expected=1.0f;
		Assert.assertTrue(PrimitiveAssertions.isEqual(actual, expected));
		actual=0.0f;
		expected=1.0f;
		Assert.assertFalse(PrimitiveAssertions.isEqual(actual, expected));
	}
	@Test
	public void testAssertEquals_float_float() {
		System.out.println("PrimitiveAssertionsFloatTest >>> testAssertEquals_float_float");
		float actual=0.0f;
		float expected=0.0f;
		PrimitiveAssertions.assertEquals(actual,expected);
		actual=1.0f;
		expected=1.0f;
		PrimitiveAssertions.assertEquals(actual,expected);
	}
	@Test
	public void testAssertEquals_float_float_failed() {
		System.out.println("PrimitiveAssertionsFloatTest >>> testAssertEquals_float_float_failed");
		try{
			float actual=1.0f;
			float expected=0.0f;
			PrimitiveAssertions.assertEquals(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.0=0.0):\n\tActual:\t\t1.0\n\tExpected:\t=0.0", e.getMessage());
		}
	}
	@Test
	public void testAssertEquals_float_float_message() {
		System.out.println("PrimitiveAssertionsFloatTest >>> testAssertEquals_float_float");
		float actual=0.0f;
		float expected=0.0f;
		PrimitiveAssertions.assertEquals(actual,expected,"Message");
		actual=1.0f;
		expected=1.0f;
		PrimitiveAssertions.assertEquals(actual,expected,"Message");
	}
	@Test
	public void testAssertEquals_float_float_message_failed() {
		System.out.println("PrimitiveAssertionsFloatTest >>> testAssertEquals_float_float_failed");
		try{
			float actual=1.0f;
			float expected=0.0f;
			PrimitiveAssertions.assertEquals(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.0=0.0):\n\tActual:\t\t1.0\n\tExpected:\t=0.0", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_float_float() {
		System.out.println("PrimitiveAssertionsFloatTest >>> testAssertNotEquals_float_float");
		float actual=1.0f;
		float expected=0.0f;
		PrimitiveAssertions.assertNotEquals(actual,expected);
		actual=0.0f;
		expected=1.0f;
		PrimitiveAssertions.assertNotEquals(actual,expected);
	}
	@Test
	public void testAssertNotEquals_float_float_failed() {
		System.out.println("PrimitiveAssertionsFloatTest >>> testAssertNotEquals_float_float_failed");
		try{
			float actual=1.0f;
			float expected=1.0f;
			PrimitiveAssertions.assertNotEquals(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.0!=1.0):\n\tActual:\t\t1.0\n\tExpected:\t!=1.0", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_float_float_message() {
		System.out.println("PrimitiveAssertionsFloatTest >>> testAssertNotEquals_float_float_message");
		float actual=0.0f;
		float expected=1.0f;
		PrimitiveAssertions.assertNotEquals(actual,expected,"Message");
		actual=1.0f;
		expected=0.0f;
		PrimitiveAssertions.assertNotEquals(actual,expected);
	}
	@Test
	public void testAssertNotEquals_float_float_message_failed() {
		System.out.println("PrimitiveAssertionsFloatTest >>> testAssertNotEquals_float_float_message_failed");
		try{
			float actual=1.0f;
			float expected=1.0f;
			PrimitiveAssertions.assertNotEquals(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.0!=1.0):\n\tActual:\t\t1.0\n\tExpected:\t!=1.0", e.getMessage());
		}
	}	
	@Test
	public void testIsGreater_float_float() {
		System.out.println("PrimitiveAssertionsFloatTest >>> testIsGreater_float_float");
		float actual=1.0f;
		float expected=0.0f;
		Assert.assertTrue(PrimitiveAssertions.isGreater(actual, expected));
		actual=10.0f;
		expected=1.0f;
		Assert.assertTrue(PrimitiveAssertions.isGreater(actual, expected));
		actual=1.0f;
		expected=1.0f;
		Assert.assertFalse(PrimitiveAssertions.isGreater(actual, expected));
		actual=0.0f;
		expected=1.0f;
		Assert.assertFalse(PrimitiveAssertions.isGreater(actual, expected));
	}
	@Test
	public void testAssertGreater_float_float() {
		System.out.println("PrimitiveAssertionsFloatTest >>> testAssertGreater_float_float");
		float actual=10.0f;
		float expected=1.0f;
		PrimitiveAssertions.assertGreater(actual,expected);
		actual=1.0f;
		expected=0.0f;
		PrimitiveAssertions.assertGreater(actual,expected);
	}
	@Test
	public void testAssertGreater_float_float_failed() {
		System.out.println("PrimitiveAssertionsFloatTest >>> testAssertGreater_float_float_failed");
		try{
			float actual=1.0f;
			float expected=1.0f;
			PrimitiveAssertions.assertGreater(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.0>1.0):\n\tActual:\t\t1.0\n\tExpected:\t>1.0", e.getMessage());
		}
		try{
			float actual=0.0f;
			float expected=1.0f;
			PrimitiveAssertions.assertGreater(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(0.0>1.0):\n\tActual:\t\t0.0\n\tExpected:\t>1.0", e.getMessage());
		}
	}	
	@Test
	public void testAssertGreater_float_float_message() {
		System.out.println("PrimitiveAssertionsFloatTest >>> testAssertGreater_float_float_message");
		float actual=10.0f;
		float expected=1.0f;
		PrimitiveAssertions.assertGreater(actual,expected,"Message");
		actual=1.0f;
		expected=0.0f;
		PrimitiveAssertions.assertGreater(actual,expected,"Message");
	}
	@Test
	public void testAssertGreater_float_float_message_failed() {
		System.out.println("PrimitiveAssertionsFloatTest >>> testAssertGreater_float_float_message_failed");
		try{
			float actual=1.0f;
			float expected=1.0f;
			PrimitiveAssertions.assertGreater(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.0>1.0):\n\tActual:\t\t1.0\n\tExpected:\t>1.0", e.getMessage());
		}
		try{
			float actual=0.0f;
			float expected=1.0f;
			PrimitiveAssertions.assertGreater(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(0.0>1.0):\n\tActual:\t\t0.0\n\tExpected:\t>1.0", e.getMessage());
		}
	}	
	@Test
	public void testIsGreaterOrEqual_float_float() {
		System.out.println("PrimitiveAssertionsFloatTest >>> testIsGreaterOrEqual_float_float");
		float actual=1.0f;
		float expected=0.0f;
		Assert.assertTrue(PrimitiveAssertions.isGreaterOrEqual(actual, expected));
		actual=10.0f;
		expected=1.0f;
		Assert.assertTrue(PrimitiveAssertions.isGreaterOrEqual(actual, expected));
		actual=1.0f;
		expected=1.0f;
		Assert.assertTrue(PrimitiveAssertions.isGreaterOrEqual(actual, expected));
		actual=0.0f;
		expected=1.0f;
		Assert.assertFalse(PrimitiveAssertions.isGreaterOrEqual(actual, expected));
	}
	@Test
	public void testAssertGreaterOrEqual_float_float() {
		System.out.println("PrimitiveAssertionsFloatTest >>> testAssertGreaterOrEqual_float_float");
		float actual=10.0f;
		float expected=1.0f;
		PrimitiveAssertions.assertGreaterOrEqual(actual,expected);
		actual=1.0f;
		expected=1.0f;
		PrimitiveAssertions.assertGreaterOrEqual(actual,expected);
	}
	@Test
	public void testAssertGreaterOrEqual_float_float_failed() {
		System.out.println("PrimitiveAssertionsFloatTest >>> testAssertGreaterOrEqual_float_float_failed");
		try{
			float actual=0.0f;
			float expected=1.0f;
			PrimitiveAssertions.assertGreaterOrEqual(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(0.0>=1.0):\n\tActual:\t\t0.0\n\tExpected:\t>=1.0", e.getMessage());
		}
	}	
	@Test
	public void testAssertGreaterOrEqual_float_float_message() {
		System.out.println("PrimitiveAssertionsFloatTest >>> testAssertGreaterOrEqual_float_float_message");
		float actual=10.0f;
		float expected=1.0f;
		PrimitiveAssertions.assertGreaterOrEqual(actual,expected,"Message");
		actual=1.0f;
		expected=1.0f;
		PrimitiveAssertions.assertGreaterOrEqual(actual,expected,"Message");
	}
	@Test
	public void testAssertGreaterOrEqual_float_float_message_failed() {
		System.out.println("PrimitiveAssertionsFloatTest >>> testAssertGreaterOrEqual_float_float_message_failed");
		try{
			float actual=0.0f;
			float expected=1.0f;
			PrimitiveAssertions.assertGreaterOrEqual(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(0.0>=1.0):\n\tActual:\t\t0.0\n\tExpected:\t>=1.0", e.getMessage());
		}
	}	
	@Test
	public void testAssertSmaller_float_float() {
		System.out.println("PrimitiveAssertionsFloatTest >>> testAssertSmaller_float_float");
		float actual=1.0f;
		float expected=10.0f;
		PrimitiveAssertions.assertSmaller(actual,expected);
		actual=0.0f;
		expected=1.0f;
		PrimitiveAssertions.assertSmaller(actual,expected);
	}
	@Test
	public void testAssertSmaller_float_float_failed() {
		System.out.println("PrimitiveAssertionsFloatTest >>> testAssertSmaller_float_float_failed");
		try{
			float actual=1.0f;
			float expected=1.0f;
			PrimitiveAssertions.assertSmaller(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.0<1.0):\n\tActual:\t\t1.0\n\tExpected:\t<1.0", e.getMessage());
		}
		try{
			float actual=1.0f;
			float expected=0.0f;
			PrimitiveAssertions.assertSmaller(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.0<0.0):\n\tActual:\t\t1.0\n\tExpected:\t<0.0", e.getMessage());
		}
	}	
	@Test
	public void testAssertSmaller_float_float_message() {
		System.out.println("PrimitiveAssertionsFloatTest >>> testAssertSmaller_float_float_message");
		float actual=1.0f;
		float expected=10.0f;
		PrimitiveAssertions.assertSmaller(actual,expected,"Message");
		actual=0.0f;
		expected=1.0f;
		PrimitiveAssertions.assertSmaller(actual,expected,"Message");
	}
	@Test
	public void testAssertSmaller_float_float_message_failed() {
		System.out.println("PrimitiveAssertionsFloatTest >>> testAssertSmaller_float_float_message_failed");
		try{
			float actual=1.0f;
			float expected=1.0f;
			PrimitiveAssertions.assertSmaller(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.0<1.0):\n\tActual:\t\t1.0\n\tExpected:\t<1.0", e.getMessage());
		}
		try{
			float actual=1.0f;
			float expected=0.0f;
			PrimitiveAssertions.assertSmaller(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.0<0.0):\n\tActual:\t\t1.0\n\tExpected:\t<0.0", e.getMessage());
		}
	}	
	@Test
	public void testAssertSmallerOrEqual_float_float() {
		System.out.println("PrimitiveAssertionsFloatTest >>> testAssertSmallerOrEqual_float_float");
		float actual=1.0f;
		float expected=10.0f;
		PrimitiveAssertions.assertSmallerOrEqual(actual,expected);
		actual=1.0f;
		expected=1.0f;
		PrimitiveAssertions.assertSmallerOrEqual(actual,expected);
	}
	@Test
	public void testAssertSmallerOrEqual_float_float_failed() {
		System.out.println("PrimitiveAssertionsFloatTest >>> testAssertSmallerOrEqual_float_float_failed");
		try{
			float actual=1.0f;
			float expected=0.0f;
			PrimitiveAssertions.assertSmallerOrEqual(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.0<=0.0):\n\tActual:\t\t1.0\n\tExpected:\t<=0.0", e.getMessage());
		}
	}	
	@Test
	public void testAssertSmallerOrEqual_float_float_message() {
		System.out.println("PrimitiveAssertionsFloatTest >>> testAssertSmallerOrEqual_float_float_message");
		float actual=1.0f;
		float expected=10.0f;
		PrimitiveAssertions.assertSmallerOrEqual(actual,expected,"Message");
		actual=1.0f;
		expected=1.0f;
		PrimitiveAssertions.assertSmallerOrEqual(actual,expected,"Message");
	}
	@Test
	public void testAssertSmallerOrEqual_float_float_message_failed() {
		System.out.println("PrimitiveAssertionsFloatTest >>> testAssertSmallerOrEqual_float_float_message_failed");
		try{
			float actual=1.0f;
			float expected=0.0f;
			PrimitiveAssertions.assertSmallerOrEqual(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.0<=0.0):\n\tActual:\t\t1.0\n\tExpected:\t<=0.0", e.getMessage());
		}
	}	
}
