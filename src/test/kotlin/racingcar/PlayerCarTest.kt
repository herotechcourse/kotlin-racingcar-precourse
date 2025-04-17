package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PlayerCarTest {

    @Test
    fun `should move forward when random number is 4 or greater`() {
        val car = PlayerCar("pobi")
        car.movingForward(4)
        assertEquals(1, car.distance)

        car.movingForward(9)
        assertEquals(2, car.distance)
    }

    @Test
    fun `should not move forward when random number is less than 4`() {
        val car = PlayerCar("jun")
        car.movingForward(2)
        assertEquals(0, car.distance)
    }
}