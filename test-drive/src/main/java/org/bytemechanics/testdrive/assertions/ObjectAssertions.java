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

import static org.bytemechanics.testdrive.assertions.ObjectAssertions.same;
import org.bytemechanics.testdrive.exceptions.AssertException;

/**
 *
 * @author afarre
 * @since 0.3.0
 */
public class ObjectAssertions extends PrimitiveAssertions{

	/**
	 * Asserts if the _actual value is true
	 * @param <T> type
	 * @param _actual actual value
	 * @return true if _actual==true
	 * @since 0.3.0
 	 */
	protected static final <T extends Boolean> boolean isTrue(final T _actual){
		return (_actual!=null)&&(_actual.equals(Boolean.TRUE));
	}
	/**
	 * Asserts if the _actual value is true
	 * @param <T> type
	 * @param _actual actual value
	 * @since 0.4.0
	 */
	public static final <T extends Boolean> void assertTrue(final T _actual){
		assertTrue(_actual,"Assertion failed");
	}
	/**
	 * Asserts if the _actual value is true
	 * @param <T> type
	 * @param _actual actual value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final <T extends Boolean> void assertTrue(final T _actual,final String _message){
		if(!isTrue(_actual))
			throw new AssertException("~", _actual, true, _message);
	}
	/**
	 * Asserts if the _actual value is false
	 * @param <T> type
	 * @param _actual actual value
	 * @since 0.4.0
	 */
	public static final <T extends Boolean> void assertFalse(final T _actual){
		assertFalse(_actual,"Assertion failed");
	}
	/**
	 * Asserts if the _actual value is false
	 * @param <T> type
	 * @param _actual actual value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final <T extends Boolean> void assertFalse(final T _actual,final String _message){
		if(isTrue(_actual))
			throw new AssertException("~", _actual, false, _message);
	}

	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param <T> type
	 * @param _actual actual value
	 * @param _expected expected value
	 * @since 0.4.0
	 */
	public static final <T extends Boolean> void assertEquals(final T _actual,final T _expected){
		assertEquals(_actual,_expected,"Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param <T> type
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final <T extends Boolean> void assertEquals(final T _actual,final T _expected,final String _message){
		assertEquals((Object)_actual,(Object)_expected, _message);
	}
	/**
	 * Asserts if the _actual and the _expected values are not equal
	 * @param <T> type
	 * @param _actual actual value
	 * @param _expected expected value
	 * @since 0.4.0
	 */
	public static final <T extends Boolean> void assertNotEquals(final T _actual,final T _expected){
		assertNotEquals(_actual,_expected,"Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param <T> type
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final <T extends Boolean> void assertNotEquals(final T _actual,final T _expected,final String _message){
		assertNotEquals((Object)_actual,(Object) _expected, _message);
	}

	
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param <T> type
	 * @param _actual actual value
	 * @param _expected expected value
	 * @since 0.4.0
	 */
	public static final <T extends Byte> void assertEquals(final T _actual,final T _expected){
		assertEquals(_actual,_expected,"Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param <T> type
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final <T extends Byte> void assertEquals(final T _actual,final T _expected,final String _message){
		assertEquals((Object)_actual,(Object)_expected, _message);
	}
	/**
	 * Asserts if the _actual and the _expected values are not equal
	 * @param <T> type
	 * @param _actual actual value
	 * @param _expected expected value
	 * @since 0.4.0
	 */
	public static final <T extends Byte> void assertNotEquals(final T _actual,final T _expected){
		assertNotEquals(_actual,_expected,"Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param <T> type
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final <T extends Byte> void assertNotEquals(final T _actual,final T _expected,final String _message){
		assertNotEquals((Object)_actual, (Object)_expected, _message);
	}

	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param <T> type
	 * @param _actual actual value
	 * @param _expected expected value
	 * @since 0.4.0
	 */
	public static final <T extends Character> void assertEquals(final T _actual,final T _expected){
		assertEquals(_actual,_expected,"Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param <T> type
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final <T extends Character> void assertEquals(final T _actual,final T _expected,final String _message){
		assertEquals((Object)_actual,(Object) _expected, _message);
	}
	/**
	 * Asserts if the _actual and the _expected values are not equal
	 * @param <T> type
	 * @param _actual actual value
	 * @param _expected expected value
	 * @since 0.4.0
	 */
	public static final <T extends Character> void assertNotEquals(final T _actual,final T _expected){
		assertNotEquals(_actual,_expected,"Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param <T> type
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final <T extends Character> void assertNotEquals(final T _actual,final T _expected,final String _message){
		assertNotEquals((Object)_actual, (Object)_expected, _message);
	}

	
	/**
	 * Asserts if the _actual value is zero
	 * @param <T> type
	 * @param _actual actual value
	 * @return true if _actual is zero
	 * @since 0.3.0
	 */
	protected static final <T extends Number> boolean zero(final T _actual){
		return (_actual!=null)&&(_actual.intValue()==0);
	}
	/**
	 * Asserts if the _actual value is zero
	 * @param <T> type
	 * @param _actual actual value
	 * @since 0.4.0
	 */
	public static final <T extends Number> void assertZero(final  T _actual){
		assertZero(_actual,"Assertion failed");
	}
	/**
	 * Asserts if the _actual value is zero
	 * @param <T> type
	 * @param _actual actual value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final <T extends Number> void assertZero(final T _actual,final String _message){
		if(!zero(_actual))
			throw new AssertException("=", _actual, 0, _message);
	}
	
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param <T> type
	 * @param _actual actual value
	 * @param _expected expected value
	 * @since 0.4.0
	 */
	public static final <T extends Number & Comparable> void assertEquals(final T _actual,final T _expected){
		assertEquals(_actual,_expected,"Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are equal, if both are null or points to the assertSame instance are considered equal
	 * @param <T> type
	 * @param _actual actual value
	 * @param _expected expected value
	 * @return true if _actual is equals to _expected
	 * @since 0.3.0
	 */
	protected static final  <T extends Number & Comparable> boolean equals(final T _actual,final T _expected){
		return (_actual==_expected)||((_actual!=null)&&(_expected!=null)&&(_actual.compareTo(_expected)==0));
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param <T> type
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final <T extends Number & Comparable> void assertEquals(final T _actual,final T _expected,final String _message){
		if(!equals(_actual, _expected))
			throw new AssertException("~", _actual,_expected, _message);
	}
	/**
	 * Asserts if the _actual and the _expected values are not equal
	 * @param <T> type
	 * @param _actual actual value
	 * @param _expected expected value
	 * @since 0.4.0
	 */
	public static final <T extends Number & Comparable> void assertNotEquals(final T _actual,final T _expected){
		assertNotEquals(_actual,_expected,"Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param <T> type
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final <T extends Number & Comparable> void assertNotEquals(final T _actual,final T _expected,final String _message){
		if(equals(_actual, _expected))
			throw new AssertException("!~", _actual,_expected, _message);
	}
	
	/**
	 * Asserts if the _actual value is greater than _limit
	 * @param <T> type
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @return true if _actual is greater than _limit
	 * @since 0.3.0
	 */
	protected static final  <T extends Number & Comparable> boolean greater(final T _actual,final T _limit){
		return (_actual!=null)&&(_limit!=null)&&(_actual.compareTo(_limit)>0);
	}
	/**
	 * Asserts if the _actual value is greater or equal than _limit
	 * @param <T> type
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @return true if _actual is greater than _limit
	 * @since 0.3.0
	 */
	protected static final  <T extends Number & Comparable> boolean greaterOrEqual(final T _actual,final T _limit){
		return (_actual!=null)&&(_limit!=null)&&(_actual.compareTo(_limit)>=0);
	}
	/**
	 * Asserts if the _actual is greater than _limit
	 * @param <T> type
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @since 0.4.0
	 */
	public static final <T extends Number & Comparable> void assertGreater(final T _actual,final T _limit){
		assertGreater(_actual, _limit,"Assertion failed");
	}
	/**
	 * Asserts if the _actual is greater than _limit
	 * @param <T> type
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final <T extends Number & Comparable> void assertGreater(final T _actual,final T _limit,final String _message){
		if(!greater(_actual, _limit))
			throw new AssertException(">", _actual,_limit, _message);
	}
	/**
	 * Asserts if the _actual is greater or equal than _limit
	 * @param <T> type
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @since 0.4.0
	 */
	public static final <T extends Number & Comparable>  void assertGreaterOrEqual(final T _actual,final T _limit){
		assertGreaterOrEqual(_actual,_limit,"Assertion failed");
	}
	/**
	 * Asserts if the _actual is greater or equal than _limit
	 * @param <T> type
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final <T extends Number & Comparable> void assertGreaterOrEqual(final T _actual,final T _limit,final String _message){
		if(!greaterOrEqual(_actual, _limit))
			throw new AssertException(">=", _actual,_limit, _message);
	}
	/**
	 * Asserts if the _actual is smaller than _limit
	 * @param <T> type
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @since 0.4.0
	 */
	public static final <T extends Number & Comparable> void assertSmaller(final T _actual,final T _limit){
		assertSmaller(_actual, _limit, "Assertion failed");
	}
	/**
	 * Asserts if the _actual is smaller than _limit
	 * @param <T> type
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final <T extends Number & Comparable> void assertSmaller(final T _actual,final T _limit,final String _message){
		if(greaterOrEqual(_actual, _limit))
			throw new AssertException("<", _actual,_limit, _message);
	}
	/**
	 * Asserts if the _actual is smaller or equal than _limit
	 * @param <T> type
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @since 0.4.0
	 */
	public static final <T extends Number & Comparable> void assertSmallerOrEqual(final T _actual,final T _limit){
		assertSmallerOrEqual(_actual, _limit, "Assertion failed");
	}
	/**
	 * Asserts if the _actual is smaller or equal than _limit
	 * @param <T> type
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final <T extends Number & Comparable> void assertSmallerOrEqual(final T _actual,final T _limit,final String _message){
		if(greater(_actual, _limit))
			throw new AssertException("<=", _actual,_limit, _message);
	}

	
	/**
	 * Asserts if the _actual value is null
	 * @param <T> type
	 * @param _actual actual value
	 * @return true if _actual==null
	 * @since 0.3.0
 	 */
	protected static final <T extends Object> boolean isNull(final T _actual){
		return (_actual==null);
	}
	/**
	 * Asserts if the _actual value is null
	 * @param <T> type
	 * @param _actual actual value
	 * @since 0.4.0
	 */
	public static final <T extends Object> void assertNull(final T _actual){
		assertNull(_actual,  "Assertion failed");
	}
	/**
	 * Asserts if the _actual value is null
	 * @param <T> type
	 * @param _actual actual value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final <T extends Object> void assertNull(final T _actual,final String _message){
		if(!isNull(_actual))
			throw new AssertException("=", _actual, null, _message);
	}
	/**
	 * Asserts if the _actual value is not null
	 * @param <T> type
	 * @param _actual actual value
	 * @since 0.4.0
	 */
	public static final <T extends Object> void assertNotNull(final T _actual){
		assertNotNull(_actual,  "Assertion failed");
	}
	/**
	 * Asserts if the _actual value is not null
	 * @param <T> type
	 * @param _actual actual value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final <T extends Object> void assertNotNull(final T _actual,final String _message){
		if(isNull(_actual))
			throw new AssertException("!=", _actual, null, _message);
	}

	/**
	 * Asserts if the _actual and the _expected values are equal or assertSame
	 * @param <T> type
	 * @param _actual actual value
	 * @param _expected expected value
	 * @return true if _actual is equals to _expected
	 * @since 0.3.0
	 */
	protected static final <T extends Object> boolean equals(final T _actual,final T _expected){
		return (same(_actual,_expected))||(_actual!=null)&&(_expected!=null)&&(_actual.equals(_expected));
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param <T> type
	 * @param _actual actual value
	 * @param _expected expected value
	 * @since 0.4.0
	 */
	public static final <T extends Object> void assertEquals(final T _actual,final T _expected){
		assertEquals(_actual,_expected,"Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param <T> type
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final <T extends Object> void assertEquals(final T _actual,final T _expected,final String _message){
		if(!equals(_actual,_expected))
			throw new AssertException("~", _actual,_expected, _message);
	}
	/**
	 * Asserts if the _actual and the _expected values are not equal
	 * @param <T> type
	 * @param _actual actual value
	 * @param _expected expected value
	 * @since 0.4.0
	 */
	public static final <T extends Object> void assertNotEquals(final T _actual,final T _expected){
		assertNotEquals(_actual,_expected,"Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param <T> type
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final <T extends Object> void assertNotEquals(final T _actual,final T _expected,final String _message){
		if(equals(_actual,_expected))
			throw new AssertException("!~", _actual, _expected, _message);
	}

	/**
	 * Asserts if the _actual and the _expected values are the assertSame instance or both null
	 * @param <T> type
	 * @param _actual actual value
	 * @param _expected expected value
	 * @return true if _actual is the assertSame instance than _expected
	 * @since 0.3.0
	 */
	protected static final <T extends Object> boolean same(final T _actual,final T _expected){
		return _actual==_expected;
	}
	/**
	 * Asserts if the _actual and the _expected values are the assertSame instance
	 * @param <T> type
	 * @param _actual actual value
	 * @param _expected expected value
	 * @since 0.4.0
	 */
	public static final <T extends Object> void assertSame(final T _actual,final T _expected){
		assertSame(_actual, _expected, "Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are the assertSame instance
	 * @param <T> type
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final <T extends Object> void assertSame(final T _actual,final T _expected,final String _message){
		if(!same(_actual,_expected))
			throw new AssertException("==", _actual,_expected, _message);
	}
	/**
	 * Asserts if the _actual and the _expected values are not the assertSame instance
	 * @param <T> type
	 * @param _actual actual value
	 * @param _expected expected value
	 * @since 0.4.0
	 */
	public static final <T extends Object> void assertNotSame(final T _actual,final T _expected){
		assertNotSame(_actual, _expected, "Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are not the assertSame instance
	 * @param <T> type
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final <T extends Object> void assertNotSame(final T _actual,final T _expected,final String _message){
		if(same(_actual,_expected))
			throw new AssertException("!==", _actual, _expected, _message);
	}
}
