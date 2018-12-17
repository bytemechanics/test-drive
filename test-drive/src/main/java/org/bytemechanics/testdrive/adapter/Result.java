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
package org.bytemechanics.testdrive.adapter;

import java.time.Duration;
import java.util.Optional;
import org.bytemechanics.testdrive.ResultStatus;
import org.bytemechanics.testdrive.internal.commons.string.SimpleFormat;
import org.bytemechanics.testdrive.internal.commons.string.Stringify;

/**
 * Execution evaluation result
 * @author afarre
 * @since 0.3.0
 */
public interface Result {

	/**
	 * Return the evaluation execution duration
	 * @return evaluation execution duration
	 * @see Duration
	 */
	public Duration getDuration();
	/**
	 * Return the evaluation execution result status
	 * @return evaluation execution result status
	 * @see ResultStatus
	 */
	public ResultStatus getStatus();
	/**
	 * Return the evaluation execution message
	 * @return evaluation execution message
	 */
	public String getMessage();
	/**
	 * Return the evaluation execution error
	 * @return evaluation execution error
	 * @see Throwable
	 */
	public Throwable getError();

	/**
	 * Build a String log with the evaluation execution result
	 * @return log with the evaluation execution result
	 */
	@SuppressWarnings("ThrowableResultIgnored")
	public default String getLog(){
		return SimpleFormat.format("[{}] >> in {}{}"
				,getStatus().name()
				,Stringify.toString(getDuration(), "m:ss.SSS")
				,Optional.ofNullable(getMessage())
							.map(String::trim)
							.filter(message -> !message.isEmpty())
							.map(message -> " >> "+message)
							.orElse(""));
	}
}
