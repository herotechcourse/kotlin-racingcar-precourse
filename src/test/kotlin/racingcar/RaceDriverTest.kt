package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceDriverTest {

    @Test
    fun `driveRound should potentially move cars`() {
        val cars = listOf("pobi", "woni")
        val totalRounds = 1
        val raceDriver = RaceDriver(cars, totalRounds)
        val initialDistances = MutableList(cars.size) { "" }
        val distancesAfterRound = MutableList(initialDistances.size) { "" }

        raceDriver.driveRound(distancesAfterRound)

        // We can only assert that the distance traveled is either 0 or 1 for each car in a single round.
        assertThat(distancesAfterRound[0].length).isLessThanOrEqualTo(1)
        assertThat(distancesAfterRound[1].length).isLessThanOrEqualTo(1)
    }

    @Test
    fun `declareWinner should return the winner when there is only one winner`() {
        val cars = listOf("pobi", "woni")
        val distances = listOf("---", "--")
        val raceDriver = RaceDriver(cars, 3)
        val winner = raceDriver.declareWinner(cars, distances)
        assertThat(winner).isEqualTo("Winners : pobi")
    }

    @Test
    fun `declareWinner should return multiple winners when there is a tie`() {
        val cars = listOf("pobi", "woni", "jun")
        val distances = listOf("---", "---", "--")
        val raceDriver = RaceDriver(cars, 3)
        val winner = raceDriver.declareWinner(cars, distances)
        assertThat(winner).isEqualTo("Winners : pobi, woni")
    }

    @Test
    fun `declareWinner should handle a single winner correctly`() {
        val cars = listOf("pobi")
        val distances = listOf("-----")
        val raceDriver = RaceDriver(cars, 5)
        val winner = raceDriver.declareWinner(cars, distances)
        assertThat(winner).isEqualTo("Winners : pobi")
    }

    @Test
    fun `declareWinner should declare all cars as winners if no car moved`() {
        val cars = listOf("pobi", "woni")
        val distances = listOf("", "")
        val raceDriver = RaceDriver(cars, 2)
        val winner = raceDriver.declareWinner(cars, distances)
        assertThat(winner).isEqualTo("Winners : pobi, woni")
    }
}