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
package org.bytemechanics.testdrive;

import java.util.stream.Stream;

/**
 * @author afarre
 */
public enum ResultStatus {

	SUCCESS(0),
	SKIPPED(0),
	FAILURE(1),
	ERROR(2),
	;
	
	private final int weight;
	
	ResultStatus(final int _weight){
		this.weight=_weight;
	}
	
	public boolean in(final ResultStatus... _statuses){
		return Stream.of(_statuses)
						.anyMatch(this::equals);
	}
	
	public static ResultStatus worst(final ResultStatus _status1,final ResultStatus _status2){
		return (_status1.weight>_status2.weight)? _status1 : _status2;
	}
}
