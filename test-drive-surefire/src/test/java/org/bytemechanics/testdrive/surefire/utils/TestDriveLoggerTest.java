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
package org.bytemechanics.testdrive.surefire.utils;

import java.util.LinkedList;
import java.util.Queue;
import org.apache.maven.surefire.report.ConsoleStream;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author afarre
 */
public class TestDriveLoggerTest {
	
	private class ConsoleStreamDummmie implements ConsoleStream{

		public Queue<String> calls=new LinkedList<>(); 
		
		@Override
		public void println(String arg0) {
			calls.offer(arg0);
		}

		@Override
		public void println(byte[] arg0, int arg1, int arg2) {
		}
	}

	private ConsoleStreamDummmie consoleStream; 
	
	@Before
	public void setUp() {
		this.consoleStream=new ConsoleStreamDummmie();
	}
	
	@After
	public void tearDown() {
		this.consoleStream=null;
	}

	@Test
	public void testSetLevel() {
		System.out.println("TestDriveLoggerTest >> setLevel");

		TestDriveLogger.Level level = TestDriveLogger.Level.DEBUG;
		TestDriveLogger instance =new TestDriveLogger(consoleStream);
		Assert.assertEquals(TestDriveLogger.Level.INFO,instance.getLevel());

		instance.setLevel(level);

		Assert.assertEquals(level,instance.getLevel());
	}

	@Test
	public void testIsDebugEnabled() {
		System.out.println("TestDriveLoggerTest >> isDebugEnabled");

		TestDriveLogger instance =new TestDriveLogger(consoleStream);

		instance.setLevel(TestDriveLogger.Level.DEBUG);
		Assert.assertTrue("debug should be enabled if DEBUG is selected",instance.isDebugEnabled());

		instance.setLevel(TestDriveLogger.Level.INFO);
		Assert.assertFalse("debug should be disabled if INFO is selected",instance.isDebugEnabled());

		instance.setLevel(TestDriveLogger.Level.WARN);
		Assert.assertFalse("debug should be disabled if WARN is selected",instance.isDebugEnabled());

		instance.setLevel(TestDriveLogger.Level.ERROR);
		Assert.assertFalse("debug should be disabled if ERROR is selected",instance.isDebugEnabled());

		instance.setLevel(TestDriveLogger.Level.OFF);
		Assert.assertFalse("debug should be disabled if OFF is selected",instance.isDebugEnabled());
	}

	@Test
	public void testDebug_String_ObjectArr() {
		System.out.println("TestDriveLoggerTest >> debug");

		String _message = "my {}{} message";
		Object[] _args = {"1",2};
		String expected = "my 12 message\n";
	
		TestDriveLogger instance =new TestDriveLogger(consoleStream);
		
		instance.setLevel(TestDriveLogger.Level.DEBUG);
		instance.debug(_message, _args);
		Assert.assertEquals(expected,this.consoleStream.calls.poll());

		instance.setLevel(TestDriveLogger.Level.INFO);
		instance.debug(_message, _args);
		Assert.assertNull(this.consoleStream.calls.poll());

		instance.setLevel(TestDriveLogger.Level.WARN);
		instance.debug(_message, _args);
		Assert.assertNull(this.consoleStream.calls.poll());

		instance.setLevel(TestDriveLogger.Level.ERROR);
		instance.debug(_message, _args);
		Assert.assertNull(this.consoleStream.calls.poll());

		instance.setLevel(TestDriveLogger.Level.OFF);
		instance.debug(_message, _args);
		Assert.assertNull(this.consoleStream.calls.poll());
	}

	@Test
	public void testIsInfoEnabled() {
		System.out.println("TestDriveLoggerTest >> isInfoEnabled");

		TestDriveLogger instance =new TestDriveLogger(consoleStream);

		instance.setLevel(TestDriveLogger.Level.DEBUG);
		Assert.assertTrue("info should be enabled if DEBUG is selected",instance.isInfoEnabled());

		instance.setLevel(TestDriveLogger.Level.INFO);
		Assert.assertTrue("info should be enabled if INFO is selected",instance.isInfoEnabled());

		instance.setLevel(TestDriveLogger.Level.WARN);
		Assert.assertFalse("info should be disabled if WARN is selected",instance.isInfoEnabled());

		instance.setLevel(TestDriveLogger.Level.ERROR);
		Assert.assertFalse("info should be disabled if ERROR is selected",instance.isInfoEnabled());

		instance.setLevel(TestDriveLogger.Level.OFF);
		Assert.assertFalse("info should be disabled if OFF is selected",instance.isInfoEnabled());
	}

	@Test
	public void testInfo_String_ObjectArr() {
		System.out.println("TestDriveLoggerTest >> info");

		String _message = "my {}{} message";
		Object[] _args = {"1",2};
		String expected = "my 12 message\n";
	
		TestDriveLogger instance =new TestDriveLogger(consoleStream);
		
		instance.setLevel(TestDriveLogger.Level.DEBUG);
		instance.info(_message, _args);
		Assert.assertEquals(expected,this.consoleStream.calls.poll());

		instance.setLevel(TestDriveLogger.Level.INFO);
		instance.info(_message, _args);
		Assert.assertEquals(expected,this.consoleStream.calls.poll());

		instance.setLevel(TestDriveLogger.Level.WARN);
		instance.info(_message, _args);
		Assert.assertNull(this.consoleStream.calls.poll());

		instance.setLevel(TestDriveLogger.Level.ERROR);
		instance.info(_message, _args);
		Assert.assertNull(this.consoleStream.calls.poll());

		instance.setLevel(TestDriveLogger.Level.OFF);
		instance.info(_message, _args);
		Assert.assertNull(this.consoleStream.calls.poll());
	}

	@Test
	public void testIsWarnEnabled() {
		System.out.println("TestDriveLoggerTest >> testIsWarnEnabled");

		TestDriveLogger instance =new TestDriveLogger(consoleStream);

		instance.setLevel(TestDriveLogger.Level.DEBUG);
		Assert.assertTrue("warn should be enabled if DEBUG is selected",instance.isWarnEnabled());

		instance.setLevel(TestDriveLogger.Level.INFO);
		Assert.assertTrue("warn should be enabled if INFO is selected",instance.isWarnEnabled());

		instance.setLevel(TestDriveLogger.Level.WARN);
		Assert.assertTrue("warn should be enabled if WARN is selected",instance.isWarnEnabled());

		instance.setLevel(TestDriveLogger.Level.ERROR);
		Assert.assertFalse("warn should be disabled if ERROR is selected",instance.isWarnEnabled());

		instance.setLevel(TestDriveLogger.Level.OFF);
		Assert.assertFalse("warn should be disabled if OFF is selected",instance.isWarnEnabled());
	}

	@Test
	public void testWarning_String_ObjectArr() {
		System.out.println("TestDriveLoggerTest >> warning");

		String _message = "my {}{} message";
		Object[] _args = {"1",2};
		String expected = "my 12 message\n";
	
		TestDriveLogger instance =new TestDriveLogger(consoleStream);
		
		instance.setLevel(TestDriveLogger.Level.DEBUG);
		instance.warning(_message, _args);
		Assert.assertEquals(expected,this.consoleStream.calls.poll());

		instance.setLevel(TestDriveLogger.Level.INFO);
		instance.warning(_message, _args);
		Assert.assertEquals(expected,this.consoleStream.calls.poll());

		instance.setLevel(TestDriveLogger.Level.WARN);
		instance.warning(_message, _args);
		Assert.assertEquals(expected,this.consoleStream.calls.poll());

		instance.setLevel(TestDriveLogger.Level.ERROR);
		instance.warning(_message, _args);
		Assert.assertNull(this.consoleStream.calls.poll());

		instance.setLevel(TestDriveLogger.Level.OFF);
		instance.warning(_message, _args);
		Assert.assertNull(this.consoleStream.calls.poll());	}

	@Test
	public void testIsErrorEnabled() {
		System.out.println("TestDriveLoggerTest >> testIsErrorEnabled");

		TestDriveLogger instance =new TestDriveLogger(consoleStream);

		instance.setLevel(TestDriveLogger.Level.DEBUG);
		Assert.assertTrue("warn should be enabled if DEBUG is selected",instance.isErrorEnabled());

		instance.setLevel(TestDriveLogger.Level.INFO);
		Assert.assertTrue("warn should be enabled if INFO is selected",instance.isErrorEnabled());

		instance.setLevel(TestDriveLogger.Level.WARN);
		Assert.assertTrue("warn should be enabled if WARN is selected",instance.isErrorEnabled());

		instance.setLevel(TestDriveLogger.Level.ERROR);
		Assert.assertTrue("warn should be enabled if ERROR is selected",instance.isErrorEnabled());

		instance.setLevel(TestDriveLogger.Level.OFF);
		Assert.assertFalse("warn should be disabled if OFF is selected",instance.isErrorEnabled());
	}

	@Test
	public void testError_3args() {
		System.out.println("TestDriveLoggerTest >> error");

		String _message = "my {}{} message";
		Object[] _args = {"1",2};
		String expected = "my 12 message\n";
	
		TestDriveLogger instance =new TestDriveLogger(consoleStream);
		
		instance.setLevel(TestDriveLogger.Level.DEBUG);
		instance.error(_message,null, _args);
		Assert.assertEquals(expected,this.consoleStream.calls.poll());

		instance.setLevel(TestDriveLogger.Level.INFO);
		instance.error(_message,null, _args);
		Assert.assertEquals(expected,this.consoleStream.calls.poll());

		instance.setLevel(TestDriveLogger.Level.WARN);
		instance.error(_message,null, _args);
		Assert.assertEquals(expected,this.consoleStream.calls.poll());

		instance.setLevel(TestDriveLogger.Level.ERROR);
		instance.error(_message,null, _args);
		Assert.assertEquals(expected,this.consoleStream.calls.poll());

		instance.setLevel(TestDriveLogger.Level.OFF);
		instance.error(_message,null, _args);
		Assert.assertNull(this.consoleStream.calls.poll());		
	}
}
