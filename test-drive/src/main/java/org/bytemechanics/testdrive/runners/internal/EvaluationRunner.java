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
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import org.bytemechanics.testdrive.DrivenTest;
import org.bytemechanics.testdrive.adapter.Result;
import org.bytemechanics.testdrive.exceptions.AssertException;
import org.bytemechanics.testdrive.exceptions.EvaluationException;
import org.bytemechanics.testdrive.exceptions.EvaluationNotAccessible;
import org.bytemechanics.testdrive.exceptions.EvaluationParametersNotMatch;
import org.bytemechanics.testdrive.internal.commons.lang.AutoCloseableResource;
import org.bytemechanics.testdrive.internal.commons.string.SimpleFormat;
import org.bytemechanics.testdrive.listeners.EvaluationListener;
import org.bytemechanics.testdrive.listeners.ExecutionListener;
import org.bytemechanics.testdrive.runners.beans.EvaluationBean;
import org.bytemechanics.testdrive.runners.beans.ResultBean;


/**
 * Evaluation test runner
 * @author afarre
 * @since 0.3.0
 * @see DrivenTestRunner
 */
public abstract class EvaluationRunner extends DrivenTestRunner{

	private Function<EvaluationBean,EvaluationBean> startEvaluation;
	private Function<EvaluationBean,EvaluationBean> endEvaluation;
	
	
	/** Evaluation test runner constructor*/
	public EvaluationRunner(){
		super();
		this.startEvaluation=(EvaluationBean evaluation) -> evaluation;
		this.endEvaluation=(EvaluationBean evaluation) -> evaluation;
	}

	/** Add failure as a result of this evaluation */
	protected abstract void addFailure();
	/** 
	 * User has requested to skip this evaluation
	 * @return true if user has requested skip
	 */
	protected abstract boolean hasUserRequestedSkip();
	
	private Function<EvaluationBean,EvaluationBean> fromConsumerToFunction(final Consumer<EvaluationBean> _consumer){
		return (EvaluationBean t) -> { _consumer.accept(t); return t;};
	}
	private Function<EvaluationBean,EvaluationBean> fromConsumerToFunctionResult(final BiConsumer<EvaluationBean,Result> _consumer){
		return (EvaluationBean t) -> { _consumer.accept(t,t.getEvaluationResult()); return t;};
	}
	
	/**
	 * Registers a listener for evaluation runner. Uses only EvaluationListener methods
	 * @param <T> execution listener
	 * @param _listener listener to register
	 * @see EvaluationListener
	 */
	@Override
	public <T extends ExecutionListener> void registerListener(final T _listener) {
		super.registerListener(_listener);
		this.startEvaluation=Optional.ofNullable(_listener)
											.filter(EvaluationListener.class::isInstance)
											.map(listener -> (EvaluationListener)listener)
											.map(listener -> fromConsumerToFunction(listener::startEvaluation))
											.orElse(this.startEvaluation);
		this.endEvaluation=Optional.ofNullable(_listener)
											.filter(EvaluationListener.class::isInstance)
											.map(listener -> (EvaluationListener)listener)
											.map(listener -> fromConsumerToFunctionResult(listener::endEvaluation))
											.orElse(this.endEvaluation);
	}

	private Object executeMethod(final EvaluationBean _evaluation){

		Object reply;
		
		try{
			reply=_evaluation.getTestMethod()
						.invoke(_evaluation.getSpecification(),_evaluation.getParsedArguments());
		}catch(IllegalArgumentException e){
			throw new EvaluationParametersNotMatch(_evaluation,_evaluation.getParsedArguments(),e);
		}catch(IllegalAccessException e){
			throw new EvaluationNotAccessible(_evaluation,e);
		}catch(InvocationTargetException e) {
			if(AssertException.class.isAssignableFrom(e.getCause().getClass())){
				throw (AssertException)e.getCause();
			}else if(AssertionError.class.isAssignableFrom(e.getCause().getClass())){
				throw (AssertionError)e.getCause();
			}else{
				throw new EvaluationException(_evaluation,e);
			}
		}catch(Exception e){
			throw new EvaluationException(_evaluation,e);
		}
		
		return reply;
	}	
	
	/**
	 * Executes test evaluation
	 * @param _evaluation evaluation bean to test
	 * @return the same _evaluation received with the result
	 */
	@SuppressWarnings("CallToPrintStackTrace")
	protected EvaluationBean executeEvaluation(final EvaluationBean _evaluation){
		
		final EvaluationBean reply=_evaluation;
		
		if(!hasUserRequestedSkip()){
			if(!_evaluation.getEvaluation().skip()){
				try(ResultBean result=new ResultBean()){
					reply.setEvaluationResult(result);
					if(DrivenTest.class.isAssignableFrom(_evaluation.getTestMethod().getReturnType())){
						driveTest(_evaluation);
					}else{
						executeMethod(_evaluation);
					}
				}catch(AssertException | AssertionError e){
					addFailure();
					reply.getEvaluationResult().failure(new AssertException(_evaluation.name(),e));
				}catch(Exception e){
					addFailure();
					reply.getEvaluationResult().error(e);
				}
			}else{
				reply.setEvaluationResult(ResultBean.skipped(SimpleFormat.format("{}: annotated to skip",reply.name())));
			}
		}else{
			reply.setEvaluationResult(ResultBean.skipped(SimpleFormat.format("{}: User requested to skip",reply.name())));
		}
		
		return reply;
	}
	
	/**
	 * Executes test evaluation
	 * @param _evaluation evaluation bean to test
	 * @return the same _evaluation received with the result
	 * @throws EvaluationException
	 */
	public EvaluationBean evaluate(final EvaluationBean _evaluation){
		try(AutoCloseableResource listeners=new AutoCloseableResource(() -> this.startEvaluation.apply(_evaluation),() -> this.endEvaluation.apply(_evaluation))){
			return executeEvaluation(_evaluation);
		}catch(EvaluationException e){
			throw new EvaluationException(_evaluation, e);
		}catch(Exception e){
			throw new EvaluationException(_evaluation, e);
		}
	}
}
