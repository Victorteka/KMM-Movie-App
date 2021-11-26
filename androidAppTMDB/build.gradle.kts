plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("kotlin-android")
    id("androidx.navigation.safeargs")
}

android {
    compileSdk = 31
    defaultConfig {
        applicationId = "letsgodigital.africa.tmdbkmm.android"
        minSdk = 21
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation(project(":sharedTMDB"))
    implementation(SupportLibraries.material)
    implementation(SupportLibraries.appcompat)
    implementation(SupportLibraries.constraintLayout)

    implementation(Libraries.coroutinesCore)
    implementation(Libraries.coroutinesAndroid)
    implementation(Libraries.koinCore)
    implementation(Libraries.koinAndroid)
    implementation(Libraries.ktorCore)
    implementation(Libraries.ktorSerialization)
    implementation(Libraries.ktorAndroid)
    implementation(Libraries.glide)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")
    kapt(Libraries.glideCompiler)
}