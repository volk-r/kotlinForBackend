// Проектный Multiplatform-модуль.
// Базовую настройку даёт convention-плагин ru.otus.kotlin.multiplatform.convention,
// а цели/source-сеты объявляются здесь, где доступны типизированные расширения KGP.
plugins {
    alias(libs.plugins.kotlin.multiplatform)
    id("ru.otus.kotlin.multiplatform.convention")
}

kotlin {
    jvmToolchain(21)
    jvm()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.datetime)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}
