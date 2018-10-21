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
package org.bytemechanics.testdrive.runners.beans;

import java.time.Duration;
import java.time.Instant;
import org.bytemechanics.testdrive.ResultStatus;
import org.bytemechanics.testdrive.adapter.Result;
import org.bytemechanics.testdrive.exceptions.AssertException;

/**
 *
 * @author afarre
 */
public class ResultBean implements Result,AutoCloseable{

	private final Instant start;
	
	private Duration duration;
	private ResultStatus status;
	private String message;
	private Throwable error;

	public ResultBean() {
		this.start=Instant.now();
		this.duration = null;
		this.status = null;
		this.message = null;
		this.error = null;
	}
	
	public ResultBean skip(final String _message){
		this.status=ResultStatus.SKIPPED;
		this.message=_message;
		this.duration=Duration.ZERO;
		return this;
	}
	public ResultBean fail(final AssertException e){
		this.status=ResultStatus.FAILURE;
		this.message=e.getMessage();
		this.error=e;
		return this;
	}
	public ResultBean error(final Throwable e){
		this.status=ResultStatus.ERROR;
		this.message=e.getMessage();
		this.error=e;
		return this;
	}
	
	@Override
	public Duration getDuration() {
		return this.duration;
	}
	@Override
	public ResultStatus getStatus() {
		return this.status;
	}
	@Override
	public String getMessage() {
		return this.message;
	}
	@Override
	public Throwable getError() {
		return this.error;
	}

	@Override
	public void close() {
		this.status=(this.status==null)? ResultStatus.SUCCESS : this.status;
		this.duration=(this.duration==null)? Duration.between(this.start,Instant.now()) : this.duration;
	}
	
	public static ResultBean skipped(final String _message){
		return new ResultBean()
					.skip(_message);
	}
}
