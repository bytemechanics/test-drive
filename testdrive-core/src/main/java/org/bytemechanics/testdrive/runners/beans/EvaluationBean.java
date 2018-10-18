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
import org.bytemechanics.testdrive.annotations.Evaluation;
import org.bytemechanics.testdrive.beans.EvaluationId;
import org.bytemechanics.testdrive.beans.Result;
import org.bytemechanics.testdrive.exceptions.TestParametersNotMatch;
import org.bytemechanics.testdrive.internal.commons.string.GenericTextParser;

/**
 *
 * @author afarre
 */
public class EvaluationBean extends EvaluationId{
	
	private Result result;

	public EvaluationBean(final TestBean _test,final int _counter,final Evaluation _evaluation) {
		super(_test.getSpecificationClass(),_test.getSpecificationName(),_test.getSpecificationGroup(),_test.getTestMethod(),_test.getTestName(), _counter,_evaluation.name() , _evaluation.args());
		this.result=null;
	}
	public EvaluationBean(final TestBean _test) {
		super(_test.getSpecificationClass(),_test.getSpecificationName(),_test.getSpecificationGroup(),_test.getTestMethod(),_test.getTestName(), 1,_test.getTestName(),new String[0]);
		this.result=null;
	}

	
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public EvaluationBean withResult(Result result) {
		this.result = result;
		return this;
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
						.filter(parameters -> parameters.length<=getArguments().length)
						.map(parameters -> parseArguments(parameters, getArguments()))
						.orElseThrow(() -> new TestParametersNotMatch(getSpecificationClass(),getTestMethod(),getArguments()));
	}
	
	
	@Override
	public int hashCode() {
		int hash = super.hashCode();
		hash = 97 * hash + Objects.hashCode(this.result);
		return hash;
	}

	@Override
	@SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
	public boolean equals(Object obj) {
		if (!super.equals(obj)) {
			return false;
		}
		final EvaluationBean other = (EvaluationBean) obj;
		return Objects.equals(this.result, other.result);
	}
	
}
