plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("com.squareup.sqldelight")
    id("dev.icerock.mobile.multiplatform-resources")
}

kotlin {
    android()

    listOf(
        iosX64(),
        iosArm64(),
        //iosSimulatorArm64() sure all ios dependencies support this target
    ).forEach {
        it.binaries.framework {
            baseName = "tmdbShared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //network
                implementation(Libraries.ktorCore)
                //Serialization
                implementation(Libraries.ktorSerialization)
                implementation(Libraries.Common.kotlinxSerializationCore)
                //Caching
                implementation(Libraries.Common.sqlDelight)
                //Coroutine
                implementation(Libraries.Common.kotlinxCoroutinesCore)
                //DI
                implementation(Libraries.koinCore)
                //Moko
                api(Libraries.mokoResources)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Libraries.Android.sqlDelight)
                implementation(Libraries.ktorAndroid)
                implementation(Libraries.coroutinesAndroid)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.2")
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        //val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            dependencies {
                implementation(Libraries.IOs.ktorClient)
                implementation(Libraries.IOs.sqlDelight)
            }
            //iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        //val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            //iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

multiplatformResources {
    multiplatformResourcesPackage = "letsgodigital.africa.tmdbkmm"
    iosBaseLocalizationRegion = "en"
    disableStaticFrameworkWarning = true
}

android {
    compileSdk = 31
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 21
        targetSdk = 31
    }
}