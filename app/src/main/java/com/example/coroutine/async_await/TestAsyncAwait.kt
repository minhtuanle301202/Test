package com.example.coroutine.async_await
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


fun main() {
    runBlocking{
        val job = launch{
            repeat(3) {
                launch{
                    delay(100)
                    println("coroutine:$it")
                }
            }
            println("Print from parent")
        }
        job.join()
        delay(1000)
    }
}
