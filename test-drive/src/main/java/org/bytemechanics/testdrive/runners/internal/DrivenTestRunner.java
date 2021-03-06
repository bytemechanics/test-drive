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
import org.bytemechanics.testdrive.exceptions.DrivenTestGivenException;
import org.bytemechanics.testdrive.exceptions.DrivenTestThenException;
import org.bytemechanics.testdrive.exceptions.DrivenTestWhenException;
import org.bytemechanics.testdrive.exceptions.TestNotAccessible;
import org.bytemechanics.testdrive.exceptions.TestParametersNotMatch;
import org.bytemechanics.testdrive.exceptions.UnexpectedTestError;
import org.bytemechanics.testdrive.listeners.DrivenTestListener;
import org.bytemechanics.testdrive.listeners.ExecutionListener;
import org.bytemechanics.testdrive.runners.beans.EvaluationBean;


/**
 *
 * @author afarre
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

	protected EvaluationBean executeDrivenTestGivenEvaluation(final DrivenTest _drivenTest,final EvaluationBean _evaluation){

		try {
			if(_drivenTest.getClass().getDeclaredMethod("given").getDeclaringClass().equals(_drivenTest.getClass())){
				try{
					this.drivenTestGivenBegin.apply(_evaluation);
					_drivenTest.given();
				}catch(Exception e){
					throw new DrivenTestGivenException(_evaluation, e);
				}finally{
					this.drivenTestGivenEnd.apply(_evaluation);
				}
			}
		} catch (NoSuchMethodException | SecurityException ex) {
			Logger.getLogger(SpecificationRunner.class.getName()).log(Level.FINEST, "given not declared, skip execution", ex);
		}
		
		return _evaluation;
	}	
	protected EvaluationBean executeDrivenTestWhenEvaluation(final DrivenTest _drivenTest,final EvaluationBean _evaluation){

		try{
			this.drivenTestWhenBegin.apply(_evaluation);
			_drivenTest.when();
		}catch(Exception e){
			throw new DrivenTestWhenException(_evaluation, e);
		}finally{
			this.drivenTestWhenEnd.apply(_evaluation);
		}
		
		return _evaluation;
	}	
	protected EvaluationBean executeDrivenTestThenEvaluation(final DrivenTest _drivenTest,final EvaluationBean _evaluation){

		try{
			this.drivenTestThenBegin.apply(_evaluation);
			_drivenTest.then();
		}catch(AssertException e){
			throw e;
		}catch(Exception e){
			throw new DrivenTestThenException(_evaluation, e);
		}finally{
			this.drivenTestThenEnd.apply(_evaluation);
		}

		
		return _evaluation;
	}	
	protected EvaluationBean executeDrivenTestCleanEvaluation(final DrivenTest _drivenTest,final EvaluationBean _evaluation){

		try {
			if(_drivenTest.getClass().getDeclaredMethod("clean").getDeclaringClass().equals(_drivenTest.getClass())){
				try{
					this.drivenTestCleanBegin.apply(_evaluation);
					_drivenTest.clean();
				}catch(Exception e){
					throw new DrivenTestCleanException(_evaluation, e);
				}finally{
					this.drivenTestCleanEnd.apply(_evaluation);
				}
			}
		} catch (NoSuchMethodException | SecurityException ex) {
			Logger.getLogger(SpecificationRunner.class.getName()).log(Level.FINEST, "clean not declared, skip execution", ex);
		}
		
		return _evaluation;
	}	
	protected Object executeMethod(final EvaluationBean _evaluation){

		Object reply;
		
		try{
			reply=_evaluation.getTestMethod()
						.invoke(_evaluation.getSpecification(),_evaluation.getParsedArguments());
		}catch(IllegalArgumentException e){
			throw new TestParametersNotMatch(_evaluation.getSpecificationClass(),_evaluation.getTestMethod(),_evaluation.getParsedArguments(),e);
		}catch(IllegalAccessException e){
			throw new TestNotAccessible(_evaluation.getSpecificationClass(),_evaluation.getTestMethod(),e);
		}catch(InvocationTargetException e) {
			if(AssertException.class.isAssignableFrom(e.getCause().getClass())){
				throw (AssertException)e.getCause();
			}else if(AssertionError.class.isAssignableFrom(e.getCause().getClass())){
				throw (AssertionError)e.getCause();
			}else{
				throw new UnexpectedTestError(_evaluation.getSpecificationClass(),_evaluation.getTestMethod(),e);
			}
		}catch(Exception e){
			throw new UnexpectedTestError(_evaluation.getSpecificationClass(),_evaluation.getTestMethod(),e);
		}
		
		return reply;
	}

	public void driveTest(final EvaluationBean _evaluation){
		
		final DrivenTest drivenTest=(DrivenTest)executeMethod(_evaluation);
		
		executeDrivenTestGivenEvaluation(drivenTest,_evaluation);
		executeDrivenTestWhenEvaluation(drivenTest,_evaluation);
		executeDrivenTestThenEvaluation(drivenTest,_evaluation);
		executeDrivenTestCleanEvaluation(drivenTest,_evaluation);
	}
}
