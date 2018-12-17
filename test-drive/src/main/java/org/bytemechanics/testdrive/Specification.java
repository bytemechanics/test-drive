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

/**
 * Interface any specification class should implement
 * @author afarre
 * @since 0.3.0
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
}
