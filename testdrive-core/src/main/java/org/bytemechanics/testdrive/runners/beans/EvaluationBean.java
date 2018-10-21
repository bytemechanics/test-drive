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
import org.bytemechanics.testdrive.exceptions.TestParametersNotMatch;
import org.bytemechanics.testdrive.internal.commons.string.GenericTextParser;
import org.bytemechanics.testdrive.internal.commons.string.SimpleFormat;

/**
 *
 * @author afarre
 */
public class EvaluationBean extends TestBean implements EvaluationId{
	
	private final Evaluation evaluation;
	private final int evaluationCounter;
	private final String evaluationName;
	private final String[] evaluationArguments;
	private ResultBean evaluationResult;

	
	public EvaluationBean(final TestBean _test,final int _counter,final Evaluation _evaluation) {
		super(_test);
		this.evaluation=_evaluation;
		this.evaluationCounter = _counter;
		this.evaluationName = Optional.of(_evaluation.name())
							.filter(val -> !val.isEmpty())
							.orElseGet(() -> SimpleFormat.format("Evaluation {} with args: {}",_counter,_evaluation.args()));
		this.evaluationArguments = _evaluation.args();
		this.evaluationResult=null;
	}
	public EvaluationBean(final TestBean _test) {
		super(_test);
		this.evaluationCounter = 1;
		this.evaluationName = _test.getTestName();
		this.evaluationArguments = new String[0];
		this.evaluationResult=null;
		this.evaluation=null;
	}

	@Override
	public int getEvaluationCounter() {
		return evaluationCounter;
	}
	@Override
	public String getEvaluationName() {
		return evaluationName;
	}
	@Override
	public String[] getEvaluationArguments() {
		return evaluationArguments;
	}
	public Evaluation getEvaluation() {
		return evaluation;
	}
	public ResultBean getEvaluationResult() {
		return evaluationResult;
	}
	public void setEvaluationResult(ResultBean result) {
		this.evaluationResult = result;
	}
	
	
	protected Object[] parseArguments(final Class[] _classes,final String[] _values){
		
		final Object[] reply=new Object[_classes.length];
		
		for(int ic1=0;ic1<_classes.length;ic1++){
			reply[ic1]=GenericTextParser.toValue(_classes[ic1], _values[ic1]);
		}
		
		return reply;
	}
	public Object[] getParsedArguments(){
		return Optional.ofNullable(getTestMethodParameters())
						.filter(parameters -> parameters.length<=getEvaluationArguments().length)
						.map(parameters -> parseArguments(parameters, getEvaluationArguments()))
						.orElseThrow(() -> new TestParametersNotMatch(getSpecificationClass(),getTestMethod(),getEvaluationArguments()));
	}
	
	
	@Override
	public int hashCode() {
		int hash = super.hashCode();
		hash = 97 * hash + Objects.hashCode(this.evaluationResult);
		return hash;
	}

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
