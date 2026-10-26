// The settings file is the entry point of every Gradle build.
// Its primary purpose is to define the subprojects.
// It is also used for some aspects of project-wide configuration, like managing plugins, dependencies, etc.
// https://docs.gradle.org/current/userguide/settings_file_basics.html

// Композитный проект №1 (учебные модули) — корневая сборка.
// Она объединяет (compose) две другие композитные сборки:
//   * gradle-plugins   - плагины Gradle (JVM + Multiplatform);
//   * project-modules  - проектные модули (заготовка под выпускной проект).

dependencyResolutionManagement {
    // Use Maven Central as the default repository (where Gradle will download dependencies) in all subprojects.
    @Suppress("UnstableApiUsage")
    repositories {
        mavenCentral()
    }
}

pluginManagement {
    // Читаем свойство с помощью providers API
    val kotlinVersion = providers.gradleProperty("kotlinVersion").get()

    // Плагины convention-сборки доступны по id во всех подпроектах корня.
    includeBuild("gradle-plugins")

    repositories {
        mavenCentral()
        gradlePluginPortal()
    }

    plugins {
        // Регистрация глобальной kotlin version
        kotlin("jvm") version kotlinVersion
    }
}

plugins {
    // Use the Foojay Toolchains plugin to automatically download JDKs required by subprojects.
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

// Include the `app` and `utils` subprojects in the build.
// If there are changes in only one of the projects, Gradle will rebuild only the one that has changed.
// Learn more about structuring projects with Gradle - https://docs.gradle.org/8.7/userguide/multi_project_builds.html
include(":m1l1-first")
// Учебный модуль, демонстрирующий подключение convention-плагина из
// композитной сборки gradle-plugins.
include(":m2l1-convention")

// Композитные сборки-проекты.
includeBuild("gradle-plugins")
includeBuild("project-modules")

rootProject.name = "kotlinForBackend"
