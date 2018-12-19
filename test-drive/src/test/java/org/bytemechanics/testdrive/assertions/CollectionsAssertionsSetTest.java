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

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.bytemechanics.testdrive.exceptions.AssertException;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author afarre
 */
public class CollectionsAssertionsSetTest {
	
	@Test
	public void testSetIsEmpty() {
		System.out.println("CollectionsAssertionsSetTest >>> testSetIsEmpty");
		Assert.assertTrue(CollectionsAssertions.isEmpty((Collection)null));
		Assert.assertTrue(CollectionsAssertions.isEmpty(Collections.emptySet()));
	}

	@Test
	public void testAssertSetEmpty() {
		System.out.println("CollectionsAssertionsSetTest >>> testAssertSetEmpty");
		CollectionsAssertions.assertEmpty((Collection)null);
		CollectionsAssertions.assertEmpty(Collections.emptySet());
	}
	@Test
	public void testAssertSetEmpty_failed() {
		System.out.println("CollectionsAssertionsSetTest >>> testAssertSetEmpty_failed");
		try{
			CollectionsAssertions.assertEmpty(Stream.of("a","b").collect(Collectors.toSet()));
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(2.size()=0):\n\tActual:\t\t2\n\tExpected:\t.size()=0", e.getMessage());
		}
	}

	@Test
	public void testAssertSetEmpty_message() {
		System.out.println("CollectionsAssertionsSetTest >>> testAssertSetEmpty_message");
		CollectionsAssertions.assertEmpty((Collection)null,"Message");
		CollectionsAssertions.assertEmpty(Collections.emptySet(),"Message");
	}
	@Test
	public void testAssertSetEmpty_message_failed() {
		System.out.println("CollectionsAssertionsSetTest >>> testAssertSetEmpty_message_failed");
		try{
			CollectionsAssertions.assertEmpty(Stream.of("a","b").collect(Collectors.toSet()),"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(2.size()=0):\n\tActual:\t\t2\n\tExpected:\t.size()=0", e.getMessage());
		}
	}

	@Test
	public void testAssertSetNotEmpty() {
		System.out.println("CollectionsAssertionsSetTest >>> testAssertSetNotEmpty");
		CollectionsAssertions.assertNotEmpty(Stream.of("a","b").collect(Collectors.toSet()));
	}
	@Test
	public void testAssertSetNotEmpty_failed() {
		System.out.println("CollectionsAssertionsSetTest >>> testAssertSetNotEmpty_failed");
		try{
			CollectionsAssertions.assertNotEmpty((Collection)null);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(0.size()>0):\n\tActual:\t\t0\n\tExpected:\t.size()>0", e.getMessage());
		}
		try{
			CollectionsAssertions.assertNotEmpty(Collections.emptySet());
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(0.size()>0):\n\tActual:\t\t0\n\tExpected:\t.size()>0", e.getMessage());
		}
	}

	@Test
	public void testAssertSetNotEmpty_message() {
		System.out.println("CollectionsAssertionsSetTest >>> testAssertSetNotEmpty_message");
		CollectionsAssertions.assertNotEmpty(Stream.of("a","b").collect(Collectors.toSet()));
	}
	@Test
	public void testAssertSetNotEmpty_message_failed() {
		System.out.println("CollectionsAssertionsSetTest >>> testAssertSetNotEmpty_message_failed");
		try{
			CollectionsAssertions.assertNotEmpty((Collection)null,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(0.size()>0):\n\tActual:\t\t0\n\tExpected:\t.size()>0", e.getMessage());
		}
		try{
			CollectionsAssertions.assertNotEmpty(Collections.emptySet(),"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(0.size()>0):\n\tActual:\t\t0\n\tExpected:\t.size()>0", e.getMessage());
		}
	}
	
	@Test
	public void testAssertSetSame() {
		System.out.println("CollectionsAssertionsSetTest >>> testAssertSetSame");
		CollectionsAssertions.same((Set)null,(Set)null);
		CollectionsAssertions.same(Collections.EMPTY_SET,Collections.EMPTY_SET);
		Set actualSet=Stream.of("a","b").collect(Collectors.toSet());
		CollectionsAssertions.same(actualSet,actualSet);
	}
	@Test
	public void testAssertSetSame_failed() {
		System.out.println("CollectionsAssertionsSetTest >>> testAssertSetSame_failed");
		try{
			CollectionsAssertions.same(Stream.of().collect(Collectors.toSet()),Stream.of().collect(Collectors.toSet()));
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([]==[]):\n\tActual:\t\t[]\n\tExpected:\t==[]", e.getMessage());
		}
		try{
			CollectionsAssertions.same(Stream.of("a","b").collect(Collectors.toSet()),Stream.of("a","b").collect(Collectors.toSet()));
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([a, b]==[a, b]):\n\tActual:\t\t[a, b]\n\tExpected:\t==[a, b]", e.getMessage());
		}
	}

	@Test
	public void testAssertSetSame_message() {
		System.out.println("CollectionsAssertionsSetTest >>> testAssertSetSame_message");
		CollectionsAssertions.same((Set)null,(Set)null,"Message");
		CollectionsAssertions.same(Collections.EMPTY_SET,Collections.EMPTY_SET,"Message");
		Set actualSet=Stream.of("a","b").collect(Collectors.toSet());
		CollectionsAssertions.same(actualSet,actualSet,"Message");
	}
	@Test
	public void testAssertSetSame_message_failed() {
		System.out.println("CollectionsAssertionsSetTest >>> testAssertSetSame_message_failed");
		try{
			CollectionsAssertions.same(Stream.of().collect(Collectors.toSet()),Stream.of().collect(Collectors.toSet()),"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([]==[]):\n\tActual:\t\t[]\n\tExpected:\t==[]", e.getMessage());
		}
		try{
			CollectionsAssertions.same(Stream.of("a","b").collect(Collectors.toSet()),Stream.of("a","b").collect(Collectors.toSet()),"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([a, b]==[a, b]):\n\tActual:\t\t[a, b]\n\tExpected:\t==[a, b]", e.getMessage());
		}
	}

	@Test
	public void testAssertSetNotSame() {
		System.out.println("CollectionsAssertionsSetTest >>> testAssertSetNotSame");
		CollectionsAssertions.notSame(Stream.of().collect(Collectors.toSet()),Stream.of().collect(Collectors.toSet()));
		CollectionsAssertions.notSame(Stream.of("a","b").collect(Collectors.toSet()),Stream.of("a","b").collect(Collectors.toSet()));
	}
	@Test
	public void testAssertSetNotSame_failed() {
		System.out.println("CollectionsAssertionsSetTest >>> testAssertSetNotSame_failed");
		try{
			CollectionsAssertions.notSame((Set)null,(Set)null);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(null!==null):\n\tActual:\t\tnull\n\tExpected:\t!==null", e.getMessage());
		}
		try{
			CollectionsAssertions.notSame(Collections.EMPTY_SET,Collections.EMPTY_SET);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([]!==[]):\n\tActual:\t\t[]\n\tExpected:\t!==[]", e.getMessage());
		}
		try{
			Set actualSet=Stream.of("a","b").collect(Collectors.toSet());
			CollectionsAssertions.notSame(actualSet,actualSet);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([a, b]!==[a, b]):\n\tActual:\t\t[a, b]\n\tExpected:\t!==[a, b]", e.getMessage());
		}
	}

	@Test
	public void testAssertSetNotSame_message() {
		System.out.println("CollectionsAssertionsSetTest >>> testAssertSetNotSame_message");
		CollectionsAssertions.notSame(Stream.of().collect(Collectors.toSet()),Stream.of().collect(Collectors.toSet()),"Message");
		CollectionsAssertions.notSame(Stream.of("a","b").collect(Collectors.toSet()),Stream.of("a","b").collect(Collectors.toSet()),"Message");
	}
	@Test
	public void testAssertSetNotSame_message_failed() {
		System.out.println("CollectionsAssertionsSetTest >>> testAssertSetNotSame_message_failed");
		try{
			CollectionsAssertions.notSame((Set)null,(Set)null,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(null!==null):\n\tActual:\t\tnull\n\tExpected:\t!==null", e.getMessage());
		}
		try{
			CollectionsAssertions.notSame(Collections.EMPTY_SET ,Collections.EMPTY_SET,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([]!==[]):\n\tActual:\t\t[]\n\tExpected:\t!==[]", e.getMessage());
		}
		try{
			Set actualSet=Stream.of("a","b").collect(Collectors.toSet());
			CollectionsAssertions.notSame(actualSet,actualSet,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([a, b]!==[a, b]):\n\tActual:\t\t[a, b]\n\tExpected:\t!==[a, b]", e.getMessage());
		}
	}

	@Test
	public void testAssertSetEquals() {
		System.out.println("CollectionsAssertionsSetTest >>> testAssertSetEquals");
		CollectionsAssertions.assertEquals((Set)null,(Set)null);
		CollectionsAssertions.assertEquals(Collections.EMPTY_SET,Collections.EMPTY_SET);
		CollectionsAssertions.assertEquals(Stream.of("a","b").collect(Collectors.toSet()),Stream.of("a","b").collect(Collectors.toSet()));
	}
	@Test
	public void testAssertSetEquals_failed() {
		System.out.println("CollectionsAssertionsSetTest >>> testAssertSetEquals_failed");
		try{
			CollectionsAssertions.assertEquals((Set)null,Collections.EMPTY_SET);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(null~[]):\n\tActual:\t\tnull\n\tExpected:\t~[]", e.getMessage());
		}
		try{
			CollectionsAssertions.assertEquals(Stream.of("a","b","c").collect(Collectors.toSet()),Stream.of("a","b").collect(Collectors.toSet()));
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([a, b, c]~[a, b]):\n\tActual:\t\t[a, b, c]\n\tExpected:\t~[a, b]", e.getMessage());
		}
	}

	@Test
	public void testAssertSetEquals_message() {
		System.out.println("CollectionsAssertionsSetTest >>> testAssertSetEquals_message");
		CollectionsAssertions.assertEquals((Set)null,(Set)null,"Message");
		CollectionsAssertions.assertEquals(Collections.EMPTY_SET,Collections.EMPTY_SET,"Message");
		CollectionsAssertions.assertEquals(Stream.of("a","b").collect(Collectors.toSet()),Stream.of("a","b").collect(Collectors.toSet()),"Message");
	}
	@Test
	public void testAssertSetEquals_message_failed() {
		System.out.println("CollectionsAssertionsSetTest >>> testAssertSetEquals_message_failed");
		try{
			CollectionsAssertions.assertEquals((Set)null,Collections.EMPTY_SET,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(null~[]):\n\tActual:\t\tnull\n\tExpected:\t~[]", e.getMessage());
		}
		try{
			CollectionsAssertions.assertEquals(Stream.of("a","b","c").collect(Collectors.toSet()),Stream.of("a","b").collect(Collectors.toSet()),"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([a, b, c]~[a, b]):\n\tActual:\t\t[a, b, c]\n\tExpected:\t~[a, b]", e.getMessage());
		}
	}

	@Test
	public void testAssertSetNotEquals() {
		System.out.println("CollectionsAssertionsSetTest >>> testAssertSetNotEquals");
		CollectionsAssertions.assertNotEquals((Set)null,Collections.EMPTY_SET);
		CollectionsAssertions.assertNotEquals(Stream.of("a","b","c").collect(Collectors.toSet()),Stream.of("a","b").collect(Collectors.toSet()));
	}
	@Test
	public void testAssertSetNotEquals_failed() {
		System.out.println("CollectionsAssertionsSetTest >>> testAssertSetNotEquals_failed");
		try{
			CollectionsAssertions.assertNotEquals((Set)null,(Set)null);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(null!~null):\n\tActual:\t\tnull\n\tExpected:\t!~null", e.getMessage());
		}
		try{
			CollectionsAssertions.assertNotEquals(Collections.EMPTY_SET,Collections.EMPTY_SET);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([]!~[]):\n\tActual:\t\t[]\n\tExpected:\t!~[]", e.getMessage());
		}
		try{
			CollectionsAssertions.assertNotEquals(Stream.of("a","b").collect(Collectors.toSet()),Stream.of("a","b").collect(Collectors.toSet()));
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([a, b]!~[a, b]):\n\tActual:\t\t[a, b]\n\tExpected:\t!~[a, b]", e.getMessage());
		}
	}

	@Test
	public void testAssertSetNotEquals_message() {
		System.out.println("CollectionsAssertionsSetTest >>> testAssertSetNotEquals_message");
		CollectionsAssertions.assertNotEquals((Set)null,Collections.EMPTY_SET,"Message");
		CollectionsAssertions.assertNotEquals(Stream.of("a","b","c").collect(Collectors.toSet()),Stream.of("a","b").collect(Collectors.toSet()),"Message");
	}
	@Test
	public void testAssertSetNotEquals_message_failed() {
		System.out.println("CollectionsAssertionsSetTest >>> testAssertSetNotEquals_message_failed");
		try{
			CollectionsAssertions.assertNotEquals((Set)null,(Set)null,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(null!~null):\n\tActual:\t\tnull\n\tExpected:\t!~null", e.getMessage());
		}
		try{
			CollectionsAssertions.assertNotEquals(Collections.EMPTY_SET,Collections.EMPTY_SET,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([]!~[]):\n\tActual:\t\t[]\n\tExpected:\t!~[]", e.getMessage());
		}
		try{
			CollectionsAssertions.assertNotEquals(Stream.of("a","b").collect(Collectors.toSet()),Stream.of("a","b").collect(Collectors.toSet()),"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([a, b]!~[a, b]):\n\tActual:\t\t[a, b]\n\tExpected:\t!~[a, b]", e.getMessage());
		}
	}
}
