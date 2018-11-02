
import org.bytemechanics.testdrive.DrivenTest;
import org.bytemechanics.testdrive.Specification;
import org.bytemechanics.testdrive.annotations.Evaluation;
import org.bytemechanics.testdrive.annotations.Test;
import org.bytemechanics.testdrive.example.AddInteger;
import org.bytemechanics.testdrive.exceptions.AssertException;

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
public class AddIntegerSpec implements Specification {

	@Override
	public void cleanupSpec() {
		System.out.println("execute: cleanupSpec");
	}
	@Override
	public void setup() {
		System.out.println("execute: setup");
	}
	@Override
	public void cleanup() {
		System.out.println("execute: cleanup");
	}
	@Override
	public void setupSpec() {
		System.out.println("execute:setupSpec");
	}

	public AddIntegerSpec(){
		System.out.println("execute: new");
	}

	@Test(evaluations = {
		@Evaluation(name = "zero",args = {"0","0","0","0"}),
		@Evaluation(name = "one",args = {"1","1","0","0"})
	})
	public DrivenTest accumulate(final int _base,final int _val1,final int _val2,final int _expected){
		System.out.println("execute: accumulate");
		return new DrivenTest() {
			
			AddInteger add;
			int actual;

			@Override
			public void given() {
				this.add=new AddInteger((int)_base);
			}
			
			@Override
			public void when() {
				this.actual=this.add.accumulate((int)_val1,(int)_val2);
			}
			@Override
			public void then() throws AssertException {
				assert(this.actual==(int)_expected);
			}
		};
	}
}
