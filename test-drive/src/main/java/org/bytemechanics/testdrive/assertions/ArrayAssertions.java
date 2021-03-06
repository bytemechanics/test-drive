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
public class ArrayAssertions extends ObjectAssertions{

	protected static final boolean isEmpty(final boolean[] _actual){
		return (_actual!=null)&&(_actual.length==0);
	}
	@SuppressWarnings({"ConfusingArrayVararg", "PrimitiveArrayArgumentToVariableArgMethod"})
	public static final void assertEmpty(final boolean[] _actual,final String _message){
		if(!isEmpty(_actual))
			throw new AssertException(SimpleFormat.format("{}.length==0", (boolean[])_actual), 0, null, _message);
	}
	@SuppressWarnings({"ConfusingArrayVararg", "PrimitiveArrayArgumentToVariableArgMethod"})
	public static final void assertNotEmpty(final boolean[] _actual,final String _message){
		if(isEmpty(_actual))
			throw new AssertException(SimpleFormat.format("{}.length>0", (boolean[])_actual), 0, null, _message);
	}

	protected static final boolean isSame(final boolean[] _actual,final boolean[] _expected){
		return _actual==_expected;
	}
	public static final void assertSame(final boolean[] _actual,final boolean[] _expected,final String _message){
		if(!isSame(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}=={}", _actual,_expected), _expected, _actual, _message);
	}
	public static final void assertNotSame(final boolean[] _actual,final boolean[] _expected,final String _message){
		if(isSame(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}!={}", _actual,_expected), _expected, _actual, _message);
	}

	protected static final boolean isEqual(final boolean[] _actual,final boolean[] _expected){
		
		boolean reply=(_actual!=null)&&(_expected!=null)&&(_actual.length==_expected.length);
		
		if(reply){
			for(int ic1=0;ic1<_expected.length;ic1++){
				reply&=isEqual(_actual[ic1], _expected[ic1]);
			}
		}
		
		return reply;
	}
	public static final void assertEquals(final boolean[] _actual,final boolean[] _expected,final String _message){
		if(!isEqual(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}:={}", _actual,_expected), _expected, _actual, _message);
	}
	public static final void assertNotEquals(final boolean[] _actual,final boolean[] _expected,final String _message){
		if(isEqual(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}:={}", _actual,_expected), _expected, _actual, _message);
	}

	
	protected static final boolean isEmpty(final byte[] _actual){
		return (_actual!=null)&&(_actual.length==0);
	}
	@SuppressWarnings({"ConfusingArrayVararg", "PrimitiveArrayArgumentToVariableArgMethod"})
	public static final void assertEmpty(final byte[] _actual,final String _message){
		if(!isEmpty(_actual))
			throw new AssertException(SimpleFormat.format("{}.length==0", (byte[])_actual), 0, null, _message);
	}
	@SuppressWarnings({"ConfusingArrayVararg", "PrimitiveArrayArgumentToVariableArgMethod"})
	public static final void assertNotEmpty(final byte[] _actual,final String _message){
		if(isEmpty(_actual))
			throw new AssertException(SimpleFormat.format("{}.length>0", (byte[])_actual), 0, null, _message);
	}

	protected static final boolean isSame(final byte[] _actual,final byte[] _expected){
		return _actual==_expected;
	}
	public static final void assertSame(final byte[] _actual,final byte[] _expected,final String _message){
		if(!isSame(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}=={}", _actual,_expected), _expected, _actual, _message);
	}
	public static final void assertNotSame(final byte[] _actual,final byte[] _expected,final String _message){
		if(isSame(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}!={}", _actual,_expected), _expected, _actual, _message);
	}

	protected static final boolean isEqual(final byte[] _actual,final byte[] _expected){
		
		boolean reply=(_actual!=null)&&(_expected!=null)&&(_actual.length==_expected.length);
		
		if(reply){
			for(int ic1=0;ic1<_expected.length;ic1++){
				reply&=isEqual(_actual[ic1], _expected[ic1]);
			}
		}
		
		return reply;
	}
	public static final void assertEquals(final byte[] _actual,final byte[] _expected,final String _message){
		if(!isEqual(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}:={}", _actual,_expected), _expected, _actual, _message);
	}
	public static final void assertNotEquals(final byte[] _actual,final byte[] _expected,final String _message){
		if(isEqual(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}:={}", _actual,_expected), _expected, _actual, _message);
	}

	
	protected static final boolean isEmpty(final char[] _actual){
		return (_actual!=null)&&(_actual.length==0);
	}
	@SuppressWarnings({"ConfusingArrayVararg", "PrimitiveArrayArgumentToVariableArgMethod"})
	public static final void assertEmpty(final char[] _actual,final String _message){
		if(!isEmpty(_actual))
			throw new AssertException(SimpleFormat.format("{}.length==0", (char[])_actual), 0, null, _message);
	}
	@SuppressWarnings({"ConfusingArrayVararg", "PrimitiveArrayArgumentToVariableArgMethod"})
	public static final void assertNotEmpty(final char[] _actual,final String _message){
		if(isEmpty(_actual))
			throw new AssertException(SimpleFormat.format("{}.length>0", (char[])_actual), 0, null, _message);
	}

	protected static final boolean isSame(final char[] _actual,final char[] _expected){
		return _actual==_expected;
	}
	public static final void assertSame(final char[] _actual,final char[] _expected,final String _message){
		if(!isSame(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}=={}", _actual,_expected), _expected, _actual, _message);
	}
	public static final void assertNotSame(final char[] _actual,final char[] _expected,final String _message){
		if(isSame(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}!={}", _actual,_expected), _expected, _actual, _message);
	}

	protected static final boolean isEqual(final char[] _actual,final char[] _expected){
		
		boolean reply=(_actual!=null)&&(_expected!=null)&&(_actual.length==_expected.length);
		
		if(reply){
			for(int ic1=0;ic1<_expected.length;ic1++){
				reply&=isEqual(_actual[ic1], _expected[ic1]);
			}
		}
		
		return reply;
	}
	public static final void assertEquals(final char[] _actual,final char[] _expected,final String _message){
		if(!isEqual(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}:={}", _actual,_expected), _expected, _actual, _message);
	}
	public static final void assertNotEquals(final char[] _actual,final char[] _expected,final String _message){
		if(isEqual(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}:={}", _actual,_expected), _expected, _actual, _message);
	}

	
	protected static final boolean isEmpty(final short[] _actual){
		return (_actual!=null)&&(_actual.length==0);
	}
	@SuppressWarnings({"ConfusingArrayVararg", "PrimitiveArrayArgumentToVariableArgMethod"})
	public static final void assertEmpty(final short[] _actual,final String _message){
		if(!isEmpty(_actual))
			throw new AssertException(SimpleFormat.format("{}.length==0", (short[])_actual), 0, null, _message);
	}
	@SuppressWarnings({"ConfusingArrayVararg", "PrimitiveArrayArgumentToVariableArgMethod"})
	public static final void assertNotEmpty(final short[] _actual,final String _message){
		if(isEmpty(_actual))
			throw new AssertException(SimpleFormat.format("{}.length>0", (short[])_actual), 0, null, _message);
	}

	protected static final boolean isSame(final short[] _actual,final short[] _expected){
		return _actual==_expected;
	}
	public static final void assertSame(final short[] _actual,final short[] _expected,final String _message){
		if(!isSame(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}=={}", _actual,_expected), _expected, _actual, _message);
	}
	public static final void assertNotSame(final short[] _actual,final short[] _expected,final String _message){
		if(isSame(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}!={}", _actual,_expected), _expected, _actual, _message);
	}

	protected static final boolean isEqual(final short[] _actual,final short[] _expected){
		
		boolean reply=(_actual!=null)&&(_expected!=null)&&(_actual.length==_expected.length);
		
		if(reply){
			for(int ic1=0;ic1<_expected.length;ic1++){
				reply&=isEqual(_actual[ic1], _expected[ic1]);
			}
		}
		
		return reply;
	}
	public static final void assertEquals(final short[] _actual,final short[] _expected,final String _message){
		if(!isEqual(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}:={}", _actual,_expected), _expected, _actual, _message);
	}
	public static final void assertNotEquals(final short[] _actual,final short[] _expected,final String _message){
		if(isEqual(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}:={}", _actual,_expected), _expected, _actual, _message);
	}

	
	protected static final boolean isEmpty(final int[] _actual){
		return (_actual!=null)&&(_actual.length==0);
	}
	@SuppressWarnings({"ConfusingArrayVararg", "PrimitiveArrayArgumentToVariableArgMethod"})
	public static final void assertEmpty(final int[] _actual,final String _message){
		if(!isEmpty(_actual))
			throw new AssertException(SimpleFormat.format("{}.length==0", (int[])_actual), 0, null, _message);
	}
	@SuppressWarnings({"ConfusingArrayVararg", "PrimitiveArrayArgumentToVariableArgMethod"})
	public static final void assertNotEmpty(final int[] _actual,final String _message){
		if(isEmpty(_actual))
			throw new AssertException(SimpleFormat.format("{}.length>0", (int[])_actual), 0, null, _message);
	}

	protected static final boolean isSame(final int[] _actual,final int[] _expected){
		return _actual==_expected;
	}
	public static final void assertSame(final int[] _actual,final int[] _expected,final String _message){
		if(!isSame(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}=={}", _actual,_expected), _expected, _actual, _message);
	}
	public static final void assertNotSame(final int[] _actual,final int[] _expected,final String _message){
		if(isSame(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}!={}", _actual,_expected), _expected, _actual, _message);
	}

	protected static final boolean isEqual(final int[] _actual,final int[] _expected){
		
		boolean reply=(_actual!=null)&&(_expected!=null)&&(_actual.length==_expected.length);
		
		if(reply){
			for(int ic1=0;ic1<_expected.length;ic1++){
				reply&=isEqual(_actual[ic1], _expected[ic1]);
			}
		}
		
		return reply;
	}
	public static final void assertEquals(final int[] _actual,final int[] _expected,final String _message){
		if(!isEqual(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}:={}", _actual,_expected), _expected, _actual, _message);
	}
	public static final void assertNotEquals(final int[] _actual,final int[] _expected,final String _message){
		if(isEqual(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}:={}", _actual,_expected), _expected, _actual, _message);
	}

	
	protected static final boolean isEmpty(final long[] _actual){
		return (_actual!=null)&&(_actual.length==0);
	}
	@SuppressWarnings({"ConfusingArrayVararg", "PrimitiveArrayArgumentToVariableArgMethod"})
	public static final void assertEmpty(final long[] _actual,final String _message){
		if(!isEmpty(_actual))
			throw new AssertException(SimpleFormat.format("{}.length==0", (long[])_actual), 0, null, _message);
	}
	@SuppressWarnings({"ConfusingArrayVararg", "PrimitiveArrayArgumentToVariableArgMethod"})
	public static final void assertNotEmpty(final long[] _actual,final String _message){
		if(isEmpty(_actual))
			throw new AssertException(SimpleFormat.format("{}.length>0", (long[])_actual), 0, null, _message);
	}

	protected static final boolean isSame(final long[] _actual,final long[] _expected){
		return _actual==_expected;
	}
	public static final void assertSame(final long[] _actual,final long[] _expected,final String _message){
		if(!isSame(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}=={}", _actual,_expected), _expected, _actual, _message);
	}
	public static final void assertNotSame(final long[] _actual,final long[] _expected,final String _message){
		if(isSame(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}!={}", _actual,_expected), _expected, _actual, _message);
	}

	protected static final boolean isEqual(final long[] _actual,final long[] _expected){
		
		boolean reply=(_actual!=null)&&(_expected!=null)&&(_actual.length==_expected.length);
		
		if(reply){
			for(int ic1=0;ic1<_expected.length;ic1++){
				reply&=isEqual(_actual[ic1], _expected[ic1]);
			}
		}
		
		return reply;
	}
	public static final void assertEquals(final long[] _actual,final long[] _expected,final String _message){
		if(!isEqual(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}:={}", _actual,_expected), _expected, _actual, _message);
	}
	public static final void assertNotEquals(final long[] _actual,final long[] _expected,final String _message){
		if(isEqual(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}:={}", _actual,_expected), _expected, _actual, _message);
	}

	
	protected static final boolean isEmpty(final float[] _actual){
		return (_actual!=null)&&(_actual.length==0);
	}
	@SuppressWarnings({"ConfusingArrayVararg", "PrimitiveArrayArgumentToVariableArgMethod"})
	public static final void assertEmpty(final float[] _actual,final String _message){
		if(!isEmpty(_actual))
			throw new AssertException(SimpleFormat.format("{}.length==0", (float[])_actual), 0, null, _message);
	}
	@SuppressWarnings({"ConfusingArrayVararg", "PrimitiveArrayArgumentToVariableArgMethod"})
	public static final void assertNotEmpty(final float[] _actual,final String _message){
		if(isEmpty(_actual))
			throw new AssertException(SimpleFormat.format("{}.length>0", (float[])_actual), 0, null, _message);
	}

	protected static final boolean isSame(final float[] _actual,final float[] _expected){
		return _actual==_expected;
	}
	public static final void assertSame(final float[] _actual,final float[] _expected,final String _message){
		if(!isSame(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}=={}", _actual,_expected), _expected, _actual, _message);
	}
	public static final void assertNotSame(final float[] _actual,final float[] _expected,final String _message){
		if(isSame(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}!={}", _actual,_expected), _expected, _actual, _message);
	}

	protected static final boolean isEqual(final float[] _actual,final float[] _expected){
		
		boolean reply=(_actual!=null)&&(_expected!=null)&&(_actual.length==_expected.length);
		
		if(reply){
			for(int ic1=0;ic1<_expected.length;ic1++){
				reply&=isEqual(_actual[ic1], _expected[ic1]);
			}
		}
		
		return reply;
	}
	public static final void assertEquals(final float[] _actual,final float[] _expected,final String _message){
		if(!isEqual(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}:={}", _actual,_expected), _expected, _actual, _message);
	}
	public static final void assertNotEquals(final float[] _actual,final float[] _expected,final String _message){
		if(isEqual(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}:={}", _actual,_expected), _expected, _actual, _message);
	}

	
	protected static final boolean isEmpty(final double[] _actual){
		return (_actual!=null)&&(_actual.length==0);
	}
	@SuppressWarnings({"ConfusingArrayVararg", "PrimitiveArrayArgumentToVariableArgMethod"})
	public static final void assertEmpty(final double[] _actual,final String _message){
		if(!isEmpty(_actual))
			throw new AssertException(SimpleFormat.format("{}.length==0", (double[])_actual), 0, null, _message);
	}
	@SuppressWarnings({"ConfusingArrayVararg", "PrimitiveArrayArgumentToVariableArgMethod"})
	public static final void assertNotEmpty(final double[] _actual,final String _message){
		if(isEmpty(_actual))
			throw new AssertException(SimpleFormat.format("{}.length>0", (double[])_actual), 0, null, _message);
	}

	protected static final boolean isSame(final double[] _actual,final double[] _expected){
		return _actual==_expected;
	}
	public static final void assertSame(final double[] _actual,final double[] _expected,final String _message){
		if(!isSame(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}=={}", _actual,_expected), _expected, _actual, _message);
	}
	public static final void assertNotSame(final double[] _actual,final double[] _expected,final String _message){
		if(isSame(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}!={}", _actual,_expected), _expected, _actual, _message);
	}

	protected static final boolean isEqual(final double[] _actual,final double[] _expected){
		
		boolean reply=(_actual!=null)&&(_expected!=null)&&(_actual.length==_expected.length);
		
		if(reply){
			for(int ic1=0;ic1<_expected.length;ic1++){
				reply&=isEqual(_actual[ic1], _expected[ic1]);
			}
		}
		
		return reply;
	}
	public static final void assertEquals(final double[] _actual,final double[] _expected,final String _message){
		if(!isEqual(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}:={}", _actual,_expected), _expected, _actual, _message);
	}
	public static final void assertNotEquals(final double[] _actual,final double[] _expected,final String _message){
		if(isEqual(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}:={}", _actual,_expected), _expected, _actual, _message);
	}

	
	protected static final <T extends Object> boolean isEmpty(final T[] _actual){
		return (_actual!=null)&&(_actual.length==0);
	}
	@SuppressWarnings({"ConfusingArrayVararg", "PrimitiveArrayArgumentToVariableArgMethod"})
	public static final <T extends Object> void assertEmpty(final T[] _actual,final String _message){
		if(!isEmpty(_actual))
			throw new AssertException(SimpleFormat.format("{}.length==0", (T[])_actual), 0, null, _message);
	}
	@SuppressWarnings({"ConfusingArrayVararg", "PrimitiveArrayArgumentToVariableArgMethod"})
	public static final <T extends Object> void assertNotEmpty(final T[] _actual,final String _message){
		if(isEmpty(_actual))
			throw new AssertException(SimpleFormat.format("{}.length>0", (T[])_actual), 0, null, _message);
	}

	protected static final <T extends Object> boolean isSame(final T[] _actual,final T[] _expected){
		return _actual==_expected;
	}
	public static final <T extends Object> void assertSame(final T[] _actual,final T[] _expected,final String _message){
		if(!isSame(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}=={}", _actual,_expected), _expected, _actual, _message);
	}
	public static final <T extends Object> void assertNotSame(final T[] _actual,final T[] _expected,final String _message){
		if(isSame(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}!={}", _actual,_expected), _expected, _actual, _message);
	}

	protected static final <T extends Object> boolean isEqual(final T[] _actual,final T[] _expected){
		
		boolean reply=(_actual!=null)&&(_expected!=null)&&(_actual.length==_expected.length);
		
		if(reply){
			for(int ic1=0;ic1<_expected.length;ic1++){
				reply&=isEqual(_actual[ic1], _expected[ic1]);
			}
		}
		
		return reply;
	}
	public static final <T extends Object> void assertEquals(final T[] _actual,final T[] _expected,final String _message){
		if(!isEqual(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}:={}", _actual,_expected), _expected, _actual, _message);
	}
	public static final <T extends Object> void assertNotEquals(final T[] _actual,final T[] _expected,final String _message){
		if(isEqual(_actual, _expected))
			throw new AssertException(SimpleFormat.format("{}:={}", _actual,_expected), _expected, _actual, _message);
	}
}
