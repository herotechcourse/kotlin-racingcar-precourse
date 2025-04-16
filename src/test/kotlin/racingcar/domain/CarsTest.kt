package racingcar.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarsTest {

    @Test
    fun `Car names must be unique`() {
        val carName = CarName("pobi")
        val pobiFirst = Car(carName, RandomPowerGenerator())
        val pobiSecond = Car(carName, RandomPowerGenerator())

        val exception = assertThrows<IllegalArgumentException> {
            Cars(listOf(pobiFirst, pobiSecond))
        }
        assertEquals("Car names must be unique.", exception.message)
    }

    @Test
    fun `every car attempts to move`() {
        val pobi = Car(CarName("pobi"), FixedPowerGenerator(4))
        val tebah = Car(CarName("tebah"), FixedPowerGenerator(3))
        val anna = Car(CarName("anna"), FixedPowerGenerator(5))
        val cars = Cars(listOf(pobi, tebah, anna))

        cars.move()

        assertEquals(1, pobi.position)
        assertEquals(0, tebah.position)
        assertEquals(1, anna.position)
    }

    @Test
    fun `returns all cars that moved the farthest as winners`() {
        val pobi = Car(CarName("pobi"), FixedPowerGenerator(4))
        val tebah = Car(CarName("tebah"), FixedPowerGenerator(3))
        val anna = Car(CarName("anna"), FixedPowerGenerator(5))
        val cars = Cars(listOf(pobi, tebah, anna))

        cars.move()

        val winners = cars.winners()
        assertEquals(2, winners.size)
        assertTrue(pobi in winners)
        assertTrue(anna in winners)
        assertFalse(tebah in winners)
    }
}
