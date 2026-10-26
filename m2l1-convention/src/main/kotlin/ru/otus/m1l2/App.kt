package ru.otus.m1l2

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun welcome(): String = "Convention plugin is working"

fun main(): Unit = runBlocking {
    delay(1)
    println(welcome())
}
