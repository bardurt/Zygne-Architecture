/**
 * Copyright (C) 2017 Bardur Thomsen Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zygnearchitecture.domain.executor.base

import com.zygnearchitecture.domain.interactors.base.AbstractInteractor

/**
 * Interface for the main Executor
 *
 * This interface should be implemented such that the method
 * execute() starts the interactor in a background thread.
 */
interface Executor {
    fun execute(interactor: AbstractInteractor?)
}