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
package com.zygnearchitecture.domain.interactors.base

import com.zygnearchitecture.domain.executor.base.Executor
import com.zygnearchitecture.domain.executor.base.MainThread

/**
 * Base class for all interactors.
 *
 * All interactors should extend this class, and implement their main logic
 * in the method run().
 */
abstract class AbstractInteractor(// executor for executing the main logic on a background thread.
        private val executor: Executor, // main thread for posting results from worker thread to the main thread.
        protected val mainThread: MainThread) : Interactor {

    private var state = State.IDLE

    // this method will execute the main logic for the interactor.
    abstract fun run()

    override fun execute() {
        state = State.RUNNING
        executor.execute(this)
    }

    override fun currentState(): State {
        return state
    }

    fun onFinished() {
        state = State.FINISHED
    }

    companion object {
        private val TAG = AbstractInteractor::class.java.simpleName
    }

}