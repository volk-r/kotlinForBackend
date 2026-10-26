plugins {
    `kotlin-dsl`
}

group = "ru.otus.kotlinForBackend"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    // Версия KGP берётся из gradle/libs.versions.toml (libs.kotlin.gradlePlugin).
    implementation(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("multiplatformConvention") {
            id = "ru.otus.kotlin.multiplatform.convention"
            implementationClass = "ru.otus.gradle.MultiplatformConventionPlugin"
            displayName = "Kotlin Multiplatform convention plugin"
            description = "Applies org.jetbrains.kotlin.multiplatform and configures the JVM toolchain"
        }
    }
}
