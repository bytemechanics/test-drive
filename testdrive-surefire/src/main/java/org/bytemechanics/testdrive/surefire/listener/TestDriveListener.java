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
package org.bytemechanics.testdrive.surefire.listener;

import org.apache.maven.surefire.report.PojoStackTraceWriter;
import org.apache.maven.surefire.report.RunListener;
import org.apache.maven.surefire.report.SimpleReportEntry;
import org.bytemechanics.testdrive.adapter.EvaluationId;
import org.bytemechanics.testdrive.adapter.Result;
import org.bytemechanics.testdrive.adapter.SpecificationId;
import org.bytemechanics.testdrive.adapter.TestId;
import org.bytemechanics.testdrive.listeners.DrivenTestListener;
import org.bytemechanics.testdrive.listeners.EvaluationListener;
import org.bytemechanics.testdrive.listeners.SpecificationListener;
import org.bytemechanics.testdrive.listeners.TestListener;

/**
 *
 * @author afarre
 */
public class TestDriveListener implements TestListener,SpecificationListener,EvaluationListener,DrivenTestListener{
	
	private final RunListener reporter;
	
	public TestDriveListener(final RunListener _reporter){
		this.reporter=_reporter;
	}

	@Override
	public <T extends TestId> void startTest(T _specificationTest) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public <T extends TestId> void startTestSetup(T _specification) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public <T extends TestId> void endTestSetup(T _specification) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public <T extends TestId> void startTestCleanup(T _specification) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public <T extends TestId> void endTestCleanup(T _specification) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public <T extends TestId> void endTest(T _specificationTest, Result _result) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public <T extends SpecificationId> void startSpecification(final T _specification) {
		this.reporter.testSetStarting(
							new SimpleReportEntry(_specification.getSpecificationClass().getName(), _specification.name(), "Specification >> Begin"));
	}

	@Override
	public <T extends SpecificationId> void startSpecificationSetup(final T _specification) {
	}

	@Override
	public <T extends SpecificationId> void endSpecificationSetup(final T _specification) {
	}

	@Override
	public <T extends SpecificationId> void startSpecificationCleanup(final T _specification) {
	}

	@Override
	public <T extends SpecificationId> void endSpecificationCleanup(final T _specification) {
	}

	@Override
	public <T extends SpecificationId> void endSpecification(final T _specification,final Result _result) {
		this.reporter.testSetCompleted(
							new SimpleReportEntry(_specification.getSpecificationClass().getName(), _specification.name(), "Specification >> End >> "+_result.getLog()));
	}

	@Override
	public <T extends EvaluationId> void startEvaluation(T _evaluation) {
		this.reporter.testStarting(
							new SimpleReportEntry(_evaluation.getTestMethod().getName(), _evaluation.name(), "Evaluation >> Begin"));
	}

	@Override
	public <T extends EvaluationId> void endEvaluation(T _evaluation, Result _result) {
		
		switch(_result.getStatus()){
			case SUCCESS:	this.reporter.testSucceeded(
											new SimpleReportEntry(_evaluation.getTestMethod().getName(), _evaluation.name(), _result.getMessage()));
							break;
			case ERROR:		this.reporter.testError(
											SimpleReportEntry.withException(_evaluation.getTestMethod().getName(), _evaluation.name(),
													new PojoStackTraceWriter( _evaluation.getSpecificationClass().getName(),_evaluation.getTestMethod().getName(),_result.getError())));
							break;
			case FAILURE:	this.reporter.testFailed(
											SimpleReportEntry.withException(_evaluation.getTestMethod().getName(), _evaluation.name(),
													new PojoStackTraceWriter( _evaluation.getSpecificationClass().getName(),_evaluation.getTestMethod().getName(),_result.getError())));
							break;
			default:		this.reporter.testSkipped(
											SimpleReportEntry.ignored(_evaluation.getTestMethod().getName(), _evaluation.name(), _result.getMessage()));
		}
	}

	@Override
	public <T extends EvaluationId> void drivenTestGivenBegin(T _evaluation) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public <T extends EvaluationId> void drivenTestGivenEnd(T _evaluation) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public <T extends EvaluationId> void drivenTestWhenBegin(T _evaluation) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public <T extends EvaluationId> void drivenTestWhenEnd(T _evaluation) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public <T extends EvaluationId> void drivenTestThenBegin(T _evaluation) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public <T extends EvaluationId> void drivenTestThenEnd(T _evaluation) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public <T extends EvaluationId> void drivenTestCleanBegin(T _evaluation) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public <T extends EvaluationId> void drivenTestCleanEnd(T _evaluation) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
