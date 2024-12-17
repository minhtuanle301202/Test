package com.example.coroutine.coroutinecontext

import android.util.Log
import com.example.coroutine.MainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull

object TestDispachers {
    fun runMyFirstCoroutines() {
        GlobalScope.launch(Dispatchers.Unconfined) {
            Log.d(MainActivity::class.java.simpleName, "Before delay - Dispachers Unconfined run on ${Thread.currentThread().name}")
            delay(1000)
            Log.d(MainActivity::class.java.simpleName, "Dispachers Unconfined run on ${Thread.currentThread().name}")
        }
        GlobalScope.launch(Dispatchers.Main) {
            Log.d(MainActivity::class.java.simpleName, "Dispachers Main run on ${Thread.currentThread().name}")
        }
    }

    fun testMySecondWithContext() {
        GlobalScope.launch(Dispatchers.IO) {
// Run long time task
            Log.d("myLog", "Run long time task - Thread:${Thread.currentThread().name}")
            delay(2000)
            withContext(Dispatchers.Main) {
// Update UI here
                Log.d("myLog", "Update UI - Thread:${Thread.currentThread().name}")
            }
        }
    }
}

fun main() {
    runBlocking {
        val result = withTimeoutOrNull(1800) {
            repeat(2) {
                println("I'm sleeping $it")
                delay(500)
            }
            "Done"
        }
        println("Result = $result")
    }
}




