package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.model.Cars

class CarsTest {

    @Test
    fun `cars move based on random numbers`() {
        val cars = Cars(listOf(Car("pobi"), Car("woni"), Car("jun")))
        val numbers = listOf(4, 3, 5)
        cars.moveCars(numbers)

        val positions = cars.getCars().map { it.position }
        assertThat(positions).isEqualTo(listOf(1, 0, 1))
    }

    @Test
    fun `getWinners returns single winner`() {
        val pobi = Car("pobi").apply { move() } // position = 1
        val woni = Car("woni")                  // position = 0
        val cars = Cars(listOf(pobi, woni))

        val winners = cars.getWinners()
        assertThat(winners).containsExactly(pobi)
    }

    @Test
    fun `getWinners returns multiple winners when tied`() {
        val pobi = Car("pobi").apply { move() }  // position = 1
        val jun = Car("jun").apply { move() }    // position = 1
        val cars = Cars(listOf(pobi, jun, Car("woni"))) // position = 0

        val winners = cars.getWinners()
        assertThat(winners).containsExactlyInAnyOrder(pobi, jun)
    }
}
