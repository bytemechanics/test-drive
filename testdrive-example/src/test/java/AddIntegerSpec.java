
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
		System.out.println("AddIntegerSpec >> cleanupSpec");
	}
	@Override
	public void setup() {
		System.out.println("AddIntegerSpec >> setup");
	}
	@Override
	public void cleanup() {
		System.out.println("AddIntegerSpec >> cleanup");
	}
	@Override
	public void setupSpec() {
		System.out.println("AddIntegerSpec >> setupSpec");
	}

	public AddIntegerSpec(){
		System.out.println("AddIntegerSpec >> new");
	}

	@Test(name = "accumulate-values",evaluations = {
		@Evaluation(name = "zero",args = {"0","0","0","0"})
	})
	public DrivenTest accumulate(final int _base,final int _val1,final int _val2){
		System.out.println("AddIntegerSpec >> accumulate");
		return new DrivenTest() {
			
			AddInteger add;
			int actual;

			@Override
			public void given(Object... _args) {
				this.add=new AddInteger((int)_args[0]);
			}
			
			@Override
			public void when(Object... _args) {
				this.actual=this.add.accumulate((int)_args[1],(int)_args[2]);
			}
			@Override
			public void then(Object... _args) throws AssertException {
				assert(this.actual==(int)_args[3]);
			}
		};
	}
}
