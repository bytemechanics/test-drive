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
public class PrimitiveAssertionsBooleanTest {
	
	@Test
	public void testIsTrue() {
		System.out.println("PrimitiveAssertionsTest >>> testIsTrue");
		Assert.assertTrue(PrimitiveAssertions.isTrue(true));
		Assert.assertFalse(PrimitiveAssertions.isTrue(false));
	}
	@Test
	public void testAssertTrue_boolean() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertTrue_boolean");
		PrimitiveAssertions.assertTrue(true);
	}
	@Test()
	public void testAssertTrue_boolean_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertTrue_boolean_failed");
		try{
			PrimitiveAssertions.assertTrue(false);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(false=true):\n\tActual:\t\tfalse\n\tExpected:\t=true", e.getMessage());
		}
	}
	@Test
	public void testAssertTrue_boolean_String() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertTrue_boolean_String");
		PrimitiveAssertions.assertTrue(true,"message");
	}
	@Test
	public void testAssertTrue_boolean_String_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertTrue_boolean_String_failed");
		try{
			PrimitiveAssertions.assertTrue(false,"message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("message(false=true):\n\tActual:\t\tfalse\n\tExpected:\t=true", e.getMessage());
		}
	}
	@Test
	public void testAssertFalse_boolean() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertFalse_boolean");
		PrimitiveAssertions.assertFalse(false);
	}
	@Test
	public void testAssertFalse_boolean_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertTrue_boolean_failed");
		try{
			PrimitiveAssertions.assertFalse(true);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(true=false):\n\tActual:\t\ttrue\n\tExpected:\t=false", e.getMessage());
		}
	}
	@Test
	public void testAssertFalse_boolean_String() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertTrue_boolean_String");
		PrimitiveAssertions.assertFalse(false,"message");
	}
	@Test
	public void testAssertFalse_boolean_String_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertTrue_boolean_String_failed");
		try{
			PrimitiveAssertions.assertFalse(true,"message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("message(true=false):\n\tActual:\t\ttrue\n\tExpected:\t=false", e.getMessage());
		}
	}
	@Test
	public void testIsEqual_boolean_boolean() {
		System.out.println("PrimitiveAssertionsTest >>> testIsEqual_boolean_boolean");
		Assert.assertTrue(PrimitiveAssertions.isEqual(false, false));
		Assert.assertTrue(PrimitiveAssertions.isEqual(true, true));
		Assert.assertFalse(PrimitiveAssertions.isEqual(true, false));
		Assert.assertFalse(PrimitiveAssertions.isEqual(false, true));
	}
	@Test
	public void testAssertEquals_boolean_boolean() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertEquals_boolean_boolean");
		PrimitiveAssertions.assertEquals(true, true);
		PrimitiveAssertions.assertEquals(false, false);
	}
	@Test
	public void testAssertEquals_boolean_boolean_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertEquals_boolean_boolean_failed");
		try{
			PrimitiveAssertions.assertEquals(true, false);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(true=false):\n\tActual:\t\ttrue\n\tExpected:\t=false", e.getMessage());
		}
		try{
			PrimitiveAssertions.assertEquals(false,true);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(false=true):\n\tActual:\t\tfalse\n\tExpected:\t=true", e.getMessage());
		}
	}
	@Test
	public void testAssertEquals_boolean_boolean_message() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertEquals_boolean_boolean_message");
		PrimitiveAssertions.assertEquals(true, true,"Message");
		PrimitiveAssertions.assertEquals(false, false,"Message");
	}
	@Test
	public void testAssertEquals_boolean_boolean_message_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertEquals_boolean_boolean_message_failed");
		try{
			PrimitiveAssertions.assertEquals(true, false,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(true=false):\n\tActual:\t\ttrue\n\tExpected:\t=false", e.getMessage());
		}
		try{
			PrimitiveAssertions.assertEquals(false,true,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(false=true):\n\tActual:\t\tfalse\n\tExpected:\t=true", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_boolean_boolean() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertNotEquals_boolean_boolean");
		PrimitiveAssertions.assertNotEquals(false, true);
		PrimitiveAssertions.assertNotEquals(true, false);
	}
	@Test
	public void testAssertNotEquals_boolean_boolean_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertNotEquals_boolean_boolean_failed");
		try{
			PrimitiveAssertions.assertNotEquals(true, true);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(true!=true):\n\tActual:\t\ttrue\n\tExpected:\t!=true", e.getMessage());
		}
		try{
			PrimitiveAssertions.assertNotEquals(false,false);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(false!=false):\n\tActual:\t\tfalse\n\tExpected:\t!=false", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_boolean_boolean_message() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertNotEquals_boolean_boolean_message");
		PrimitiveAssertions.assertNotEquals(false, true,"Message");
		PrimitiveAssertions.assertNotEquals(true, false,"Message");
	}
	@Test
	public void testAssertNotEquals_boolean_boolean_message_failed() {
		System.out.println("PrimitiveAssertionsTest >>> testAssertNotEquals_boolean_boolean_message_failed");
		try{
			PrimitiveAssertions.assertNotEquals(true, true,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(true!=true):\n\tActual:\t\ttrue\n\tExpected:\t!=true", e.getMessage());
		}
		try{
			PrimitiveAssertions.assertNotEquals(false,false,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(false!=false):\n\tActual:\t\tfalse\n\tExpected:\t!=false", e.getMessage());
		}
	}
}
