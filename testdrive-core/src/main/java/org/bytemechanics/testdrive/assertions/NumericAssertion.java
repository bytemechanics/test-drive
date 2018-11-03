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
public interface NumericAssertion {

	public default <T extends Number> void assertZero(final T _actual,final String _message){
		if(_actual==null)
			throw new AssertException(SimpleFormat.format("{}==0", _actual), 0, _actual, _message);
		if(_actual.intValue()!=0)
			throw new AssertException(SimpleFormat.format("{}==0", _actual), 0, _actual, _message);
	}
	public default <T extends Number & Comparable> void assertEquals(final T _actual,final T _expected,final String _message){
		if((_actual==null)||(_expected==null))
			throw new AssertException(SimpleFormat.format("{}=={}", _actual), 0, _actual, _message);
		if(_actual.compareTo(_expected)!=0)
			throw new AssertException(SimpleFormat.format("{}=={}", _actual,_expected), _expected, _actual, _message);
	}
	public default <T extends Number & Comparable> void assertGreater(final T _actual,final T _limit,final String _message){
		if((_actual==null)||(_limit==null))
			throw new AssertException(SimpleFormat.format("{}>{}", _actual), 0, _actual, _message);
		if(_actual.compareTo(_limit)<=0)
			throw new AssertException(SimpleFormat.format("{}>{}", _actual,_limit), _limit, _actual, _message);
	}
	public default <T extends Number & Comparable> void assertGreaterOrEqual(final T _actual,final T _limit,final String _message){
		if((_actual==null)||(_limit==null))
			throw new AssertException(SimpleFormat.format("{}>={}", _actual), 0, _actual, _message);
		if(_actual.compareTo(_limit)<0)
			throw new AssertException(SimpleFormat.format("{}>={}", _actual,_limit), _limit, _actual, _message);
	}
	public default <T extends Number & Comparable> void assertSmaller(final T _actual,final T _limit,final String _message){
		if((_actual==null)||(_limit==null))
			throw new AssertException(SimpleFormat.format("{}<{}", _actual), 0, _actual, _message);
		if(_actual.compareTo(_limit)>=0)
			throw new AssertException(SimpleFormat.format("{}<{}", _actual,_limit), _limit, _actual, _message);
	}
	public default <T extends Number & Comparable> void assertSmallerOrEqual(final T _actual,final T _limit,final String _message){
		if((_actual==null)||(_limit==null))
			throw new AssertException(SimpleFormat.format("{}<={}", _actual), 0, _actual, _message);
		if(_actual.compareTo(_limit)>0)
			throw new AssertException(SimpleFormat.format("{}<={}", _actual,_limit), _limit, _actual, _message);
	}

	public default void assertZero(final short _actual,final String _message){
		if(_actual!=0)
			throw new AssertException(SimpleFormat.format("{}==0", _actual), 0, _actual, _message);
	}
	public default void assertEquals(final short _actual,final short _expected,final String _message){
		if(_actual!=_expected)
			throw new AssertException(SimpleFormat.format("{}=={}", _actual,_expected), _expected, _actual, _message);
	}
	public default void assertGreater(final short _actual,final short _limit,final String _message){
		if(_actual<=_limit)
			throw new AssertException(SimpleFormat.format("{}>{}", _actual,_limit), _limit, _actual, _message);
	}
	public default void assertGreaterOrEqual(final short _actual,final short _limit,final String _message){
		if(_actual<_limit)
			throw new AssertException(SimpleFormat.format("{}>={}", _actual,_limit), _limit, _actual, _message);
	}
	public default void assertSmaller(final short _actual,final short _limit,final String _message){
		if(_actual>=_limit)
			throw new AssertException(SimpleFormat.format("{}<{}", _actual,_limit), _limit, _actual, _message);
	}
	public default void assertSmallerOrEqual(final short _actual,final short _limit,final String _message){
		if(_actual>_limit)
			throw new AssertException(SimpleFormat.format("{}<={}", _actual,_limit), _limit, _actual, _message);
	}

	public default void assertZero(final int _actual,final String _message){
		if(_actual!=0)
			throw new AssertException(SimpleFormat.format("{}==0", _actual), 0, _actual, _message);
	}
	public default void assertEquals(final int _actual,final int _expected,final String _message){
		if(_actual!=_expected)
			throw new AssertException(SimpleFormat.format("{}=={}", _actual,_expected), _expected, _actual, _message);
	}
	public default void assertGreater(final int _actual,final int _limit,final String _message){
		if(_actual<=_limit)
			throw new AssertException(SimpleFormat.format("{}>{}", _actual,_limit), _limit, _actual, _message);
	}
	public default void assertGreaterOrEqual(final int _actual,final int _limit,final String _message){
		if(_actual<_limit)
			throw new AssertException(SimpleFormat.format("{}>={}", _actual,_limit), _limit, _actual, _message);
	}
	public default void assertSmaller(final int _actual,final int _limit,final String _message){
		if(_actual>=_limit)
			throw new AssertException(SimpleFormat.format("{}<{}", _actual,_limit), _limit, _actual, _message);
	}
	public default void assertSmallerOrEqual(final int _actual,final int _limit,final String _message){
		if(_actual>_limit)
			throw new AssertException(SimpleFormat.format("{}<={}", _actual,_limit), _limit, _actual, _message);
	}

	public default void assertZero(final long _actual,final String _message){
		if(_actual!=0l)
			throw new AssertException(SimpleFormat.format("{}==0l", _actual), 0l, _actual, _message);
	}
	public default void assertEquals(final long _actual,final long _expected,final String _message){
		if(_actual!=_expected)
			throw new AssertException(SimpleFormat.format("{}=={}", _actual,_expected), _expected, _actual, _message);
	}
	public default void assertGreater(final long _actual,final long _limit,final String _message){
		if(_actual<=_limit)
			throw new AssertException(SimpleFormat.format("{}>{}", _actual,_limit), _limit, _actual, _message);
	}
	public default void assertGreaterOrEqual(final long _actual,final long _limit,final String _message){
		if(_actual<_limit)
			throw new AssertException(SimpleFormat.format("{}>={}", _actual,_limit), _limit, _actual, _message);
	}
	public default void assertSmaller(final long _actual,final long _limit,final String _message){
		if(_actual>=_limit)
			throw new AssertException(SimpleFormat.format("{}<{}", _actual,_limit), _limit, _actual, _message);
	}
	public default void assertSmallerOrEqual(final long _actual,final long _limit,final String _message){
		if(_actual>_limit)
			throw new AssertException(SimpleFormat.format("{}<={}", _actual,_limit), _limit, _actual, _message);
	}

	public default void assertZero(final float _actual,final String _message){
		if(_actual!=0.0f)
			throw new AssertException(SimpleFormat.format("{}==0.0f", _actual), 0.0f, _actual, _message);
	}
	public default void assertEquals(final float _actual,final float _expected,final String _message){
		if(_actual!=_expected)
			throw new AssertException(SimpleFormat.format("{}=={}", _actual,_expected), _expected, _actual, _message);
	}
	public default void assertGreater(final float _actual,final float _limit,final String _message){
		if(_actual<=_limit)
			throw new AssertException(SimpleFormat.format("{}>{}", _actual,_limit), _limit, _actual, _message);
	}
	public default void assertGreaterOrEqual(final float _actual,final float _limit,final String _message){
		if(_actual<_limit)
			throw new AssertException(SimpleFormat.format("{}>={}", _actual,_limit), _limit, _actual, _message);
	}
	public default void assertSmaller(final float _actual,final float _limit,final String _message){
		if(_actual>=_limit)
			throw new AssertException(SimpleFormat.format("{}<{}", _actual,_limit), _limit, _actual, _message);
	}
	public default void assertSmallerOrEqual(final float _actual,final float _limit,final String _message){
		if(_actual>_limit)
			throw new AssertException(SimpleFormat.format("{}<={}", _actual,_limit), _limit, _actual, _message);
	}

	public default void assertZero(final double _actual,final String _message){
		if(_actual!=0.0d)
			throw new AssertException(SimpleFormat.format("{}==0.0d", _actual), 0.0d, _actual, _message);
	}
	public default void assertEquals(final double _actual,final double _expected,final String _message){
		if(_actual!=_expected)
			throw new AssertException(SimpleFormat.format("{}=={}", _actual,_expected), _expected, _actual, _message);
	}
	public default void assertGreater(final double _actual,final double _limit,final String _message){
		if(_actual<=_limit)
			throw new AssertException(SimpleFormat.format("{}>{}", _actual,_limit), _limit, _actual, _message);
	}
	public default void assertGreaterOrEqual(final double _actual,final double _limit,final String _message){
		if(_actual<_limit)
			throw new AssertException(SimpleFormat.format("{}>={}", _actual,_limit), _limit, _actual, _message);
	}
	public default void assertSmaller(final double _actual,final double _limit,final String _message){
		if(_actual>=_limit)
			throw new AssertException(SimpleFormat.format("{}<{}", _actual,_limit), _limit, _actual, _message);
	}
	public default void assertSmallerOrEqual(final double _actual,final double _limit,final String _message){
		if(_actual>_limit)
			throw new AssertException(SimpleFormat.format("{}<={}", _actual,_limit), _limit, _actual, _message);
	}
}
