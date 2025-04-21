package racingcar.output

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceResultRendererTest {

    private val raceResultRenderer = RaceResultRenderer()
    private val raceResult = mapOf(
        "pobi" to listOf(4, 3, 5),
        "woni" to listOf(2, 4, 6)
    )

    @Test
    fun `calculatePerRoundScores should return scores round by round`() {
        val result = raceResultRenderer.calculatePerRoundScores(raceResult, 3)

        assertThat(result).hasSize(3)
        assertThat(result[0]).containsExactlyEntriesOf(mapOf("pobi" to 1, "woni" to 0))
        assertThat(result[1]).containsExactlyEntriesOf(mapOf("pobi" to 1, "woni" to 1))
        assertThat(result[2]).containsExactlyEntriesOf(mapOf("pobi" to 2, "woni" to 2))
    }

    @Test
    fun `calculateRaceScores should return final scores after all rounds`() {
        val result = raceResultRenderer.calculateRaceScores(raceResult, 3)

        assertThat(result).containsExactlyEntriesOf(mapOf("pobi" to 2, "woni" to 2))
    }

    @Test
    fun `determineWinners should return car names with max score`() {
        val finalScores = mapOf("pobi" to 2, "woni" to 2, "jun" to 1)

        val winners = raceResultRenderer.determineWinners(finalScores)

        assertThat(winners).containsExactlyInAnyOrder("pobi", "woni")
    }

    @Test
    fun `renderPerRoundScores should return visual score display`() {
        val perRound = listOf(
            mapOf("pobi" to 1, "woni" to 0),
            mapOf("pobi" to 2, "woni" to 1)
        )

        val output = raceResultRenderer.renderPerRoundScores(perRound)

        val expected = """
            pobi : -
            woni : 

            pobi : --
            woni : -
        """.trimIndent()

        assertThat(output).isEqualTo(expected)
    }

    @Test
    fun `renderFinalWinners should format winner line`() {
        val winners = listOf("pobi", "woni")

        val result = raceResultRenderer.renderFinalWinners(winners)

        assertThat(result).isEqualTo("\nWinners : pobi,woni")
    }
}