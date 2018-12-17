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

/**
 * Primitive assertions library
 * @author afarre
 * @since 0.3.0
 */
public class PrimitiveAssertions {

	/**
	 * Asserts if the _actual value is true
	 * @param _actual actual value
	 * @return true if _actual==true
	 * @since 0.3.0
 	 */
	protected static final boolean isTrue(final boolean _actual){
		return _actual==true;
	}
	/**
	 * Asserts if the _actual value is true
	 * @param _actual actual value
	 * @since 0.4.0
	 */
	public static final void assertTrue(final boolean _actual){
		assertTrue(_actual,"Assertion failed");
	}
	/**
	 * Asserts if the _actual value is true
	 * @param _actual actual value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertTrue(final boolean _actual,final String _message){
		if(!isTrue(_actual))
			throw new AssertException("=", _actual, true, _message);
	}
	/**
	 * Asserts if the _actual value is false
	 * @param _actual actual value
	 * @since 0.4.0
	 */
	public static final void assertFalse(final boolean _actual){
		assertFalse(_actual,"Assertion failed");
	}
	/**
	 * Asserts if the _actual value is false
	 * @param _actual actual value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertFalse(final boolean _actual,final String _message){
		if(isTrue(_actual))
			throw new AssertException("=", _actual, false, _message);
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @return true if _actual is equals to _expected
	 * @since 0.3.0
	 */
	protected static final boolean isEqual(final boolean _actual,final boolean _expected){
		return _actual==_expected;
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @since 0.4.0
	 */
	public static final void assertEquals(final boolean _actual,final boolean _expected){
		assertEquals(_actual,_expected,"Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertEquals(final boolean _actual,final boolean _expected,final String _message){
		if(!isEqual(_actual, _expected))
			throw new AssertException("=", _actual,_expected , _message);
	}
	/**
	 * Asserts if the _actual and the _expected values are not equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @since 0.4.0
	 */
	public static final void assertNotEquals(final boolean _actual,final boolean _expected){
		assertNotEquals(_actual,_expected,"Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are not equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertNotEquals(final boolean _actual,final boolean _expected,final String _message){
		if(isEqual(_actual, _expected))
			throw new AssertException("!=", _actual,_expected, _message);
	}


	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @return true if _actual is equals to _expected
	 * @since 0.3.0
	 */
	protected static final boolean isEqual(final byte _actual,final byte _expected){
		return _actual==_expected;
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @since 0.4.0
	 */
	public static final void assertEquals(final byte _actual,final byte _expected){
		assertEquals(_actual,_expected,"Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertEquals(final byte _actual,final byte _expected,final String _message){
		if(!isEqual(_actual, _expected))
			throw new AssertException("=", _actual,_expected, _message);
	}
	/**
	 * Asserts if the _actual and the _expected values are not equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @since 0.4.0
	 */
	public static final void assertNotEquals(final byte _actual,final byte _expected){
		assertNotEquals(_actual,_expected,"Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertNotEquals(final byte _actual,final byte	 _expected,final String _message){
		if(isEqual(_actual, _expected))
			throw new AssertException("!=",  _actual,_expected, _message);
	}

	
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @return true if _actual is equals to _expected
	 * @since 0.3.0
	 */
	protected static final boolean isEqual(final char _actual,final char _expected){
		return _actual==_expected;
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @since 0.4.0
	 */
	public static final void assertEquals(final char _actual,final char _expected){
		assertEquals(_actual,_expected,"Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertEquals(final char _actual,final char _expected,final String _message){
		if(!isEqual(_actual, _expected))
			throw new AssertException("=", _actual,_expected, _message);
	}
	/**
	 * Asserts if the _actual and the _expected values are not equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @since 0.4.0
	 */
	public static final void assertNotEquals(final char _actual,final char _expected){
		assertNotEquals(_actual,_expected,"Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertNotEquals(final char _actual,final char _expected,final String _message){
		if(isEqual(_actual, _expected))
			throw new AssertException("!=",  _actual,_expected, _message);
	}

	
	/**
	 * Asserts if the _actual value is zero
	 * @param _actual actual value
	 * @return true if _actual is zero
	 * @since 0.3.0
	 */
	protected static final boolean isZero(final short _actual){
		return _actual==0;
	}
	/**
	 * Asserts if the _actual value is zero
	 * @param _actual actual value
	 * @since 0.4.0
	 */
	public static final void assertZero(final short _actual){
		assertZero(_actual,"Assertion failed");
	}
	/**
	 * Asserts if the _actual value is zero
	 * @param _actual actual value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertZero(final short _actual,final String _message){
		if(!isZero(_actual))
			throw new AssertException("=", _actual, 0, _message);
	}
	
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @return true if _actual is equals to _expected
	 * @since 0.3.0
	 */
	protected static final boolean isEqual(final short _actual,final short _expected){
		return _actual==_expected;
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @since 0.4.0
	 */
	public static final void assertEquals(final short _actual,final short _expected){
		assertEquals(_actual,_expected,"Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertEquals(final short _actual,final short _expected,final String _message){
		if(!isEqual(_actual,_expected))
			throw new AssertException("=", _actual,_expected, _message);
	}
	/**
	 * Asserts if the _actual and the _expected values are not equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @since 0.4.0
	 */
	public static final void assertNotEquals(final short _actual,final short _expected){
		assertNotEquals(_actual,_expected,"Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertNotEquals(final short _actual,final short _expected,final String _message){
		if(!isEqual(_actual,_expected))
			throw new AssertException("!=", _actual,_expected, _message);
	}
	
	/**
	 * Asserts if the _actual value is greater than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @return true if _actual is greater than _limit
	 * @since 0.3.0
	 */
	protected static final boolean isGreater(final short _actual,final short _limit){
		return _actual>_limit;
	}
	/**
	 * Asserts if the _actual value is greater or equal than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @return true if _actual is greater than _limit
	 * @since 0.3.0
	 */
	protected static final boolean isGreaterOrEqual(final short _actual,final short _limit){
		return _actual>=_limit;
	}
	/**
	 * Asserts if the _actual is greater than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @since 0.4.0
	 */
	public static final void assertGreater(final short _actual,final short _limit){
		assertGreater(_actual, _limit,"Assertion failed");
	}
	/**
	 * Asserts if the _actual is greater than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertGreater(final short _actual,final short _limit,final String _message){
		if(!isGreater(_actual,_limit))
			throw new AssertException(">", _actual, _limit, _message);
	}
	/**
	 * Asserts if the _actual is greater or equal than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @since 0.4.0
	 */
	public static final void assertGreaterOrEqual(final short _actual,final short _limit){
		assertGreaterOrEqual(_actual,_limit,"Assertion failed");
	}
	/**
	 * Asserts if the _actual is greater or equal than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertGreaterOrEqual(final short _actual,final short _limit,final String _message){
		if(!isGreaterOrEqual(_actual,_limit))
			throw new AssertException(">=", _actual, _limit, _message);
	}
	/**
	 * Asserts if the _actual is smaller than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @since 0.4.0
	 */
	public static final void assertSmaller(final short _actual,final short _limit){
		assertSmaller(_actual, _limit, "Assertion failed");
	}
	/**
	 * Asserts if the _actual is smaller than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertSmaller(final short _actual,final short _limit,final String _message){
		if(isGreaterOrEqual(_actual,_limit))
			throw new AssertException("<", _actual, _limit, _message);
	}
	/**
	 * Asserts if the _actual is smaller or equal than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @since 0.4.0
	 */
	public static final void assertSmallerOrEqual(final short _actual,final short _limit){
		assertSmallerOrEqual(_actual, _limit, "Assertion failed");
	}
	/**
	 * Asserts if the _actual is smaller or equal than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertSmallerOrEqual(final short _actual,final short _limit,final String _message){
		if(isGreater(_actual,_limit))
			throw new AssertException("<=", _actual, _limit, _message);
	}


	/**
	 * Asserts if the _actual value is zero
	 * @param _actual actual value
	 * @return true if _actual is zero
	 * @since 0.3.0
	 */
	
	protected static final boolean isZero(final int _actual){
		return _actual==0;
	}
	/**
	 * Asserts if the _actual value is zero
	 * @param _actual actual value
	 * @since 0.4.0
	 */
	public static final void assertZero(final int _actual){
		assertZero(_actual,"Assertion failed");
	}
	/**
	 * Asserts if the _actual value is zero
	 * @param _actual actual value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertZero(final int _actual,final String _message){
		if(!isZero(_actual))
			throw new AssertException("=", _actual, 0, _message);
	}
	
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @return true if _actual is equals to _expected
	 * @since 0.3.0
	 */
	protected static final boolean isEqual(final int _actual,final int _expected){
		return _actual==_expected;
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @since 0.4.0
	 */
	public static final void assertEquals(final int _actual,final int _expected){
		assertEquals(_actual,_expected,"Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertEquals(final int _actual,final int _expected,final String _message){
		if(!isEqual(_actual,_expected))
			throw new AssertException("=", _actual,_expected, _message);
	}
	/**
	 * Asserts if the _actual and the _expected values are not equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @since 0.4.0
	 */
	public static final void assertNotEquals(final int _actual,final int _expected){
		assertNotEquals(_actual,_expected,"Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertNotEquals(final int _actual,final int _expected,final String _message){
		if(!isEqual(_actual,_expected))
			throw new AssertException("!=", _actual,_expected, _message);
	}
	
	/**
	 * Asserts if the _actual value is greater than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @return true if _actual is greater than _limit
	 * @since 0.3.0
	 */
	protected static final boolean isGreater(final int _actual,final int _limit){
		return _actual>_limit;
	}
	/**
	 * Asserts if the _actual value is greater or equal than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @return true if _actual is greater than _limit
	 * @since 0.3.0
	 */
	protected static final boolean isGreaterOrEqual(final int _actual,final int _limit){
		return _actual>=_limit;
	}
	/**
	 * Asserts if the _actual is greater than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @since 0.4.0
	 */
	public static final void assertGreater(final int _actual,final int _limit){
		assertGreater(_actual, _limit,"Assertion failed");
	}
	/**
	 * Asserts if the _actual is greater than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertGreater(final int _actual,final int _limit,final String _message){
		if(!isGreater(_actual,_limit))
			throw new AssertException(">", _actual, _limit, _message);
	}
	/**
	 * Asserts if the _actual is greater or equal than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @since 0.4.0
	 */
	public static final void assertGreaterOrEqual(final int _actual,final int _limit){
		assertGreaterOrEqual(_actual,_limit,"Assertion failed");
	}
	/**
	 * Asserts if the _actual is greater or equal than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertGreaterOrEqual(final int _actual,final int _limit,final String _message){
		if(!isGreaterOrEqual(_actual,_limit))
			throw new AssertException(">=", _actual, _limit, _message);
	}
	/**
	 * Asserts if the _actual is smaller than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @since 0.4.0
	 */
	public static final void assertSmaller(final int _actual,final int _limit){
		assertSmaller(_actual, _limit, "Assertion failed");
	}
	/**
	 * Asserts if the _actual is smaller than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertSmaller(final int _actual,final int _limit,final String _message){
		if(isGreaterOrEqual(_actual,_limit))
			throw new AssertException("<", _actual, _limit, _message);
	}
	/**
	 * Asserts if the _actual is smaller or equal than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @since 0.4.0
	 */
	public static final void assertSmallerOrEqual(final int _actual,final int _limit){
		assertSmallerOrEqual(_actual, _limit, "Assertion failed");
	}
	/**
	 * Asserts if the _actual is smaller or equal than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertSmallerOrEqual(final int _actual,final int _limit,final String _message){
		if(isGreater(_actual,_limit))
			throw new AssertException("<=", _actual, _limit, _message);
	}


	/**
	 * Asserts if the _actual value is zero
	 * @param _actual actual value
	 * @return true if _actual is zero
	 * @since 0.3.0
	 */
	protected static final boolean isZero(final long _actual){
		return _actual==0l;
	}
	/**
	 * Asserts if the _actual value is zero
	 * @param _actual actual value
	 * @since 0.4.0
	 */
	public static final void assertZero(final long _actual){
		assertZero(_actual,"Assertion failed");
	}
	/**
	 * Asserts if the _actual value is zero
	 * @param _actual actual value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertZero(final long _actual,final String _message){
		if(!isZero(_actual))
			throw new AssertException("=", _actual, 0, _message);
	}
	
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @return true if _actual is equals to _expected
	 * @since 0.3.0
	 */
	protected static final boolean isEqual(final long _actual,final long _expected){
		return _actual==_expected;
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @since 0.4.0
	 */
	public static final void assertEquals(final long _actual,final long _expected){
		assertEquals(_actual,_expected,"Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertEquals(final long _actual,final long _expected,final String _message){
		if(!isEqual(_actual,_expected))
			throw new AssertException("=", _actual,_expected, _message);
	}
	/**
	 * Asserts if the _actual and the _expected values are not equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @since 0.4.0
	 */
	public static final void assertNotEquals(final long _actual,final long _expected){
		assertNotEquals(_actual,_expected,"Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertNotEquals(final long _actual,final long _expected,final String _message){
		if(!isEqual(_actual,_expected))
			throw new AssertException("!=", _actual,_expected, _message);
	}
	
	/**
	 * Asserts if the _actual value is greater than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @return true if _actual is greater than _limit
	 * @since 0.3.0
	 */
	protected static final boolean isGreater(final long _actual,final long _limit){
		return _actual>_limit;
	}
	/**
	 * Asserts if the _actual value is greater or equal than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @return true if _actual is greater than _limit
	 * @since 0.3.0
	 */
	protected static final boolean isGreaterOrEqual(final long _actual,final long _limit){
		return _actual>=_limit;
	}
	/**
	 * Asserts if the _actual is greater than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @since 0.4.0
	 */
	public static final void assertGreater(final long _actual,final long _limit){
		assertGreater(_actual, _limit,"Assertion failed");
	}
	/**
	 * Asserts if the _actual is greater than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertGreater(final long _actual,final long _limit,final String _message){
		if(!isGreater(_actual,_limit))
			throw new AssertException(">", _actual, _limit, _message);
	}
	/**
	 * Asserts if the _actual is greater or equal than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @since 0.4.0
	 */
	public static final void assertGreaterOrEqual(final long _actual,final long _limit){
		assertGreaterOrEqual(_actual,_limit,"Assertion failed");
	}
	/**
	 * Asserts if the _actual is greater or equal than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertGreaterOrEqual(final long _actual,final long _limit,final String _message){
		if(!isGreaterOrEqual(_actual,_limit))
			throw new AssertException(">=", _actual, _limit, _message);
	}
	/**
	 * Asserts if the _actual is smaller than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @since 0.4.0
	 */
	public static final void assertSmaller(final long _actual,final long _limit){
		assertSmaller(_actual, _limit, "Assertion failed");
	}
	/**
	 * Asserts if the _actual is smaller than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertSmaller(final long _actual,final long _limit,final String _message){
		if(isGreaterOrEqual(_actual,_limit))
			throw new AssertException("<", _actual, _limit, _message);
	}
	/**
	 * Asserts if the _actual is smaller or equal than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @since 0.4.0
	 */
	public static final void assertSmallerOrEqual(final long _actual,final long _limit){
		assertSmallerOrEqual(_actual, _limit, "Assertion failed");
	}
	/**
	 * Asserts if the _actual is smaller or equal than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertSmallerOrEqual(final long _actual,final long _limit,final String _message){
		if(isGreater(_actual,_limit))
			throw new AssertException("<=", _actual, _limit, _message);
	}

	
	/**
	 * Asserts if the _actual value is zero
	 * @param _actual actual value
	 * @return true if _actual is zero
	 * @since 0.3.0
	 */
	protected static final boolean isZero(final float _actual){
		return _actual==0.0f;
	}
	/**
	 * Asserts if the _actual value is zero
	 * @param _actual actual value
	 * @since 0.4.0
	 */
	public static final void assertZero(final float _actual){
		assertZero(_actual,"Assertion failed");
	}
	/**
	 * Asserts if the _actual value is zero
	 * @param _actual actual value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertZero(final float _actual,final String _message){
		if(!isZero(_actual))
			throw new AssertException("=", _actual, 0.0f, _message);
	}
	
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @return true if _actual is equals to _expected
	 * @since 0.3.0
	 */
	protected static final boolean isEqual(final float _actual,final float _expected){
		return _actual==_expected;
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @since 0.4.0
	 */
	public static final void assertEquals(final float _actual,final float _expected){
		assertEquals(_actual,_expected,"Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertEquals(final float _actual,final float _expected,final String _message){
		if(!isEqual(_actual,_expected))
			throw new AssertException("=", _actual,_expected, _message);
	}
	/**
	 * Asserts if the _actual and the _expected values are not equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @since 0.4.0
	 */
	public static final void assertNotEquals(final float _actual,final float _expected){
		assertNotEquals(_actual,_expected,"Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertNotEquals(final float _actual,final float _expected,final String _message){
		if(!isEqual(_actual,_expected))
			throw new AssertException("!=", _actual,_expected, _message);
	}
	
	/**
	 * Asserts if the _actual value is greater than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @return true if _actual is greater than _limit
	 * @since 0.3.0
	 */
	protected static final boolean isGreater(final float _actual,final float _limit){
		return _actual>_limit;
	}
	/**
	 * Asserts if the _actual value is greater or equal than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @return true if _actual is greater than _limit
	 * @since 0.3.0
	 */
	protected static final boolean isGreaterOrEqual(final float _actual,final float _limit){
		return _actual>=_limit;
	}
	/**
	 * Asserts if the _actual is greater than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @since 0.4.0
	 */
	public static final void assertGreater(final float _actual,final float _limit){
		assertGreater(_actual, _limit,"Assertion failed");
	}
	/**
	 * Asserts if the _actual is greater than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertGreater(final float _actual,final float _limit,final String _message){
		if(!isGreater(_actual,_limit))
			throw new AssertException(">", _actual, _limit, _message);
	}
	/**
	 * Asserts if the _actual is greater or equal than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @since 0.4.0
	 */
	public static final void assertGreaterOrEqual(final float _actual,final float _limit){
		assertGreaterOrEqual(_actual,_limit,"Assertion failed");
	}
	/**
	 * Asserts if the _actual is greater or equal than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertGreaterOrEqual(final float _actual,final float _limit,final String _message){
		if(!isGreaterOrEqual(_actual,_limit))
			throw new AssertException(">=", _actual, _limit, _message);
	}
	/**
	 * Asserts if the _actual is smaller than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @since 0.4.0
	 */
	public static final void assertSmaller(final float _actual,final float _limit){
		assertSmaller(_actual, _limit, "Assertion failed");
	}
	/**
	 * Asserts if the _actual is smaller than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertSmaller(final float _actual,final float _limit,final String _message){
		if(isGreaterOrEqual(_actual,_limit))
			throw new AssertException("<", _actual, _limit, _message);
	}
	/**
	 * Asserts if the _actual is smaller or equal than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @since 0.4.0
	 */
	public static final void assertSmallerOrEqual(final float _actual,final float _limit){
		assertSmallerOrEqual(_actual, _limit, "Assertion failed");
	}
	/**
	 * Asserts if the _actual is smaller or equal than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertSmallerOrEqual(final float _actual,final float _limit,final String _message){
		if(isGreater(_actual,_limit))
			throw new AssertException("<=", _actual, _limit, _message);
	}

	
	/**
	 * Asserts if the _actual value is zero
	 * @param _actual actual value
	 * @return true if _actual is zero
	 * @since 0.3.0
	 */
	protected static final boolean isZero(final double _actual){
		return _actual==0.0d;
	}
	/**
	 * Asserts if the _actual value is zero
	 * @param _actual actual value
	 * @since 0.4.0
	 */
	public static final void assertZero(final double _actual){
		assertZero(_actual,"Assertion failed");
	}
	/**
	 * Asserts if the _actual value is zero
	 * @param _actual actual value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertZero(final double _actual,final String _message){
		if(!isZero(_actual))
			throw new AssertException("=", _actual, 0.0d, _message);
	}
	
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @return true if _actual is equals to _expected
	 * @since 0.3.0
	 */
	protected static final boolean isEqual(final double _actual,final double _expected){
		return _actual==_expected;
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @since 0.4.0
	 */
	public static final void assertEquals(final double _actual,final double _expected){
		assertEquals(_actual,_expected,"Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertEquals(final double _actual,final double _expected,final String _message){
		if(!isEqual(_actual,_expected))
			throw new AssertException("=", _actual,_expected, _message);
	}
	/**
	 * Asserts if the _actual and the _expected values are not equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @since 0.4.0
	 */
	public static final void assertNotEquals(final double _actual,final double _expected){
		assertNotEquals(_actual,_expected,"Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertNotEquals(final double _actual,final double _expected,final String _message){
		if(!isEqual(_actual,_expected))
			throw new AssertException("!=", _actual,_expected, _message);
	}
	
	/**
	 * Asserts if the _actual value is greater than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @return true if _actual is greater than _limit
	 * @since 0.3.0
	 */
	protected static final boolean isGreater(final double _actual,final double _limit){
		return _actual>_limit;
	}
	/**
	 * Asserts if the _actual value is greater or equal than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @return true if _actual is greater than _limit
	 * @since 0.3.0
	 */
	protected static final boolean isGreaterOrEqual(final double _actual,final double _limit){
		return _actual>=_limit;
	}
	/**
	 * Asserts if the _actual is greater than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @since 0.4.0
	 */
	public static final void assertGreater(final double _actual,final double _limit){
		assertGreater(_actual, _limit,"Assertion failed");
	}
	/**
	 * Asserts if the _actual is greater than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertGreater(final double _actual,final double _limit,final String _message){
		if(!isGreater(_actual,_limit))
			throw new AssertException(">", _actual, _limit, _message);
	}
	/**
	 * Asserts if the _actual is greater or equal than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @since 0.4.0
	 */
	public static final void assertGreaterOrEqual(final double _actual,final double _limit){
		assertGreaterOrEqual(_actual,_limit,"Assertion failed");
	}
	/**
	 * Asserts if the _actual is greater or equal than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertGreaterOrEqual(final double _actual,final double _limit,final String _message){
		if(!isGreaterOrEqual(_actual,_limit))
			throw new AssertException(">=", _actual, _limit, _message);
	}
	/**
	 * Asserts if the _actual is smaller than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @since 0.4.0
	 */
	public static final void assertSmaller(final double _actual,final double _limit){
		assertSmaller(_actual, _limit, "Assertion failed");
	}
	/**
	 * Asserts if the _actual is smaller than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertSmaller(final double _actual,final double _limit,final String _message){
		if(isGreaterOrEqual(_actual,_limit))
			throw new AssertException("<", _actual, _limit, _message);
	}
	/**
	 * Asserts if the _actual is smaller or equal than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @since 0.4.0
	 */
	public static final void assertSmallerOrEqual(final double _actual,final double _limit){
		assertSmallerOrEqual(_actual, _limit, "Assertion failed");
	}
	/**
	 * Asserts if the _actual is smaller or equal than _limit
	 * @param _actual actual value
	 * @param _limit limit to compare
	 * @param _message message to show if the assertion fail
	 * @since 0.3.0
	 */
	public static final void assertSmallerOrEqual(final double _actual,final double _limit,final String _message){
		if(isGreater(_actual,_limit))
			throw new AssertException("<=", _actual, _limit, _message);
	}
}
