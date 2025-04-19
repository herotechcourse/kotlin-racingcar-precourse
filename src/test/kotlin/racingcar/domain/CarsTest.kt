package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class CarsTest {
    @Test
    fun `All car move when larger than 4`() {
        val cars = Cars(listOf(Car("Pobi"), Car("Woni"), Car("Jun")))
        cars.moveAll { 5 }   // all cars have to move

        val positions = cars.getPositions().map { it.second }
        assertThat(positions).allSatisfy { pos ->
            assertThat(pos).isEqualTo(1)
        }
    }

    @Test
    fun `Cars with highest position are selected as winners`() {
        val car1 = Car("Pobi", position = 6)
        val car2 = Car("Woni", position = 3)
        val car3 = Car("Jun", position = 6)

        val cars = Cars(listOf(car1, car2, car3))
        val winners = cars.findWinners()

        assertThat(winners).containsExactlyInAnyOrder("Pobi", "Jun")

    }
}