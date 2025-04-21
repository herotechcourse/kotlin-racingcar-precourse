package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.dto.CarSnapshot

class RaceTest {

    @Test
    fun `should return correct number of round results`() {
        val cars = listOf(Car("car1"), Car("car2"))
        val rounds = 3
        val race = Race(cars, rounds)

        val results: List<List<CarSnapshot>> = race.start()

        assertThat(results).hasSize(rounds)
    }

    @Test
    fun `should return snapshot of all cars in each round`() {
        val cars = listOf(Car("car1"), Car("car2"))
        val rounds = 2
        val race = Race(cars, rounds)

        val results = race.start()

        results.forEach { roundSnapshot ->
            assertThat(roundSnapshot).hasSize(cars.size)
            assertThat(roundSnapshot.map { it.name }).containsExactlyInAnyOrder("car1", "car2")
        }
    }

    @Test
    fun `should return correct winner(s)`() {
        val car1 = Car("car1")
        val car2 = Car("car2")

        repeat(5) { car1.moveForward() }
        repeat(3) { car2.moveForward() }

        val race = Race(listOf(car1, car2), 0)

        val winners = race.getWinners()

        assertThat(winners).containsExactly("car1")
    }

    @Test
    fun `should return multiple winners when positions are tied`() {
        val car1 = Car("car1")
        val car2 = Car("car2")

        repeat(4) {
            car1.moveForward()
            car2.moveForward()
        }

        val race = Race(listOf(car1, car2), 0)

        val winners = race.getWinners()

        assertThat(winners).containsExactlyInAnyOrder("car1", "car2")
    }
}