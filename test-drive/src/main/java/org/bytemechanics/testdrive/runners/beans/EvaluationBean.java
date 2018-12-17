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
package org.bytemechanics.testdrive.runners.beans;

import java.util.Objects;
import java.util.Optional;
import org.bytemechanics.testdrive.adapter.EvaluationId;
import org.bytemechanics.testdrive.annotations.Evaluation;
import org.bytemechanics.testdrive.exceptions.EvaluationParametersNotMatch;
import org.bytemechanics.testdrive.exceptions.EvaluationUnparseableParameter;
import org.bytemechanics.testdrive.internal.commons.string.GenericTextParser;
import org.bytemechanics.testdrive.internal.commons.string.SimpleFormat;

/**
 * Evaluation bean
 * @author afarre
 * @since 0.3.0
 * @see TestBean
 * @see EvaluationId
 */
public class EvaluationBean extends TestBean implements EvaluationId{
	
	private final Evaluation evaluation;
	private final int evaluationCounter;
	private final String evaluationName;
	private final String[] evaluationArguments;
	private ResultBean evaluationResult;

	
	/**
	 * Builds evaluation bean from testbean counter and evaluation instance¡
	 * @param _test testBean where this evaluatio is executed
	 * @param _counter number of evaluation in order of definition
	 * @param _evaluation evaluation annotation
	 * @see TestBean
	 * @see Evaluation
	 */
	public EvaluationBean(final TestBean _test,final int _counter,final Evaluation _evaluation) {
		super(_test);
		this.evaluation=_evaluation;
		this.evaluationCounter = _counter;
		this.evaluationName = Optional.of(_evaluation.name())
										.filter(val -> !val.isEmpty())
										.map(val -> SimpleFormat.format("{}(\"{}\")",_counter,val))
										.orElseGet(() -> String.valueOf(_counter));
		this.evaluationArguments = _evaluation.args();
		this.evaluationResult=null;
	}
	/**
	 * Builds a basic evaluation bean from the given _test with one single evaluation without parameters
	 * @param _test test bean
	 */
	public EvaluationBean(final TestBean _test) {
		super(_test);
		this.evaluationCounter = 1;
		this.evaluationName = _test.getTestName();
		this.evaluationArguments = new String[0];
		this.evaluationResult=null;
		this.evaluation=null;
	}

	/** @see EvaluationId#getEvaluationCounter() */
	@Override
	public int getEvaluationCounter() {
		return evaluationCounter;
	}
	/** @see EvaluationId#getEvaluationName() */
	@Override
	public String getEvaluationName() {
		return evaluationName;
	}
	/** @see EvaluationId#getEvaluationArguments() */
	@Override
	public String[] getEvaluationArguments() {
		return evaluationArguments;
	}
	public Evaluation getEvaluation() {
		return evaluation;
	}
	/**
	 * Returns the evaluation result after executing the evaluation represented by this bean
	 * @return evaluation result after executing the evaluation represented by this bean
	 */
	public ResultBean getEvaluationResult() {
		return evaluationResult;
	}
	/**
	 * Sets the evaluation evaluation result
	 * @param _result result to register
	 */
	public void setEvaluationResult(ResultBean _result) {
		this.evaluationResult = _result;
	}
	
	
	protected Object[] parseArguments(final Class[] _classes,final String[] _values){
		
		final Object[] reply=new Object[_classes.length];
		
		for(int ic1=0;ic1<_classes.length;ic1++){
			try {
				final int position=ic1;
				reply[position]=GenericTextParser.toValue(_classes[position], _values[position])
						.orElseThrow(() -> new EvaluationUnparseableParameter(this,position, _classes[position], _values[position]));
			} catch (Throwable ex) {
				throw (EvaluationUnparseableParameter)ex;
			}
		}
		
		return reply;
	}
	public Object[] getParsedArguments(){
		return Optional.ofNullable(getTestMethodParameters())
						.filter(parameters -> parameters.length<=getEvaluationArguments().length)
						.map(parameters -> parseArguments(parameters, getEvaluationArguments()))
						.orElseThrow(() -> new EvaluationParametersNotMatch(this,getEvaluationArguments()));
	}
	
	
	/** @see Object#hashCode() */
	@Override
	public int hashCode() {
		int hash = super.hashCode();
		hash = 97 * hash + Objects.hashCode(this.evaluationResult);
		return hash;
	}

	/** @see Object#equals(java.lang.Object) */
	@Override
	@SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
	public boolean equals(Object obj) {
		if (!super.equals(obj)) {
			return false;
		}
		final EvaluationBean other = (EvaluationBean) obj;
		return Objects.equals(this.evaluationResult, other.evaluationResult);
	}
	
}
