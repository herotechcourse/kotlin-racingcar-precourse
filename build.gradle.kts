plugins {
    kotlin("jvm") version "1.9.24"
    application
}

group = "com.camila"
version = "1.0"

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation("com.github.woowacourse-projects:mission-utils:1.2.0")
}

application {
    mainClass.set("MainKt") //
}

tasks.test {
    useJUnitPlatform()
}

