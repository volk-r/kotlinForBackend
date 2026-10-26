// Композитный проект №2: библиотека плагинов Gradle (convention plugins).
// Содержит два плагина для сборки подпроектов:
//   * ru.otus.kotlin.jvm.convention          - на базе JVM
//   * ru.otus.kotlin.multiplatform.convention - на базе Multiplatform
// Версии зависимостей объявлены в gradle/libs.versions.toml и используются
// в build-скриптах плагинов (см. libs.kotlin.gradlePlugin и др.).

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        mavenCentral()
    }
}

plugins {
    // Автоматически скачивает требуемые JDK для toolchain.
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "gradle-plugins"

include(":jvm-convention")
include(":multiplatform-convention")
