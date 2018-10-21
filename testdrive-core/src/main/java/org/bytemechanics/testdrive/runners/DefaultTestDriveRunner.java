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
package org.bytemechanics.testdrive.runners;

import java.lang.reflect.Method;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Stream;
import org.bytemechanics.testdrive.Specification;
import org.bytemechanics.testdrive.TestDriveRunner;
import org.bytemechanics.testdrive.adapter.Result;
import org.bytemechanics.testdrive.annotations.Skip;
import org.bytemechanics.testdrive.annotations.Test;
import org.bytemechanics.testdrive.exceptions.AssertException;
import org.bytemechanics.testdrive.internal.commons.string.SimpleFormat;
import org.bytemechanics.testdrive.listeners.EvaluationListener;
import org.bytemechanics.testdrive.listeners.ExecutionListener;
import org.bytemechanics.testdrive.listeners.SpecificationListener;
import org.bytemechanics.testdrive.listeners.TestListener;
import org.bytemechanics.testdrive.runners.beans.EvaluationBean;
import org.bytemechanics.testdrive.runners.beans.ResultBean;
import org.bytemechanics.testdrive.runners.beans.SpecificationBean;
import org.bytemechanics.testdrive.runners.beans.TestBean;


/**
 *
 * @author afarre
 */
public class DefaultTestDriveRunner implements TestDriveRunner{

	private Function<SpecificationBean,SpecificationBean> startSpecification;
	private Function<TestBean,TestBean> startTest;
	private Function<EvaluationBean,EvaluationBean> startEvaluation;
	private Function<EvaluationBean,EvaluationBean> endEvaluation;
	private Function<TestBean,TestBean> endTest;
	private Function<SpecificationBean,SpecificationBean> endSpecification;
	
	public DefaultTestDriveRunner(){
		this.startSpecification=(SpecificationBean specification) -> specification;
		this.startTest=(TestBean test) -> test;
		this.startEvaluation=(EvaluationBean evaluation) -> evaluation;
		this.endEvaluation=(EvaluationBean evaluation) -> evaluation;
		this.endTest=(TestBean test) -> test;
		this.endSpecification=(SpecificationBean specification) -> specification;
	}

	
	@Override
	public <T extends ExecutionListener> void registerListener(final T _listener) {
		this.startSpecification=Optional.ofNullable(_listener)
											.filter(SpecificationListener.class::isInstance)
											.map(listener -> (SpecificationListener)listener)
											.map(listener -> ((Function<SpecificationBean,SpecificationBean>)listener::startSpecification))
											.orElse(this.startSpecification);
		this.endSpecification=Optional.ofNullable(_listener)
											.filter(SpecificationListener.class::isInstance)
											.map(listener -> (SpecificationListener)listener)
											.map(listener -> (Function<SpecificationBean,SpecificationBean>)((SpecificationBean spec) -> listener.endSpecification(spec,spec.getSpecificationResult())))
											.orElse(this.endSpecification);
		this.startTest=Optional.ofNullable(_listener)
											.filter(TestListener.class::isInstance)
											.map(listener -> (TestListener)listener)
											.map(listener -> ((Function<TestBean,TestBean>)listener::startTest))
											.orElse(this.startTest);
		this.endTest=Optional.ofNullable(_listener)
											.filter(TestListener.class::isInstance)
											.map(listener -> (TestListener)listener)
											.map(listener -> (Function<TestBean,TestBean>)((TestBean test) -> listener.endTest(test,test.getTestResult())))
											.orElse(this.endTest);
		this.startEvaluation=Optional.ofNullable(_listener)
											.filter(EvaluationListener.class::isInstance)
											.map(listener -> (EvaluationListener)listener)
											.map(listener -> ((Function<EvaluationBean,EvaluationBean>)listener::startEvaluation))
											.orElse(this.startEvaluation);
		this.endEvaluation=Optional.ofNullable(_listener)
											.filter(EvaluationListener.class::isInstance)
											.map(listener -> (EvaluationListener)listener)
											.map(listener -> (Function<EvaluationBean,EvaluationBean>)((EvaluationBean evaluation) -> listener.endEvaluation(evaluation,evaluation.getEvaluationResult())))
											.orElse(this.endEvaluation);
	}



	protected EvaluationBean evaluate(final EvaluationBean _evaluation){
		
		final EvaluationBean reply=_evaluation;
		
		if(!_evaluation.getEvaluation().skip()){
			try(ResultBean result=new ResultBean()){
				reply.setEvaluationResult(result);
				_evaluation.getSpecification()
							.executeTest(_evaluation.getTestMethod(), _evaluation.getParsedArguments());
			}catch(AssertException e){
				reply.getEvaluationResult().fail(e);
			}catch(Exception e){
				reply.getEvaluationResult().error(e);
			}
		}else{
			reply.setEvaluationResult(ResultBean.skipped(SimpleFormat.format("{}: annotated to skip",_evaluation.name())));
		}
		
		return reply;
	}
	
	protected TestBean evaluateSpecificationTest(final TestBean _test) {
		
		final TestBean reply=_test;
		
		if(!_test.getTestMethod().isAnnotationPresent(Skip.class)){
			if(_test.getEvaluations().length>0){
				try(ResultBean result=new ResultBean()){
					reply.setTestResult(result);
					AtomicInteger counter=new AtomicInteger();
					Stream.of(_test.getEvaluations())
							.map(evaluation -> new EvaluationBean(_test,counter.addAndGet(1),evaluation))
							.peek(this.startEvaluation::apply)
							.map(this::evaluate)
							.forEach(this.endEvaluation::apply);
				}catch(Exception e){
					reply.getTestResult().error(e);
				}
			}else if(_test.getTestMethodParameters().length==0){
				try(ResultBean result=new ResultBean()){
					reply.setTestResult(result);
					EvaluationBean eval=this.startEvaluation
												.andThen(this::evaluate)
												.andThen(this.endEvaluation)
												.apply(new EvaluationBean(_test));
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
	protected SpecificationBean evaluateSpecification(final SpecificationBean _specification) {
		
		SpecificationBean reply=_specification;

		if(!reply.getSpecificationClass().isAnnotationPresent(Skip.class)){
			try(ResultBean result=new ResultBean()){
				reply.setSpecificationResult(result);
				Stream.of(_specification.getSpecificationClass().getMethods())
						.filter(method -> method.isAnnotationPresent(Test.class))
						.map(method -> new TestBean(_specification, method))
						.peek(this.startTest::apply)
						.map(this::evaluateSpecificationTest)
						.forEach(this.endTest::apply);
			}catch(Exception e){
				reply.getSpecificationResult().error(e);
			}
		}else{
			reply.setSpecificationResult(ResultBean.skipped(SimpleFormat.format("{}: class has marked with skip annotation",reply.name())));
		}
		
		return reply;
	}

	@Override
	public Result evaluateSpecification(final Class<? extends Specification> _specificationClass) {
		return Optional.ofNullable(_specificationClass)
						.map(SpecificationBean::new)
						.map(this.startSpecification.andThen(this::evaluateSpecification).andThen(this.endSpecification)::apply)
						.map(SpecificationBean::getSpecificationResult)
						.orElse(null);
	}

	@Override
	public Result evaluateSpecificationTest(final Class<? extends Specification> _specificationClass,final Method _method) {
		return Optional.ofNullable(_specificationClass)
						.map(SpecificationBean::new)
						.filter(spec -> _method!=null)
						.map(spec -> new TestBean(spec, _method))
						.map(this.startTest.andThen(this::evaluateSpecificationTest).andThen(this.endTest)::apply)
						.map(TestBean::getTestResult)
						.orElse(null);
	}
	
	@Override
	public void evaluateStream(final Stream<Class<? extends Specification>> _specifications) {
		_specifications.forEach(this::evaluateSpecification);
	}

}
