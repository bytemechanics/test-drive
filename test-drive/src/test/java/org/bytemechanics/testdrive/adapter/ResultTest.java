/*
 * Copyright 2019 Byte Mechanics.
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
import org.bytemechanics.testdrive.ResultStatus;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author afarre
 */
public class ResultTest {
	

	@Test
	public void testGetLog() {
		System.out.println("ResultTest >>> testGetLog");
		
		Result instance = new ResultImpl(Duration.ofHours(10),ResultStatus.ERROR,"myMessage",new RuntimeException("errorMessage"));
		String expResult = "[ERROR] >> in 0:00.000 >> myMessage";
		String result = instance.getLog();
		Assert.assertEquals(expResult, result);
	}

	@Test
	public void testGetLogOverriden() {
		System.out.println("ResultTest >>> testGetLogOverriden");
		
		Result instance = new ResultImplOverride(Duration.ofHours(10),ResultStatus.ERROR,"myMessage",new RuntimeException("errorMessage"));
		String expResult = "myLog";
		String result = instance.getLog();
		Assert.assertEquals(expResult, result);
	}

	public class ResultImpl implements Result {

		private final Duration duration;
		private final ResultStatus status;
		private final String message;
		private final Throwable error;
		
		public ResultImpl(final Duration _duration,final ResultStatus _status,final String _message,final Throwable _error){
			this.duration=_duration;
			this.status=_status;
			this.message=_message;
			this.error=_error;
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
	}
	
	public class ResultImplOverride extends ResultImpl {

		public ResultImplOverride(Duration _duration, ResultStatus _status, String _message, Throwable _error) {
			super(_duration, _status, _message, _error);
		}

		@Override
		public String getLog() {
			return "myLog";
		}
	}
}
