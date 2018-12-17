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

/**
 * Evaluation execution result bean
 * @author afarre
 * @since 0.3.0
 * @see Result
 * @see AutoCloseable
 */
public class ResultBean implements Result,AutoCloseable{

	private final Instant start;
	
	private Duration duration;
	private ResultStatus status;
	private String message;
	private Throwable error;

	/** Result bean constructor */
	public ResultBean() {
		this.start=Instant.now();
		this.duration = null;
		this.status = null;
		this.message = null;
		this.error = null;
	}
	
	/** 
	 * Sets skip result to the result bean
	 * @param _message reason to skip
	 * @return the current result bean updated
	 */
	public ResultBean skip(final String _message){
		this.duration=Duration.ZERO;
		return update(ResultStatus.SKIPPED, _message, null);
	}
	/** 
	 * Sets failure result to the result bean
	 * @param _error error cause
	 * @return the current result bean updated
	 */
	public ResultBean failure(final Throwable _error){
		return failure(_error.getMessage(),_error);
	}
	/** 
	 * Sets failure result to the result bean
	 * @param _message message cause
	 * @return the current result bean updated
	 */
	public ResultBean failure(final String _message){
		return failure(_message,null);
	}
	/** 
	 * Sets failure result to the result bean
	 * @param _message message cause
	 * @param _error error cause
	 * @return the current result bean updated
	 */
	public ResultBean failure(final String _message,final Throwable _error){
		return update(ResultStatus.FAILURE, _message, _error);
	}
	/** 
	 * Sets error result to the result bean
	 * @param _error error cause
	 * @return the current result bean updated
	 */
	public ResultBean error(final Throwable _error){
		return error(_error.getMessage(),_error);
	}
	/** 
	 * Sets error result to the result bean
	 * @param _message message cause
	 * @return the current result bean updated
	 */
	public ResultBean error(final String _message){
		return error(_message,null);
	}
	/** 
	 * Sets error result to the result bean
	 * @param _message message cause
	 * @param _error error cause
	 * @return the current result bean updated
	 */
	public ResultBean error(final String _message,final Throwable _error){
		return update(ResultStatus.ERROR, _message, _error);
	}
	/** 
	 * Update result with the given _status, _message and _error cause
	 * @param _status result status
	 * @param _message message cause (can be null)
	 * @param _error error cause (can be null)
	 * @return the current result bean updated
	 */
	public ResultBean update(final ResultStatus _status,final String _message,final Throwable _error){
		this.status=_status;
		this.message=_message;
		this.error=_error;
		return this;
	}
	
	/** @see Result#getDuration() */
	@Override
	public Duration getDuration() {
		return this.duration;
	}
	/** @see Result#getStatus() */
	@Override
	public ResultStatus getStatus() {
		return this.status;
	}
	/** @see Result#getMessage() */
	@Override
	public String getMessage() {
		return this.message;
	}
	/** @see Result#getError() */
	@Override
	public Throwable getError() {
		return this.error;
	}

	/** @see AutoCloseable#close() */
	@Override
	public void close() {
		this.status=(this.status==null)? ResultStatus.SUCCESS : this.status;
		this.duration=(this.duration==null)? Duration.between(this.start,Instant.now()) : this.duration;
	}
	
	/** 
	 * Builds a new ResultBean with skipped status 
	 * @param _message message cause
	 * @return new ResultBean with skipped status
	 */
	public static ResultBean skipped(final String _message){
		return new ResultBean()
					.skip(_message);
	}
}
