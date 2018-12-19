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

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.bytemechanics.testdrive.exceptions.AssertException;
import org.bytemechanics.testdrive.internal.commons.functional.Tuple;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author afarre
 */
public class CollectionsAssertionsMapTest {
	
	@Test
	public void testMapIsEmpty() {
		System.out.println("CollectionsAssertionsMapTest >>> testMapIsEmpty");
		Assert.assertTrue(CollectionsAssertions.isEmpty((Map)null));
		Assert.assertTrue(CollectionsAssertions.isEmpty(Collections.emptyMap()));
		Assert.assertFalse(CollectionsAssertions.isEmpty(Stream.of(Tuple.of("key1", "value1"),Tuple.of("key2", "value2")).collect(Collectors.toMap(Tuple::left,Tuple::right))));
	}

	@Test
	public void testAssertMapEmpty() {
		System.out.println("CollectionsAssertionsMapTest >>> testAssertMapEmpty");
		CollectionsAssertions.assertEmpty((Map)null);
		CollectionsAssertions.assertEmpty(Collections.emptyMap());
	}
	@Test
	public void testAssertMapEmpty_failed() {
		System.out.println("CollectionsAssertionsMapTest >>> testAssertMapEmpty_failed");
		try{
			CollectionsAssertions.assertEmpty(Stream.of(Tuple.of("key1", "value1"),Tuple.of("key2", "value2")).collect(Collectors.toMap(Tuple::left,Tuple::right)));
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(2.size()=0):\n\tActual:\t\t2\n\tExpected:\t.size()=0", e.getMessage());
		}
	}

	@Test
	public void testAssertMapEmpty_message() {
		System.out.println("CollectionsAssertionsMapTest >>> testAssertMapEmpty_message");
		CollectionsAssertions.assertEmpty((Map)null,"Message");
		CollectionsAssertions.assertEmpty(Collections.emptyMap(),"Message");
	}
	@Test
	public void testAssertMapEmpty_message_failed() {
		System.out.println("CollectionsAssertionsMapTest >>> testAssertMapEmpty_message_failed");
		try{
			CollectionsAssertions.assertEmpty(Stream.of(Tuple.of("key1", "value1"),Tuple.of("key2", "value2")).collect(Collectors.toMap(Tuple::left,Tuple::right)),"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(2.size()=0):\n\tActual:\t\t2\n\tExpected:\t.size()=0", e.getMessage());
		}
	}

	@Test
	public void testAssertMapNotEmpty() {
		System.out.println("CollectionsAssertionsMapTest >>> testAssertMapNotEmpty");
		CollectionsAssertions.assertNotEmpty(Stream.of(Tuple.of("key1", "value1"),Tuple.of("key2", "value2")).collect(Collectors.toMap(Tuple::left,Tuple::right)));
	}
	@Test
	public void testAssertMapNotEmpty_failed() {
		System.out.println("CollectionsAssertionsMapTest >>> testAssertMapNotEmpty_failed");
		try{
			CollectionsAssertions.assertNotEmpty((Map)null);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(0.size()>0):\n\tActual:\t\t0\n\tExpected:\t.size()>0", e.getMessage());
		}
		try{
			CollectionsAssertions.assertNotEmpty(Collections.emptyMap());
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(0.size()>0):\n\tActual:\t\t0\n\tExpected:\t.size()>0", e.getMessage());
		}
	}

	@Test
	public void testAssertMapNotEmpty_message() {
		System.out.println("CollectionsAssertionsMapTest >>> testAssertMapNotEmpty_message");
		CollectionsAssertions.assertNotEmpty(Stream.of(Tuple.of("key1", "value1"),Tuple.of("key2", "value2")).collect(Collectors.toMap(Tuple::left,Tuple::right)));
	}
	@Test
	public void testAssertMapNotEmpty_message_failed() {
		System.out.println("CollectionsAssertionsMapTest >>> testAssertMapNotEmpty_message_failed");
		try{
			CollectionsAssertions.assertNotEmpty((Map)null,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(0.size()>0):\n\tActual:\t\t0\n\tExpected:\t.size()>0", e.getMessage());
		}
		try{
			CollectionsAssertions.assertNotEmpty(Collections.emptyMap(),"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(0.size()>0):\n\tActual:\t\t0\n\tExpected:\t.size()>0", e.getMessage());
		}
	}
	
	@Test
	public void testAssertMapSame() {
		System.out.println("CollectionsAssertionsMapTest >>> testAssertMapSame");
		CollectionsAssertions.same((Map)null,(Map)null);
		CollectionsAssertions.same(Collections.EMPTY_MAP,Collections.EMPTY_MAP);
		Map<String,String> actualSet=Stream.of(Tuple.of("key1", "value1"),Tuple.of("key2", "value2")).collect(Collectors.toMap(Tuple::left,Tuple::right));
		CollectionsAssertions.same(actualSet,actualSet);
	}
	@Test
	public void testAssertMapSame_failed() {
		System.out.println("CollectionsAssertionsMapTest >>> testAssertMapSame_failed");
		try{
			CollectionsAssertions.same(new HashMap(),new HashMap());
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed({}=={}):\n\tActual:\t\t{}\n\tExpected:\t=={}", e.getMessage());
		}
		try{
			CollectionsAssertions.same(Stream.of(Tuple.of("key1", "value1"),Tuple.of("key2", "value2")).collect(Collectors.toMap(Tuple::left,Tuple::right)),Stream.of(Tuple.of("key1", "value1"),Tuple.of("key2", "value2")).collect(Collectors.toMap(Tuple::left,Tuple::right)));
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed({key1=value1, key2=value2}=={key1=value1, key2=value2}):\n\tActual:\t\t{key1=value1, key2=value2}\n\tExpected:\t=={key1=value1, key2=value2}", e.getMessage());
		}
	}

	@Test
	public void testAssertMapSame_message() {
		System.out.println("CollectionsAssertionsMapTest >>> testAssertMapSame_message");
		CollectionsAssertions.same((Map)null,(Map)null,"Message");
		CollectionsAssertions.same(Collections.EMPTY_MAP,Collections.EMPTY_MAP,"Message");
		Map<String,String> actualSet=Stream.of(Tuple.of("key1", "value1"),Tuple.of("key2", "value2")).collect(Collectors.toMap(Tuple::left,Tuple::right));
		CollectionsAssertions.same(actualSet,actualSet,"Message");
	}
	@Test
	public void testAssertMapSame_message_failed() {
		System.out.println("CollectionsAssertionsMapTest >>> testAssertMapSame_message_failed");
		try{
			CollectionsAssertions.same(new HashMap(),new HashMap(),"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message({}=={}):\n\tActual:\t\t{}\n\tExpected:\t=={}", e.getMessage());
		}
		try{
			CollectionsAssertions.same(Stream.of(Tuple.of("key1", "value1"),Tuple.of("key2", "value2")).collect(Collectors.toMap(Tuple::left,Tuple::right)),Stream.of(Tuple.of("key1", "value1"),Tuple.of("key2", "value2")).collect(Collectors.toMap(Tuple::left,Tuple::right)),"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message({key1=value1, key2=value2}=={key1=value1, key2=value2}):\n\tActual:\t\t{key1=value1, key2=value2}\n\tExpected:\t=={key1=value1, key2=value2}", e.getMessage());
		}
	}

	@Test
	public void testAssertMapNotSame() {
		System.out.println("CollectionsAssertionsMapTest >>> testAssertMapNotSame");
		CollectionsAssertions.notSame(Stream.of().collect(Collectors.toSet()),Stream.of().collect(Collectors.toSet()));
		CollectionsAssertions.notSame(Stream.of(Tuple.of("key1", "value1"),Tuple.of("key2", "value2")).collect(Collectors.toMap(Tuple::left,Tuple::right)),Stream.of(Tuple.of("key1", "value1"),Tuple.of("key2", "value2")).collect(Collectors.toMap(Tuple::left,Tuple::right)));
	}
	@Test
	public void testAssertMapNotSame_failed() {
		System.out.println("CollectionsAssertionsMapTest >>> testAssertMapNotSame_failed");
		try{
			CollectionsAssertions.notSame((Map)null,(Map)null);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(null!==null):\n\tActual:\t\tnull\n\tExpected:\t!==null", e.getMessage());
		}
		try{
			CollectionsAssertions.notSame(Collections.EMPTY_MAP,Collections.EMPTY_MAP);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed({}!=={}):\n\tActual:\t\t{}\n\tExpected:\t!=={}", e.getMessage());
		}
		try{
			Map<String,String> actualSet=Stream.of(Tuple.of("key1", "value1"),Tuple.of("key2", "value2")).collect(Collectors.toMap(Tuple::left,Tuple::right));
			CollectionsAssertions.notSame(actualSet,actualSet);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed({key1=value1, key2=value2}!=={key1=value1, key2=value2}):\n\tActual:\t\t{key1=value1, key2=value2}\n\tExpected:\t!=={key1=value1, key2=value2}", e.getMessage());
		}
	}

	@Test
	public void testAssertMapNotSame_message() {
		System.out.println("CollectionsAssertionsMapTest >>> testAssertMapNotSame_message");
		CollectionsAssertions.notSame(new HashMap(),new HashMap(),"Message");
		CollectionsAssertions.notSame(Stream.of(Tuple.of("key1", "value1"),Tuple.of("key2", "value2")).collect(Collectors.toMap(Tuple::left,Tuple::right)),Stream.of(Tuple.of("key1", "value1"),Tuple.of("key2", "value2")).collect(Collectors.toMap(Tuple::left,Tuple::right)),"Message");
	}
	@Test
	public void testAssertMapNotSame_message_failed() {
		System.out.println("CollectionsAssertionsMapTest >>> testAssertMapNotSame_message_failed");
		try{
			CollectionsAssertions.notSame((Map)null,(Map)null,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(null!==null):\n\tActual:\t\tnull\n\tExpected:\t!==null", e.getMessage());
		}
		try{
			CollectionsAssertions.notSame(Collections.EMPTY_MAP ,Collections.EMPTY_MAP,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message({}!=={}):\n\tActual:\t\t{}\n\tExpected:\t!=={}", e.getMessage());
		}
		try{
			Map<String,String> actualSet=Stream.of(Tuple.of("key1", "value1"),Tuple.of("key2", "value2")).collect(Collectors.toMap(Tuple::left,Tuple::right));
			CollectionsAssertions.notSame(actualSet,actualSet,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message({key1=value1, key2=value2}!=={key1=value1, key2=value2}):\n\tActual:\t\t{key1=value1, key2=value2}\n\tExpected:\t!=={key1=value1, key2=value2}", e.getMessage());
		}
	}

	@Test
	public void testAssertMapEquals() {
		System.out.println("CollectionsAssertionsMapTest >>> testAssertMapEquals");
		CollectionsAssertions.assertEquals((Map)null,(Map)null);
		CollectionsAssertions.assertEquals(Collections.EMPTY_MAP,Collections.EMPTY_MAP);
		CollectionsAssertions.assertEquals(Stream.of(Tuple.of("key1", "value1"),Tuple.of("key2", "value2")).collect(Collectors.toMap(Tuple::left,Tuple::right)),Stream.of(Tuple.of("key1", "value1"),Tuple.of("key2", "value2")).collect(Collectors.toMap(Tuple::left,Tuple::right)));
		CollectionsAssertions.assertEquals((List)null,(List)null);
		CollectionsAssertions.assertEquals(Collections.EMPTY_LIST,Collections.EMPTY_LIST);
		CollectionsAssertions.assertEquals(Stream.of("a","b").collect(Collectors.toList()),Stream.of("a","b").collect(Collectors.toList()));
	}
	@Test
	public void testAssertMapEquals_failed() {
		System.out.println("CollectionsAssertionsMapTest >>> testAssertMapEquals_failed");
		try{
			CollectionsAssertions.assertEquals((Map)null,Collections.EMPTY_MAP);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(null~{}):\n\tActual:\t\tnull\n\tExpected:\t~{}", e.getMessage());
		}
		try{
			CollectionsAssertions.assertEquals(Stream.of(Tuple.of("key1", "value1")).collect(Collectors.toMap(Tuple::left,Tuple::right)),Stream.of(Tuple.of("key1", "value1"),Tuple.of("key2", "value2")).collect(Collectors.toMap(Tuple::left,Tuple::right)));
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed({key1=value1}~{key1=value1, key2=value2}):\n\tActual:\t\t{key1=value1}\n\tExpected:\t~{key1=value1, key2=value2}", e.getMessage());
		}
	}

	@Test
	public void testAssertMapEquals_message() {
		System.out.println("CollectionsAssertionsMapTest >>> testAssertMapEquals_message");
		CollectionsAssertions.assertEquals((Map)null,(Map)null,"Message");
		CollectionsAssertions.assertEquals(Collections.EMPTY_MAP,Collections.EMPTY_MAP,"Message");
		CollectionsAssertions.assertEquals(Stream.of(Tuple.of("key1", "value1"),Tuple.of("key2", "value2")).collect(Collectors.toMap(Tuple::left,Tuple::right)),Stream.of(Tuple.of("key1", "value1"),Tuple.of("key2", "value2")).collect(Collectors.toMap(Tuple::left,Tuple::right)),"Message");
	}
	@Test
	public void testAssertMapEquals_message_failed() {
		System.out.println("CollectionsAssertionsMapTest >>> testAssertMapEquals_message_failed");
		try{
			CollectionsAssertions.assertEquals((Map)null,Collections.EMPTY_MAP,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(null~{}):\n\tActual:\t\tnull\n\tExpected:\t~{}", e.getMessage());
		}
		try{
			CollectionsAssertions.assertEquals(Stream.of(Tuple.of("key1", "value1")).collect(Collectors.toMap(Tuple::left,Tuple::right)),Stream.of(Tuple.of("key1", "value1"),Tuple.of("key2", "value2")).collect(Collectors.toMap(Tuple::left,Tuple::right)),"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message({key1=value1}~{key1=value1, key2=value2}):\n\tActual:\t\t{key1=value1}\n\tExpected:\t~{key1=value1, key2=value2}", e.getMessage());
		}
	}

	@Test
	public void testAssertMapNotEquals() {
		System.out.println("CollectionsAssertionsMapTest >>> testAssertMapNotEquals");
		CollectionsAssertions.assertNotEquals((Map)null,Collections.EMPTY_MAP);
		CollectionsAssertions.assertNotEquals(Stream.of(Tuple.of("key1", "value1")).collect(Collectors.toMap(Tuple::left,Tuple::right)),Stream.of(Tuple.of("key1", "value1"),Tuple.of("key2", "value2")).collect(Collectors.toMap(Tuple::left,Tuple::right)));
	}
	@Test
	public void testAssertMapNotEquals_failed() {
		System.out.println("CollectionsAssertionsMapTest >>> testAssertMapNotEquals_failed");
		try{
			CollectionsAssertions.assertNotEquals((Map)null,(Map)null);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed(null!~null):\n\tActual:\t\tnull\n\tExpected:\t!~null", e.getMessage());
		}
		try{
			CollectionsAssertions.assertNotEquals(Collections.EMPTY_MAP,Collections.EMPTY_MAP);
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed({}!~{}):\n\tActual:\t\t{}\n\tExpected:\t!~{}", e.getMessage());
		}
		try{
			CollectionsAssertions.assertNotEquals(Stream.of(Tuple.of("key1", "value1"),Tuple.of("key2", "value2")).collect(Collectors.toMap(Tuple::left,Tuple::right)),Stream.of(Tuple.of("key1", "value1"),Tuple.of("key2", "value2")).collect(Collectors.toMap(Tuple::left,Tuple::right)));
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Assertion failed({key1=value1, key2=value2}!~{key1=value1, key2=value2}):\n\tActual:\t\t{key1=value1, key2=value2}\n\tExpected:\t!~{key1=value1, key2=value2}", e.getMessage());
		}
	}

	@Test
	public void testAssertMapNotEquals_message() {
		System.out.println("CollectionsAssertionsMapTest >>> testAssertMapNotEquals_message");
		CollectionsAssertions.assertNotEquals((Map)null,Collections.EMPTY_MAP,"Message");
		CollectionsAssertions.assertNotEquals(Stream.of(Tuple.of("key1", "value1")).collect(Collectors.toMap(Tuple::left,Tuple::right)),Stream.of(Tuple.of("key1", "value1"),Tuple.of("key2", "value2")).collect(Collectors.toMap(Tuple::left,Tuple::right)),"Message");
	}
	@Test
	public void testAssertMapNotEquals_message_failed() {
		System.out.println("CollectionsAssertionsMapTest >>> testAssertMapNotEquals_message_failed");
		try{
			CollectionsAssertions.assertNotEquals((Map)null,(Map)null,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message(null!~null):\n\tActual:\t\tnull\n\tExpected:\t!~null", e.getMessage());
		}
		try{
			CollectionsAssertions.assertNotEquals(Collections.EMPTY_MAP,Collections.EMPTY_MAP,"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message({}!~{}):\n\tActual:\t\t{}\n\tExpected:\t!~{}", e.getMessage());
		}
		try{
			CollectionsAssertions.assertNotEquals(Stream.of(Tuple.of("key1", "value1"),Tuple.of("key2", "value2")).collect(Collectors.toMap(Tuple::left,Tuple::right)),Stream.of(Tuple.of("key1", "value1"),Tuple.of("key2", "value2")).collect(Collectors.toMap(Tuple::left,Tuple::right)),"Message");
			Assert.fail();
		}catch(AssertException e){
			Assert.assertEquals("Message({key1=value1, key2=value2}!~{key1=value1, key2=value2}):\n\tActual:\t\t{key1=value1, key2=value2}\n\tExpected:\t!~{key1=value1, key2=value2}", e.getMessage());
		}
	}
}
