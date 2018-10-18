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

import org.bytemechanics.testdrive.beans.Result;
import org.bytemechanics.testdrive.beans.SpecificationId;

/**
 *
 * @author afarre
 */
public interface SpecificationListener extends ExecutionListener{

	public void startSpecification(final SpecificationId _specification);
	public void endSpecification(final SpecificationId _specification,final Result _result);
}
