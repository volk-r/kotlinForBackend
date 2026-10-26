package ru.otus.project.shared

/** Ожидаемая (multiplatform) функция — реализация задаётся per-target. */
expect fun platformName(): String

fun greeting(): String = "Hello from ${platformName()}"
