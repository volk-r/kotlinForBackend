plugins {
    // kotlin-dsl: компилирует convention-плагин на встроенном Kotlin Gradle
    // и подключает gradleApi().
    `kotlin-dsl`
}

group = "ru.otus.kotlinForBackend"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    // Версия берётся из gradle/libs.versions.toml (libs.kotlin.gradlePlugin).
    // KGP нужен на runtime-класспейсе, чтобы плагин мог применить
    // org.jetbrains.kotlin.jvm в целевом проекте.
    implementation(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("jvmConvention") {
            id = "ru.otus.kotlin.jvm.convention"
            implementationClass = "ru.otus.gradle.JvmConventionPlugin"
            displayName = "Kotlin JVM convention plugin"
            description = "Applies org.jetbrains.kotlin.jvm, configures toolchain and JUnit Platform"
        }
    }
}
