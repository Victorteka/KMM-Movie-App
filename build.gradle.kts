buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Libraries.kotlin)
        classpath(Libraries.gradle)
        classpath(Libraries.sqlDelight)
        classpath(Libraries.kotlinSerialization)
        classpath(Libraries.mokoResourceGenerator)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.0")
        val nav_version = "2.3.5"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}