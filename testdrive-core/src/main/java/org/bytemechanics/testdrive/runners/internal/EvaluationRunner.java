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
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import org.bytemechanics.testdrive.DrivenTest;
import org.bytemechanics.testdrive.adapter.Result;
import org.bytemechanics.testdrive.exceptions.AssertException;
import org.bytemechanics.testdrive.internal.commons.string.SimpleFormat;
import org.bytemechanics.testdrive.listeners.EvaluationListener;
import org.bytemechanics.testdrive.listeners.ExecutionListener;
import org.bytemechanics.testdrive.runners.beans.EvaluationBean;
import org.bytemechanics.testdrive.runners.beans.ResultBean;


/**
 *
 * @author afarre
 */
public class EvaluationRunner extends DrivenTestRunner{

	private Function<EvaluationBean,EvaluationBean> startEvaluation;
	private Function<EvaluationBean,EvaluationBean> endEvaluation;
	
	
	public EvaluationRunner(){
		super();
		this.startEvaluation=(EvaluationBean evaluation) -> evaluation;
		this.endEvaluation=(EvaluationBean evaluation) -> evaluation;
	}

	private Function<EvaluationBean,EvaluationBean> fromConsumerToFunction(final Consumer<EvaluationBean> _consumer){
		return (EvaluationBean t) -> { _consumer.accept(t); return t;};
	}
	private Function<EvaluationBean,EvaluationBean> fromConsumerToFunctionResult(final BiConsumer<EvaluationBean,Result> _consumer){
		return (EvaluationBean t) -> { _consumer.accept(t,t.getEvaluationResult()); return t;};
	}
	
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

	protected EvaluationBean executeEvaluation(final EvaluationBean _evaluation){
		
		final EvaluationBean reply=_evaluation;
		
		if(!_evaluation.getEvaluation().skip()){
			try(ResultBean result=new ResultBean()){
				reply.setEvaluationResult(result);
				if(DrivenTest.class.isAssignableFrom(_evaluation.getTestMethod().getReturnType())){
					driveTest(_evaluation);
				}else{
					executeMethod(_evaluation);
				}
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
	
	public EvaluationBean evaluate(final EvaluationBean _evaluation){
		return this.startEvaluation
					.andThen(this::executeEvaluation)
					.andThen(this.endEvaluation)
					.apply(_evaluation);
	}
}
