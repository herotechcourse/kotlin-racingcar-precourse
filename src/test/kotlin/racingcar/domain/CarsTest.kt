package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarsTest {

    @Test
    fun `Car names must be unique`() {
        val carName1 = CarName("pobi")
        val car1 = Car(carName1, RandomPowerGenerator())
        val carName2 = CarName("pobi")
        val car2 = Car(carName2, RandomPowerGenerator())

        val exception = assertThrows<IllegalArgumentException> {
            Cars(listOf(car1, car2))
        }
        assertEquals("Car names must be unique.", exception.message)
    }
}
