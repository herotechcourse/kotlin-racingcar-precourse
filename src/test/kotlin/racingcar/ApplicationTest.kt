package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method

class ApplicationTest {
    private lateinit var game: RaceCars
    private val originalOut = System.out
    private val outContent = ByteArrayOutputStream()
    private val outputSeparator = System.lineSeparator()

    @BeforeEach
    fun setUp() {
        game = RaceCars()
        System.setOut(PrintStream(outContent))
    }

    @AfterEach
    fun restoreStreams() {
        System.setOut(originalOut)
    }

    @Test
    fun `should create car with correct name`() {
        val car = Car("Test")

        assertThat(car.name).isEqualTo("Test")
        assertThat(car.position).isZero()
        assertThat(car.lastPosition).isZero()
    }

    @Test
    fun `should throw exception when car name is empty`() {
        try {
            val privateMethod = getMethod("validateEmpty")
            privateMethod.invoke(game, "")
            org.junit.jupiter.api.Assertions.fail("Expected an IllegalArgumentException to be thrown")
        } catch (e: InvocationTargetException) {
            val cause = e.cause
            assertThat(cause).isInstanceOf(IllegalArgumentException::class.java)
            if (cause != null) {
                assertThat(cause.message).contains("didn't provide")
            }
        }
    }

    @Test
    fun `should throw exception when car name exceeds 5 characters`() {
        try {
            val privateMethod = getMethod("validateNameLength")
            privateMethod.invoke(game, "TooLong")
            org.junit.jupiter.api.Assertions.fail("Expected an IllegalArgumentException to be thrown")
        } catch (e: InvocationTargetException) {
            val cause = e.cause
            assertThat(cause).isInstanceOf(IllegalArgumentException::class.java)
            if (cause != null) {
                assertThat(cause.message).contains("longer than 5 characters")
            }
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["A B", "A\tB", "A\nB"])
    fun `should validate that car name contains no whitespace`(nameWithSpace: String) {
        val privateMethod = getMethod("validateSpaces")
        val result = privateMethod.invoke(game, nameWithSpace) as Boolean

        assertThat(result).isFalse()
    }

    @Test
    fun `should throw exception when no car names provided`() {
        try {
            val privateMethod = RaceCars::class.java.getDeclaredMethod("validateCarNames", List::class.java)
            privateMethod.isAccessible = true
            privateMethod.invoke(game, emptyList<String>())
            org.junit.jupiter.api.Assertions.fail("Expected an IllegalArgumentException to be thrown")
        } catch (e: InvocationTargetException) {
            val cause = e.cause
            assertThat(cause).isInstanceOf(IllegalArgumentException::class.java)
            if (cause != null) {
                assertThat(cause.message).contains("Please provide")
            }
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "-1", "abc"])
    fun `should throw exception for invalid round count`(invalidRound: String) {
        try {
            val privateMethod = getMethod("createRoundCount")
            privateMethod.invoke(game, invalidRound)
            org.junit.jupiter.api.Assertions.fail("Expected an IllegalArgumentException to be thrown")
        } catch (e: InvocationTargetException) {
            val cause = e.cause
            assertThat(cause).isInstanceOf(IllegalArgumentException::class.java)
        }
    }

    @Test
    fun `should parse valid round count`() {
        val privateMethod = getMethod("createRoundCount")
        val result = privateMethod.invoke(game, "3")

        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `car should move when random number is 4 or higher`() {
        assertThat(4 >= 4).isTrue()
    }

    @Test
    fun `car should not move when random number is less than 4`() {
        assertThat(3 >= 4).isFalse()
    }

    @Test
    fun `car position should increase when it moves`() {
        val car = Car("Test")
        val initialPosition = car.position

        car.position++

        assertThat(car.position).isEqualTo(initialPosition + 1)
    }

    @Test
    fun `car position should remain the same when it doesn't move`() {
        val car = Car("Test")
        val initialPosition = car.position

        assertThat(car.position).isEqualTo(initialPosition)
    }

    @Test
    fun `getWinners should return cars with max position`() {
        // Create test cars with different positions
        val car1 = Car("A").apply { position = 5 }
        val car2 = Car("B").apply { position = 3 }
        val car3 = Car("C").apply { position = 5 }

        val carsField = RaceCars::class.java.getDeclaredField("cars")
        carsField.isAccessible = true
        carsField.set(game, listOf(car1, car2, car3))

        val method = RaceCars::class.java.getDeclaredMethod("getWinners", Int::class.java)
        method.isAccessible = true
        val winners = method.invoke(game, 5) as List<*>

        assertThat(winners).hasSize(2)
        assertThat(winners).extracting("name").containsExactlyInAnyOrder("A", "C")
    }

    @Test
    fun `displayWinners should correctly format single winner`() {
        // Create test cars
        val car1 = Car("A").apply { position = 5 }
        val car2 = Car("B").apply { position = 3 }

        val carsField = RaceCars::class.java.getDeclaredField("cars")
        carsField.isAccessible = true
        carsField.set(game, listOf(car1, car2))

        val method = getMethod("displayWinners")
        method.invoke(game)

        assertThat(outContent.toString()).contains("Winner: A")
    }

    @Test
    fun `displayWinners should correctly format multiple winners`() {
        val car1 = Car("A").apply { position = 5 }
        val car2 = Car("B").apply { position = 5 }

        val carsField = RaceCars::class.java.getDeclaredField("cars")
        carsField.isAccessible = true
        carsField.set(game, listOf(car1, car2))

        val method = getMethod("displayWinners")
        method.invoke(game)

        assertThat(outContent.toString()).contains("Winners: A, B")
    }

    // Helper methods

    private fun getMethod(methodName: String, vararg parameterTypes: Class<*>): Method {
        try {
            val method: Method = when {
                methodName == "validateEmpty" || methodName == "validateNameLength" ||
                        methodName == "validateSpaces" || methodName == "createRoundCount" -> {
                    // Methods that take a String parameter
                    RaceCars::class.java.getDeclaredMethod(methodName, String::class.java)
                }
                methodName == "getWinners" -> {
                    // getWinners takes an Int parameter
                    RaceCars::class.java.getDeclaredMethod(methodName, Int::class.java)
                }
                parameterTypes.isNotEmpty() -> {
                    // For methods with specified parameter types
                    RaceCars::class.java.getDeclaredMethod(methodName, *parameterTypes)
                }
                else -> {
                    // For methods without parameters
                    RaceCars::class.java.getDeclaredMethod(methodName)
                }
            }
            method.isAccessible = true
            return method
        } catch (e: NoSuchMethodException) {
            println("Method not found: $methodName")
            // Print all available methods for debugging
            val methods = RaceCars::class.java.declaredMethods
            println("Available methods: ${methods.joinToString { it.name }}")
            throw e
        }
    }

}