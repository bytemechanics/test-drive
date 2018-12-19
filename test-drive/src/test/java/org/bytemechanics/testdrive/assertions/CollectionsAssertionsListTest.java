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
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.bytemechanics.testdrive.exceptions.AssertException;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author afarre
 */
public class CollectionsAssertionsListTest {
	
	@Test
	public void testListIsEmpty() {
		System.out.println("CollectionsAssertionsListTest >>> testListIsEmpty");
		Assert.assertTrue(CollectionsAssertions.isEmpty((Collection)null));
		Assert.assertFalse(CollectionsAssertions.isEmpty(Stream.of("a","b").collect(Collectors.toSet())));
		Assert.assertFalse(CollectionsAssertions.isEmpty(Stream.of("a").collect(Collectors.toList())));
	}

	@Test
	public void testAssertListEmpty() {
		System.out.println("CollectionsAssertionsListTest >>> testAssertListEmpty");
		CollectionsAssertions.assertEmpty((Collection)null);
		CollectionsAssertions.assertEmpty(Collections.emptyList());
	}
	@Test
	public void testAssertListEmpty_failed() {
		System.out.println("CollectionsAssertionsListTest >>> testAssertListEmpty_failed");
		try{
			CollectionsAssertions.assertEmpty(Stream.of("a").collect(Collectors.toList()));
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(1.size()=0):\n\tActual:\t\t1\n\tExpected:\t.size()=0", e.getMessage());
		}
	}

	@Test
	public void testAssertListEmpty_message() {
		System.out.println("CollectionsAssertionsListTest >>> testAssertListEmpty_message");
		CollectionsAssertions.assertEmpty((Collection)null,"Message");
		CollectionsAssertions.assertEmpty(Collections.emptyList(),"Message");
	}
	@Test
	public void testAssertListEmpty_message_failed() {
		System.out.println("CollectionsAssertionsListTest >>> testAssertListEmpty_message_failed");
		try{
			CollectionsAssertions.assertEmpty(Stream.of("a").collect(Collectors.toList()),"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(1.size()=0):\n\tActual:\t\t1\n\tExpected:\t.size()=0", e.getMessage());
		}
	}

	@Test
	public void testAssertListNotEmpty() {
		System.out.println("CollectionsAssertionsListTest >>> testAssertListNotEmpty");
		CollectionsAssertions.assertNotEmpty(Stream.of("a").collect(Collectors.toList()));
	}
	@Test
	public void testAssertListNotEmpty_failed() {
		System.out.println("CollectionsAssertionsListTest >>> testAssertListNotEmpty_failed");
		try{
			CollectionsAssertions.assertNotEmpty((Collection)null);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(0.size()>0):\n\tActual:\t\t0\n\tExpected:\t.size()>0", e.getMessage());
		}
		try{
			CollectionsAssertions.assertNotEmpty(Collections.emptyList());
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(0.size()>0):\n\tActual:\t\t0\n\tExpected:\t.size()>0", e.getMessage());
		}
	}

	@Test
	public void testAssertListNotEmpty_message() {
		System.out.println("CollectionsAssertionsListTest >>> testAssertListNotEmpty_message");
		CollectionsAssertions.assertNotEmpty(Stream.of("a").collect(Collectors.toList()));
	}
	@Test
	public void testAssertListNotEmpty_message_failed() {
		System.out.println("CollectionsAssertionsListTest >>> testAssertListNotEmpty_message_failed");
		try{
			CollectionsAssertions.assertNotEmpty((Collection)null,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(0.size()>0):\n\tActual:\t\t0\n\tExpected:\t.size()>0", e.getMessage());
		}
		try{
			CollectionsAssertions.assertNotEmpty(Collections.emptyList(),"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(0.size()>0):\n\tActual:\t\t0\n\tExpected:\t.size()>0", e.getMessage());
		}
	}
	
	@Test
	public void testAssertListSame() {
		System.out.println("CollectionsAssertionsListTest >>> testAssertListSame");
		CollectionsAssertions.same((List)null,(List)null);
		CollectionsAssertions.same(Collections.EMPTY_LIST,Collections.EMPTY_LIST);
		List actualList=Stream.of("a","b").collect(Collectors.toList());
		CollectionsAssertions.same(actualList,actualList);
	}
	@Test
	public void testAssertListSame_failed() {
		System.out.println("CollectionsAssertionsListTest >>> testAssertListSame_failed");
		try{
			CollectionsAssertions.same(Stream.of().collect(Collectors.toList()),Stream.of().collect(Collectors.toList()));
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([]==[]):\n\tActual:\t\t[]\n\tExpected:\t==[]", e.getMessage());
		}
		try{
			CollectionsAssertions.same(Stream.of("a","b").collect(Collectors.toList()),Stream.of("a","b").collect(Collectors.toList()));
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([a, b]==[a, b]):\n\tActual:\t\t[a, b]\n\tExpected:\t==[a, b]", e.getMessage());
		}
	}

	@Test
	public void testAssertListSame_message() {
		System.out.println("CollectionsAssertionsListTest >>> testAssertListSame_message");
		CollectionsAssertions.same((List)null,(List)null,"Message");
		CollectionsAssertions.same(Collections.EMPTY_LIST,Collections.EMPTY_LIST,"Message");
		List actualList=Stream.of("a","b").collect(Collectors.toList());
		CollectionsAssertions.same(actualList,actualList,"Message");
	}
	@Test
	public void testAssertListSame_message_failed() {
		System.out.println("CollectionsAssertionsListTest >>> testAssertListSame_message_failed");
		try{
			CollectionsAssertions.same(Stream.of().collect(Collectors.toList()),Stream.of().collect(Collectors.toList()),"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([]==[]):\n\tActual:\t\t[]\n\tExpected:\t==[]", e.getMessage());
		}
		try{
			CollectionsAssertions.same(Stream.of("a","b").collect(Collectors.toList()),Stream.of("a","b").collect(Collectors.toList()),"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([a, b]==[a, b]):\n\tActual:\t\t[a, b]\n\tExpected:\t==[a, b]", e.getMessage());
		}
	}

	@Test
	public void testAssertListNotSame() {
		System.out.println("CollectionsAssertionsListTest >>> testAssertListNotSame");
		CollectionsAssertions.notSame(Stream.of().collect(Collectors.toList()),Stream.of().collect(Collectors.toList()));
		CollectionsAssertions.notSame(Stream.of("a","b").collect(Collectors.toList()),Stream.of("a","b").collect(Collectors.toList()));
	}
	@Test
	public void testAssertListNotSame_failed() {
		System.out.println("CollectionsAssertionsListTest >>> testAssertListNotSame_failed");
		try{
			CollectionsAssertions.notSame((List)null,(List)null);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(null!==null):\n\tActual:\t\tnull\n\tExpected:\t!==null", e.getMessage());
		}
		try{
			CollectionsAssertions.notSame(Collections.EMPTY_LIST,Collections.EMPTY_LIST);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([]!==[]):\n\tActual:\t\t[]\n\tExpected:\t!==[]", e.getMessage());
		}
		try{
			List actualList=Stream.of("a","b").collect(Collectors.toList());
			CollectionsAssertions.notSame(actualList,actualList);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([a, b]!==[a, b]):\n\tActual:\t\t[a, b]\n\tExpected:\t!==[a, b]", e.getMessage());
		}
	}

	@Test
	public void testAssertListNotSame_message() {
		System.out.println("CollectionsAssertionsListTest >>> testAssertListNotSame_message");
		CollectionsAssertions.notSame(Stream.of().collect(Collectors.toList()),Stream.of().collect(Collectors.toList()),"Message");
		CollectionsAssertions.notSame(Stream.of("a","b").collect(Collectors.toList()),Stream.of("a","b").collect(Collectors.toList()),"Message");
	}
	@Test
	public void testAssertListNotSame_message_failed() {
		System.out.println("CollectionsAssertionsListTest >>> testAssertListNotSame_message_failed");
		try{
			CollectionsAssertions.notSame((List)null,(List)null,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(null!==null):\n\tActual:\t\tnull\n\tExpected:\t!==null", e.getMessage());
		}
		try{
			CollectionsAssertions.notSame(Collections.EMPTY_LIST,Collections.EMPTY_LIST,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([]!==[]):\n\tActual:\t\t[]\n\tExpected:\t!==[]", e.getMessage());
		}
		try{
			List actualList=Stream.of("a","b").collect(Collectors.toList());
			CollectionsAssertions.notSame(actualList,actualList,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([a, b]!==[a, b]):\n\tActual:\t\t[a, b]\n\tExpected:\t!==[a, b]", e.getMessage());
		}
	}

	@Test
	public void testAssertListEquals() {
		System.out.println("CollectionsAssertionsListTest >>> testAssertListEquals");
		CollectionsAssertions.assertEquals((List)null,(List)null);
		CollectionsAssertions.assertEquals(Collections.EMPTY_LIST,Collections.EMPTY_LIST);
		CollectionsAssertions.assertEquals(Stream.of("a","b").collect(Collectors.toList()),Stream.of("a","b").collect(Collectors.toList()));
	}
	@Test
	public void testAssertListEquals_failed() {
		System.out.println("CollectionsAssertionsListTest >>> testAssertListEquals_failed");
		try{
			CollectionsAssertions.assertEquals(Collections.EMPTY_LIST,(List)null);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([]~null):\n\tActual:\t\t[]\n\tExpected:\t~null", e.getMessage());
		}
		try{
			CollectionsAssertions.assertEquals(Stream.of("a","b").collect(Collectors.toList()),Stream.of("a","b","c").collect(Collectors.toList()));
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([a, b]~[a, b, c]):\n\tActual:\t\t[a, b]\n\tExpected:\t~[a, b, c]", e.getMessage());
		}
	}

	@Test
	public void testAssertListEquals_message() {
		System.out.println("CollectionsAssertionsListTest >>> testAssertListEquals_message");
		CollectionsAssertions.assertEquals((List)null,(List)null,"Message");
		CollectionsAssertions.assertEquals(Collections.EMPTY_LIST,Collections.EMPTY_LIST,"Message");
		CollectionsAssertions.assertEquals(Stream.of("a","b").collect(Collectors.toList()),Stream.of("a","b").collect(Collectors.toList()),"Message");
	}
	@Test
	public void testAssertListEquals_message_failed() {
		System.out.println("CollectionsAssertionsListTest >>> testAssertListEquals_message_failed");
		try{
			CollectionsAssertions.assertEquals(Collections.EMPTY_LIST,(List)null,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([]~null):\n\tActual:\t\t[]\n\tExpected:\t~null", e.getMessage());
		}
		try{
			CollectionsAssertions.assertEquals(Stream.of("a","b").collect(Collectors.toList()),Stream.of("a","b","c").collect(Collectors.toList()),"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([a, b]~[a, b, c]):\n\tActual:\t\t[a, b]\n\tExpected:\t~[a, b, c]", e.getMessage());
		}
	}

	@Test
	public void testAssertListNotEquals() {
		System.out.println("CollectionsAssertionsListTest >>> testAssertListNotEquals");
		CollectionsAssertions.assertNotEquals(Collections.EMPTY_LIST,(List)null);
		CollectionsAssertions.assertNotEquals(Stream.of("a","b").collect(Collectors.toList()),Stream.of("a","b","c").collect(Collectors.toList()));
	}
	@Test
	public void testAssertListNotEquals_failed() {
		System.out.println("CollectionsAssertionsListTest >>> testAssertListNotEquals_failed");
		try{
			CollectionsAssertions.assertNotEquals((List)null,(List)null);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(null!~null):\n\tActual:\t\tnull\n\tExpected:\t!~null", e.getMessage());
		}
		try{
			CollectionsAssertions.assertNotEquals(Collections.EMPTY_LIST,Collections.EMPTY_LIST);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([]!~[]):\n\tActual:\t\t[]\n\tExpected:\t!~[]", e.getMessage());
		}
		try{
			CollectionsAssertions.assertNotEquals(Stream.of("a","b").collect(Collectors.toList()),Stream.of("a","b").collect(Collectors.toList()));
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed([a, b]!~[a, b]):\n\tActual:\t\t[a, b]\n\tExpected:\t!~[a, b]", e.getMessage());
		}
	}

	@Test
	public void testAssertListNotEquals_message() {
		System.out.println("CollectionsAssertionsListTest >>> testAssertListNotEquals_message");
		CollectionsAssertions.assertNotEquals(Collections.EMPTY_LIST,(List)null,"Message");
		CollectionsAssertions.assertNotEquals(Stream.of("a","b").collect(Collectors.toList()),Stream.of("a","b","c").collect(Collectors.toList()),"Message");
	}
	@Test
	public void testAssertListNotEquals_message_failed() {
		System.out.println("CollectionsAssertionsListTest >>> testAssertListNotEquals_message_failed");
		try{
			CollectionsAssertions.assertNotEquals((List)null,(List)null,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(null!~null):\n\tActual:\t\tnull\n\tExpected:\t!~null", e.getMessage());
		}
		try{
			CollectionsAssertions.assertNotEquals(Collections.EMPTY_LIST,Collections.EMPTY_LIST,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([]!~[]):\n\tActual:\t\t[]\n\tExpected:\t!~[]", e.getMessage());
		}
		try{
			CollectionsAssertions.assertNotEquals(Stream.of("a","b").collect(Collectors.toList()),Stream.of("a","b").collect(Collectors.toList()),"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message([a, b]!~[a, b]):\n\tActual:\t\t[a, b]\n\tExpected:\t!~[a, b]", e.getMessage());
		}
	}
}
