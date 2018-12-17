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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import org.bytemechanics.testdrive.ResultStatus;
import org.bytemechanics.testdrive.adapter.Result;
import org.bytemechanics.testdrive.annotations.Skip;
import org.bytemechanics.testdrive.annotations.Test;
import org.bytemechanics.testdrive.exceptions.SpecificationCleanupException;
import org.bytemechanics.testdrive.exceptions.SpecificationException;
import org.bytemechanics.testdrive.exceptions.SpecificationSetupException;
import org.bytemechanics.testdrive.internal.commons.lang.AutoCloseableResource;
import org.bytemechanics.testdrive.internal.commons.string.SimpleFormat;
import org.bytemechanics.testdrive.listeners.ExecutionListener;
import org.bytemechanics.testdrive.listeners.SpecificationListener;
import org.bytemechanics.testdrive.runners.beans.ResultBean;
import org.bytemechanics.testdrive.runners.beans.SpecificationBean;
import org.bytemechanics.testdrive.runners.beans.TestBean;


/**
 * Specification test runner
 * @author afarre
 * @since 0.3.0
 */
public abstract class SpecificationRunner extends TestRunner{

	private Function<SpecificationBean,SpecificationBean> startSpecification;
	private Function<SpecificationBean,SpecificationBean> startSpecificationSetup;
	private Function<SpecificationBean,SpecificationBean> endSpecificationSetup;
	private Function<SpecificationBean,SpecificationBean> startSpecificationCleanup;
	private Function<SpecificationBean,SpecificationBean> endSpecificationCleanup;
	private Function<SpecificationBean,SpecificationBean> endSpecification;
	
	/**
	 * Specification runner constructor
	 */
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

	/**
	 * Registers a listener for specification runner. Uses only SpecificationListener methods
	 * @param <T> execution listener
	 * @param _listener listener to register
	 * @see SpecificationListener
	 */
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

	/**
	 * Execute specification setup phase and return the SpecificationBean completed
	 * @param _specification evaluation to use
	 * @return the same _specification bean provided
	 * @throws SpecificationSetupException if any exception occurs during setup
	 */
	protected SpecificationBean executeSpecificationSetup(final SpecificationBean _specification){
		
		try {
			if(_specification.getSpecificationClass().getDeclaredMethod("setupSpec").getDeclaringClass().equals(_specification.getSpecificationClass())){
				try(AutoCloseableResource listeners=new AutoCloseableResource(() -> this.startSpecificationSetup.apply(_specification),() -> this.endSpecificationSetup.apply(_specification))){
					_specification.getSpecification().setupSpec();
					return _specification;
				}catch(Exception e){
					throw new SpecificationSetupException(_specification, e);
				}
			}
		} catch (NoSuchMethodException | SecurityException ex) {
			Logger.getLogger(SpecificationRunner.class.getName()).log(Level.FINEST, "setupSpec not declared, skip execution", ex);
		}
		
		return _specification;
	}
	/**
	 * Execute specification cleanup phase and return the SpecificationBean completed
	 * @param _specification evaluation to use
	 * @return the same _specification bean provided
	 * @throws SpecificationCleanupException if any exception occurs during cleanup
	 */
	protected SpecificationBean executeSpecificationCleanup(final SpecificationBean _specification){
		try {
			if(_specification.getSpecificationClass().getDeclaredMethod("cleanupSpec").getDeclaringClass().equals(_specification.getSpecificationClass())){
				try(AutoCloseableResource listeners=new AutoCloseableResource(() -> this.startSpecificationCleanup.apply(_specification),() -> this.endSpecificationCleanup.apply(_specification))){
					_specification.getSpecification().cleanupSpec();
					return _specification;
				}catch(Exception e){
					throw new SpecificationCleanupException(_specification, e);
				}
			}
		} catch (NoSuchMethodException | SecurityException ex) {
			Logger.getLogger(SpecificationRunner.class.getName()).log(Level.FINEST, "cleanupSpec not declared, skip execution", ex);
		}
		return _specification;
	}
	
	/**
	 * Evaluate specification exclusivelly without setup and cleanup
	 * @param _specification specification to evaluate
	 * @return SpecificationBean provided as parameter with the result informed
	 */
	protected SpecificationBean evaluateSpecification(final SpecificationBean _specification) {
		
		SpecificationBean reply=_specification;

		if(!hasUserRequestedSkip()){
			if(!reply.getSpecificationClass().isAnnotationPresent(Skip.class)){
				try(ResultBean result=new ResultBean()){
					reply.setSpecificationResult(result);
					Stream.of(_specification.getSpecificationClass().getMethods())
							.filter(method -> method.isAnnotationPresent(Test.class))
							.map(method -> new TestBean(_specification, method))
							.map(this::test)
							.map(TestBean::getTestResult)
							.map(ResultBean::getStatus)
							.reduce(ResultStatus::worst)
								.filter(status -> status.in(ResultStatus.ERROR,ResultStatus.FAILURE))
								.ifPresent(status -> reply.getSpecificationResult().update(status, SimpleFormat.format("There are {}s in spec", status.name().toLowerCase()), null));
				}catch(Exception e){
					reply.getSpecificationResult().error(e);
				}
			}else{
				reply.setSpecificationResult(ResultBean.skipped(SimpleFormat.format("{}: class has marked with skip annotation",reply.name())));
			}
		}else{
			reply.setSpecificationResult(ResultBean.skipped(SimpleFormat.format("{}: User requested to skip",reply.name())));
		}
		
		return reply;
	}

	/**
	 * Evaluate specification with setup and cleanup
	 * @param _specification specification to evaluate
	 * @return SpecificationBean provided as parameter with the result informed
	 */
	public SpecificationBean verifySpecification(final SpecificationBean _specification) {
		
		try(AutoCloseableResource listeners=new AutoCloseableResource(() -> this.startSpecification.apply(_specification),() -> this.endSpecification.apply(_specification))){
			try(AutoCloseableResource environment=new AutoCloseableResource(() -> this.executeSpecificationSetup(_specification),() -> this.executeSpecificationCleanup(_specification))){
				return this.evaluateSpecification(_specification);
			}catch(SpecificationException e){
				throw e;
			}catch(Exception e){
				throw new SpecificationException(_specification, e);
			}
		}catch(SpecificationException e){
			throw e;
		}catch(Exception e){
			throw new SpecificationException(_specification, e);
		}
	}
}
