/*
 * Copyright 2019 Byte Mechanics.
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
package org.bytemechanics.testdrive.adapter;

import java.lang.reflect.Method;
import org.bytemechanics.testdrive.Specification;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author afarre
 */
public class EvaluationIdTest {

	public Method getMyTestMethod(int a,String b){
		try {
			return this.getClass().getMethod("getMyTestMethod", int.class,String.class);
		} catch (NoSuchMethodException | SecurityException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	@Test
	public void testTestName() {
		System.out.println("EvaluationIdTest >>> testTestName");
		
		EvaluationId instance=new EvaluationIdImpl("mySpecificationName "," mySpecificationGroup",getMyTestMethod(1,"a"),null,"myevalNAme",new Object[]{1,"myStringArg"});
		String expResult = "getMyTestMethod(1,myStringArg)";
		String result = instance.testName();
		Assert.assertEquals(expResult, result);
	}
	@Test
	public void testTestNameOverride() {
		System.out.println("EvaluationIdTest >>> testTestNameOverride");
		
		EvaluationId instance=new EvaluationIdOverrideImpl("mySpecificationName "," mySpecificationGroup",getMyTestMethod(1,"a"),null,"myevalNAme",new Object[]{1,"myStringArg"});
		String expResult = "overriden testname";
		String result = instance.testName();
		Assert.assertEquals(expResult, result);
	}
	@Test
	public void testName() {
		System.out.println("EvaluationIdTest >>> testName");
		
		EvaluationId instance=new EvaluationIdImpl("mySpecificationName "," mySpecificationGroup",getMyTestMethod(1,"a"),null,"myevalNAme",new Object[]{1,"myStringArg"});
		String expResult = "myevalNAme: getMyTestMethod(1,myStringArg)";
		String result = instance.name();
		Assert.assertEquals(expResult, result);
	}
	@Test
	public void testNameOverride() {
		System.out.println("EvaluationIdTest >>> testNameOverride");
		
		EvaluationId instance=new EvaluationIdOverrideImpl("mySpecificationName "," mySpecificationGroup",getMyTestMethod(1,"a"),null,"myevalNAme",new Object[]{1,"myStringArg"});
		String expResult = "overriden name";
		String result = instance.name();
		Assert.assertEquals(expResult, result);
	}
		
	
	class SpecificationImpl implements Specification{
	}
	class EvaluationIdImpl implements EvaluationId{
		
		private final String specificationGroup;
		private final String specificationName;
		private final Method method;
		private final String testName;
		private final String evaluationName;
		private final Object[] evaluationArguments;
		
		EvaluationIdImpl(final String _specificationName,final String _specificationGroup,final Method _method,final String _testName,final String _evaluationName,final Object[] _evaluationArguments){
			this.specificationName=_specificationName;
			this.specificationGroup=_specificationGroup;
			this.method=_method;
			this.testName=_testName;
			this.evaluationName=_evaluationName;
			this.evaluationArguments=_evaluationArguments;
		}
		
		@Override
		public Class<? extends Specification> getSpecificationClass() { return SpecificationImpl.class;}
		@Override
		public String getSpecificationName() { return specificationName;}
		@Override
		public String getSpecificationGroup() { return specificationGroup;}

		@Override
		public Method getTestMethod() {
			return method;
		}

		@Override
		public String getTestName() {
			return testName;
		}

		@Override
		public int getEvaluationCounter() {
			return 0;
		}

		@Override
		public String getEvaluationName() {
			return this.evaluationName;
		}

		@Override
		public Object[] getEvaluationArguments() {
			return this.evaluationArguments;
		}
	}
	class EvaluationIdOverrideImpl extends EvaluationIdImpl{

		public EvaluationIdOverrideImpl(String _specificationName, String _specificationGroup, Method _method, String _testName, String _evaluationName, Object[] _evaluationArguments) {
			super(_specificationName, _specificationGroup, _method, _testName, _evaluationName, _evaluationArguments);
		}


		@Override
		public String name() {
			return "overriden name";
		}
		@Override
		public String testName() {
			return "overriden testname";
		}
	}
}
