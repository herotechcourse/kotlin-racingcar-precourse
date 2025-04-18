plugins {
    kotlin("jvm") version "1.9.24"
    application
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
}

tasks {
    test {
        useJUnitPlatform()
    }

    // 👇 Add this to include dependencies and main class in the JAR
    jar {
        manifest {
            attributes["Main-Class"] = "racingcar.ApplicationKt"
        }
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        from({
            configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) }
        })
    }
}

application {
    mainClass.set("racingcar.ApplicationKt")
}
