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
import java.util.LinkedList;
import java.util.Queue;
import org.apache.maven.surefire.report.ConsoleStream;
import org.apache.maven.surefire.report.ReportEntry;
import org.apache.maven.surefire.report.RunListener;
import org.apache.maven.surefire.report.TestSetReportEntry;
import org.bytemechanics.testdrive.ResultStatus;
import org.bytemechanics.testdrive.Specification;
import org.bytemechanics.testdrive.adapter.EvaluationId;
import org.bytemechanics.testdrive.adapter.Result;
import org.bytemechanics.testdrive.adapter.SpecificationId;
import org.bytemechanics.testdrive.adapter.TestId;
import org.bytemechanics.testdrive.surefire.test.commons.functional.Tuple;
import org.bytemechanics.testdrive.surefire.utils.TestDriveLogger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author afarre
 */
public class TestDriveListenerTest {

	private class DummieSpec implements Specification{

		public void test(String a,Integer b){}
	}
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
	private class RunListenerDummie implements RunListener{

		public Queue<Tuple<String,ReportEntry>> calls=new LinkedList<>(); 
		
		@Override
		public void testSetStarting(TestSetReportEntry report) {
			calls.add(Tuple.of("testSetStarting", report));
		}
		@Override
		public void testSetCompleted(TestSetReportEntry report) {
			calls.add(Tuple.of("testSetCompleted", report));
		}
		@Override
		public void testStarting(ReportEntry report) {
			calls.add(Tuple.of("testStarting", report));
		}
		@Override
		public void testSucceeded(ReportEntry report) {
			calls.add(Tuple.of("testSucceeded", report));
		}
		@Override
		public void testAssumptionFailure(ReportEntry report) {
			calls.add(Tuple.of("testAssumptionFailure", report));
		}
		@Override
		public void testError(ReportEntry report) {
			calls.add(Tuple.of("testError", report));
		}
		@Override
		public void testFailed(ReportEntry report) {
			calls.add(Tuple.of("testFailed", report));
		}
		@Override
		public void testSkipped(ReportEntry report) {
			calls.add(Tuple.of("testSkipped", report));
		}
		@Override
		public void testExecutionSkippedByUser() {
			calls.add(Tuple.of("testExecutionSkippedByUser", null));
		}
	}
	
	
	private ConsoleStreamDummmie consoleStream; 
	private TestDriveLogger testDriveLogger; 
	private RunListenerDummie runListener;
	private TestDriveListener instance;
	
	@Before
	public void setUp() {
		this.consoleStream=new ConsoleStreamDummmie();
		this.testDriveLogger=new TestDriveLogger(consoleStream);
		this.testDriveLogger.setLevel(TestDriveLogger.Level.DEBUG);
		this.runListener=new RunListenerDummie();
		this.instance=new TestDriveListener(runListener, testDriveLogger);
	}
	
	@After
	public void tearDown() {
		this.consoleStream=null;
		this.testDriveLogger=null;
		this.runListener=null;
		this.instance=null;
	}

	@Test
	public void testStartSpecification() {
		System.out.println("TestDriveListenerTest >> testStartSpecification");
		
		SpecificationId spec=getSpecificationId();
		
		instance.startSpecification(spec);
		Assert.assertEquals(spec.name()+" >> begin\n", this.consoleStream.calls.poll());
		Assert.assertEquals("testSetStarting", this.runListener.calls.peek().left());
		Assert.assertEquals(spec.getSpecificationClass().getName(), this.runListener.calls.peek().right().getSourceName());
		Assert.assertEquals(spec.name(), this.runListener.calls.poll().right().getName());
	}

	@Test
	public void testStartSpecificationSetup() {
		System.out.println("TestDriveListenerTest >> testStartSpecificationSetup");
		
		SpecificationId spec=getSpecificationId();
			
		instance.startSpecificationSetup(spec);
		Assert.assertEquals(spec.name()+" >> setup >> begin\n", this.consoleStream.calls.poll());
		Assert.assertNull(this.runListener.calls.peek());
	}

	@Test
	public void testEndSpecificationSetup() {
		System.out.println("TestDriveListenerTest >> testEndSpecificationSetup");
		
		SpecificationId spec=getSpecificationId();
		
		instance.endSpecificationSetup(spec);
		Assert.assertEquals(spec.name()+" >> setup >> end\n", this.consoleStream.calls.poll());
		Assert.assertNull(this.runListener.calls.peek());
	}

	@Test
	public void testStartTest() {
		System.out.println("TestDriveListenerTest >> testStartTest");
		
		TestId test=getTestId();
		
		instance.startTest(test);
		Assert.assertEquals(test.specName()+" >> "+test.name()+" >> begin\n", this.consoleStream.calls.poll());
		Assert.assertNull(this.runListener.calls.peek());
	}

	@Test
	public void testStartTestSetup() {
		System.out.println("TestDriveListenerTest >> testStartTestSetup");
		
		TestId test=getTestId();
		
		instance.startTestSetup(test);
		Assert.assertEquals(test.specName()+" >> "+test.name()+" >> setup >> begin\n", this.consoleStream.calls.poll());
		Assert.assertNull(this.runListener.calls.peek());
	}

	@Test
	public void testEndTestSetup() {
		System.out.println("TestDriveListenerTest >> testEndTestSetup");
		
		TestId test=getTestId();
		
		instance.endTestSetup(test);
		Assert.assertEquals(test.specName()+" >> "+test.name()+" >> setup >> end\n", this.consoleStream.calls.poll());
		Assert.assertNull(this.runListener.calls.peek());
	}

	@Test
	public void testStartEvaluation() {
		System.out.println("TestDriveListenerTest >> testStartEvaluation");
		
		EvaluationId evaluation=getEvaluationId();
		
		instance.startEvaluation(evaluation);
		Assert.assertEquals(evaluation.specName()+" >> "+evaluation.name()+" >> begin\n", this.consoleStream.calls.poll());
		Assert.assertNull(this.runListener.calls.peek());
	}

	@Test
	public void testDrivenTestGivenBegin() {
		System.out.println("TestDriveListenerTest >> testDrivenTestGivenBegin");
		
		EvaluationId evaluation=getEvaluationId();
		
		instance.drivenTestGivenBegin(evaluation);
		Assert.assertEquals(evaluation.specName()+" >> "+evaluation.name()+" >> test-driven >> given >> begin\n", this.consoleStream.calls.poll());
		Assert.assertNull(this.runListener.calls.peek());
	}

	@Test
	public void testDrivenTestGivenEnd() {
		System.out.println("TestDriveListenerTest >> testDrivenTestGivenEnd");
		
		EvaluationId evaluation=getEvaluationId();
		
		instance.drivenTestGivenEnd(evaluation);
		Assert.assertEquals(evaluation.specName()+" >> "+evaluation.name()+" >> test-driven >> given >> end\n", this.consoleStream.calls.poll());
		Assert.assertNull(this.runListener.calls.peek());
	}

	@Test
	public void testDrivenTestWhenBegin() {
		System.out.println("TestDriveListenerTest >> testDrivenTestWhenBegin");
		
		EvaluationId evaluation=getEvaluationId();
		
		instance.drivenTestWhenBegin(evaluation);
		Assert.assertEquals(evaluation.specName()+" >> "+evaluation.name()+" >> test-driven >> when >> begin\n", this.consoleStream.calls.poll());
		Assert.assertNull(this.runListener.calls.peek());
	}

	@Test
	public void testDrivenTestWhenEnd() {
		System.out.println("TestDriveListenerTest >> testDrivenTestWhenEnd");
		
		EvaluationId evaluation=getEvaluationId();
		
		instance.drivenTestWhenEnd(evaluation);
		Assert.assertEquals(evaluation.specName()+" >> "+evaluation.name()+" >> test-driven >> when >> end\n", this.consoleStream.calls.poll());
		Assert.assertNull(this.runListener.calls.peek());
	}

	@Test
	public void testDrivenTestThenBegin() {
		System.out.println("TestDriveListenerTest >> testDrivenTestThenBegin");
		
		EvaluationId evaluation=getEvaluationId();
		
		instance.drivenTestThenBegin(evaluation);
		Assert.assertEquals(evaluation.specName()+" >> "+evaluation.name()+" >> test-driven >> then >> begin\n", this.consoleStream.calls.poll());
		Assert.assertNull(this.runListener.calls.peek());
	}

	@Test
	public void testDrivenTestThenEnd() {
		System.out.println("TestDriveListenerTest >> testDrivenTestThenEnd");
		
		EvaluationId evaluation=getEvaluationId();
		
		instance.drivenTestThenEnd(evaluation);
		Assert.assertEquals(evaluation.specName()+" >> "+evaluation.name()+" >> test-driven >> then >> end\n", this.consoleStream.calls.poll());
		Assert.assertNull(this.runListener.calls.peek());
	}

	@Test
	public void testDrivenTestCleanBegin() {
		System.out.println("TestDriveListenerTest >> testDrivenTestCleanBegin");
		
		EvaluationId evaluation=getEvaluationId();
		
		instance.drivenTestCleanBegin(evaluation);
		Assert.assertEquals(evaluation.specName()+" >> "+evaluation.name()+" >> test-driven >> clean >> begin\n", this.consoleStream.calls.poll());
		Assert.assertNull(this.runListener.calls.peek());
	}

	@Test
	public void testDrivenTestCleanEnd() {
		System.out.println("TestDriveListenerTest >> testDrivenTestCleanEnd");
		
		EvaluationId evaluation=getEvaluationId();
		
		instance.drivenTestCleanEnd(evaluation);
		Assert.assertEquals(evaluation.specName()+" >> "+evaluation.name()+" >> test-driven >> clean >> end\n", this.consoleStream.calls.poll());
		Assert.assertNull(this.runListener.calls.peek());
	}

	@Test
	public void testEndEvaluation() {
		System.out.println("TestDriveListenerTest >> testEndEvaluation");
		
		EvaluationId evaluation=getEvaluationId();
		Result result=getResult(ResultStatus.SUCCESS);
		instance.endEvaluation(evaluation,result);
		Assert.assertEquals(evaluation.specName()+" >> "+evaluation.name()+" >> "+result.getLog()+"\n", this.consoleStream.calls.poll());
		Assert.assertEquals("testSucceeded", this.runListener.calls.peek().left());
		Assert.assertEquals(evaluation.getSpecificationClass().getName(), this.runListener.calls.peek().right().getSourceName());	
		Assert.assertEquals(evaluation.getTestMethod().getName(), this.runListener.calls.peek().right().getName());	
		Assert.assertEquals(evaluation.name(), this.runListener.calls.peek().right().getGroup());	
		Assert.assertEquals(result.getMessage(), this.runListener.calls.peek().right().getMessage());	
		Assert.assertEquals((Integer)((Long)result.getDuration().toMillis()).intValue(), this.runListener.calls.poll().right().getElapsed());	

		result=getResult(ResultStatus.FAILURE);
		instance.endEvaluation(evaluation,result);
		Assert.assertEquals(evaluation.specName()+" >> "+evaluation.name()+" >> "+result.getLog()+"\n", this.consoleStream.calls.poll());
		Assert.assertEquals("testFailed", this.runListener.calls.peek().left());
		Assert.assertEquals(evaluation.getSpecificationClass().getName(), this.runListener.calls.peek().right().getSourceName());	
		Assert.assertEquals(evaluation.getTestMethod().getName(), this.runListener.calls.peek().right().getName());	
		Assert.assertEquals(evaluation.name(), this.runListener.calls.peek().right().getGroup());	
		Assert.assertEquals(result.getMessage(), this.runListener.calls.peek().right().getMessage());	
		Assert.assertNotNull(this.runListener.calls.peek().right().getStackTraceWriter());	
		Assert.assertEquals((Integer)((Long)result.getDuration().toMillis()).intValue(), this.runListener.calls.poll().right().getElapsed());	

		result=getResult(ResultStatus.ERROR);
		instance.endEvaluation(evaluation,result);
		Assert.assertNotNull(this.consoleStream.calls.poll());
		Assert.assertEquals(evaluation.specName()+" >> "+evaluation.name()+" >> "+result.getLog()+"\n", this.consoleStream.calls.poll());
		Assert.assertEquals("testError", this.runListener.calls.peek().left());
		Assert.assertEquals(evaluation.getSpecificationClass().getName(), this.runListener.calls.peek().right().getSourceName());	
		Assert.assertEquals(evaluation.getTestMethod().getName(), this.runListener.calls.peek().right().getName());	
		Assert.assertEquals(evaluation.name(), this.runListener.calls.peek().right().getGroup());	
		Assert.assertEquals(result.getMessage(), this.runListener.calls.peek().right().getMessage());	
		Assert.assertNotNull(this.runListener.calls.peek().right().getStackTraceWriter());	
		Assert.assertEquals((Integer)((Long)result.getDuration().toMillis()).intValue(), this.runListener.calls.poll().right().getElapsed());	

		result=getResult(ResultStatus.SKIPPED);
		instance.endEvaluation(evaluation,result);
		Assert.assertEquals(evaluation.specName()+" >> "+evaluation.name()+" >> "+result.getLog()+"\n", this.consoleStream.calls.poll());
		Assert.assertEquals("testSkipped", this.runListener.calls.peek().left());
		Assert.assertEquals(evaluation.getSpecificationClass().getName(), this.runListener.calls.peek().right().getSourceName());	
		Assert.assertEquals(evaluation.getTestMethod().getName(), this.runListener.calls.peek().right().getName());	
		Assert.assertEquals(evaluation.name(), this.runListener.calls.peek().right().getGroup());	
		Assert.assertEquals(result.getMessage(), this.runListener.calls.peek().right().getMessage());	
		Assert.assertEquals((Integer)((Long)result.getDuration().toMillis()).intValue(), this.runListener.calls.poll().right().getElapsed());	
	}

	@Test
	public void testStartTestCleanup() {
		System.out.println("TestDriveListenerTest >> testStartTestCleanup");
		
		TestId test=getTestId();
		
		instance.startTestCleanup(test);
		Assert.assertEquals(test.specName()+" >> "+test.name()+" >> cleanup >> begin\n", this.consoleStream.calls.poll());
		Assert.assertNull(this.runListener.calls.peek());
	}

	@Test
	public void testEndTestCleanup() {
		System.out.println("TestDriveListenerTest >> testEndTestCleanup");
		
		TestId test=getTestId();
		
		instance.endTestCleanup(test);
		Assert.assertEquals(test.specName()+" >> "+test.name()+" >> cleanup >> end\n", this.consoleStream.calls.poll());
		Assert.assertNull(this.runListener.calls.peek());
	}

	@Test
	public void testEndTest() {
		System.out.println("TestDriveListenerTest >> testEndTest");
		
		TestId test=getTestId();
		Result result=getResult();
		
		instance.endTest(test,result);
		Assert.assertEquals(test.specName()+" >> "+test.name()+" >> "+result.getLog()+"\n", this.consoleStream.calls.poll());
		Assert.assertNull(this.runListener.calls.peek());
	}

	@Test
	public void testStartSpecificationCleanup() {
		System.out.println("TestDriveListenerTest >> testStartSpecificationCleanup");
		
		SpecificationId spec=getSpecificationId();
			
		instance.startSpecificationCleanup(spec);
		Assert.assertEquals(spec.name()+" >> cleanup >> begin\n", this.consoleStream.calls.poll());
		Assert.assertNull(this.runListener.calls.peek());
	}

	@Test
	public void testEndSpecificationCleanup() {
		System.out.println("TestDriveListenerTest >> testEndSpecificationCleanup");
		
		SpecificationId spec=getSpecificationId();
			
		instance.endSpecificationCleanup(spec);
		Assert.assertEquals(spec.name()+" >> cleanup >> end\n", this.consoleStream.calls.poll());
		Assert.assertNull(this.runListener.calls.peek());
	}

	@Test
	public void testEndSpecification() {
		System.out.println("TestDriveListenerTest >> testEndSpecification");
		
		SpecificationId spec=getSpecificationId();
		Result result=getResult();
		
		instance.startSpecification(spec);
		instance.endSpecification(spec,result);
		 this.consoleStream.calls.poll();
		Assert.assertEquals(spec.name()+" >> "+result.getLog()+"\n", this.consoleStream.calls.poll());
		 this.runListener.calls.poll();
		Assert.assertEquals("testSetCompleted", this.runListener.calls.peek().left());
		Assert.assertEquals(spec.getSpecificationClass().getName(), this.runListener.calls.peek().right().getSourceName());
		Assert.assertEquals(spec.name(), this.runListener.calls.poll().right().getName());
	}
	
	
	protected SpecificationId getSpecificationId(){
		return getEvaluationId();
	}
	protected TestId getTestId(){
		return getEvaluationId();
	}
	protected EvaluationId getEvaluationId(){
		
		return new EvaluationId() {
			@Override
			public Class<? extends Specification> getSpecificationClass() {
				return DummieSpec.class;
			}
			@Override
			public String getSpecificationName() {
				return "dummie-name";
			}
			@Override
			public String getSpecificationGroup() {
				return "dummie-group";
			}

			@Override
			public Method getTestMethod() {
				try {
					return DummieSpec.class.getMethod("test",new Class[]{String.class,Integer.class});
				} catch (NoSuchMethodException | SecurityException ex) {
					throw new RuntimeException(ex);
				}
			}

			@Override
			public Class[] getTestMethodParameters() {
				return new Class[]{String.class,Integer.class};
			}

			@Override
			public String getTestName() {
				return "test-name";
			}

			@Override
			public int getEvaluationCounter() {
				return 1;
			}

			@Override
			public String getEvaluationName() {
				return "evaluation-name";
			}

			@Override
			public String[] getEvaluationArguments() {
				return new String[]{"a","1"};
			}
		};
	}
	
	private Result getResult(){
		return getResult(ResultStatus.SUCCESS);
	}
	private Result getResult(final ResultStatus _status){
		return new Result() {
			@Override
			public Duration getDuration() {
				return Duration.ZERO;
			}

			@Override
			public ResultStatus getStatus() {
				return _status;
			}

			@Override
			public String getMessage() {
				return "result-message";
			}

			@Override
			public Throwable getError() {
				return new RuntimeException("error-message");
			}
		};
	}
}
