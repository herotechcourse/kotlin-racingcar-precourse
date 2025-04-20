package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `car moves forward when random number is 4 or more`() {
        val car = Car("pobi")

        car.moveForward(4, 9)

        assertEquals(1, car.movementCount)
    }

    @Test
    fun `car stops when random number is less than 4`() {
        val car = Car("pobi")

        car.moveForward(0, 3)

        assertEquals(0, car.movementCount)
    }
}
