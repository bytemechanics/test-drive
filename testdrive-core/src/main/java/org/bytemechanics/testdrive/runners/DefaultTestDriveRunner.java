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
import java.util.function.Consumer;
import java.util.stream.Stream;
import org.bytemechanics.testdrive.Specification;
import org.bytemechanics.testdrive.TestDriveRunner;
import org.bytemechanics.testdrive.annotations.Test;
import org.bytemechanics.testdrive.listeners.EvaluationListener;
import org.bytemechanics.testdrive.listeners.ExecutionListener;
import org.bytemechanics.testdrive.listeners.SpecificationListener;
import org.bytemechanics.testdrive.listeners.TestListener;
import org.bytemechanics.testdrive.runners.beans.EvaluationBean;
import org.bytemechanics.testdrive.runners.beans.SpecificationBean;
import org.bytemechanics.testdrive.runners.beans.TestBean;


/**
 *
 * @author afarre
 */
public class DefaultTestDriveRunner implements TestDriveRunner{

	private Optional<SpecificationListener> specificationListener;
	private Optional<TestListener> testListener;
	private Optional<EvaluationListener> evaluationListener;
	
	private Consumer<SpecificationBean> startSpecification;
	private Consumer<TestBean> startTest;
	private Consumer<EvaluationBean> startEvaluation;
	private Consumer<EvaluationBean> endEvaluation;
	private Consumer<TestBean> endTest;
	private Consumer<SpecificationBean> endSpecification;
	
	public DefaultTestDriveRunner(){
		this.specificationListener=Optional.empty();
		this.testListener=Optional.empty();
		this.evaluationListener=Optional.empty();
	}

	
	@Override
	public <T extends ExecutionListener> void registerListener(final T _listener) {
		this.startSpecification=Optional.ofNullable(_listener)
											.filter(SpecificationListener.class::isInstance)
											.map(listener -> (SpecificationListener)listener)
											.map(listener -> ((Consumer<SpecificationBean>)listener::startSpecification))
											.orElse((SpecificationBean specification) -> {});
		this.endSpecification=Optional.ofNullable(_listener)
											.filter(SpecificationListener.class::isInstance)
											.map(listener -> (SpecificationListener)listener)
											.map(listener -> (Consumer<SpecificationBean>)((SpecificationBean spec) -> listener.endSpecification(spec,spec.getResult())))
											.orElse((SpecificationBean specification) -> {});
		this.startTest=Optional.ofNullable(_listener)
											.filter(TestListener.class::isInstance)
											.map(listener -> (TestListener)listener)
											.map(listener -> ((Consumer<TestBean>)listener::startTest))
											.orElse((TestBean test) -> {});
		this.endTest=Optional.ofNullable(_listener)
											.filter(TestListener.class::isInstance)
											.map(listener -> (TestListener)listener)
											.map(listener -> (Consumer<TestBean>)((TestBean test) -> listener.endTest(test,test.getResult())))
											.orElse((TestBean test) -> {});
		this.startEvaluation=Optional.ofNullable(_listener)
											.filter(EvaluationListener.class::isInstance)
											.map(listener -> (EvaluationListener)listener)
											.map(listener -> ((Consumer<EvaluationBean>)listener::startEvaluation))
											.orElse((EvaluationBean evaluation) -> {});
		this.endEvaluation=Optional.ofNullable(_listener)
											.filter(EvaluationListener.class::isInstance)
											.map(listener -> (EvaluationListener)listener)
											.map(listener -> (Consumer<EvaluationBean>)((EvaluationBean evaluation) -> listener.endEvaluation(evaluation,evaluation.getResult())))
											.orElse((EvaluationBean evaluation) -> {});
	}



	protected SpecificationBean evaluateSpecification(final SpecificationBean _specification) {
		
		Stream.of(_specification.getSpecificationClass().getMethods())
				.filter(method -> method.isAnnotationPresent(Test.class))
				.map(method -> new TestBean(_specification, method))
				.peek(this.startTest::accept)
				.map(this::evaluateSpecificationTest)
				.forEach(this.endTest::accept);
		
		return _specification;
	}
	
	protected TestBean evaluateSpecificationTest(final TestBean _test) {
		
		if(_test.getEvaluations().length>0){
			AtomicInteger counter=new AtomicInteger();
			Stream.of(_test.getEvaluations())
					.map(evaluation -> new EvaluationBean(_test,counter.addAndGet(1),evaluation))
					.peek(this.startEvaluation::accept)
					//Todo do something to evaluate test
					.forEach(this.endEvaluation::accept);
		}else if(_test.getTestMethodParameters().length==0){
			this.startEvaluation
					//Todo do something to evaluate test
					.andThen(this.endEvaluation)
					.accept(new EvaluationBean(_test));
		}else{
			//Test skipped no evaluations
		}
		
		return _test;
	}

	@Override
	public void evaluateSpecification(final Class<? extends Specification> _specificationClass) {
		Optional.ofNullable(_specificationClass)
				.map(SpecificationBean::new)
				.ifPresent(this.startSpecification.andThen(this::evaluateSpecification).andThen(this.endSpecification)::accept);
	}

	@Override
	public void evaluateSpecificationTest(final Class<? extends Specification> _specificationClass,final Method _method) {
		Optional.ofNullable(_specificationClass)
				.map(SpecificationBean::new)
				.filter(spec -> _method!=null)
				.map(spec -> new TestBean(spec, _method))
				.ifPresent(this.startTest.andThen(this::evaluateSpecificationTest).andThen(this.endTest)::accept);
	}
	
	@Override
	public void evaluateStream(final Stream<Class<? extends Specification>> _specifications) {
		_specifications
				.map(SpecificationBean::new)
				.peek(this.startSpecification::accept)
				.map(this::evaluateSpecification)
				.forEach(this.endSpecification::accept);
	}

}
