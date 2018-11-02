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
package org.bytemechanics.testdrive.runners;

import java.lang.reflect.Method;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import org.bytemechanics.testdrive.Specification;
import org.bytemechanics.testdrive.TestDriveRunner;
import org.bytemechanics.testdrive.adapter.Result;
import org.bytemechanics.testdrive.runners.beans.SpecificationBean;
import org.bytemechanics.testdrive.runners.beans.TestBean;
import org.bytemechanics.testdrive.runners.internal.SpecificationRunner;


/**
 *
 * @author afarre
 */
public class DefaultTestDriveRunner extends SpecificationRunner implements TestDriveRunner{

	private final AtomicInteger maxFailuresLeft;
	

	public DefaultTestDriveRunner(){
		super();
		this.maxFailuresLeft=new AtomicInteger( Integer.MAX_VALUE);
	}
	public DefaultTestDriveRunner(final int _maxFailuresAllowed){
		super();
		this.maxFailuresLeft=new AtomicInteger((_maxFailuresAllowed>0)? _maxFailuresAllowed : Integer.MAX_VALUE);
	}

	@Override
	protected void addFailure(){
		this.maxFailuresLeft.decrementAndGet();
	}
	@Override
	protected boolean hasUserRequestedSkip(){
		return this.maxFailuresLeft.get()<0;
	}
	
	
	@Override
	public Result evaluateSpecification(final Class<? extends Specification> _specificationClass) {
		return Optional.ofNullable(_specificationClass)
						.map(SpecificationBean::new)
						.map(this::verifySpecification)
						.map(SpecificationBean::getSpecificationResult)
						.orElse(null);
	}

	@Override
	public Result evaluateSpecificationTest(final Class<? extends Specification> _specificationClass,final Method _method) {
		return Optional.ofNullable(_specificationClass)
						.map(SpecificationBean::new)
						.filter(spec -> _method!=null)
						.map(spec -> new TestBean(spec, _method))
						.map(this::test)
						.map(TestBean::getTestResult)
						.orElse(null);
	}
	
	@Override
	public void evaluateStream(final Stream<Class<? extends Specification>> _specifications) {
		_specifications.forEach(this::evaluateSpecification);
	}
}
