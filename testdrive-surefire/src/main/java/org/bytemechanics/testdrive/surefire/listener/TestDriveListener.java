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

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.apache.maven.surefire.report.CategorizedReportEntry;
import org.apache.maven.surefire.report.PojoStackTraceWriter;
import org.apache.maven.surefire.report.ReportEntry;
import org.apache.maven.surefire.report.RunListener;
import org.apache.maven.surefire.report.SimpleReportEntry;
import org.apache.maven.surefire.report.StackTraceWriter;
import org.apache.maven.surefire.report.TestSetReportEntry;
import org.apache.maven.surefire.util.internal.ObjectUtils;
import org.bytemechanics.testdrive.adapter.EvaluationId;
import org.bytemechanics.testdrive.adapter.Result;
import org.bytemechanics.testdrive.adapter.SpecificationId;
import org.bytemechanics.testdrive.adapter.TestId;
import org.bytemechanics.testdrive.internal.commons.string.SimpleFormat;
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
	private final Map<SpecificationId,TestSetReportEntry> specs;
	
	public TestDriveListener(final RunListener _reporter){
		this.reporter=_reporter;
		this.specs=new HashMap<>();
	}

	@Override
	public <T extends SpecificationId> void startSpecification(final T _specification) {
		System.out.println(SimpleFormat.format("{} >> {}",_specification.name(),"begin"));
		final TestSetReportEntry reportEntry=new SimpleReportEntry(_specification.getSpecificationClass().getName(), _specification.name(), ObjectUtils.systemProps());
		this.specs.put(_specification, reportEntry);
		this.reporter.testSetStarting(reportEntry);
	}

	@Override
	public <T extends SpecificationId> void startSpecificationSetup(final T _specification) {
		System.out.println(SimpleFormat.format("{} >> {}",_specification.name(),"setup >> begin"));
	}
	@Override
	public <T extends SpecificationId> void endSpecificationSetup(final T _specification) {
		System.out.println(SimpleFormat.format("{} >> {}",_specification.name(),"setup >> end"));
	}


	@Override
	public <T extends TestId> void startTest(T _test) {
		System.out.println(SimpleFormat.format("{} >> {} >> {}", _test.specName(),_test.name(),"begin"));
	}

	@Override
	public <T extends TestId> void startTestSetup(T _test) {
		System.out.println(SimpleFormat.format("{} >> {} >> {}",_test.specName(),_test.name(),"setup >> begin"));
	}
	@Override
	public <T extends TestId> void endTestSetup(T _test) {
		System.out.println(SimpleFormat.format("{} >> {} >> {}",_test.specName(),_test.name(),"setup >> end"));
	}

	@Override
	public <T extends EvaluationId> void startEvaluation(T _evaluation) {
		System.out.println(SimpleFormat.format("{} >> {} >> {}",_evaluation.specName(),_evaluation.name(),"begin"));
	}

	@Override
	public <T extends EvaluationId> void drivenTestGivenBegin(T _evaluation) {
		System.out.println(SimpleFormat.format("{} >> {} >> {}",_evaluation.specName(),_evaluation.name(),"test-driven >> begin"));
	}
	@Override
	public <T extends EvaluationId> void drivenTestWhenBegin(T _evaluation) {
		System.out.println(SimpleFormat.format("{} >> {} >> {}",_evaluation.specName(),_evaluation.name(),"test-driven >> when >> begin"));
	}

	@Override
	public <T extends EvaluationId> void drivenTestWhenEnd(T _evaluation) {
		System.out.println(SimpleFormat.format("{} >> {} >> {}",_evaluation.specName(),_evaluation.name(),"test-driven >> when >> end"));
	}
	@Override
	public <T extends EvaluationId> void drivenTestThenBegin(T _evaluation) {
		System.out.println(SimpleFormat.format("{} >> {} >> {}",_evaluation.specName(),_evaluation.name(),"test-driven >> then >> begin"));
	}

	@Override
	public <T extends EvaluationId> void drivenTestThenEnd(T _evaluation) {
		System.out.println(SimpleFormat.format("{} >> {} >> {}",_evaluation.specName(),_evaluation.name(),"test-driven >> then >> end"));
	}
	@Override
	public <T extends EvaluationId> void drivenTestCleanBegin(T _evaluation) {
		System.out.println(SimpleFormat.format("{} >> {} >> {}",_evaluation.specName(),_evaluation.name(),"test-driven >> clean >> begin"));
	}

	@Override
	public <T extends EvaluationId> void drivenTestCleanEnd(T _evaluation) {
		System.out.println(SimpleFormat.format("{} >> {} >> {}",_evaluation.specName(),_evaluation.name(),"test-driven >> clean >> end"));
	}
	@Override
	public <T extends EvaluationId> void drivenTestGivenEnd(T _evaluation) {
		System.out.println(SimpleFormat.format("{} >> {} >> {}",_evaluation.specName(),_evaluation.name(),"test-driven >> end"));
	}


	@Override
	public <T extends EvaluationId> void endEvaluation(T _evaluation, Result _result) {
		
		switch(_result.getStatus()){
			//TODO
			case SUCCESS:	this.reporter.testSucceeded(
											getReport(_evaluation.getSpecificationClass(), _evaluation.getTestMethod(), _evaluation.name(),  _result.getMessage(), _result.getDuration()));
							break;
			case ERROR:		this.reporter.testError(
											getReport(_evaluation.getSpecificationClass(), _evaluation.getTestMethod(), _evaluation.name(),  _result.getMessage(),_result.getError()));
							_result.getError().printStackTrace(System.err);
							break;
			case FAILURE:	this.reporter.testFailed(
											getReport(_evaluation.getSpecificationClass(), _evaluation.getTestMethod(), _evaluation.name(),  _result.getMessage(),_result.getError()));
							break;
			default:		this.reporter.testSkipped(
											getReport(_evaluation.getSpecificationClass(), _evaluation.getTestMethod(), _evaluation.name(),  _result.getMessage(), _result.getDuration()));
		}
		System.out.println(SimpleFormat.format("{} >> {} >> {}",_evaluation.specName(),_evaluation.name(),_result.getLog()));
	}
	
	@Override
	public <T extends TestId> void startTestCleanup(T _test) {
		System.out.println(SimpleFormat.format("{} >> {} >> {}",_test.specName(),_test.name(),"cleanup >> begin"));
	}
	@Override
	public <T extends TestId> void endTestCleanup(T _test) {
		System.out.println(SimpleFormat.format("{} >> {} >> {}",_test.specName(),_test.name(),"cleanup >> end"));
	}

	@Override
	public <T extends TestId> void endTest(T _test, Result _result) {
		System.out.println(SimpleFormat.format("{{} >> {} >> {}",_test.specName(),_test.name(),_result.getLog()));
	}

	@Override
	public <T extends SpecificationId> void startSpecificationCleanup(final T _specification) {
		System.out.println(SimpleFormat.format("{} >> {}",_specification.name(),"cleanup >> begin"));
	}
	@Override
	public <T extends SpecificationId> void endSpecificationCleanup(final T _specification) {
		System.out.println(SimpleFormat.format("{} >> {}",_specification.name(),"cleanup >> end"));
	}

	@Override
	public <T extends SpecificationId> void endSpecification(final T _specification,final Result _result) {
		System.out.println(SimpleFormat.format("{} >> {}",_specification.name(),_result.getLog()));
		final TestSetReportEntry reportEntry=this.specs.get(_specification);
		this.reporter.testSetCompleted(reportEntry);
	}
	
	protected ReportEntry getReport(final Class _class,final Method _method,final String _group,final String _message,final Duration _duration){
		return CategorizedReportEntry.reportEntry(_class.getName(), _method.getName(),_group,null,((Long)_duration.toMillis()).intValue(), _message, ObjectUtils.systemProps());
	}
	protected ReportEntry getReport(final Class _class,final Method _method,final String _group,final String _message,final Throwable _error){
		final StackTraceWriter errorWriter=new PojoStackTraceWriter(_class.getName(),_method.getName(),_error);
		return CategorizedReportEntry.reportEntry(_class.getName(), _method.getName(),_group,errorWriter,0, _message, ObjectUtils.systemProps());
	}
}
