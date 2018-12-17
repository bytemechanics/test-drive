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
package org.bytemechanics.testdrive.surefire;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.apache.maven.surefire.booter.Command;
import org.apache.maven.surefire.booter.CommandReader;
import org.apache.maven.surefire.providerapi.AbstractProvider;
import org.apache.maven.surefire.providerapi.ProviderParameters;
import org.apache.maven.surefire.report.ConsoleOutputCapture;
import org.apache.maven.surefire.report.ConsoleOutputReceiver;
import org.apache.maven.surefire.report.ReporterException;
import org.apache.maven.surefire.report.ReporterFactory;
import org.apache.maven.surefire.report.RunListener;
import org.apache.maven.surefire.suite.RunResult;
import org.apache.maven.surefire.testset.TestSetFailedException;
import org.apache.maven.surefire.util.RunOrderCalculator;
import org.apache.maven.surefire.util.ScanResult;
import org.apache.maven.surefire.util.TestsToRun;
import org.bytemechanics.testdrive.Specification;
import org.bytemechanics.testdrive.TestDriveRunner;
import org.bytemechanics.testdrive.runners.DefaultTestDriveRunner;
import org.bytemechanics.testdrive.surefire.listener.TestDriveListener;
import org.bytemechanics.testdrive.surefire.utils.TestDriveLogger;

/**
 * TestDrive provider for maven surefire. This is the main class to make maven surefire work with TestDrive
 * @see AbstractProvider
 * @author afarre
 * @since 0.3.0
 */
public class TestDriveProvider extends AbstractProvider{

	private final ClassLoader testClassLoader;
    private final ProviderParameters providerParameters;
    private final RunOrderCalculator runOrderCalculator;
    private final ScanResult scanResult;
    private final CommandReader commandsReader;
	private final TestDriveLogger logger;
	private TestsToRun testsToRun;

	
	public TestDriveProvider(final ProviderParameters _parameters){
		this.commandsReader = _parameters.isInsideFork() ? CommandReader.getReader().setShutdown( _parameters.getShutdown() ) : null;
        this.providerParameters = _parameters;
        this.testClassLoader = _parameters.getTestClassLoader();
        this.scanResult = _parameters.getScanResult();
        this.runOrderCalculator = _parameters.getRunOrderCalculator();
        this.logger=new TestDriveLogger(_parameters.getConsoleLogger());
		this.testsToRun=null;
	}
	
	/** @see AbstractProvider#getSuites() */
	@Override
	public Iterable<Class<?>> getSuites() {
		return scanClassPath()
					.map(tests -> (Iterable<Class<?>>)tests)
					.orElse(Collections.emptyList());
	}
	
	/**
	 * Return an optional list of tests to run
	 * @return an optional of TestsToRun
	 * @see Optional
	 * @see TestsToRun
	 * @since 0.3.0
	 */
	protected Optional<TestsToRun> scanClassPath() {
		return Optional.ofNullable(this.scanResult)
						.map(result -> result.applyFilter(Specification.class::isAssignableFrom, testClassLoader))
						.map(this.runOrderCalculator::orderTestClasses);
	}

	
	/** @see AbstractProvider#invoke(java.lang.Object) */
	@Override
	public RunResult invoke(final Object _forkTestSet) throws TestSetFailedException, ReporterException, InvocationTargetException {

		RunResult reply;

        final ReporterFactory reporterFactory = providerParameters.getReporterFactory();
		try{
			//Create reporter
	        final RunListener reporter = reporterFactory.createReporter();
			//Initiate capture
	        ConsoleOutputCapture.startCapture((ConsoleOutputReceiver)reporter);
			//Ensure tests to run
			ensureTestsToRun(_forkTestSet);
			//Prepare commands reader
            if(this.commandsReader!=null){
                registerShutdownListener( testsToRun );
                this.commandsReader.awaitStarted();
            }
			//Create runner
			final TestDriveRunner runner=new DefaultTestDriveRunner(this.providerParameters.getSkipAfterFailureCount());
			//add listener to runner
			runner.registerListener(new TestDriveListener(reporter,this.logger));
			//Evaluate
			runner.completeStream(specStream(testsToRun))
					.count();
        }finally{
            reply = reporterFactory.close();
        }
		
		return reply;
	}
	
	private void ensureTestsToRun(final Object _forkTestSet) throws TestSetFailedException{
		
		if ( this.testsToRun == null ){
			if (_forkTestSet instanceof TestsToRun){
				this.testsToRun = (TestsToRun) _forkTestSet;
			}else if(_forkTestSet instanceof Class){
				this.testsToRun = TestsToRun.fromClass((Class<?>)_forkTestSet);
			}else{
				this.testsToRun = scanClassPath()
									.orElseGet(() -> new TestsToRun(Collections.emptySet()));
			}
		}
	}
	
	private Stream<Class<? extends Specification>> specStream(final TestsToRun _testsToRun){
		return StreamSupport.stream(_testsToRun.spliterator(), false)
							.filter(Specification.class::isAssignableFrom)
							.map(clazz -> (Class<? extends Specification>)clazz);
	}
	
	private void registerShutdownListener( final TestsToRun _testsToRun ){
        this.commandsReader.addShutdownListener((Command command) -> _testsToRun.markTestSetFinished());
    }
}
