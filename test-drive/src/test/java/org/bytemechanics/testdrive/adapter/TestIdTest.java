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
public class TestIdTest {

	public Method getMyTestMethod(int a,String b){
		try {
			return this.getClass().getMethod("getMyTestMethod", int.class,String.class);
		} catch (NoSuchMethodException | SecurityException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	@Test
	public void testSpecName() {
		System.out.println("TestIdTest >>> testSpecName");
		
		TestId instance=new TestIdImpl("mySpecificationName "," mySpecificationGroup",getMyTestMethod(1,"a"),null);
		String expResult = "mySpecificationGroup:mySpecificationName";
		String result = instance.specName();
		Assert.assertEquals(expResult, result);
	}
	@Test
	public void testSpecNameOverride() {
		System.out.println("TestIdTest >>> testSpecNameOverride");
		
		TestId instance=new TestIdOverrideImpl("mySpecificationName "," mySpecificationGroup",getMyTestMethod(1,"a"),null);
		String expResult = "overriden specname";
		String result = instance.specName();
		Assert.assertEquals(expResult, result);
	}
	@Test
	public void testGetTestMethodParameters() {
		System.out.println("TestIdTest >>> testGetTestMethodParameters");
		
		TestId instance=new TestIdImpl("mySpecificationName "," mySpecificationGroup",getMyTestMethod(1,"a"),null);
		Class[] expResult = getMyTestMethod(1,"a").getParameterTypes();
		Class[] result = instance.getTestMethodParameters();
		Assert.assertArrayEquals(expResult, result);

		instance=new TestIdImpl("mySpecificationName "," mySpecificationGroup",null,null);
		expResult = new Class[0];
		result = instance.getTestMethodParameters();
		Assert.assertArrayEquals(expResult, result);
	}
	@Test
	public void testGetTestMethodParametersOverride() {
		System.out.println("TestIdTest >>> testGetTestMethodParametersOverride");
		
		TestId instance=new TestIdOverrideImpl("mySpecificationName "," mySpecificationGroup",getMyTestMethod(1,"a"),null);
		Class[] expResult = new Class[]{TestIdOverrideImpl.class};
		Class[] result = instance.getTestMethodParameters();
		Assert.assertArrayEquals(expResult, result);

		instance=new TestIdOverrideImpl("mySpecificationName "," mySpecificationGroup",null,null);
		expResult = new Class[]{TestIdOverrideImpl.class};
		result = instance.getTestMethodParameters();
		Assert.assertArrayEquals(expResult, result);
	}
	@Test
	public void testName() {
		System.out.println("TestIdTest >>> testName");
		
		TestId instance=new TestIdImpl("mySpecificationName "," mySpecificationGroup",getMyTestMethod(1,"a"),null);
		String expResult = "getMyTestMethod(int,String)";
		String result = instance.name();
		Assert.assertEquals(expResult, result);
	}
	@Test
	public void testNameOverride() {
		System.out.println("TestIdTest >>> testNameOverride");
		
		TestId instance=new TestIdOverrideImpl("mySpecificationName "," mySpecificationGroup",getMyTestMethod(1,"a"),null);
		String expResult = "overriden name";
		String result = instance.name();
		Assert.assertEquals(expResult, result);
	}
	@Test
	public void testNameArgs() {
		System.out.println("TestIdTest >>> testNameArgs");
		
		TestId instance=new TestIdImpl("mySpecificationName "," mySpecificationGroup",getMyTestMethod(1,"a"),null);
		String expResult = "getMyTestMethod(1,myStringArg)";
		String result = instance.name("1","myStringArg");
		Assert.assertEquals(expResult, result);
	}
	@Test
	public void testNameArgsOverride() {
		System.out.println("TestIdTest >>> testNameArgsOverride");
		
		TestId instance=new TestIdOverrideImpl("mySpecificationName "," mySpecificationGroup",getMyTestMethod(1,"a"),null);
		String expResult = "overriden name with args";
		String result = instance.name(1,"myStringArg");
		Assert.assertEquals(expResult, result);
	}
		
	
	class SpecificationImpl implements Specification{
	}
	class TestIdImpl implements TestId{
		
		private final String specificationGroup;
		private final String specificationName;
		private final Method method;
		private final String testName;
		
		TestIdImpl(final String _specificationName,final String _specificationGroup,final Method _method,final String _testName){
			this.specificationName=_specificationName;
			this.specificationGroup=_specificationGroup;
			this.method=_method;
			this.testName=_testName;
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
	}
	class TestIdOverrideImpl extends TestIdImpl{

		public TestIdOverrideImpl(String _specificationName, String _specificationGroup, Method _method, String _testName) {
			super(_specificationName, _specificationGroup, _method, _testName);
		}


		@Override
		public String name() {
			return "overriden name";
		}

		@Override
		public String name(Object... _args) {
			return "overriden name with args";
		}

		@Override
		public String specName() {
			return "overriden specname";
		}

		@Override
		public Class[] getTestMethodParameters() {
			return new Class[]{this.getClass()};
		}
	}
}
