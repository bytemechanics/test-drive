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
 *
 * @author afarre
 */
public interface Result {

	public Duration getDuration();
	public ResultStatus getStatus();
	public String getMessage();
	public Throwable getError();

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
