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
public class ObjectAssertionsBooleanTest {
	
@Test
	public void testIsTrue() {
		System.out.println("ObjectAssertionsBooleanTest >>> testIsTrue");
		Assert.assertTrue(ObjectAssertions.isTrue(Boolean.TRUE));
		Assert.assertFalse(ObjectAssertions.isTrue(Boolean.FALSE));
	}
	@Test
	public void testAssertTrue_boolean() {
		System.out.println("ObjectAssertionsBooleanTest >>> testAssertTrue_boolean");
		ObjectAssertions.assertTrue(Boolean.TRUE);
	}
	@Test()
	public void testAssertTrue_boolean_failed() {
		System.out.println("ObjectAssertionsBooleanTest >>> testAssertTrue_boolean_failed");
		try{
			ObjectAssertions.assertTrue(Boolean.FALSE);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(false~true):\n\tActual:\t\tfalse\n\tExpected:\t~true", e.getMessage());
		}
	}
	@Test
	public void testAssertTrue_boolean_String() {
		System.out.println("ObjectAssertionsBooleanTest >>> testAssertTrue_boolean_String");
		ObjectAssertions.assertTrue(Boolean.TRUE,"message");
	}
	@Test
	public void testAssertTrue_boolean_String_failed() {
		System.out.println("ObjectAssertionsBooleanTest >>> testAssertTrue_boolean_String_failed");
		try{
			ObjectAssertions.assertTrue(Boolean.FALSE,"message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("message(false~true):\n\tActual:\t\tfalse\n\tExpected:\t~true", e.getMessage());
		}
	}
	@Test
	public void testAssertFalse_boolean() {
		System.out.println("ObjectAssertionsBooleanTest >>> testAssertFalse_boolean");
		ObjectAssertions.assertFalse(Boolean.FALSE);
	}
	@Test
	public void testAssertFalse_boolean_failed() {
		System.out.println("ObjectAssertionsBooleanTest >>> testAssertTrue_boolean_failed");
		try{
			ObjectAssertions.assertFalse(Boolean.TRUE);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(true~false):\n\tActual:\t\ttrue\n\tExpected:\t~false", e.getMessage());
		}
	}
	@Test
	public void testAssertFalse_boolean_String() {
		System.out.println("ObjectAssertionsBooleanTest >>> testAssertTrue_boolean_String");
		ObjectAssertions.assertFalse(Boolean.FALSE,"message");
	}
	@Test
	public void testAssertFalse_boolean_String_failed() {
		System.out.println("ObjectAssertionsBooleanTest >>> testAssertTrue_boolean_String_failed");
		try{
			ObjectAssertions.assertFalse(Boolean.TRUE,"message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("message(true~false):\n\tActual:\t\ttrue\n\tExpected:\t~false", e.getMessage());
		}
	}
	@Test
	public void testIsEqual_boolean_boolean() {
		System.out.println("ObjectAssertionsBooleanTest >>> testIsEqual_boolean_boolean");
		Assert.assertTrue(ObjectAssertions.isEquals(Boolean.FALSE,Boolean.FALSE));
		Assert.assertTrue(ObjectAssertions.isEquals(Boolean.TRUE,Boolean.TRUE));
		Assert.assertFalse(ObjectAssertions.isEquals(Boolean.TRUE,Boolean.FALSE));
		Assert.assertFalse(ObjectAssertions.isEquals(Boolean.FALSE,Boolean.TRUE));
	}
	@Test
	public void testAssertEquals_boolean_boolean() {
		System.out.println("ObjectAssertionsBooleanTest >>> testAssertEquals_boolean_boolean");
		ObjectAssertions.assertEquals(Boolean.TRUE,Boolean.TRUE);
		ObjectAssertions.assertEquals(Boolean.FALSE,Boolean.FALSE);
	}
	@Test
	public void testAssertEquals_boolean_boolean_failed() {
		System.out.println("ObjectAssertionsBooleanTest >>> testAssertEquals_boolean_boolean_failed");
		try{
			ObjectAssertions.assertEquals(Boolean.TRUE,Boolean.FALSE);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(true~false):\n\tActual:\t\ttrue\n\tExpected:\t~false", e.getMessage());
		}
		try{
			ObjectAssertions.assertEquals(Boolean.FALSE,Boolean.TRUE);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(false~true):\n\tActual:\t\tfalse\n\tExpected:\t~true", e.getMessage());
		}
	}
	@Test
	public void testAssertEquals_boolean_boolean_message() {
		System.out.println("ObjectAssertionsBooleanTest >>> testAssertEquals_boolean_boolean_message");
		ObjectAssertions.assertEquals(Boolean.TRUE,Boolean.TRUE,"Message");
		ObjectAssertions.assertEquals(Boolean.FALSE,Boolean.FALSE,"Message");
	}
	@Test
	public void testAssertEquals_boolean_boolean_message_failed() {
		System.out.println("ObjectAssertionsBooleanTest >>> testAssertEquals_boolean_boolean_message_failed");
		try{
			ObjectAssertions.assertEquals(Boolean.TRUE,Boolean.FALSE,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(true~false):\n\tActual:\t\ttrue\n\tExpected:\t~false", e.getMessage());
		}
		try{
			ObjectAssertions.assertEquals(Boolean.FALSE,Boolean.TRUE,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(false~true):\n\tActual:\t\tfalse\n\tExpected:\t~true", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_boolean_boolean() {
		System.out.println("ObjectAssertionsBooleanTest >>> testAssertNotEquals_boolean_boolean");
		ObjectAssertions.assertNotEquals(Boolean.FALSE,Boolean.TRUE);
		ObjectAssertions.assertNotEquals(Boolean.TRUE,Boolean.FALSE);
	}
	@Test
	public void testAssertNotEquals_boolean_boolean_failed() {
		System.out.println("ObjectAssertionsBooleanTest >>> testAssertNotEquals_boolean_boolean_failed");
		try{
			ObjectAssertions.assertNotEquals(Boolean.TRUE,Boolean.TRUE);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(true!~true):\n\tActual:\t\ttrue\n\tExpected:\t!~true", e.getMessage());
		}
		try{
			ObjectAssertions.assertNotEquals(Boolean.FALSE,Boolean.FALSE);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(false!~false):\n\tActual:\t\tfalse\n\tExpected:\t!~false", e.getMessage());
		}
	}
	@Test
	public void testAssertNotEquals_boolean_boolean_message() {
		System.out.println("ObjectAssertionsBooleanTest >>> testAssertNotEquals_boolean_boolean_message");
		ObjectAssertions.assertNotEquals(Boolean.FALSE,Boolean.TRUE,"Message");
		ObjectAssertions.assertNotEquals(Boolean.TRUE,Boolean.FALSE,"Message");
	}
	@Test
	public void testAssertNotEquals_boolean_boolean_message_failed() {
		System.out.println("ObjectAssertionsBooleanTest >>> testAssertNotEquals_boolean_boolean_message_failed");
		try{
			ObjectAssertions.assertNotEquals(Boolean.TRUE,Boolean.TRUE,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(true!~true):\n\tActual:\t\ttrue\n\tExpected:\t!~true", e.getMessage());
		}
		try{
			ObjectAssertions.assertNotEquals(Boolean.FALSE,Boolean.FALSE,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(false!~false):\n\tActual:\t\tfalse\n\tExpected:\t!~false", e.getMessage());
		}
	}	
}
