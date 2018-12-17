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
package org.bytemechanics.testdrive.listeners;

import org.bytemechanics.testdrive.adapter.EvaluationId;

/**
 * Driven test listener interface
 * @author afarre
 * @since 0.3.0
 * @see ExecutionListener
 * @see EvaluationId
 */
public interface DrivenTestListener extends ExecutionListener{

	/**
	 * Driven test evaluation given phase begin event method
	 * @param <T> evaluation identifier implementing EvaluationId interface
	 * @param _evaluation evaluation
	 */
	public <T extends EvaluationId> void drivenTestGivenBegin(final T _evaluation);
	/**
	 * Driven test evaluation given phase end event method
	 * @param <T> evaluation identifier implementing EvaluationId interface
	 * @param _evaluation evaluation
	 */
	public <T extends EvaluationId> void drivenTestGivenEnd(final T _evaluation);
	/**
	 * Driven test evaluation when phase begin event method
	 * @param <T> evaluation identifier implementing EvaluationId interface
	 * @param _evaluation evaluation
	 */
	public <T extends EvaluationId> void drivenTestWhenBegin(final T _evaluation);
	/**
	 * Driven test evaluation when phase end event method
	 * @param <T> evaluation identifier implementing EvaluationId interface
	 * @param _evaluation evaluation
	 */
	public <T extends EvaluationId> void drivenTestWhenEnd(final T _evaluation);
	/**
	 * Driven test evaluation then phase begin event method
	 * @param <T> evaluation identifier implementing EvaluationId interface
	 * @param _evaluation evaluation
	 */
	public <T extends EvaluationId> void drivenTestThenBegin(final T _evaluation);
	/**
	 * Driven test evaluation then phase end event method
	 * @param <T> evaluation identifier implementing EvaluationId interface
	 * @param _evaluation evaluation
	 */
	public <T extends EvaluationId> void drivenTestThenEnd(final T _evaluation);
	/**
	 * Driven test evaluation clean phase begin event method
	 * @param <T> evaluation identifier implementing EvaluationId interface
	 * @param _evaluation evaluation
	 */
	public <T extends EvaluationId> void drivenTestCleanBegin(final T _evaluation);
	/**
	 * Driven test evaluation clean phase end event method
	 * @param <T> evaluation identifier implementing EvaluationId interface
	 * @param _evaluation evaluation
	 */
	public <T extends EvaluationId> void drivenTestCleanEnd(final T _evaluation);
}
