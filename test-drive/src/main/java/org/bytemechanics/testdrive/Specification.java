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
package org.bytemechanics.testdrive;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.bytemechanics.testdrive.exceptions.AssertException;
import org.bytemechanics.testdrive.exceptions.TestNotAccessible;
import org.bytemechanics.testdrive.exceptions.TestParametersNotMatch;
import org.bytemechanics.testdrive.exceptions.UnexpectedTestError;

/**
 * Interface any specification class should implement
 * @author afarre
 * @since 1.0.0
 */
public interface Specification {
	
	/**
	 * runs once - before the first feature method
	 */
	public default void setupSpec() {}
	/**
	 * runs before every feature method
	 */
	public default void setup() {}
	/**
	 * runs after every feature method
	 */
	public default void cleanup() {} 
	/**
	 * runs once - after the last feature method
	 */
	public default void cleanupSpec() {} 


	/**
	 * Executes the given method with the given arguments
	 * @param _method method to test
	 * @param _args arguments to pass to method
	 */
	public default void executeTest(final Method _method,final Object... _args){
		
		try{
			_method.invoke(_method, _args);
		}catch(IllegalArgumentException e){
			throw new TestParametersNotMatch(this.getClass(),_method,_args,e);
		}catch(IllegalAccessException e){
			throw new TestNotAccessible(this.getClass(),_method,e);
		}catch(InvocationTargetException e) {
			if(AssertException.class.isAssignableFrom(e.getCause().getClass())){
				throw (AssertException)e.getCause();
			}else{
				throw new UnexpectedTestError(this.getClass(),_method,e);
			}
		}
	}
}
