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
package com.zygnearchitecture.threads

import android.os.Handler
import android.os.Looper
import com.zygnearchitecture.domain.executor.base.MainThread

/**
 * Implementation of the MainThread interface.
 *
 * This class is used to send tasks from a background thread to the main thread
 */
class AndroidThread private constructor() : MainThread {
    private val handler: Handler = Handler(Looper.getMainLooper())

    // post the runnable to the main thread
    override fun post(runnable: Runnable?) {
        handler.post(runnable)
    }

    companion object {
        private var androidThread: AndroidThread? = null
        @JvmStatic
        val instance: MainThread?
            get() {
                if (androidThread == null) {
                    androidThread = AndroidThread()
                }
                return androidThread
            }
    }

}