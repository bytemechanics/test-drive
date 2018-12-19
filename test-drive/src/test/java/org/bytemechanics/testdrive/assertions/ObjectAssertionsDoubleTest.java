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
public class ObjectAssertionsDoubleTest {
	
	
	@Test
	public void testIsZero_Double() {
		System.out.println("ObjectAssertionsDoubleTest >>> testIsZero_Double");
		Double actual = 0.0d;
		Assert.assertTrue(ObjectAssertions.zero(actual));
		actual = 2.0d;
		Assert.assertFalse(ObjectAssertions.zero(actual));
		actual = 10.0d;
		Assert.assertFalse(ObjectAssertions.zero(actual));
	}
	@Test
	public void testAssertZero_Double() {
		System.out.println("ObjectAssertionsDoubleTest >>> testAssertZero_Double");
		Double actual = 0.0d;
		ObjectAssertions.assertZero(actual);
	}
	@Test
	public void testAssertZero_Double_failed() {
		System.out.println("ObjectAssertionsDoubleTest >>> testAssertZero_Double_failed");
		try{
			Double actual=1.0d;
			ObjectAssertions.assertZero(actual);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.0=0):\n\tActual:\t\t1.0\n\tExpected:\t=0", e.getMessage());
		}
	}
	@Test
	public void testAssertZero_Double_message() {
		System.out.println("ObjectAssertionsDoubleTest >>> testAssertZero_Double_message");
		Double actual = 0.0d;
		ObjectAssertions.assertZero(actual,"Message");
	}
	@Test
	public void testAssertZero_Double_message_failed() {
		System.out.println("ObjectAssertionsDoubleTest >>> testAssertZero_Double_message_failed");
		try{
			Double actual=1.0d;
			ObjectAssertions.assertZero(actual,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.0=0):\n\tActual:\t\t1.0\n\tExpected:\t=0", e.getMessage());
		}
	}
	@Test
	public void testIsEqual_Double_Double() {
		System.out.println("ObjectAssertionsDoubleTest >>> testIsEqual_Double_Double");
		Double actual=0.0d;
		Double expected=0.0d;
		Assert.assertTrue(ObjectAssertions.equals(actual, expected));
		actual=1.0d;
		expected=1.0d;
		Assert.assertTrue(ObjectAssertions.equals(actual, expected));
		actual=0.0d;
		expected=1.0d;
		Assert.assertFalse(ObjectAssertions.equals(actual, expected));
	}
	@Test
	public void testAssertEquals_Double_Double() {
		System.out.println("ObjectAssertionsDoubleTest >>> testAssertEquals_Double_Double");
		Double actual=0.0d;
		Double expected=0.0d;
		ObjectAssertions.assertEquals(actual,expected);
		actual=1.0d;
		expected=1.0d;
		ObjectAssertions.assertEquals(actual,expected);
	}
	@Test
	public void testAssertEquals_Double_Double_failed() {
		System.out.println("ObjectAssertionsDoubleTest >>> testAssertEquals_Double_Double_failed");
		try{
			Double actual=1.0d;
			Double expected=0.0d;
			ObjectAssertions.assertEquals(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.0~0.0):\n\tActual:\t\t1.0\n\tExpected:\t~0.0", e.getMessage());
		}
	}
	@Test
	public void testAssertEquals_Double_Double_message() {
		System.out.println("ObjectAssertionsDoubleTest >>> testAssertEquals_Double_Double");
		Double actual=0.0d;
		Double expected=0.0d;
		ObjectAssertions.assertEquals(actual,expected,"Message");
		actual=1.0d;
		expected=1.0d;
		ObjectAssertions.assertEquals(actual,expected,"Message");
	}
	@Test
	public void testAssertEquals_Double_Double_message_failed() {
		System.out.println("ObjectAssertionsDoubleTest >>> testAssertEquals_Double_Double_failed");
		try{
			Double actual=1.0d;
			Double expected=0.0d;
			ObjectAssertions.assertEquals(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.0~0.0):\n\tActual:\t\t1.0\n\tExpected:\t~0.0", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_Double_Double() {
		System.out.println("ObjectAssertionsDoubleTest >>> testAssertNotEquals_Double_Double");
		Double actual=1.0d;
		Double expected=0.0d;
		ObjectAssertions.assertNotEquals(actual,expected);
		actual=0.0d;
		expected=1.0d;
		ObjectAssertions.assertNotEquals(actual,expected);
	}
	@Test
	public void testAssertNotEquals_Double_Double_failed() {
		System.out.println("ObjectAssertionsDoubleTest >>> testAssertNotEquals_Double_Double_failed");
		try{
			Double actual=1.0d;
			Double expected=1.0d;
			ObjectAssertions.assertNotEquals(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.0!~1.0):\n\tActual:\t\t1.0\n\tExpected:\t!~1.0", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_Double_Double_message() {
		System.out.println("ObjectAssertionsDoubleTest >>> testAssertNotEquals_Double_Double_message");
		Double actual=0.0d;
		Double expected=1.0d;
		ObjectAssertions.assertNotEquals(actual,expected,"Message");
		actual=1.0d;
		expected=0.0d;
		ObjectAssertions.assertNotEquals(actual,expected);
	}
	@Test
	public void testAssertNotEquals_Double_Double_message_failed() {
		System.out.println("ObjectAssertionsDoubleTest >>> testAssertNotEquals_Double_Double_message_failed");
		try{
			Double actual=1.0d;
			Double expected=1.0d;
			ObjectAssertions.assertNotEquals(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.0!~1.0):\n\tActual:\t\t1.0\n\tExpected:\t!~1.0", e.getMessage());
		}
	}	
	@Test
	public void testIsGreater_Double_Double() {
		System.out.println("ObjectAssertionsDoubleTest >>> testIsGreater_Double_Double");
		Double actual=1.0d;
		Double expected=0.0d;
		Assert.assertTrue(ObjectAssertions.greater(actual, expected));
		actual=10.0d;
		expected=1.0d;
		Assert.assertTrue(ObjectAssertions.greater(actual, expected));
		actual=1.0d;
		expected=1.0d;
		Assert.assertFalse(ObjectAssertions.greater(actual, expected));
		actual=0.0d;
		expected=1.0d;
		Assert.assertFalse(ObjectAssertions.greater(actual, expected));
	}
	@Test
	public void testAssertGreater_Double_Double() {
		System.out.println("ObjectAssertionsDoubleTest >>> testAssertGreater_Double_Double");
		Double actual=10.0d;
		Double expected=1.0d;
		ObjectAssertions.assertGreater(actual,expected);
		actual=1.0d;
		expected=0.0d;
		ObjectAssertions.assertGreater(actual,expected);
	}
	@Test
	public void testAssertGreater_Double_Double_failed() {
		System.out.println("ObjectAssertionsDoubleTest >>> testAssertGreater_Double_Double_failed");
		try{
			Double actual=1.0d;
			Double expected=1.0d;
			ObjectAssertions.assertGreater(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.0>1.0):\n\tActual:\t\t1.0\n\tExpected:\t>1.0", e.getMessage());
		}
		try{
			Double actual=0.0d;
			Double expected=1.0d;
			ObjectAssertions.assertGreater(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(0.0>1.0):\n\tActual:\t\t0.0\n\tExpected:\t>1.0", e.getMessage());
		}
	}	
	@Test
	public void testAssertGreater_Double_Double_message() {
		System.out.println("ObjectAssertionsDoubleTest >>> testAssertGreater_Double_Double_message");
		Double actual=10.0d;
		Double expected=1.0d;
		ObjectAssertions.assertGreater(actual,expected,"Message");
		actual=1.0d;
		expected=0.0d;
		ObjectAssertions.assertGreater(actual,expected,"Message");
	}
	@Test
	public void testAssertGreater_Double_Double_message_failed() {
		System.out.println("ObjectAssertionsDoubleTest >>> testAssertGreater_Double_Double_message_failed");
		try{
			Double actual=1.0d;
			Double expected=1.0d;
			ObjectAssertions.assertGreater(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.0>1.0):\n\tActual:\t\t1.0\n\tExpected:\t>1.0", e.getMessage());
		}
		try{
			Double actual=0.0d;
			Double expected=1.0d;
			ObjectAssertions.assertGreater(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(0.0>1.0):\n\tActual:\t\t0.0\n\tExpected:\t>1.0", e.getMessage());
		}
	}	
	@Test
	public void testIsGreaterOrEqual_Double_Double() {
		System.out.println("ObjectAssertionsDoubleTest >>> testIsGreaterOrEqual_Double_Double");
		Double actual=1.0d;
		Double expected=0.0d;
		Assert.assertTrue(ObjectAssertions.greaterOrEqual(actual, expected));
		actual=10.0d;
		expected=1.0d;
		Assert.assertTrue(ObjectAssertions.greaterOrEqual(actual, expected));
		actual=1.0d;
		expected=1.0d;
		Assert.assertTrue(ObjectAssertions.greaterOrEqual(actual, expected));
		actual=0.0d;
		expected=1.0d;
		Assert.assertFalse(ObjectAssertions.greaterOrEqual(actual, expected));
	}
	@Test
	public void testAssertGreaterOrEqual_Double_Double() {
		System.out.println("ObjectAssertionsDoubleTest >>> testAssertGreaterOrEqual_Double_Double");
		Double actual=10.0d;
		Double expected=1.0d;
		ObjectAssertions.assertGreaterOrEqual(actual,expected);
		actual=1.0d;
		expected=1.0d;
		ObjectAssertions.assertGreaterOrEqual(actual,expected);
	}
	@Test
	public void testAssertGreaterOrEqual_Double_Double_failed() {
		System.out.println("ObjectAssertionsDoubleTest >>> testAssertGreaterOrEqual_Double_Double_failed");
		try{
			Double actual=0.0d;
			Double expected=1.0d;
			ObjectAssertions.assertGreaterOrEqual(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(0.0>=1.0):\n\tActual:\t\t0.0\n\tExpected:\t>=1.0", e.getMessage());
		}
	}	
	@Test
	public void testAssertGreaterOrEqual_Double_Double_message() {
		System.out.println("ObjectAssertionsDoubleTest >>> testAssertGreaterOrEqual_Double_Double_message");
		Double actual=10.0d;
		Double expected=1.0d;
		ObjectAssertions.assertGreaterOrEqual(actual,expected,"Message");
		actual=1.0d;
		expected=1.0d;
		ObjectAssertions.assertGreaterOrEqual(actual,expected,"Message");
	}
	@Test
	public void testAssertGreaterOrEqual_Double_Double_message_failed() {
		System.out.println("ObjectAssertionsDoubleTest >>> testAssertGreaterOrEqual_Double_Double_message_failed");
		try{
			Double actual=0.0d;
			Double expected=1.0d;
			ObjectAssertions.assertGreaterOrEqual(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(0.0>=1.0):\n\tActual:\t\t0.0\n\tExpected:\t>=1.0", e.getMessage());
		}
	}	
	@Test
	public void testAssertSmaller_Double_Double() {
		System.out.println("ObjectAssertionsDoubleTest >>> testAssertSmaller_Double_Double");
		Double actual=1.0d;
		Double expected=10.0d;
		ObjectAssertions.assertSmaller(actual,expected);
		actual=0.0d;
		expected=1.0d;
		ObjectAssertions.assertSmaller(actual,expected);
	}
	@Test
	public void testAssertSmaller_Double_Double_failed() {
		System.out.println("ObjectAssertionsDoubleTest >>> testAssertSmaller_Double_Double_failed");
		try{
			Double actual=1.0d;
			Double expected=1.0d;
			ObjectAssertions.assertSmaller(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.0<1.0):\n\tActual:\t\t1.0\n\tExpected:\t<1.0", e.getMessage());
		}
		try{
			Double actual=1.0d;
			Double expected=0.0d;
			ObjectAssertions.assertSmaller(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.0<0.0):\n\tActual:\t\t1.0\n\tExpected:\t<0.0", e.getMessage());
		}
	}	
	@Test
	public void testAssertSmaller_Double_Double_message() {
		System.out.println("ObjectAssertionsDoubleTest >>> testAssertSmaller_Double_Double_message");
		Double actual=1.0d;
		Double expected=10.0d;
		ObjectAssertions.assertSmaller(actual,expected,"Message");
		actual=0.0d;
		expected=1.0d;
		ObjectAssertions.assertSmaller(actual,expected,"Message");
	}
	@Test
	public void testAssertSmaller_Double_Double_message_failed() {
		System.out.println("ObjectAssertionsDoubleTest >>> testAssertSmaller_Double_Double_message_failed");
		try{
			Double actual=1.0d;
			Double expected=1.0d;
			ObjectAssertions.assertSmaller(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.0<1.0):\n\tActual:\t\t1.0\n\tExpected:\t<1.0", e.getMessage());
		}
		try{
			Double actual=1.0d;
			Double expected=0.0d;
			ObjectAssertions.assertSmaller(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.0<0.0):\n\tActual:\t\t1.0\n\tExpected:\t<0.0", e.getMessage());
		}
	}	
	@Test
	public void testAssertSmallerOrEqual_Double_Double() {
		System.out.println("ObjectAssertionsDoubleTest >>> testAssertSmallerOrEqual_Double_Double");
		Double actual=1.0d;
		Double expected=10.0d;
		ObjectAssertions.assertSmallerOrEqual(actual,expected);
		actual=1.0d;
		expected=1.0d;
		ObjectAssertions.assertSmallerOrEqual(actual,expected);
	}
	@Test
	public void testAssertSmallerOrEqual_Double_Double_failed() {
		System.out.println("ObjectAssertionsDoubleTest >>> testAssertSmallerOrEqual_Double_Double_failed");
		try{
			Double actual=1.0d;
			Double expected=0.0d;
			ObjectAssertions.assertSmallerOrEqual(actual,expected);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.0<=0.0):\n\tActual:\t\t1.0\n\tExpected:\t<=0.0", e.getMessage());
		}
	}	
	@Test
	public void testAssertSmallerOrEqual_Double_Double_message() {
		System.out.println("ObjectAssertionsDoubleTest >>> testAssertSmallerOrEqual_Double_Double_message");
		Double actual=1.0d;
		Double expected=10.0d;
		ObjectAssertions.assertSmallerOrEqual(actual,expected,"Message");
		actual=1.0d;
		expected=1.0d;
		ObjectAssertions.assertSmallerOrEqual(actual,expected,"Message");
	}
	@Test
	public void testAssertSmallerOrEqual_Double_Double_message_failed() {
		System.out.println("ObjectAssertionsDoubleTest >>> testAssertSmallerOrEqual_Double_Double_message_failed");
		try{
			Double actual=1.0d;
			Double expected=0.0d;
			ObjectAssertions.assertSmallerOrEqual(actual,expected,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.0<=0.0):\n\tActual:\t\t1.0\n\tExpected:\t<=0.0", e.getMessage());
		}
	}
}
