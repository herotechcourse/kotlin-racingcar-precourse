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
    /**
     *  [ Test libraries ]
     *  Format:
     *  testImplementation(  “1.Group of Library” : “2. Name of Library” : “3. Version")
     *
     *      org.junit.jupiter
     *      = JUnit5's core module
     *      = Defines the structure and methods of test.
     *      = ex) @Test, @BeforeEach, @ParameterizedTest, ..
     *      = (K) 테스트의 구조를 만드는 도구들의 라이브러리
     *
     *      org.assertj
     *      = Make test more detail, clearer and more expressive.
     *      = Provides a readable and rich assertion API
     *      = ex) assertEquals, assertTrue, assertThat(result), ..
     *      = (K) 테스트가 성공 / 실패했는지 판단하는 도구들의 라이브러리
     *
     *  Both are
     */
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testImplementation("org.assertj:assertj-core:3.25.3")
}

tasks {
    test {
        useJUnitPlatform()
    }
}
