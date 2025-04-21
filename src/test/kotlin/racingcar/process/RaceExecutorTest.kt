package racingcar.process

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceExecutorTest {
    private val raceExecutor = RaceExecutor()

    @Test
    fun `should return race result map with correct number of random values`() {
        val carNames = listOf("car1", "car2")
        val rounds = 3

        val result = raceExecutor.executeRaceAndGetResult(carNames, rounds)


        assertThat(result.keys).containsExactlyInAnyOrderElementsOf(carNames)
        result.forEach { (_, scores) ->
            assertThat(scores).hasSize(rounds)
            assertThat(scores).allMatch { it in 0..9 }
        }
    }
}