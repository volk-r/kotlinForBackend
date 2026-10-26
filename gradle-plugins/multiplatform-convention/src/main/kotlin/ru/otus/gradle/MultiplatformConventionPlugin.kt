package ru.otus.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.jvm.toolchain.JavaLanguageVersion

/**
 * Convention-плагин для подпроектов на базе Kotlin Multiplatform.
 *
 * Применение в целевом проекте:
 * ```
 * plugins { id("ru.otus.kotlin.multiplatform.convention") }
 * ```
 *
 * Плагин применяет org.jetbrains.kotlin.multiplatform и задаёт Java toolchain
 * (версия читается из свойства jvmToolchain). Цели (jvm(), js(), ...) и
 * зависимости source-сетов объявляются в самом проектном модуле, где доступны
 * типизированные расширения KGP.
 */
class MultiplatformConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply("org.jetbrains.kotlin.multiplatform")

        val toolchainVersion = providers.gradleProperty("jvmToolchain")
            .orElse("21")
            .map { it.toInt() }

        // Java toolchain появляется после применения JVM/Java плагина внутри KMP.
        plugins.withId("org.gradle.java") {
            val java = extensions.getByType(JavaPluginExtension::class.java)
            java.toolchain.languageVersion.set(JavaLanguageVersion.of(toolchainVersion.get()))
        }
    }
}
