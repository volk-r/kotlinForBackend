package ru.otus.project.shared

import kotlin.test.Test
import kotlin.test.assertEquals

class PlatformTest {
    @Test
    fun `jvm platform name`() {
        assertEquals("JVM", platformName())
    }
}
