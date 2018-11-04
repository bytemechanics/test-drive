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
public class PrimitiveAssertions {

	protected static final boolean isTrue(final boolean _actual){
		return _actual==true;
	}
	public static final void assertTrue(final boolean _actual,final String _message){
		if(!isTrue(_actual))
			throw new AssertException(SimpleFormat.format("{}==true", _actual,true), true, _actual, _message);
	}
	public static final void assertFalse(final boolean _actual,final String _message){
		if(isTrue(_actual))
			throw new AssertException(SimpleFormat.format("{}==false", _actual,false), false, _actual, _message);
	}
	protected static final boolean isEqual(final boolean _actual,final boolean _expected){
		return _actual==_expected;
	}
	public static final void assertEquals(final boolean _actual,final boolean _expected,final String _message){
		if(!isEqual(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}=={}", _actual,_expected), _expected, _actual, _message);
	}
	public static final void assertNotEquals(final boolean _actual,final boolean _expected,final String _message){
		if(isEqual(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}!={}", _actual,_expected), _expected, _actual, _message);
	}


	protected static final boolean isEqual(final byte _actual,final byte _expected){
		return _actual==_expected;
	}
	public static final void assertEquals(final byte _actual,final byte _expected,final String _message){
		if(!isEqual(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}=={}", _actual,_expected), _expected, _actual, _message);
	}
	public static final void assertNotEquals(final byte _actual,final byte	 _expected,final String _message){
		if(isEqual(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}!={}", _actual,_expected), _expected, _actual, _message);
	}

	
	protected static final boolean isEqual(final char _actual,final char _expected){
		return _actual==_expected;
	}
	public static final void assertEquals(final char _actual,final char _expected,final String _message){
		if(!isEqual(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}=={}", _actual,_expected), _expected, _actual, _message);
	}
	public static final void assertNotEquals(final char _actual,final char _expected,final String _message){
		if(isEqual(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}!={}", _actual,_expected), _expected, _actual, _message);
	}

	
	protected static final boolean isZero(final short _actual){
		return _actual==0;
	}
	public static final void assertZero(final short _actual,final String _message){
		if(!isZero(_actual))
			throw new AssertException(SimpleFormat.format("{}==0", _actual), 0, _actual, _message);
	}
	
	protected static final boolean isEqual(final short _actual,final short _expected){
		return _actual==_expected;
	}
	public static final void assertEquals(final short _actual,final short _expected,final String _message){
		if(!isEqual(_actual,_expected))
			throw new AssertException(SimpleFormat.format("{}=={}", _actual,_expected), _expected, _actual, _message);
	}
	public static final void assertNotEquals(final short _actual,final short _expected,final String _message){
		if(!isEqual(_actual,_expected))
			throw new AssertException(SimpleFormat.format("{}!={}", _actual,_expected), _expected, _actual, _message);
	}
	
	protected static final boolean isGreater(final short _actual,final short _limit){
		return _actual>_limit;
	}
	protected static final boolean isGreaterOrEqual(final short _actual,final short _limit){
		return _actual>=_limit;
	}
	public static final void assertGreater(final short _actual,final short _limit,final String _message){
		if(!isGreater(_actual,_limit))
			throw new AssertException(SimpleFormat.format("{}>{}", _actual,_limit), _limit, _actual, _message);
	}
	public static final void assertGreaterOrEqual(final short _actual,final short _limit,final String _message){
		if(!isGreaterOrEqual(_actual,_limit))
			throw new AssertException(SimpleFormat.format("{}>={}", _actual,_limit), _limit, _actual, _message);
	}
	public static final void assertSmaller(final short _actual,final short _limit,final String _message){
		if(isGreaterOrEqual(_actual,_limit))
			throw new AssertException(SimpleFormat.format("{}<{}", _actual,_limit), _limit, _actual, _message);
	}
	public static final void assertSmallerOrEqual(final short _actual,final short _limit,final String _message){
		if(isGreater(_actual,_limit))
			throw new AssertException(SimpleFormat.format("{}<={}", _actual,_limit), _limit, _actual, _message);
	}


	
	protected static final boolean isZero(final int _actual){
		return _actual==0;
	}
	public static final void assertZero(final int _actual,final String _message){
		if(!isZero(_actual))
			throw new AssertException(SimpleFormat.format("{}==0", _actual), 0, _actual, _message);
	}
	
	protected static final boolean isEqual(final int _actual,final int _expected){
		return _actual==_expected;
	}
	public static final void assertEquals(final int _actual,final int _expected,final String _message){
		if(!isEqual(_actual,_expected))
			throw new AssertException(SimpleFormat.format("{}=={}", _actual,_expected), _expected, _actual, _message);
	}
	public static final void assertNotEquals(final int _actual,final int _expected,final String _message){
		if(!isEqual(_actual,_expected))
			throw new AssertException(SimpleFormat.format("{}!={}", _actual,_expected), _expected, _actual, _message);
	}
	
	protected static final boolean isGreater(final int _actual,final int _limit){
		return _actual>_limit;
	}
	protected static final boolean isGreaterOrEqual(final int _actual,final int _limit){
		return _actual>=_limit;
	}
	public static final void assertGreater(final int _actual,final int _limit,final String _message){
		if(!isGreater(_actual,_limit))
			throw new AssertException(SimpleFormat.format("{}>{}", _actual,_limit), _limit, _actual, _message);
	}
	public static final void assertGreaterOrEqual(final int _actual,final int _limit,final String _message){
		if(!isGreaterOrEqual(_actual,_limit))
			throw new AssertException(SimpleFormat.format("{}>={}", _actual,_limit), _limit, _actual, _message);
	}
	public static final void assertSmaller(final int _actual,final int _limit,final String _message){
		if(isGreaterOrEqual(_actual,_limit))
			throw new AssertException(SimpleFormat.format("{}<{}", _actual,_limit), _limit, _actual, _message);
	}
	public static final void assertSmallerOrEqual(final int _actual,final int _limit,final String _message){
		if(isGreater(_actual,_limit))
			throw new AssertException(SimpleFormat.format("{}<={}", _actual,_limit), _limit, _actual, _message);
	}


	protected static final boolean isZero(final long _actual){
		return _actual==0l;
	}
	public static final void assertZero(final long _actual,final String _message){
		if(!isZero(_actual))
			throw new AssertException(SimpleFormat.format("{}==0l", _actual), 0, _actual, _message);
	}
	
	protected static final boolean isEqual(final long _actual,final long _expected){
		return _actual==_expected;
	}
	public static final void assertEquals(final long _actual,final long _expected,final String _message){
		if(!isEqual(_actual,_expected))
			throw new AssertException(SimpleFormat.format("{}=={}", _actual,_expected), _expected, _actual, _message);
	}
	public static final void assertNotEquals(final long _actual,final long _expected,final String _message){
		if(!isEqual(_actual,_expected))
			throw new AssertException(SimpleFormat.format("{}!={}", _actual,_expected), _expected, _actual, _message);
	}
	
	protected static final boolean isGreater(final long _actual,final long _limit){
		return _actual>_limit;
	}
	protected static final boolean isGreaterOrEqual(final long _actual,final long _limit){
		return _actual>=_limit;
	}
	public static final void assertGreater(final long _actual,final long _limit,final String _message){
		if(!isGreater(_actual,_limit))
			throw new AssertException(SimpleFormat.format("{}>{}", _actual,_limit), _limit, _actual, _message);
	}
	public static final void assertGreaterOrEqual(final long _actual,final long _limit,final String _message){
		if(!isGreaterOrEqual(_actual,_limit))
			throw new AssertException(SimpleFormat.format("{}>={}", _actual,_limit), _limit, _actual, _message);
	}
	public static final void assertSmaller(final long _actual,final long _limit,final String _message){
		if(isGreaterOrEqual(_actual,_limit))
			throw new AssertException(SimpleFormat.format("{}<{}", _actual,_limit), _limit, _actual, _message);
	}
	public static final void assertSmallerOrEqual(final long _actual,final long _limit,final String _message){
		if(isGreater(_actual,_limit))
			throw new AssertException(SimpleFormat.format("{}<={}", _actual,_limit), _limit, _actual, _message);
	}

	
	protected static final boolean isZero(final float _actual){
		return _actual==0.0f;
	}
	public static final void assertZero(final float _actual,final String _message){
		if(!isZero(_actual))
			throw new AssertException(SimpleFormat.format("{}==0.0f", _actual), 0, _actual, _message);
	}
	
	protected static final boolean isEqual(final float _actual,final float _expected){
		return _actual==_expected;
	}
	public static final void assertEquals(final float _actual,final float _expected,final String _message){
		if(!isEqual(_actual,_expected))
			throw new AssertException(SimpleFormat.format("{}=={}", _actual,_expected), _expected, _actual, _message);
	}
	public static final void assertNotEquals(final float _actual,final float _expected,final String _message){
		if(!isEqual(_actual,_expected))
			throw new AssertException(SimpleFormat.format("{}!={}", _actual,_expected), _expected, _actual, _message);
	}
	
	protected static final boolean isGreater(final float _actual,final float _limit){
		return _actual>_limit;
	}
	protected static final boolean isGreaterOrEqual(final float _actual,final float _limit){
		return _actual>=_limit;
	}
	public static final void assertGreater(final float _actual,final float _limit,final String _message){
		if(!isGreater(_actual,_limit))
			throw new AssertException(SimpleFormat.format("{}>{}", _actual,_limit), _limit, _actual, _message);
	}
	public static final void assertGreaterOrEqual(final float _actual,final float _limit,final String _message){
		if(!isGreaterOrEqual(_actual,_limit))
			throw new AssertException(SimpleFormat.format("{}>={}", _actual,_limit), _limit, _actual, _message);
	}
	public static final void assertSmaller(final float _actual,final float _limit,final String _message){
		if(isGreaterOrEqual(_actual,_limit))
			throw new AssertException(SimpleFormat.format("{}<{}", _actual,_limit), _limit, _actual, _message);
	}
	public static final void assertSmallerOrEqual(final float _actual,final float _limit,final String _message){
		if(isGreater(_actual,_limit))
			throw new AssertException(SimpleFormat.format("{}<={}", _actual,_limit), _limit, _actual, _message);
	}

	
	protected static final boolean isZero(final double _actual){
		return _actual==0.0d;
	}
	public static final void assertZero(final double _actual,final String _message){
		if(!isZero(_actual))
			throw new AssertException(SimpleFormat.format("{}==0.0d", _actual), 0, _actual, _message);
	}
	
	protected static final boolean isEqual(final double _actual,final double _expected){
		return _actual==_expected;
	}
	public static final void assertEquals(final double _actual,final double _expected,final String _message){
		if(!isEqual(_actual,_expected))
			throw new AssertException(SimpleFormat.format("{}=={}", _actual,_expected), _expected, _actual, _message);
	}
	public static final void assertNotEquals(final double _actual,final double _expected,final String _message){
		if(!isEqual(_actual,_expected))
			throw new AssertException(SimpleFormat.format("{}!={}", _actual,_expected), _expected, _actual, _message);
	}
	
	protected static final boolean isGreater(final double _actual,final double _limit){
		return _actual>_limit;
	}
	protected static final boolean isGreaterOrEqual(final double _actual,final double _limit){
		return _actual>=_limit;
	}
	public static final void assertGreater(final double _actual,final double _limit,final String _message){
		if(!isGreater(_actual,_limit))
			throw new AssertException(SimpleFormat.format("{}>{}", _actual,_limit), _limit, _actual, _message);
	}
	public static final void assertGreaterOrEqual(final double _actual,final double _limit,final String _message){
		if(!isGreaterOrEqual(_actual,_limit))
			throw new AssertException(SimpleFormat.format("{}>={}", _actual,_limit), _limit, _actual, _message);
	}
	public static final void assertSmaller(final double _actual,final double _limit,final String _message){
		if(isGreaterOrEqual(_actual,_limit))
			throw new AssertException(SimpleFormat.format("{}<{}", _actual,_limit), _limit, _actual, _message);
	}
	public static final void assertSmallerOrEqual(final double _actual,final double _limit,final String _message){
		if(isGreater(_actual,_limit))
			throw new AssertException(SimpleFormat.format("{}<={}", _actual,_limit), _limit, _actual, _message);
	}
}
