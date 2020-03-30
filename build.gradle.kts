plugins {
    kotlin("multiplatform") version "1.3.71"
}

group = "br.com.gamemods.koterite"
version = "1.0.0-SNAPSHOT"

repositories {
    jcenter()
}

val ktor_version: String by project

kotlin {
    jvm()
    mingwX64("windows") {
        binaries {
            executable()
        }
    }
    /*linuxX64() {
        binaries {
            executable()
        }
    }*/
    /* Targets configuration omitted.
    *  To find out how to configure the targets, please follow the link:
    *  https://kotlinlang.org/docs/reference/building-mpp-with-gradle.html#setting-up-targets */

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(kotlin("stdlib"))
                api("br.com.gamemods.koterite:koterite-filesystem:1.0.0-SNAPSHOT")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        val jvmMain by getting {
            dependencies {
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }

        all {
            languageSettings.apply {
                //useExperimentalAnnotation("kotlin.ExperimentalMultiplatform")
                //useExperimentalAnnotation("kotlin.RequiresOptIn")
                enableLanguageFeature("InlineClasses")
            }
        }
    }
}
