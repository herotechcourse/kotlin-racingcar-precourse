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
<<<<<<< HEAD

=======
  
>>>>>>> 67388167d0b77f46a97d1f83682f1648dbfa9b28
}

tasks {
    test {
        useJUnitPlatform()
    }
}
