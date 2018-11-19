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

import org.apache.maven.plugin.surefire.log.api.ConsoleLogger;
import org.apache.maven.surefire.report.ConsoleStream;
import org.bytemechanics.testdrive.internal.commons.string.SimpleFormat;
import org.bytemechanics.testdrive.internal.commons.string.Stringify;

/**
 * Logger utility for testDrive surefire implementation.
 * @see ConsoleLogger
 * @author afarre
 * @since 0.3.0
 */
public class TestDriveLogger implements ConsoleLogger {

	/**
	 * Log level enumeration
	 */
	public enum Level{
		
		OFF(4),
		ERROR(3),
		WARN(2),
		INFO(1),
		DEBUG(0),
		;
		
		private final int level;
		
		Level(final int _level){
			this.level=_level;
		}
		
		public boolean isEqualOrGreater(final Level _level){
			return this.level>=_level.level;
		}		
	}
	
	private Level level=Level.INFO;
	private final ConsoleStream stream;
	
	/**
	 * Builds a logger using the ConsoleStream as underlaying output stream
	 * @param _stream log output stream
	 * @see ConsoleStream
	 * @since 0.3.0
	 */
	public TestDriveLogger(final ConsoleStream _stream){
		this.stream=_stream;
	}

	/**
	 * Changes the current log level (all logs more or equal important will be logged, the rest ignored)
	 * @param _level log level
	 * @see Level
	 * @since 0.3.0
	 */
	public void setLevel(final Level _level) {
		this.level = _level;
	}
	/**
	 * Returns the current log level 
	 * @return log level
	 * @see Level
	 * @since 0.4.0
	 */
	public Level getLevel() {
		return level;
	}
	
	/** @see ConsoleLogger#isDebugEnabled() */
	@Override
	public boolean isDebugEnabled() {
		return Level.DEBUG.isEqualOrGreater(this.level);
	}
	/** @see ConsoleLogger#debug(java.lang.String)  */
	@Override
	public void debug(final String _message) {
		if(isDebugEnabled()){
			this.stream.println(_message+"\n");
		}
	}
	public void debug(final String _message,final Object... _args) {
		if(isDebugEnabled()){
			this.stream.println(SimpleFormat.format(_message, _args)+"\n");
		}
	}

	/** @see ConsoleLogger#isInfoEnabled()   */
	@Override
	public boolean isInfoEnabled() {
		return Level.INFO.isEqualOrGreater(this.level);
	}
	/** @see ConsoleLogger#info(java.lang.String)  */
	@Override
	public void info(final String _message) {
		if(isInfoEnabled()){
			this.stream.println(_message+"\n");
		}
	}
	/**
	 * Logs info _message replacing {} with the given _args in order using SimpleFormat
	 * @param _message message to replace and log
	 * @param _args arguments to replace into _message by the given order
	 * @see SimpleFormat
	 * @since 0.3.0
	 */
	public void info(final String _message,final Object... _args) {
		if(isInfoEnabled()){
			this.stream.println(SimpleFormat.format(_message, _args)+"\n");
		}
	}

	/** @see ConsoleLogger#isWarnEnabled() */
	@Override
	public boolean isWarnEnabled() {
		return Level.WARN.isEqualOrGreater(this.level);
	}
	/** @see ConsoleLogger#warning(java.lang.String) */
	@Override
	public void warning(final String _message) {
		if(isWarnEnabled()){
			this.stream.println(_message+"\n");
		}
	}
	/**
	 * Logs warning _message replacing {} with the given _args in order using SimpleFormat
	 * @param _message message to replace and log
	 * @param _args arguments to replace into _message by the given order
	 * @see SimpleFormat
	 * @since 0.3.0
	 */
	public void warning(final String _message,final Object... _args) {
		if(isWarnEnabled()){
			this.stream.println(SimpleFormat.format(_message, _args)+"\n");
		}
	}

	/** @see ConsoleLogger#isErrorEnabled() */
	@Override
	public boolean isErrorEnabled() {
		return Level.ERROR.isEqualOrGreater(this.level);
	}
	/** @see ConsoleLogger#error(java.lang.String) */
	@Override
	public void error(final String _message) {
		if(isErrorEnabled()){
			this.stream.println(_message+"\n");
		}
	}
	/** @see ConsoleLogger#error(java.lang.String, java.lang.Throwable) */
	@Override
	public void error(final String _message, final Throwable _throwable) {
		if(isErrorEnabled()){
			this.stream.println(SimpleFormat.format("{}\n{}\n", _message,Stringify.toString(_throwable)));
		}
	}
	/**
	 * Logs error _message replacing {} with the given _args in order using SimpleFormat
	 * @param _message message to replace and log
	 * @param _throwable exception to log
	 * @param _args arguments to replace into _message by the given order
	 * @see SimpleFormat
	 * @since 0.3.0
	 */
	public void error(final String _message, final Throwable _throwable,final Object... _args) {
		if(isErrorEnabled()){
			final StringBuilder builder=new StringBuilder(SimpleFormat.format(_message, _args))
												.append("\n");
			if(_throwable!=null){
				builder.append(Stringify.toString(_throwable))
						.append("\n");
			}
			this.stream.println(builder.toString());
		}
	}
	/** @see ConsoleLogger#error(java.lang.Throwable) */
	@Override
	public void error(final Throwable _throwable) {
		if(isErrorEnabled()){
			this.stream.println(Stringify.toString(_throwable)+"\n");
		}
	}
}
