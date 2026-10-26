// Учебный модуль №2: демонстрирует, как convention-плагин из композитной
// сборки gradle-plugins (ru.otus.kotlin.jvm.convention) собирает JVM-подпроект.
// Версии зависимостей берутся из корневого gradle/libs.versions.toml.
plugins {
    id("ru.otus.kotlin.jvm.convention")
}

dependencies {
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlinxCoroutines)
    testImplementation(libs.kotlin.test)
}
