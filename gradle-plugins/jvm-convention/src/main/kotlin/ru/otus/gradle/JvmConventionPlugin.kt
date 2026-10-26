package ru.otus.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.tasks.testing.Test
import org.gradle.jvm.toolchain.JavaLanguageVersion

/**
 * Convention-плагин для подпроектов на базе JVM.
 *
 * Применение в целевом проекте:
 * ```
 * plugins { id("ru.otus.kotlin.jvm.convention") }
 * ```
 *
 * Плагин:
 *  - применяет org.jetbrains.kotlin.jvm;
 *  - настраивает Java/Kotlin toolchain (версия читается из свойства jvmToolchain);
 *  - включает JUnit Platform для задач тестирования.
 */
class JvmConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply("org.jetbrains.kotlin.jvm")

        val toolchainVersion = providers.gradleProperty("jvmToolchain")
            .orElse("21")
            .map { it.toInt() }

        val java = extensions.getByType(JavaPluginExtension::class.java)
        java.toolchain.languageVersion.set(JavaLanguageVersion.of(toolchainVersion.get()))

        tasks.withType(Test::class.java).configureEach {
            useJUnitPlatform()
        }
    }
}
