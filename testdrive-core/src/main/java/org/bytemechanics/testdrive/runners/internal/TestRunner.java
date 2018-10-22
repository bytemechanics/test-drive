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
package org.bytemechanics.testdrive.runners.internal;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Stream;
import org.bytemechanics.testdrive.annotations.Skip;
import org.bytemechanics.testdrive.internal.commons.string.SimpleFormat;
import org.bytemechanics.testdrive.listeners.ExecutionListener;
import org.bytemechanics.testdrive.listeners.TestListener;
import org.bytemechanics.testdrive.runners.beans.EvaluationBean;
import org.bytemechanics.testdrive.runners.beans.ResultBean;
import org.bytemechanics.testdrive.runners.beans.TestBean;


/**
 *
 * @author afarre
 */
public class TestRunner extends EvaluationRunner{

	private Function<TestBean,TestBean> startTest;
	private Function<TestBean,TestBean> startTestSetup;
	private Function<TestBean,TestBean> endTestSetup;
	private Function<TestBean,TestBean> startTestCleanup;
	private Function<TestBean,TestBean> endTestCleanup;
	private Function<TestBean,TestBean> endTest;
	
	public TestRunner(){
		super();
		this.startTest=(TestBean test) -> test;
		this.endTest=(TestBean test) -> test;
	}

	
	@Override
	public <T extends ExecutionListener> void registerListener(final T _listener) {
		super.registerListener(_listener);
		this.startTest=Optional.ofNullable(_listener)
											.filter(TestListener.class::isInstance)
											.map(listener -> (TestListener)listener)
											.map(listener -> ((Function<TestBean,TestBean>)listener::startTest))
											.orElse(this.startTest);
		this.startTestSetup=Optional.ofNullable(_listener)
											.filter(TestListener.class::isInstance)
											.map(listener -> (TestListener)listener)
											.map(listener -> ((Function<TestBean,TestBean>)listener::startTestSetup))
											.orElse(this.startTestSetup);
		this.endTestSetup=Optional.ofNullable(_listener)
											.filter(TestListener.class::isInstance)
											.map(listener -> (TestListener)listener)
											.map(listener -> (Function<TestBean,TestBean>)((TestBean test) -> listener.endTestSetup(test)))
											.orElse(this.endTestSetup);
		this.startTestCleanup=Optional.ofNullable(_listener)
											.filter(TestListener.class::isInstance)
											.map(listener -> (TestListener)listener)
											.map(listener -> ((Function<TestBean,TestBean>)listener::startTestCleanup))
											.orElse(this.startTestCleanup);
		this.endTestCleanup=Optional.ofNullable(_listener)
											.filter(TestListener.class::isInstance)
											.map(listener -> (TestListener)listener)
											.map(listener -> (Function<TestBean,TestBean>)((TestBean test) -> listener.endTestCleanup(test)))
											.orElse(this.endTestCleanup);
		this.endTest=Optional.ofNullable(_listener)
											.filter(TestListener.class::isInstance)
											.map(listener -> (TestListener)listener)
											.map(listener -> (Function<TestBean,TestBean>)((TestBean test) -> listener.endTest(test,test.getTestResult())))
											.orElse(this.endTest);
	}
	
	protected TestBean executeSetup(final TestBean _test){
		this.startTestSetup.apply(_test);
		_test.getSpecification().setup();
		this.endTestSetup.apply(_test);
		return _test;
	}
	protected TestBean executeCleanup(final TestBean _test){
		this.startTestCleanup.apply(_test);
		_test.getSpecification().cleanup();
		this.endTestCleanup.apply(_test);
		return _test;
	}
	
	protected TestBean executeTest(final TestBean _test) {
		
		final TestBean reply=_test;
		
		if(!_test.getTestMethod().isAnnotationPresent(Skip.class)){
			if(_test.getEvaluations().length>0){
				try(ResultBean result=new ResultBean()){
					reply.setTestResult(result);
					AtomicInteger counter=new AtomicInteger();
					Stream.of(_test.getEvaluations())
							.map(evaluation -> new EvaluationBean(_test,counter.addAndGet(1),evaluation))
							.forEach(this::evaluate);
				}catch(Exception e){
					reply.getTestResult().error(e);
				}
			}else if(_test.getTestMethodParameters().length==0){
				try(ResultBean result=new ResultBean()){
					reply.setTestResult(result);
					this.evaluate(new EvaluationBean(_test));
				}catch(Exception e){
					reply.getTestResult().error(e);
				}
			}else{
				reply.setTestResult(ResultBean.skipped(SimpleFormat.format("{}: method has arguments and can not find any evaluation",_test.name())));
			}
		}else{
			reply.setTestResult(ResultBean.skipped(SimpleFormat.format("{}: method has marked with skip annotation",_test.name())));
		}
		
		return _test;
	}
	
	public TestBean test(final TestBean _evaluation){
		return this.startTest
					.andThen(this::executeSetup)
					.andThen(this::executeTest)
					.andThen(this::executeCleanup)
					.andThen(this.endTest)
					.apply(_evaluation);
	}
}
