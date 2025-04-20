plugins {
    kotlin("jvm") version "1.9.24"
    application // Enables the 'run' task for executing the main() function
}

group = "camp.nextstep.edu"
version = "1.0-SNAPSHOT"

kotlin {
    jvmToolchain(21)
}

repositories {
    mavenCentral()
    maven { setUrl("https://jitpack.io") }
}

dependencies {
    implementation("com.github.woowacourse-projects:mission-utils:1.2.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testImplementation("org.assertj:assertj-core:3.25.3")
}

// Specifies the entry point of the application.
application {
    mainClass.set("racingcar.ApplicationKt")
}

tasks {
    // Setting for getting input in terminal.
    named<JavaExec>("run") {
        standardInput = System.`in`
    }
    test {
        useJUnitPlatform()
    }
}
