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

import java.util.Optional;
import org.bytemechanics.testdrive.Specification;
import org.bytemechanics.testdrive.internal.commons.string.SimpleFormat;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author afarre
 */
public class SpecificationIdTest {


	@Test
	public void testName() {
		System.out.println("SpecificationIdTest >>> testName");

		SpecificationId instance=new SpecificationIdImpl("mySpecificationName "," mySpecificationGroup");
		String expResult = "mySpecificationGroup:mySpecificationName";
		String result = instance.name();
		Assert.assertEquals(expResult, result);

		instance=new SpecificationIdImpl(null," mySpecificationGroup");
		expResult = "mySpecificationGroup:SpecificationImpl";
		result = instance.name();
		Assert.assertEquals(expResult, result);
		instance=new SpecificationIdImpl("   "," mySpecificationGroup");
		expResult = "mySpecificationGroup:SpecificationImpl";
		result = instance.name();
		Assert.assertEquals(expResult, result);

		instance=new SpecificationIdImpl("mySpecificationName   ",null);
		expResult = "mySpecificationName";
		result = instance.name();
		Assert.assertEquals(expResult, result);

		instance=new SpecificationIdImpl("mySpecificationName   ","");
		expResult = "mySpecificationName";
		result = instance.name();
		Assert.assertEquals(expResult, result);
	}
	
	@Test
	public void testOverridedName() {
		System.out.println("SpecificationIdTest >>> testOverridedName");
		
		SpecificationId instance=new SpecificationIdOverrided("mySpecificationName "," mySpecificationGroup");
		String expResult = "mySpecificationGroup:>mySpecificationName";
		String result = instance.name();
		Assert.assertEquals(expResult, result);

		instance=new SpecificationIdOverrided(null," mySpecificationGroup");
		expResult = "mySpecificationGroup:>SpecificationImpl";
		result = instance.name();
		Assert.assertEquals(expResult, result);
		instance=new SpecificationIdOverrided("   "," mySpecificationGroup");
		expResult = "mySpecificationGroup:>SpecificationImpl";
		result = instance.name();
		Assert.assertEquals(expResult, result);

		instance=new SpecificationIdOverrided("mySpecificationName   ",null);
		expResult = ">mySpecificationName";
		result = instance.name();
		Assert.assertEquals(expResult, result);

		instance=new SpecificationIdOverrided("mySpecificationName   ","");
		expResult = ">mySpecificationName";
		result = instance.name();
		Assert.assertEquals(expResult, result);
	}
	
	class SpecificationImpl implements Specification{
	}
	
	class SpecificationIdImpl implements SpecificationId{
		
		private final String specificationGroup;
		private final String specificationName;
		
		SpecificationIdImpl(final String _specificationName,final String _specificationGroup){
			this.specificationName=_specificationName;
			this.specificationGroup=_specificationGroup;
		}
		
		@Override
		public Class<? extends Specification> getSpecificationClass() { return SpecificationImpl.class;}
		@Override
		public String getSpecificationName() { return specificationName;}
		@Override
		public String getSpecificationGroup() { return specificationGroup;}
	}

	class SpecificationIdOverrided extends SpecificationIdImpl{

		public SpecificationIdOverrided(String _specificationName,String _specificationGroup) {
			super(_specificationName, _specificationGroup);
		}
		@Override
		public String name(){
			return SimpleFormat.format("{}>{}"
									,Optional.ofNullable(getSpecificationGroup())
												.map(String::trim)
												.filter(group -> !group.isEmpty())
												.map(group -> SimpleFormat.format("{}:", group))
												.orElse("")
									, Optional.ofNullable(getSpecificationName())
												.map(String::trim)
												.filter(name -> !name.isEmpty())
												.orElseGet(() -> getSpecificationClass().getSimpleName()));
		}
	}
}
