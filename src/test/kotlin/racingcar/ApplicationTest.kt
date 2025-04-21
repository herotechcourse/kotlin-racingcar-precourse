package racingcar

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ApplicationTest {
    private lateinit var game: RaceCars

    @BeforeEach
    fun setUp() {
        game = RaceCars()
    }

    @Test
    fun testCarCreation() {
        val car = Car("Test")
        assertEquals("Test", car.name)
        assertEquals(0, car.position)
        assertEquals(0, car.lastPosition)
    }

    @Test
    fun testValidateNameLength() {
        val exception = assertThrows(Exception::class.java) {
            val method = RaceCars::class.java.getDeclaredMethod("validateNameLength", String::class.java)
            method.isAccessible = true
            method.invoke(game, "TooLong")
        }
        val cause = exception.cause
        assertTrue(cause is IllegalArgumentException)
    }

    @Test
    fun testValidateNoCarNames() {
        val exception = assertThrows(Exception::class.java) {
            val method = RaceCars::class.java.getDeclaredMethod("validateCarNames", List::class.java)
            method.isAccessible = true
            method.invoke(game, emptyList<String>())
        }
        val cause = exception.cause
        assertTrue(cause is IllegalArgumentException)
    }

    @Test
    fun testRoundCountZero() {
        val exception = assertThrows(Exception::class.java) {
            val method = RaceCars::class.java.getDeclaredMethod("createRoundCount", String::class.java)
            method.isAccessible = true
            method.invoke(game, "0")
        }
        val cause = exception.cause
        assertTrue(cause is IllegalArgumentException)
    }

    @Test
    fun testRoundCountNegative() {
        val exception = assertThrows(Exception::class.java) {
            val method = RaceCars::class.java.getDeclaredMethod("createRoundCount", String::class.java)
            method.isAccessible = true
            method.invoke(game, "-1")
        }
        val cause = exception.cause
        assertTrue(cause is IllegalArgumentException)
    }

    @Test
    fun testRoundCountNonNumeric() {
        val exception = assertThrows(Exception::class.java) {
            val method = RaceCars::class.java.getDeclaredMethod("createRoundCount", String::class.java)
            method.isAccessible = true
            method.invoke(game, "abc")
        }
        val cause = exception.cause
        assertTrue(cause is IllegalArgumentException)
    }

    @Test
    fun testValidRoundCount() {
        val method = RaceCars::class.java.getDeclaredMethod("createRoundCount", String::class.java)
        method.isAccessible = true

        val result = method.invoke(game, "3")
        assertEquals(3, result)
    }

    @Test
    fun testCarMovement() {
        val car = Car("Test")
        car.position++
        assertEquals(1, car.position)
    }

    @Test
    fun testGetWinners() {
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
}