package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingCarsTest {
    private class FixNumberGenerator(private val number: Int) : RandomNumberGenerator {
        override fun generate(): Int = number
    }

    @Test
    fun `all cars move when generator returns 4 or more`() {
        val cars = RacingCars(
            listOf(RacingCar("pobi"), RacingCar("woni")),
            FixNumberGenerator(4)
        )

        cars.moveAll()

        assertThat(cars.all().map { it.progress }).containsExactly(1, 1)
    }

    @Test
    fun `no cars move when generator returns less than 4`() {
        val cars = RacingCars(
            listOf(RacingCar("pobi"), RacingCar("woni")),
            FixNumberGenerator(2)
        )

        cars.moveAll()

        assertThat(cars.all().map { it.progress }).containsExactly(0, 0)
    }

    @Test
    fun `winners are cars that reached the furthest position`() {
        val cars = RacingCars(
            listOf(RacingCar("pobi", 3), RacingCar("woni", 3), RacingCar("jun", 2)),
            FixNumberGenerator(5)
        )

        val winners = cars.findWinners()

        assertThat(winners).containsExactly("pobi", "woni")
    }

    @Test
    fun `create RacingCars using fromNames`() {
        val cars = RacingCars.fromNames(listOf("pobi", "woni"))
        assertThat(cars.all().map { it.name }).containsExactly("pobi", "woni")
    }
}
