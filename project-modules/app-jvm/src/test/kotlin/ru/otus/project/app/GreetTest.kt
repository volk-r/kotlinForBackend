package ru.otus.project.app

import kotlin.test.Test
import kotlin.test.assertEquals

class GreetTest {
    @Test
    fun `greets with name`() {
        assertEquals("Hello, Kotlin!", greet("Kotlin"))
    }
}
