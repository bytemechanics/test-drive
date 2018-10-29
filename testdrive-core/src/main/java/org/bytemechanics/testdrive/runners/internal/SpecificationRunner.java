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
package org.bytemechanics.testdrive.runners.internal;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;
import org.bytemechanics.testdrive.adapter.Result;
import org.bytemechanics.testdrive.annotations.Skip;
import org.bytemechanics.testdrive.annotations.Test;
import org.bytemechanics.testdrive.internal.commons.string.SimpleFormat;
import org.bytemechanics.testdrive.listeners.ExecutionListener;
import org.bytemechanics.testdrive.listeners.SpecificationListener;
import org.bytemechanics.testdrive.runners.beans.ResultBean;
import org.bytemechanics.testdrive.runners.beans.SpecificationBean;
import org.bytemechanics.testdrive.runners.beans.TestBean;


/**
 *
 * @author afarre
 */
public class SpecificationRunner extends TestRunner{

	private Function<SpecificationBean,SpecificationBean> startSpecification;
	private Function<SpecificationBean,SpecificationBean> startSpecificationSetup;
	private Function<SpecificationBean,SpecificationBean> endSpecificationSetup;
	private Function<SpecificationBean,SpecificationBean> startSpecificationCleanup;
	private Function<SpecificationBean,SpecificationBean> endSpecificationCleanup;
	private Function<SpecificationBean,SpecificationBean> endSpecification;
	
	public SpecificationRunner(){
		super();
		this.startSpecification=(SpecificationBean specification) -> specification;
		this.startSpecificationSetup=(SpecificationBean specification) -> specification;
		this.endSpecificationSetup=(SpecificationBean specification) -> specification;
		this.startSpecificationCleanup=(SpecificationBean specification) -> specification;
		this.endSpecificationCleanup=(SpecificationBean specification) -> specification;
		this.endSpecification=(SpecificationBean specification) -> specification;
	}

	private Function<SpecificationBean,SpecificationBean> fromConsumerToFunction(final Consumer<SpecificationBean> _consumer){
		return (SpecificationBean t) -> { _consumer.accept(t); return t;};
	}
	private Function<SpecificationBean,SpecificationBean> fromConsumerToFunctionResult(final BiConsumer<SpecificationBean,Result> _consumer){
		return (SpecificationBean t) -> { _consumer.accept(t,t.getSpecificationResult()); return t;};
	}

	@Override
	public <T extends ExecutionListener> void registerListener(final T _listener) {
		super.registerListener(_listener);
		this.startSpecification=Optional.ofNullable(_listener)
											.filter(SpecificationListener.class::isInstance)
											.map(listener -> (SpecificationListener)listener)
											.map(listener -> fromConsumerToFunction(listener::startSpecification))
											.orElse(this.startSpecification);
		this.startSpecificationSetup=Optional.ofNullable(_listener)
											.filter(SpecificationListener.class::isInstance)
											.map(listener -> (SpecificationListener)listener)
											.map(listener -> fromConsumerToFunction(listener::startSpecificationSetup))
											.orElse(this.startSpecificationSetup);
		this.endSpecificationSetup=Optional.ofNullable(_listener)
											.filter(SpecificationListener.class::isInstance)
											.map(listener -> (SpecificationListener)listener)
											.map(listener -> fromConsumerToFunction(listener::endSpecificationSetup))
											.orElse(this.endSpecificationSetup);
		this.startSpecificationCleanup=Optional.ofNullable(_listener)
											.filter(SpecificationListener.class::isInstance)
											.map(listener -> (SpecificationListener)listener)
											.map(listener -> fromConsumerToFunction(listener::startSpecificationCleanup))
											.orElse(this.startSpecificationCleanup);
		this.endSpecificationCleanup=Optional.ofNullable(_listener)
											.filter(SpecificationListener.class::isInstance)
											.map(listener -> (SpecificationListener)listener)
											.map(listener -> fromConsumerToFunction(listener::endSpecificationCleanup))
											.orElse(this.endSpecificationCleanup);
		this.endSpecification=Optional.ofNullable(_listener)
											.filter(SpecificationListener.class::isInstance)
											.map(listener -> (SpecificationListener)listener)
											.map(listener -> fromConsumerToFunctionResult(listener::endSpecification))
											.orElse(this.endSpecification);
	}

	protected SpecificationBean executeSpecificationSetup(final SpecificationBean _specification){
		this.startSpecificationSetup.apply(_specification);
		_specification.getSpecification().setupSpec();
		this.endSpecificationSetup.apply(_specification);
		return _specification;
	}
	protected SpecificationBean executeSpecificationCleanup(final SpecificationBean _specification){
		this.startSpecificationCleanup.apply(_specification);
		_specification.getSpecification().cleanupSpec();
		this.endSpecificationCleanup.apply(_specification);
		return _specification;
	}
	
	protected SpecificationBean evaluateSpecification(final SpecificationBean _specification) {
		
		SpecificationBean reply=_specification;

		if(!reply.getSpecificationClass().isAnnotationPresent(Skip.class)){
			try(ResultBean result=new ResultBean()){
				reply.setSpecificationResult(result);
				Stream.of(_specification.getSpecificationClass().getMethods())
						.filter(method -> method.isAnnotationPresent(Test.class))
						.map(method -> new TestBean(_specification, method))
						.forEach(this::test);
			}catch(Exception e){
				reply.getSpecificationResult().error(e);
			}
		}else{
			reply.setSpecificationResult(ResultBean.skipped(SimpleFormat.format("{}: class has marked with skip annotation",reply.name())));
		}
		
		return reply;
	}

	public SpecificationBean verifySpecification(final SpecificationBean _specification) {
		return this.startSpecification
					.andThen(this::executeSpecificationSetup)
					.andThen(this::evaluateSpecification)
					.andThen(this::executeSpecificationCleanup)
					.andThen(this.endSpecification)
					.apply(_specification);
	}
}
