package ru.otus.m1l2

import kotlin.test.Test
import kotlin.test.assertEquals

class ConventionTest {
    @Test
    fun `welcome message`() {
        assertEquals("Convention plugin is working", welcome())
    }
}
