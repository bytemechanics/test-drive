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
public class ObjectAssertionsFloatTest {
	
	
	@Test
	public void testIsZero_Float() {
		System.out.println("ObjectAssertionsFloatTest >>> testIsZero_Float");
		Float actual = 0.0f;
		Assert.assertTrue(ObjectAssertions.isZero(actual));
		actual = 2.0f;
		Assert.assertFalse(ObjectAssertions.isZero(actual));
		actual = 10.0f;
		Assert.assertFalse(ObjectAssertions.isZero(actual));
	}
	@Test
	public void testAssertZero_Float() {
		System.out.println("ObjectAssertionsFloatTest >>> testAssertZero_Float");
		Float actual = 0.0f;
		ObjectAssertions.assertZero(actual);
	}
	@Test
	public void testAssertZero_Float_failed() {
		System.out.println("ObjectAssertionsFloatTest >>> testAssertZero_Float_failed");
		try{
			Float actual=1.0f;
			ObjectAssertions.assertZero(actual);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.0=0):\n\tActual:\t\t1.0\n\tExpected:\t=0", e.getMessage());
		}
	}
	@Test
	public void testAssertZero_Float_message() {
		System.out.println("ObjectAssertionsFloatTest >>> testAssertZero_Float_message");
		Float actual = 0.0f;
		ObjectAssertions.assertZero(actual,"Message");
	}
	@Test
	public void testAssertZero_Float_message_failed() {
		System.out.println("ObjectAssertionsFloatTest >>> testAssertZero_Float_message_failed");
		try{
			Float actual=1.0f;
			ObjectAssertions.assertZero(actual,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.0=0):\n\tActual:\t\t1.0\n\tExpected:\t=0", e.getMessage());
		}
	}
	@Test
	public void testIsEqual_Float_Float() {
		System.out.println("ObjectAssertionsFloatTest >>> testIsEqual_Float_Float");
		Float actual=0.0f;
		Float expected=0.0f;
		Assert.assertTrue(ObjectAssertions.isEqual(actual, expected));
		actual=1.0f;
		expected=1.0f;
		Assert.assertTrue(ObjectAssertions.isEqual(actual, expected));
		actual=0.0f;
		expected=1.0f;
		Assert.assertFalse(ObjectAssertions.isEqual(actual, expected));
	}
	@Test
	public void testAssertEquals_Float_Float() {
		System.out.println("ObjectAssertionsFloatTest >>> testAssertEquals_Float_Float");
		Float actual=0.0f;
		Float expected=0.0f;
		ObjectAssertions.assertEquals(actual,expected);
		actual=1.0f;
		expected=1.0f;
		ObjectAssertions.assertEquals(actual,expected);
	}
	@Test
	public void testAssertEquals_Float_Float_failed() {
		System.out.println("ObjectAssertionsFloatTest >>> testAssertEquals_Float_Float_failed");
		try{
			Float actual=1.0f;
			Float expected=0.0f;
			ObjectAssertions.assertEquals(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.0~0.0):\n\tActual:\t\t1.0\n\tExpected:\t~0.0", e.getMessage());
		}
	}
	@Test
	public void testAssertEquals_Float_Float_message() {
		System.out.println("ObjectAssertionsFloatTest >>> testAssertEquals_Float_Float");
		Float actual=0.0f;
		Float expected=0.0f;
		ObjectAssertions.assertEquals(actual,expected,"Message");
		actual=1.0f;
		expected=1.0f;
		ObjectAssertions.assertEquals(actual,expected,"Message");
	}
	@Test
	public void testAssertEquals_Float_Float_message_failed() {
		System.out.println("ObjectAssertionsFloatTest >>> testAssertEquals_Float_Float_failed");
		try{
			Float actual=1.0f;
			Float expected=0.0f;
			ObjectAssertions.assertEquals(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.0~0.0):\n\tActual:\t\t1.0\n\tExpected:\t~0.0", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_Float_Float() {
		System.out.println("ObjectAssertionsFloatTest >>> testAssertNotEquals_Float_Float");
		Float actual=1.0f;
		Float expected=0.0f;
		ObjectAssertions.assertNotEquals(actual,expected);
		actual=0.0f;
		expected=1.0f;
		ObjectAssertions.assertNotEquals(actual,expected);
	}
	@Test
	public void testAssertNotEquals_Float_Float_failed() {
		System.out.println("ObjectAssertionsFloatTest >>> testAssertNotEquals_Float_Float_failed");
		try{
			Float actual=1.0f;
			Float expected=1.0f;
			ObjectAssertions.assertNotEquals(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.0!~1.0):\n\tActual:\t\t1.0\n\tExpected:\t!~1.0", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_Float_Float_message() {
		System.out.println("ObjectAssertionsFloatTest >>> testAssertNotEquals_Float_Float_message");
		Float actual=0.0f;
		Float expected=1.0f;
		ObjectAssertions.assertNotEquals(actual,expected,"Message");
		actual=1.0f;
		expected=0.0f;
		ObjectAssertions.assertNotEquals(actual,expected);
	}
	@Test
	public void testAssertNotEquals_Float_Float_message_failed() {
		System.out.println("ObjectAssertionsFloatTest >>> testAssertNotEquals_Float_Float_message_failed");
		try{
			Float actual=1.0f;
			Float expected=1.0f;
			ObjectAssertions.assertNotEquals(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.0!~1.0):\n\tActual:\t\t1.0\n\tExpected:\t!~1.0", e.getMessage());
		}
	}	
	@Test
	public void testIsGreater_Float_Float() {
		System.out.println("ObjectAssertionsFloatTest >>> testIsGreater_Float_Float");
		Float actual=1.0f;
		Float expected=0.0f;
		Assert.assertTrue(ObjectAssertions.isGreater(actual, expected));
		actual=10.0f;
		expected=1.0f;
		Assert.assertTrue(ObjectAssertions.isGreater(actual, expected));
		actual=1.0f;
		expected=1.0f;
		Assert.assertFalse(ObjectAssertions.isGreater(actual, expected));
		actual=0.0f;
		expected=1.0f;
		Assert.assertFalse(ObjectAssertions.isGreater(actual, expected));
	}
	@Test
	public void testAssertGreater_Float_Float() {
		System.out.println("ObjectAssertionsFloatTest >>> testAssertGreater_Float_Float");
		Float actual=10.0f;
		Float expected=1.0f;
		ObjectAssertions.assertGreater(actual,expected);
		actual=1.0f;
		expected=0.0f;
		ObjectAssertions.assertGreater(actual,expected);
	}
	@Test
	public void testAssertGreater_Float_Float_failed() {
		System.out.println("ObjectAssertionsFloatTest >>> testAssertGreater_Float_Float_failed");
		try{
			Float actual=1.0f;
			Float expected=1.0f;
			ObjectAssertions.assertGreater(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.0>1.0):\n\tActual:\t\t1.0\n\tExpected:\t>1.0", e.getMessage());
		}
		try{
			Float actual=0.0f;
			Float expected=1.0f;
			ObjectAssertions.assertGreater(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(0.0>1.0):\n\tActual:\t\t0.0\n\tExpected:\t>1.0", e.getMessage());
		}
	}	
	@Test
	public void testAssertGreater_Float_Float_message() {
		System.out.println("ObjectAssertionsFloatTest >>> testAssertGreater_Float_Float_message");
		Float actual=10.0f;
		Float expected=1.0f;
		ObjectAssertions.assertGreater(actual,expected,"Message");
		actual=1.0f;
		expected=0.0f;
		ObjectAssertions.assertGreater(actual,expected,"Message");
	}
	@Test
	public void testAssertGreater_Float_Float_message_failed() {
		System.out.println("ObjectAssertionsFloatTest >>> testAssertGreater_Float_Float_message_failed");
		try{
			Float actual=1.0f;
			Float expected=1.0f;
			ObjectAssertions.assertGreater(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.0>1.0):\n\tActual:\t\t1.0\n\tExpected:\t>1.0", e.getMessage());
		}
		try{
			Float actual=0.0f;
			Float expected=1.0f;
			ObjectAssertions.assertGreater(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(0.0>1.0):\n\tActual:\t\t0.0\n\tExpected:\t>1.0", e.getMessage());
		}
	}	
	@Test
	public void testIsGreaterOrEqual_Float_Float() {
		System.out.println("ObjectAssertionsFloatTest >>> testIsGreaterOrEqual_Float_Float");
		Float actual=1.0f;
		Float expected=0.0f;
		Assert.assertTrue(ObjectAssertions.isGreaterOrEqual(actual, expected));
		actual=10.0f;
		expected=1.0f;
		Assert.assertTrue(ObjectAssertions.isGreaterOrEqual(actual, expected));
		actual=1.0f;
		expected=1.0f;
		Assert.assertTrue(ObjectAssertions.isGreaterOrEqual(actual, expected));
		actual=0.0f;
		expected=1.0f;
		Assert.assertFalse(ObjectAssertions.isGreaterOrEqual(actual, expected));
	}
	@Test
	public void testAssertGreaterOrEqual_Float_Float() {
		System.out.println("ObjectAssertionsFloatTest >>> testAssertGreaterOrEqual_Float_Float");
		Float actual=10.0f;
		Float expected=1.0f;
		ObjectAssertions.assertGreaterOrEqual(actual,expected);
		actual=1.0f;
		expected=1.0f;
		ObjectAssertions.assertGreaterOrEqual(actual,expected);
	}
	@Test
	public void testAssertGreaterOrEqual_Float_Float_failed() {
		System.out.println("ObjectAssertionsFloatTest >>> testAssertGreaterOrEqual_Float_Float_failed");
		try{
			Float actual=0.0f;
			Float expected=1.0f;
			ObjectAssertions.assertGreaterOrEqual(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(0.0>=1.0):\n\tActual:\t\t0.0\n\tExpected:\t>=1.0", e.getMessage());
		}
	}	
	@Test
	public void testAssertGreaterOrEqual_Float_Float_message() {
		System.out.println("ObjectAssertionsFloatTest >>> testAssertGreaterOrEqual_Float_Float_message");
		Float actual=10.0f;
		Float expected=1.0f;
		ObjectAssertions.assertGreaterOrEqual(actual,expected,"Message");
		actual=1.0f;
		expected=1.0f;
		ObjectAssertions.assertGreaterOrEqual(actual,expected,"Message");
	}
	@Test
	public void testAssertGreaterOrEqual_Float_Float_message_failed() {
		System.out.println("ObjectAssertionsFloatTest >>> testAssertGreaterOrEqual_Float_Float_message_failed");
		try{
			Float actual=0.0f;
			Float expected=1.0f;
			ObjectAssertions.assertGreaterOrEqual(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(0.0>=1.0):\n\tActual:\t\t0.0\n\tExpected:\t>=1.0", e.getMessage());
		}
	}	
	@Test
	public void testAssertSmaller_Float_Float() {
		System.out.println("ObjectAssertionsFloatTest >>> testAssertSmaller_Float_Float");
		Float actual=1.0f;
		Float expected=10.0f;
		ObjectAssertions.assertSmaller(actual,expected);
		actual=0.0f;
		expected=1.0f;
		ObjectAssertions.assertSmaller(actual,expected);
	}
	@Test
	public void testAssertSmaller_Float_Float_failed() {
		System.out.println("ObjectAssertionsFloatTest >>> testAssertSmaller_Float_Float_failed");
		try{
			Float actual=1.0f;
			Float expected=1.0f;
			ObjectAssertions.assertSmaller(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.0<1.0):\n\tActual:\t\t1.0\n\tExpected:\t<1.0", e.getMessage());
		}
		try{
			Float actual=1.0f;
			Float expected=0.0f;
			ObjectAssertions.assertSmaller(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.0<0.0):\n\tActual:\t\t1.0\n\tExpected:\t<0.0", e.getMessage());
		}
	}	
	@Test
	public void testAssertSmaller_Float_Float_message() {
		System.out.println("ObjectAssertionsFloatTest >>> testAssertSmaller_Float_Float_message");
		Float actual=1.0f;
		Float expected=10.0f;
		ObjectAssertions.assertSmaller(actual,expected,"Message");
		actual=0.0f;
		expected=1.0f;
		ObjectAssertions.assertSmaller(actual,expected,"Message");
	}
	@Test
	public void testAssertSmaller_Float_Float_message_failed() {
		System.out.println("ObjectAssertionsFloatTest >>> testAssertSmaller_Float_Float_message_failed");
		try{
			Float actual=1.0f;
			Float expected=1.0f;
			ObjectAssertions.assertSmaller(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.0<1.0):\n\tActual:\t\t1.0\n\tExpected:\t<1.0", e.getMessage());
		}
		try{
			Float actual=1.0f;
			Float expected=0.0f;
			ObjectAssertions.assertSmaller(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.0<0.0):\n\tActual:\t\t1.0\n\tExpected:\t<0.0", e.getMessage());
		}
	}	
	@Test
	public void testAssertSmallerOrEqual_Float_Float() {
		System.out.println("ObjectAssertionsFloatTest >>> testAssertSmallerOrEqual_Float_Float");
		Float actual=1.0f;
		Float expected=10.0f;
		ObjectAssertions.assertSmallerOrEqual(actual,expected);
		actual=1.0f;
		expected=1.0f;
		ObjectAssertions.assertSmallerOrEqual(actual,expected);
	}
	@Test
	public void testAssertSmallerOrEqual_Float_Float_failed() {
		System.out.println("ObjectAssertionsFloatTest >>> testAssertSmallerOrEqual_Float_Float_failed");
		try{
			Float actual=1.0f;
			Float expected=0.0f;
			ObjectAssertions.assertSmallerOrEqual(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.0<=0.0):\n\tActual:\t\t1.0\n\tExpected:\t<=0.0", e.getMessage());
		}
	}	
	@Test
	public void testAssertSmallerOrEqual_Float_Float_message() {
		System.out.println("ObjectAssertionsFloatTest >>> testAssertSmallerOrEqual_Float_Float_message");
		Float actual=1.0f;
		Float expected=10.0f;
		ObjectAssertions.assertSmallerOrEqual(actual,expected,"Message");
		actual=1.0f;
		expected=1.0f;
		ObjectAssertions.assertSmallerOrEqual(actual,expected,"Message");
	}
	@Test
	public void testAssertSmallerOrEqual_Float_Float_message_failed() {
		System.out.println("ObjectAssertionsFloatTest >>> testAssertSmallerOrEqual_Float_Float_message_failed");
		try{
			Float actual=1.0f;
			Float expected=0.0f;
			ObjectAssertions.assertSmallerOrEqual(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.0<=0.0):\n\tActual:\t\t1.0\n\tExpected:\t<=0.0", e.getMessage());
		}
	}
}
