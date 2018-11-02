
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

	
	
	
	@Test(name="accumulate {} and {} should result with {} with driven test", evaluations = {
		@Evaluation(name = "one",args = {"1","1","0","0"}),
		@Evaluation(name = "zero",args = {"0","0","0","0"})
	})
	public DrivenTest accumulateDriven(final int _base,final int _val1,final int _val2,final int _expected){
		return new DrivenTest() {
			
			AddInteger add;
			int actual;
			
			@Override
			public void given() {
				this.add=new AddInteger(_base);
			}
			@Override
			public void when() {
				this.actual=this.add.accumulate(_val1,_val2);
			}
			@Override
			public void then() throws AssertException {
				assert(this.actual==_expected);
			}
		};
	}
	
	@Test(evaluations = {
		@Evaluation(name = "zero",args = {"0","0","0","0"}),
		@Evaluation(name = "one",args = {"1","1","0","0"})
	})
	public void accumulate2(final int _base,final int _val1,final int _val2,final int _expected){

		AddInteger add;
		int actual;
		
		given:
			add=new AddInteger(_base);
		
		when:
			actual=add.accumulate(_val1,_val2);
		
		then:
			assert(actual==_expected);
	}
}
