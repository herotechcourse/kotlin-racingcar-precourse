package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RaceTest {
    @Test
    @DisplayName("Run all rounds and save results")
    fun runAllRoundsAndSaveResults() {
        val cars = Car.fromNames(listOf("pobi", "woni"))
        val race = Race(cars, 3)

        race.runRace { 5 }

        assertThat(race.results).hasSize(3)
        assertThat(race.results[0]).allSatisfy { assertThat(it.position).isEqualTo(1) }
        assertThat(race.results[1]).allSatisfy { assertThat(it.position).isEqualTo(2) }
        assertThat(race.results[2]).allSatisfy { assertThat(it.position).isEqualTo(3) }
    }

    @Test
    @DisplayName("Determine multiple winners if tied")
    fun determineMultipleWinnersIfTied() {
        val cars = listOf(Car("pobi", 3), Car("woni", 3), Car("jun", 1))
        val race = Race(cars, 1)
        val winners = race.getWinner()
        assertThat(winners.map { it.name }).containsExactlyInAnyOrder("pobi", "woni")
    }
}