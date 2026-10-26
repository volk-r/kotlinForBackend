// Композитный проект №3: проектные модули (заготовка под выпускной проект).
// Использует convention-плагины из композитной сборки ../gradle-plugins.
pluginManagement {
    // Подключаем сборку плагинов как included build: id плагинов становятся доступны.
    includeBuild("../gradle-plugins")

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
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "project-modules"

include(":app-jvm")
include(":shared")
