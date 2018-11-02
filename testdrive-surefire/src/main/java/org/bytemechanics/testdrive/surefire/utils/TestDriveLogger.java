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

import java.util.logging.Level;
import org.apache.maven.plugin.surefire.log.api.ConsoleLogger;
import org.apache.maven.surefire.report.ConsoleStream;
import org.bytemechanics.testdrive.internal.commons.string.SimpleFormat;
import org.bytemechanics.testdrive.internal.commons.string.Stringify;

/**
 *
 * @author afarre
 */
public class TestDriveLogger implements ConsoleLogger {

	private Level level=Level.INFO;
	private final ConsoleStream stream;
	
	public TestDriveLogger(final ConsoleStream _stream){
		this.stream=_stream;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
	
	@Override
	public boolean isDebugEnabled() {
		return this.level.intValue()<=Level.CONFIG.intValue();
	}
	@Override
	public void debug(final String _message) {
		if(isDebugEnabled()){
			this.stream.println(_message);
			this.stream.println("\n");
		}
	}
	public void debug(final String _message,final Object... _args) {
		if(isDebugEnabled()){
			this.stream.println(SimpleFormat.format(_message, _args));
			this.stream.println("\n");
		}
	}

	@Override
	public boolean isInfoEnabled() {
		return this.level.intValue()<=Level.INFO.intValue();
	}
	@Override
	public void info(final String _message) {
		if(isInfoEnabled()){
			this.stream.println(_message);
			this.stream.println("\n");
		}
	}
	public void info(final String _message,final Object... _args) {
		if(isInfoEnabled()){
			this.stream.println(SimpleFormat.format(_message, _args));
			this.stream.println("\n");
		}
	}

	@Override
	public boolean isWarnEnabled() {
		return this.level.intValue()<=Level.WARNING.intValue();
	}
	@Override
	public void warning(final String _message) {
		if(isWarnEnabled()){
			this.stream.println(_message);
			this.stream.println("\n");
		}
	}
	public void warning(final String _message,final Object... _args) {
		if(isWarnEnabled()){
			this.stream.println(SimpleFormat.format(_message, _args));
			this.stream.println("\n");
		}
	}

	@Override
	public boolean isErrorEnabled() {
		return this.level.intValue()<=Level.SEVERE.intValue();
	}
	@Override
	public void error(final String _message) {
		if(isErrorEnabled()){
			this.stream.println(_message);
			this.stream.println("\n");
		}
	}
	@Override
	public void error(final String _message, final Throwable _throwable) {
		if(isErrorEnabled()){
			this.stream.println(_message);
			this.stream.println("\n");
			this.stream.println(Stringify.toString(_throwable));
			this.stream.println("\n");
		}
	}
	public void error(final String _message, final Throwable _throwable,final Object... _args) {
		if(isErrorEnabled()){
			this.stream.println(SimpleFormat.format(_message, _args));
			this.stream.println("\n");
			if(_throwable!=null){
				this.stream.println(Stringify.toString(_throwable));
				this.stream.println("\n");
			}
		}
	}
	@Override
	public void error(final Throwable _throwable) {
		if(isErrorEnabled()){
			this.stream.println(Stringify.toString(_throwable));
			this.stream.println("\n");
		}
	}
}
