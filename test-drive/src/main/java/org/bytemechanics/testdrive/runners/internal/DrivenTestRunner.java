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

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bytemechanics.testdrive.DrivenTest;
import org.bytemechanics.testdrive.exceptions.AssertException;
import org.bytemechanics.testdrive.exceptions.DrivenTestCleanException;
import org.bytemechanics.testdrive.exceptions.DrivenTestException;
import org.bytemechanics.testdrive.exceptions.DrivenTestGivenException;
import org.bytemechanics.testdrive.exceptions.DrivenTestInstanceParametersNotMatch;
import org.bytemechanics.testdrive.exceptions.DrivenTestNotAccessible;
import org.bytemechanics.testdrive.exceptions.DrivenTestThenException;
import org.bytemechanics.testdrive.exceptions.DrivenTestWhenException;
import org.bytemechanics.testdrive.internal.commons.lang.AutoCloseableResource;
import org.bytemechanics.testdrive.listeners.DrivenTestListener;
import org.bytemechanics.testdrive.listeners.ExecutionListener;
import org.bytemechanics.testdrive.runners.beans.EvaluationBean;


/**
 * Driven test runner
 * @author afarre
 * @since 0.3.0
 */
public class DrivenTestRunner{

	private Function<EvaluationBean,EvaluationBean> drivenTestGivenBegin;
	private Function<EvaluationBean,EvaluationBean> drivenTestGivenEnd;
	private Function<EvaluationBean,EvaluationBean> drivenTestWhenBegin;
	private Function<EvaluationBean,EvaluationBean> drivenTestWhenEnd;
	private Function<EvaluationBean,EvaluationBean> drivenTestThenBegin;
	private Function<EvaluationBean,EvaluationBean> drivenTestThenEnd;
	private Function<EvaluationBean,EvaluationBean> drivenTestCleanBegin;
	private Function<EvaluationBean,EvaluationBean> drivenTestCleanEnd;
	
	
	/**
	 * Driven test runner constructor
	 */
	public DrivenTestRunner(){
		this.drivenTestGivenBegin=(EvaluationBean evaluation) -> evaluation;
		this.drivenTestGivenEnd=(EvaluationBean evaluation) -> evaluation;
		this.drivenTestWhenBegin=(EvaluationBean evaluation) -> evaluation;
		this.drivenTestWhenEnd=(EvaluationBean evaluation) -> evaluation;
		this.drivenTestThenBegin=(EvaluationBean evaluation) -> evaluation;
		this.drivenTestThenEnd=(EvaluationBean evaluation) -> evaluation;
		this.drivenTestCleanBegin=(EvaluationBean evaluation) -> evaluation;
		this.drivenTestCleanEnd=(EvaluationBean evaluation) -> evaluation;
	}

	
	private Function<EvaluationBean,EvaluationBean> fromConsumerToFunction(final Consumer<EvaluationBean> _consumer){
		return (EvaluationBean t) -> { _consumer.accept(t); return t;};
	}
	
	/**
	 * Registers a listener for driven test runner. Uses only DrivenTestListener methods
	 * @param <T> execution listener
	 * @param _listener listener to register
	 * @see DrivenTestListener
	 */
	public <T extends ExecutionListener> void registerListener(final T _listener) {
		this.drivenTestGivenBegin=Optional.ofNullable(_listener)
											.filter(DrivenTestListener.class::isInstance)
											.map(listener -> (DrivenTestListener)listener)
											.map(listener -> fromConsumerToFunction(listener::drivenTestCleanBegin))
											.orElse(this.drivenTestGivenBegin);
		this.drivenTestGivenEnd=Optional.ofNullable(_listener)
											.filter(DrivenTestListener.class::isInstance)
											.map(listener -> (DrivenTestListener)listener)
											.map(listener -> fromConsumerToFunction(listener::drivenTestGivenEnd))
											.orElse(this.drivenTestGivenEnd);
		this.drivenTestWhenBegin=Optional.ofNullable(_listener)
											.filter(DrivenTestListener.class::isInstance)
											.map(listener -> (DrivenTestListener)listener)
											.map(listener -> fromConsumerToFunction(listener::drivenTestWhenBegin))
											.orElse(this.drivenTestWhenBegin);
		this.drivenTestWhenEnd=Optional.ofNullable(_listener)
											.filter(DrivenTestListener.class::isInstance)
											.map(listener -> (DrivenTestListener)listener)
											.map(listener -> fromConsumerToFunction(listener::drivenTestWhenEnd))
											.orElse(this.drivenTestWhenEnd);
		this.drivenTestThenBegin=Optional.ofNullable(_listener)
											.filter(DrivenTestListener.class::isInstance)
											.map(listener -> (DrivenTestListener)listener)
											.map(listener -> fromConsumerToFunction(listener::drivenTestThenBegin))
											.orElse(this.drivenTestThenBegin);
		this.drivenTestThenEnd=Optional.ofNullable(_listener)
											.filter(DrivenTestListener.class::isInstance)
											.map(listener -> (DrivenTestListener)listener)
											.map(listener -> fromConsumerToFunction(listener::drivenTestThenEnd))
											.orElse(this.drivenTestThenEnd);
		this.drivenTestCleanBegin=Optional.ofNullable(_listener)
											.filter(DrivenTestListener.class::isInstance)
											.map(listener -> (DrivenTestListener)listener)
											.map(listener -> fromConsumerToFunction(listener::drivenTestCleanBegin))
											.orElse(this.drivenTestCleanBegin);
		this.drivenTestCleanEnd=Optional.ofNullable(_listener)
											.filter(DrivenTestListener.class::isInstance)
											.map(listener -> (DrivenTestListener)listener)
											.map(listener -> fromConsumerToFunction(listener::drivenTestCleanEnd))
											.orElse(this.drivenTestCleanEnd);
	}

	/**
	 * Execute driven test given phase and return the evaluationBean completed
	 * @param _drivenTest driven test to evaluate
	 * @param _evaluation evaluation to use
	 * @return the same evaluation bean provided
	 * @throws DrivenTestGivenException if any error happens during given phase
	 */
	protected EvaluationBean executeDrivenTestGivenEvaluation(final DrivenTest _drivenTest,final EvaluationBean _evaluation){

		try {
			if(_drivenTest.getClass().getDeclaredMethod("given").getDeclaringClass().equals(_drivenTest.getClass())){
				try(AutoCloseableResource listeners=new AutoCloseableResource(() -> this.drivenTestGivenBegin.apply(_evaluation),() -> this.drivenTestGivenEnd.apply(_evaluation))){
					_drivenTest.given();
				}catch(Exception e){
					throw new DrivenTestGivenException(_evaluation, e);
				}
			}else{
				Logger.getLogger(SpecificationRunner.class.getName()).log(Level.FINEST, "given not declared, skip execution");
			}
		} catch (NoSuchMethodException | SecurityException ex) {
			Logger.getLogger(SpecificationRunner.class.getName()).log(Level.FINEST, "given not declared, skip execution", ex);
		}
		
		return _evaluation;
	}	
	/**
	 * Execute driven test when phase and return the evaluationBean completed
	 * @param _drivenTest driven test to evaluate
	 * @param _evaluation evaluation to use
	 * @return the same evaluation bean provided
	 * @throws DrivenTestWhenException if any error happens during when phase
	 */
	protected EvaluationBean executeDrivenTestWhenEvaluation(final DrivenTest _drivenTest,final EvaluationBean _evaluation){

		try(AutoCloseableResource listeners=new AutoCloseableResource(() -> this.drivenTestWhenBegin.apply(_evaluation),() -> this.drivenTestWhenEnd.apply(_evaluation))){
			_drivenTest.when();
		}catch(Exception e){
			throw new DrivenTestWhenException(_evaluation, e);
		}
		
		return _evaluation;
	}	
	/**
	 * Execute driven test then phase and return the evaluationBean completed
	 * @param _drivenTest driven test to evaluate
	 * @param _evaluation evaluation to use
	 * @return the same evaluation bean provided
	 * @throws DrivenTestThenException if any error happens during test phase
	 */
	protected EvaluationBean executeDrivenTestThenEvaluation(final DrivenTest _drivenTest,final EvaluationBean _evaluation){

		try(AutoCloseableResource listeners=new AutoCloseableResource(() -> this.drivenTestThenBegin.apply(_evaluation),() -> this.drivenTestThenEnd.apply(_evaluation))){
			_drivenTest.then();
		}catch(AssertException e){
			throw e;
		}catch(Exception e){
			throw new DrivenTestThenException(_evaluation, e);
		}

		
		return _evaluation;
	}	
	/**
	 * Execute driven test clean phase and return the evaluationBean completed
	 * @param _drivenTest driven test to evaluate
	 * @param _evaluation evaluation to use
	 * @return the same evaluation bean provided
	 * @throws DrivenTestCleanException if any error happens during clean phase
	 */
	protected EvaluationBean executeDrivenTestCleanEvaluation(final DrivenTest _drivenTest,final EvaluationBean _evaluation){

		try {
			if(_drivenTest.getClass().getDeclaredMethod("clean").getDeclaringClass().equals(_drivenTest.getClass())){
				try(AutoCloseableResource listeners=new AutoCloseableResource(() -> this.drivenTestCleanBegin.apply(_evaluation),() -> this.drivenTestCleanEnd.apply(_evaluation))){
					_drivenTest.clean();
				}catch(Exception e){
					throw new DrivenTestCleanException(_evaluation, e);
				}
			}else{
				Logger.getLogger(SpecificationRunner.class.getName()).log(Level.FINEST, "clean not declared, skip execution");
			}
		} catch (NoSuchMethodException | SecurityException ex) {
			Logger.getLogger(SpecificationRunner.class.getName()).log(Level.FINEST, "clean not declared, skip execution", ex);
		}
		
		return _evaluation;
	}	


	private DrivenTest getDrivenTest(final EvaluationBean _evaluation){

		DrivenTest reply;
		
		try{
			reply=(DrivenTest)_evaluation.getTestMethod()
											.invoke(_evaluation.getSpecification(),_evaluation.getParsedArguments());
		}catch(IllegalArgumentException e){
			throw new DrivenTestInstanceParametersNotMatch(_evaluation,_evaluation.getParsedArguments(),e);
		}catch(IllegalAccessException e){
			throw new DrivenTestNotAccessible(_evaluation,e);
		}catch(InvocationTargetException e){
			throw new DrivenTestException(_evaluation,e);
		}
		
		return reply;
	}

	/**
	 * Executes the driven test with the given evaluation bean
	 * @param _evaluation evaluation to execute
	 * @throws DrivenTestException if some exeption happens in any of the phases
	 */
	public void driveTest(final EvaluationBean _evaluation){
		
		final DrivenTest drivenTest=getDrivenTest(_evaluation);

		try(AutoCloseableResource testDriveEval=new AutoCloseableResource(() -> executeDrivenTestGivenEvaluation(drivenTest,_evaluation),() -> executeDrivenTestCleanEvaluation(drivenTest,_evaluation))){
			executeDrivenTestWhenEvaluation(drivenTest,_evaluation);
			executeDrivenTestThenEvaluation(drivenTest,_evaluation);
		}catch(DrivenTestException e){
			throw e;
		}catch(Exception e){
			throw new DrivenTestException(_evaluation,e);
		}
	}
}
