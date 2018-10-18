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
package org.bytemechanics.testdrive.beans;

import java.time.Duration;
import java.util.Objects;

/**
 *
 * @author afarre
 */
public class Result {

	private final Duration duration;
	private final boolean skipped;
	private final String failureMessage;
	private final Throwable error;

	
	public Result(final Duration _duration,final boolean _skipped,final String _failureMessage,final Throwable _error) {
		this.duration=_duration;
		this.skipped = _skipped;
		this.failureMessage = _failureMessage;
		this.error = _error;
	}
	
	
	public Duration getDuration() {
		return duration;
	}
	public boolean isSkipped() {
		return skipped;
	}
	public String getFailureMessage() {
		return failureMessage;
	}
	public Throwable getError() {
		return error;
	}

	
	@Override
	public int hashCode() {
		int hash = 3;
		hash = 97 * hash + Objects.hashCode(this.duration);
		hash = 97 * hash + (this.skipped ? 1 : 0);
		hash = 97 * hash + Objects.hashCode(this.failureMessage);
		hash = 97 * hash + Objects.hashCode(this.error);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Result other = (Result) obj;
		if (this.skipped != other.skipped) {
			return false;
		}
		if (!Objects.equals(this.failureMessage, other.failureMessage)) {
			return false;
		}
		if (!Objects.equals(this.duration, other.duration)) {
			return false;
		}
		if (!Objects.equals(this.error, other.error)) {
			return false;
		}
		return true;
	}	
}
