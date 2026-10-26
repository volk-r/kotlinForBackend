plugins {
    kotlin("jvm")
}

dependencies {
    // Версии подтягиваются из корневого gradle/libs.versions.toml
    implementation(libs.kotlin.stdlib)
    testImplementation(libs.kotlin.test)
}
