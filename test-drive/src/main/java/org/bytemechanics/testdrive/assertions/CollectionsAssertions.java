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
import java.util.Map;
import org.bytemechanics.testdrive.exceptions.AssertException;

/**
 * Collections assertions
 * @author afarre
 * @since 0.4.0
 */
public class CollectionsAssertions extends ObjectAssertions{

	/**
	 * Asserts if the _actual map has zero length or is null
	 * @param <T> type of the map
	 * @param _actual actual value
	 * @return true if the _actual map has zero length
	 */
	protected static final <T> boolean isEmpty(final Collection<T> _actual){
		return (_actual==null)||(_actual.isEmpty());
	}
	/**
	 * Asserts if the _actual map has zero length
	 * @param <T> type of the map
	 * @param _actual actual value
	 */
	@SuppressWarnings({"ConfusingArrayVararg", "PrimitiveArrayArgumentToVariableArgMethod"})
	public static final <T> void assertEmpty(final Collection<T> _actual){
		assertEmpty(_actual,"Assertion failed");
	}
	/**
	 * Asserts if the _actual map has zero length
	 * @param <T> type of the map
	 * @param _actual actual value
	 * @param _message message to show if the assertion fail
	 */
	@SuppressWarnings({"ConfusingArrayVararg", "PrimitiveArrayArgumentToVariableArgMethod"})
	public static final <T> void assertEmpty(final Collection<T>  _actual,final String _message){
		if(!isEmpty(_actual))
			throw new AssertException(".size()=",_actual.size(),0, _message);
	}
	/**
	 * Asserts if the _actual map at least one element
	 * @param <T> type of the map
	 * @param _actual actual value
	 */
	@SuppressWarnings({"ConfusingArrayVararg", "PrimitiveArrayArgumentToVariableArgMethod"})
	public static final <T> void assertNotEmpty(final Collection<T>  _actual){
		assertNotEmpty(_actual,"Assertion failed");
	}
	/**
	 * Asserts if the _actual map at least one element
	 * @param <T> type of the map
	 * @param _actual actual value
	 * @param _message message to show if the assertion fail
	 */
	@SuppressWarnings({"ConfusingArrayVararg", "PrimitiveArrayArgumentToVariableArgMethod"})
	public static final <T> void assertNotEmpty(final Collection<T>  _actual,final String _message){
		if(isEmpty(_actual))
			throw new AssertException(".size()>",0,0, _message);
	}

	/**
	 * Asserts if the _actual and the _expected values are the same instance
	 * @param <T> type of the map
	 * @param _actual actual value
	 * @param _expected expected value
	 */
	public static final <T> void assertSame(final Collection<T>  _actual,final Collection<T>  _expected){
		assertSame(_actual, _expected, "Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are the same instance
	 * @param <T> type of the map
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 */
	public static final <T> void assertSame(final Collection<T>  _actual,final Collection<T>  _expected,final String _message){
		if(!isSame(_actual, _expected))
			throw new AssertException("==", _actual,_expected, _message);
	}
	/**
	 * Asserts if the _actual and the _expected values are not the same instance
	 * @param <T> type of the map
	 * @param _actual actual value
	 * @param _expected expected value
	 */
	public static final <T> void assertNotSame(final Collection<T>  _actual,final Collection<T>  _expected){
		assertNotSame(_actual, _expected, "Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are the same instance
	 * @param <T> type of the map
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 */
	public static final <T> void assertNotSame(final Collection<T>  _actual,final Collection<T>  _expected,final String _message){
		if(isSame(_actual, _expected))
			throw new AssertException("!==", _actual,_expected, _message);
	}

	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param <T> type of the map
	 * @param _actual actual value
	 * @param _expected expected value
	 */
	public static final <T> void assertEquals(final Collection<T>  _actual,final Collection<T>  _expected){
		assertEquals(_actual,_expected,"Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param <T> type of the map
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 */
	public static final <T> void assertEquals(final Collection<T>  _actual,final Collection<T>  _expected,final String _message){
		if(!CollectionsAssertions.isEquals(_actual, _expected))
			throw new AssertException("~", _actual,_expected, _message);
	}
	/**
	 * Asserts if the _actual and the _expected values are not equal
	 * @param <T> type of the map
	 * @param _actual actual value
	 * @param _expected expected value
	 */
	public static final <T> void assertNotEquals(final Collection<T>  _actual,final Collection<T>  _expected){
		assertNotEquals(_actual,_expected,"Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param <T> type of the map
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 */
	public static final <T> void assertNotEquals(final Collection<T>  _actual,final Collection<T>  _expected,final String _message){
		if(CollectionsAssertions.isEquals(_actual, _expected))
			throw new AssertException("!~", _actual,_expected, _message);
	}


	/**
	 * Asserts if the _actual map has zero length or is null
	 * @param <T> map key type
	 * @param <K> map value type
	 * @param _actual actual value
	 * @return true if the _actual map has zero length
	 */
	protected static final <T,K> boolean isEmpty(final Map<T,K> _actual){
		return (_actual==null)||(_actual.isEmpty());
	}
	/**
	 * Asserts if the _actual map has zero length
	 * @param <T> map key type
	 * @param <K> map value type
	 * @param _actual actual value
	 */
	@SuppressWarnings({"ConfusingArrayVararg", "PrimitiveArrayArgumentToVariableArgMethod"})
	public static final <T,K> void assertEmpty(final Map<T,K> _actual){
		assertEmpty(_actual,"Assertion failed");
	}
	/**
	 * Asserts if the _actual map has zero length
	 * @param <T> map key type
	 * @param <K> map value type
	 * @param _actual actual value
	 * @param _message message to show if the assertion fail
	 */
	@SuppressWarnings({"ConfusingArrayVararg", "PrimitiveArrayArgumentToVariableArgMethod"})
	public static final <T,K> void assertEmpty(final Map<T,K>  _actual,final String _message){
		if(!isEmpty(_actual))
			throw new AssertException(".size()=",_actual.size(),0, _message);
	}
	/**
	 * Asserts if the _actual map at least one element
	 * @param <T> map key type
	 * @param <K> map value type
	 * @param _actual actual value
	 */
	@SuppressWarnings({"ConfusingArrayVararg", "PrimitiveArrayArgumentToVariableArgMethod"})
	public static final <T,K> void assertNotEmpty(final Map<T,K>  _actual){
		assertNotEmpty(_actual,"Assertion failed");
	}
	/**
	 * Asserts if the _actual map at least one element
	 * @param <T> map key type
	 * @param <K> map value type
	 * @param _actual actual value
	 * @param _message message to show if the assertion fail
	 */
	@SuppressWarnings({"ConfusingArrayVararg", "PrimitiveArrayArgumentToVariableArgMethod"})
	public static final <T,K> void assertNotEmpty(final Map<T,K>  _actual,final String _message){
		if(isEmpty(_actual))
			throw new AssertException(".size()>",0,0, _message);
	}

	/**
	 * Asserts if the _actual and the _expected values are the same instance
	 * @param <T> map key type
	 * @param <K> map value type
	 * @param _actual actual value
	 * @param _expected expected value
	 */
	public static final <T,K> void assertSame(final Map<T,K>  _actual,final Map<T,K>  _expected){
		assertSame(_actual, _expected, "Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are the same instance
	 * @param <T> map key type
	 * @param <K> map value type
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 */
	public static final <T,K> void assertSame(final Map<T,K>  _actual,final Map<T,K>  _expected,final String _message){
		if(!isSame(_actual, _expected))
			throw new AssertException("=", _actual,_expected, _message);
	}
	/**
	 * Asserts if the _actual and the _expected values are not the same instance
	 * @param <T> map key type
	 * @param <K> map value type
	 * @param _actual actual value
	 * @param _expected expected value
	 */
	public static final <T,K> void assertNotSame(final Map<T,K>  _actual,final Map<T,K>  _expected){
		assertNotSame(_actual, _expected, "Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are the same instance
	 * @param <T> map key type
	 * @param <K> map value type
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 */
	public static final <T,K> void assertNotSame(final Map<T,K>  _actual,final Map<T,K>  _expected,final String _message){
		if(isSame(_actual, _expected))
			throw new AssertException("!=", _actual,_expected, _message);
	}

	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param <T> map key type
	 * @param <K> map value type
	 * @param _actual actual value
	 * @param _expected expected value
	 */
	public static final <T,K> void assertEquals(final Map<T,K>  _actual,final Map<T,K>  _expected){
		assertEquals(_actual,_expected,"Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param <T> map key type
	 * @param <K> map value type
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 */
	public static final <T,K> void assertEquals(final Map<T,K>  _actual,final Map<T,K>  _expected,final String _message){
		if(!isEquals(_actual, _expected))
			throw new AssertException("~", _actual,_expected, _message);
	}
	/**
	 * Asserts if the _actual and the _expected values are not equal
	 * @param <T> map key type
	 * @param <K> map value type
	 * @param _actual actual value
	 * @param _expected expected value
	 */
	public static final <T,K> void assertNotEquals(final Map<T,K>  _actual,final Map<T,K>  _expected){
		assertNotEquals(_actual,_expected,"Assertion failed");
	}
	/**
	 * Asserts if the _actual and the _expected values are equal
	 * @param <T> map key type
	 * @param <K> map value type
	 * @param _actual actual value
	 * @param _expected expected value
	 * @param _message message to show if the assertion fail
	 */
	public static final <T,K> void assertNotEquals(final Map<T,K>  _actual,final Map<T,K>  _expected,final String _message){
		if(isEquals(_actual, _expected))
			throw new AssertException("!~", _actual,_expected, _message);
	}
}
