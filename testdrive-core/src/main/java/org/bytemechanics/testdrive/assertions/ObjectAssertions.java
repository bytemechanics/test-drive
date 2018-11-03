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
import org.bytemechanics.testdrive.internal.commons.string.SimpleFormat;

/**
 *
 * @author afarre
 */
public class ObjectAssertions extends PrimitiveAssertions{

	protected static final <T extends Boolean> boolean isTrue(final T _actual){
		return (_actual!=null)&&(_actual.equals(Boolean.TRUE));
	}
	public static final <T extends Boolean> void assertTrue(final T _actual,final String _message){
		if(!isTrue(_actual))
			throw new AssertException(SimpleFormat.format("{}.equals(true)", _actual,true), true, _actual, _message);
	}
	public static final <T extends Boolean> void assertFalse(final T _actual,final String _message){
		if(isTrue(_actual))
			throw new AssertException(SimpleFormat.format("{}.equals(false)", _actual,true), false, _actual, _message);
	}
	public static final <T extends Boolean> void assertEquals(final T _actual,final T _expected,final String _message){
		equals(_actual, _expected, _message);
	}
	public static final <T extends Boolean> void assertNotEquals(final T _actual,final T _expected,final String _message){
		notEquals(_actual, _expected, _message);
	}

	
	public static final <T extends Byte> void assertEquals(final T _actual,final T _expected,final String _message){
		equals(_actual, _expected, _message);
	}
	public static final <T extends Byte> void assertNotEquals(final T _actual,final T _expected,final String _message){
		notEquals(_actual, _expected, _message);
	}

	public static final <T extends Character> void assertEquals(final T _actual,final T _expected,final String _message){
		equals(_actual, _expected, _message);
	}
	public static final <T extends Character> void assertNotEquals(final T _actual,final T _expected,final String _message){
		notEquals(_actual, _expected, _message);
	}

	
	protected static final <T extends Number> boolean isZero(final T _actual){
		return (_actual!=null)&&(_actual.intValue()==0);
	}
	public static final <T extends Number> void assertZero(final T _actual,final String _message){
		if(!isZero(_actual))
			throw new AssertException(SimpleFormat.format("{}==0", _actual), 0, _actual, _message);
	}
	
	protected static final  <T extends Number & Comparable> boolean isEqual(final T _actual,final T _expected){
		return (_actual!=null)&&(_expected!=null)&&(_actual.compareTo(_expected)==0);
	}
	public static final <T extends Number & Comparable> void assertEquals(final T _actual,final T _expected,final String _message){
		if(!isEqual(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}.equals({})", _actual,_expected), _expected, _actual, _message);
	}
	public static final <T extends Number & Comparable> void assertNotEquals(final T _actual,final T _expected,final String _message){
		if(isEqual(_actual, _expected))
			throw new AssertException(SimpleFormat.format("!{}.equals({})", _actual,_expected), _expected, _actual, _message);
	}
	
	protected static final  <T extends Number & Comparable> boolean isGreater(final T _actual,final T _expected){
		return (_actual!=null)&&(_expected!=null)&&(_actual.compareTo(_expected)>0);
	}
	protected static final  <T extends Number & Comparable> boolean isGreaterOrEqual(final T _actual,final T _expected){
		return (_actual!=null)&&(_expected!=null)&&(_actual.compareTo(_expected)>=0);
	}
	public static final <T extends Number & Comparable> void assertGreater(final T _actual,final T _limit,final String _message){
		if(!isGreater(_actual, _limit))
			throw new AssertException(SimpleFormat.format("{}>{}", _actual,_limit),_limit, _actual, _message);
	}
	public static final <T extends Number & Comparable> void assertGreaterOrEqual(final T _actual,final T _limit,final String _message){
		if(!isGreaterOrEqual(_actual, _limit))
			throw new AssertException(SimpleFormat.format("{}>={}", _actual,_limit),_limit, _actual, _message);
	}
	public static final <T extends Number & Comparable> void assertSmaller(final T _actual,final T _limit,final String _message){
		if(isGreaterOrEqual(_actual, _limit))
			throw new AssertException(SimpleFormat.format("{}<{}", _actual,_limit),_limit, _actual, _message);
	}
	public static final <T extends Number & Comparable> void assertSmallerOrEqual(final T _actual,final T _limit,final String _message){
		if(isGreater(_actual, _limit))
			throw new AssertException(SimpleFormat.format("{}<={}", _actual,_limit),_limit, _actual, _message);
	}

	
	protected static final <T extends Object> boolean isNull(final T _actual){
		return (_actual==null);
	}
	public static final <T extends Object> void assertNull(final T _actual,final String _message){
		if(!isNull(_actual))
			throw new AssertException(SimpleFormat.format("{}==null", _actual), null, _actual, _message);
	}
	public static final <T extends Object> void assertNotNull(final T _actual,final String _message){
		if(isNull(_actual))
			throw new AssertException(SimpleFormat.format("{}!=null", _actual), null, _actual, _message);
	}

	protected static final <T extends Object> boolean isEqual(final T _actual,final T _expected){
		return (_actual!=null)&&(_expected!=null)&&(_actual.equals(_expected));
	}
	public static final <T extends Object> void equals(final T _actual,final T _expected,final String _message){
		if(!isEqual(_actual,_expected))
			throw new AssertException(SimpleFormat.format("{}.equals({})", _actual,_expected), _expected, _actual, _message);
	}
	public static final <T extends Object> void notEquals(final T _actual,final T _expected,final String _message){
		if(isEqual(_actual,_expected))
			throw new AssertException(SimpleFormat.format("!{}.equals({})", _actual,_expected), 0, _actual, _message);
	}

	protected static final <T extends Object> boolean isSame(final T _actual,final T _expected){
		return (_actual!=null)&&(_expected!=null)&&(_actual==_expected);
	}
	public static final <T extends Object> void same(final T _actual,final T _expected,final String _message){
		if(!isSame(_actual,_expected))
			throw new AssertException(SimpleFormat.format("{}=={}", _actual,_expected), _expected, _actual, _message);
	}
	public static final <T extends Object> void notSame(final T _actual,final T _expected,final String _message){
		if(isSame(_actual,_expected))
			throw new AssertException(SimpleFormat.format("{}!={}", _actual,_expected), 0, _actual, _message);
	}
}
