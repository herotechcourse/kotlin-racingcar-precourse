package racingcar

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method

class ApplicationTest {
    private lateinit var game: RaceCars
    private val originalOut = System.out
    private val outContent = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        game = RaceCars()
        System.setOut(PrintStream(outContent))
    }

    @Test
    fun `should create car with correct name`() {
        val car = Car("Test")

        assertEquals("Test", car.name)
        assertEquals(0, car.position)
        assertEquals(0, car.lastPosition)
    }

    @Test
    fun `should throw exception when car name exceeds 5 characters`() {
        try {
            val privateMethod = getMethod("validateNameLength")
            privateMethod.invoke(game, "TooLong")
            fail("Expected an IllegalArgumentException to be thrown")
        } catch (e: InvocationTargetException) {
            val cause = e.cause
            assertTrue(cause is IllegalArgumentException)
            assertTrue(cause?.message?.contains("longer than 5 characters") == true)
        }
    }

    @Test
    fun `should throw exception when no car names provided`() {
        try {
            val privateMethod = RaceCars::class.java.getDeclaredMethod("validateCarNames", List::class.java)
            privateMethod.isAccessible = true
            privateMethod.invoke(game, emptyList<String>())
            fail("Expected an IllegalArgumentException to be thrown")
        } catch (e: InvocationTargetException) {
            val cause = e.cause
            assertTrue(cause is IllegalArgumentException)
            assertTrue(cause?.message?.contains("Please provide") == true)
        }
    }

    @Test
    fun `should throw exception for invalid round count zero`() {
        try {
            val privateMethod = getMethod("createRoundCount")
            privateMethod.invoke(game, "0")
            fail("Expected an IllegalArgumentException to be thrown")
        } catch (e: InvocationTargetException) {
            val cause = e.cause
            assertTrue(cause is IllegalArgumentException)
        }
    }

    @Test
    fun `should throw exception for invalid round count negative`() {
        try {
            val privateMethod = getMethod("createRoundCount")
            privateMethod.invoke(game, "-1")
            fail("Expected an IllegalArgumentException to be thrown")
        } catch (e: InvocationTargetException) {
            val cause = e.cause
            assertTrue(cause is IllegalArgumentException)
        }
    }

    @Test
    fun `should throw exception for invalid round count non-numeric`() {
        try {
            val privateMethod = getMethod("createRoundCount")
            privateMethod.invoke(game, "abc")
            fail("Expected an IllegalArgumentException to be thrown")
        } catch (e: InvocationTargetException) {
            val cause = e.cause
            assertTrue(cause is IllegalArgumentException)
        }
    }

    @Test
    fun `should parse valid round count`() {
        val privateMethod = getMethod("createRoundCount")
        val result = privateMethod.invoke(game, "3")

        assertEquals(3, result)
    }

    @Test
    fun `car position should increase when it moves`() {
        val car = Car("Test")
        val initialPosition = car.position

        car.position++

        assertEquals(initialPosition + 1, car.position)
    }

    @Test
    fun `car position should remain the same when it doesn't move`() {
        val car = Car("Test")
        val initialPosition = car.position

        assertEquals(initialPosition, car.position)
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

        assertEquals(2, winners.size)
        assertTrue(winners.any { (it as Car).name == "A" })
        assertTrue(winners.any { (it as Car).name == "C" })
    }

    @Test
    fun `displayWinners should correctly format multiple winners`() {
        val car1 = Car("A").apply { position = 5 }
        val car2 = Car("B").apply { position = 5 }

        val carsField = RaceCars::class.java.getDeclaredField("cars")
        carsField.isAccessible = true
        carsField.set(game, listOf(car1, car2))

        val method = getMethod("displayWinners")
        method.isAccessible = true
        method.invoke(game)

        assertTrue(outContent.toString().contains("Winners: A, B"))
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