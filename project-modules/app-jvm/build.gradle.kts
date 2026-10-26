// Проектный JVM-модуль. Сборка целиком описывается convention-плагином
// ru.otus.kotlin.jvm.convention из композитной сборки gradle-plugins.
plugins {
    id("ru.otus.kotlin.jvm.convention")
}

dependencies {
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlinx.coroutines.core)
    testImplementation(libs.kotlin.test)
}
