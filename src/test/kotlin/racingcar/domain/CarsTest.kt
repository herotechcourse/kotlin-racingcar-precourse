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

    @Test
    fun `every car attempts to move`() {
        val carName1 = CarName("pobi")
        val carPobi = Car(carName1, FixedPowerGenerator(4))
        val carName2 = CarName("tebah")
        val carTebah = Car(carName2, FixedPowerGenerator(3))
        val carName3 = CarName("anna")
        val carAnna = Car(carName3, FixedPowerGenerator(5))
        val cars = Cars(listOf(carPobi, carTebah, carAnna))

        cars.move()

        assertEquals(1, carPobi.position)
        assertEquals(0, carTebah.position)
        assertEquals(1, carAnna.position)
    }
}
