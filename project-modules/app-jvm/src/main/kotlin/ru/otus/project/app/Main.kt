package ru.otus.project.app

import kotlinx.coroutines.runBlocking

fun greet(name: String): String = "Hello, $name!"

fun main() {
    runBlocking {
        println(greet("project-modules"))
    }
}
