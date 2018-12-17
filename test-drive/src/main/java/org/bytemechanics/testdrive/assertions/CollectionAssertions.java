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
import org.bytemechanics.testdrive.exceptions.AssertException;

/**
 * Collection assertions
 * @author afarre
 * @since 0.4.0
 */
public class CollectionAssertions extends ObjectAssertions{

	/**
	 * Asserts if the _actual collection has zero length
	 * @param <T> type of the collection
	 * @param _actual actual value
	 * @return true if the _actual collection has zero length
	 * @since 0.3.0
	 */
	protected static final <T> boolean isEmpty(final Collection<T> _actual){
		return (_actual!=null)&&(_actual.isEmpty());
	}
	/**
	 * Asserts if the _actual collection has zero length
	 * @param <T> type of the collection
	 * @param _actual actual value
	 * @since 0.4.0
	 */
	@SuppressWarnings({"ConfusingArrayVararg", "PrimitiveArrayArgumentToVariableArgMethod"})
	public static final <T> void assertEmpty(final Collection<T> _actual){
		assertEmpty(_actual,"Assertion failed");
	}
	/**
	 * Asserts if the _actual collection has zero length
	 * @param <T> type of the collection
	 * @param _actual actual value
	 * @param _message message to show if the assertion fail
	 */
	@SuppressWarnings({"ConfusingArrayVararg", "PrimitiveArrayArgumentToVariableArgMethod"})
	public static final <T> void assertEmpty(final Collection<T>  _actual,final String _message){
		if(!isEmpty(_actual))
			throw new AssertException(".length=",_actual.size(),0, _message);
	}
	/**
	 * Asserts if the _actual collection at least one element
	 * @param <T> type of the collection
	 * @param _actual actual value
	 */
	@SuppressWarnings({"ConfusingArrayVararg", "PrimitiveArrayArgumentToVariableArgMethod"})
	public static final <T> void assertNotEmpty(final Collection<T>  _actual){
		assertNotEmpty(_actual,"Assertion failed");
	}
	/**
	 * Asserts if the _actual collection at least one element
	 * @param <T> type of the collection
	 * @param _actual actual value
	 * @param _message message to show if the assertion fail
	 */
	@SuppressWarnings({"ConfusingArrayVararg", "PrimitiveArrayArgumentToVariableArgMethod"})
	public static final <T> void assertNotEmpty(final Collection<T>  _actual,final String _message){
		if(isEmpty(_actual))
			throw new AssertException(".length>",_actual.size(),0, _message);
	}

	/**
	 * Asserts if the _actual and the _expected values are the same instance
	 * @param <T> type of the collection
	 * @param _actual actual value
	 * @param _expected expected value
	 * @return true if _actual is the same instance than _expected
	 */
	protected static final <T> boolean isSame(final Collection<T>  _actual,final Collection<T>  _expected){
		return _actual==_expected;
	}
	/**
	 * Asserts if the _actual and the _expected values are the same instance
	 * @param <T> type of the collection
	 * @param _actual actual value
	 * @param _expected expected value
	 */
	public static final <T> void assertSame(final Collection<T>  _actual,final Collection<T>  _expected){
		assertSame(_actual, _expected, "Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are the same instance
	 * @param <T> type of the collection
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 */
	public static final <T> void assertSame(final Collection<T>  _actual,final Collection<T>  _expected,final String _message){
		if(!isSame(_actual, _expected))
			throw new AssertException("=", _actual,_expected, _message);
	}
	/**
	 * Asserts if the _actual and the _expected values are not the same instance
	 * @param <T> type of the collection
	 * @param _actual actual value
	 * @param _expected expected value
	 */
	public static final <T> void assertNotSame(final Collection<T>  _actual,final Collection<T>  _expected){
		assertNotSame(_actual, _expected, "Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are the same instance
	 * @param <T> type of the collection
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 */
	public static final <T> void assertNotSame(final Collection<T>  _actual,final Collection<T>  _expected,final String _message){
		if(isSame(_actual, _expected))
			throw new AssertException("!=", _actual,_expected, _message);
	}

	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param <T> type of the collection
	 * @param _actual actual value
	 * @param _expected expected value
	 * @return true if _actual is equals to _expected
	 */
	@SuppressWarnings("null")
	protected static final <T> boolean isEqual(final Collection<T>  _actual,final Collection<T>  _expected){
		
		boolean reply=(_actual!=null)&&(_expected!=null)&&(_actual.size()==_expected.size());
		
		if(reply){
			reply=_actual.equals(_expected);
		}
		
		return reply;
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param <T> type of the collection
	 * @param _actual actual value
	 * @param _expected expected value
	 */
	public static final <T> void assertEquals(final Collection<T>  _actual,final Collection<T>  _expected){
		assertEquals(_actual,_expected,"Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param <T> type of the collection
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 */
	public static final <T> void assertEquals(final Collection<T>  _actual,final Collection<T>  _expected,final String _message){
		if(!isEqual(_actual, _expected))
			throw new AssertException("~", _actual,_expected, _message);
	}
	/**
	 * Asserts if the _actual and the _expected values are not equal
	 * @param <T> type of the collection
	 * @param _actual actual value
	 * @param _expected expected value
	 */
	public static final <T> void assertNotEquals(final Collection<T>  _actual,final Collection<T>  _expected){
		assertNotEquals(_actual,_expected,"Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param <T> type of the collection
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 */
	public static final <T> void assertNotEquals(final Collection<T>  _actual,final Collection<T>  _expected,final String _message){
		if(isEqual(_actual, _expected))
			throw new AssertException("!~", _actual,_expected, _message);
	}
}
