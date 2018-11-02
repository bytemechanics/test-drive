
import org.bytemechanics.testdrive.example.AddInteger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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

/**
 *
 * @author afarre
 */
public class AddIntegerT_est {

	@BeforeClass
	public static void beforeClass() {
		System.out.println("AddIntegerTest >> beforeClass");
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("AddIntegerTest >> afterClass");
	}
	@Before
	public void before() {
		System.out.println("AddIntegerTest >> before");
	}
	@After
	public void after() {
		System.out.println("AddIntegerTest >> after");
	}

	public AddIntegerT_est(){
		System.out.println("AddIntegerTest >> new");
	}

	@Test
	public void accumulate(final int _base,final int _val1,final int _val2){
		System.out.println("AddIntegerTest >> accumulate");

		AddInteger add=new AddInteger(0);
		int actual=add.accumulate(0,0);
		Assert.assertEquals(0, actual);
	}
}
