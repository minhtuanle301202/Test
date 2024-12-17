package com.example.coroutine.firstcoroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        delay(1000)
        println("Hello ")
        delay(1000)
        println("World ")
    }
    println("After runBlocking")
}