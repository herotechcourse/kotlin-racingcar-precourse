package racingcar.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `should move forward when random number is 4 or higher`() {
        val car = Car("Flash")
        val moved = car.move(4)
        assertEquals(1, moved.position)
    }

    @Test
    fun `should not move when random number is less than 4`() {
        val car = Car("Neo")
        val moved = car.move(3)
        assertEquals(0, moved.position)
    }

    @Test
    fun `should return correct progress string based on position`() {
        val car = Car("Broom", 5)
        assertEquals("-----", car.progress())
    }
}
