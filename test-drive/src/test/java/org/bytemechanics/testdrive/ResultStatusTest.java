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

import org.junit.Test;

/**
 * @author afarre
 */
public class ResultStatusTest {
	
	@Test
	public void testIn() {
		System.out.println("ResultStatusTest >>> testIn");
		org.junit.Assert.assertFalse(ResultStatus.ERROR.in());
		org.junit.Assert.assertFalse(ResultStatus.ERROR.in(ResultStatus.FAILURE));
		org.junit.Assert.assertFalse(ResultStatus.ERROR.in(ResultStatus.FAILURE,ResultStatus.SKIPPED));
		org.junit.Assert.assertFalse(ResultStatus.ERROR.in(ResultStatus.FAILURE,ResultStatus.SKIPPED,ResultStatus.SUCCESS));
		org.junit.Assert.assertTrue(ResultStatus.ERROR.in(ResultStatus.ERROR));
		org.junit.Assert.assertTrue(ResultStatus.ERROR.in(ResultStatus.ERROR,ResultStatus.SUCCESS));
		org.junit.Assert.assertTrue(ResultStatus.ERROR.in(ResultStatus.FAILURE,ResultStatus.ERROR,ResultStatus.SUCCESS));
		org.junit.Assert.assertTrue(ResultStatus.ERROR.in(ResultStatus.FAILURE,ResultStatus.SKIPPED,ResultStatus.SUCCESS,ResultStatus.ERROR));
	}

	@Test
	public void testWorst() {
		System.out.println("ResultStatusTest >>> testWorst");
		org.junit.Assert.assertEquals(ResultStatus.ERROR,ResultStatus.worst(ResultStatus.ERROR, ResultStatus.ERROR));
		org.junit.Assert.assertEquals(ResultStatus.ERROR,ResultStatus.worst(ResultStatus.FAILURE, ResultStatus.ERROR));
		org.junit.Assert.assertEquals(ResultStatus.ERROR,ResultStatus.worst(ResultStatus.ERROR, ResultStatus.FAILURE));
		org.junit.Assert.assertEquals(ResultStatus.FAILURE,ResultStatus.worst(ResultStatus.FAILURE, ResultStatus.FAILURE));
		org.junit.Assert.assertEquals(ResultStatus.FAILURE,ResultStatus.worst(ResultStatus.SKIPPED, ResultStatus.FAILURE));
		org.junit.Assert.assertEquals(ResultStatus.FAILURE,ResultStatus.worst(ResultStatus.FAILURE, ResultStatus.SKIPPED));
		org.junit.Assert.assertEquals(ResultStatus.SKIPPED,ResultStatus.worst(ResultStatus.SKIPPED, ResultStatus.SKIPPED));
		org.junit.Assert.assertEquals(ResultStatus.SKIPPED,ResultStatus.worst(ResultStatus.SKIPPED, ResultStatus.SUCCESS));
		org.junit.Assert.assertEquals(ResultStatus.SKIPPED,ResultStatus.worst(ResultStatus.SUCCESS, ResultStatus.SKIPPED));
		org.junit.Assert.assertEquals(ResultStatus.SUCCESS,ResultStatus.worst(ResultStatus.SUCCESS, ResultStatus.SUCCESS));
	}
	
}
