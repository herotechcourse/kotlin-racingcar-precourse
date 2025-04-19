plugins {
    kotlin("jvm") version "1.9.24"
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
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0") // for test
}

tasks {
    test {
        useJUnitPlatform()
    }
}
