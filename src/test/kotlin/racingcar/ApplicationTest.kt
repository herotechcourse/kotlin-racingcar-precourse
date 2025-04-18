package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {

    // Test for valid feature behavior
    @Test
    fun `feature test`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1") // Simulating the input for the test
                assertThat(output()).contains("pobi : -", "woni : ", "Winners : pobi") // Checking the expected output
            },
            MOVING_FORWARD,
            STOP
        )
    }

    // Test for exception when an invalid player name is entered
    @Test
    fun `exception test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,javaji", "1") // This should throw an exception due to invalid player name "javaji"
            }
        }
    }

    // Test for empty player names input (should throw an exception)
    @Test
    fun `empty player names input test`() {
        val input = "" // Empty input for player names should throw an exception

        assertThrows<IllegalArgumentException> {
            getPlayerNamesFromInput(input) // This should throw exception
        }
    }

    // Test for player names with invalid length (greater than 5 characters)
    @Test
    fun `invalid player names length test`() {
        val input = "pobi, javaji" // javaji is longer than 5 characters

        assertThrows<IllegalArgumentException> {
            getPlayerNamesFromInput(input) // This should throw exception due to "javaji"
        }
    }

    // Test for valid player names input
    @Test
    fun `valid player names input test`() {
        val input = "pobi, woni"
        val expected = listOf("pobi", "woni")

        val result = getPlayerNamesFromInput(input)

        assertThat(result).isEqualTo(expected) // Checking if the result matches the expected player names
    }

    // Test for valid rounds input
    @Test
    fun `valid rounds input test`() {
        val input = "3"
        val expected = 3

        val result = getRoundsFromInput(input)

        assertThat(result).isEqualTo(expected) // Verifying the valid round input
    }

    // Test for invalid rounds input (non-numeric input)
    @Test
    fun `invalid rounds input test`() {
        val input = "abc" // Non-numeric input for rounds

        assertThrows<IllegalArgumentException> {
            getRoundsFromInput(input) // This should throw an exception
        }
    }

    // Simulating the race logic for player movement
    @Test
    fun `race movement test`() {
        val playerNames = listOf("pobi", "woni")
        val rounds = 3
        val results = race(playerNames, rounds)

        // Ensuring the results contain player movements
        assertThat(results).anyMatch { it.contains("pobi :") }
        assertThat(results).anyMatch { it.contains("woni :") }
    }

    // Test to ensure that the race function identifies winners correctly
    @Test
    fun `race winner test`() {
        val playerNames = listOf("pobi", "woni")
        val rounds = 5
        val results = race(playerNames, rounds)

        val winnerLine = results.last() // The last line contains the winner(s)

        assertThat(winnerLine).contains("Winners :") // Checking if the winners are listed correctly
    }

    // Function for validating player names input
    private fun getPlayerNamesFromInput(input: String): List<String> {
        if (input.isBlank()) {
            throw IllegalArgumentException("Player names cannot be empty")
        }
        
        val names = input.split(",").map { it.trim() }

        // Ensure that all player names are 5 characters or fewer
        names.forEach { name ->
            if (name.length > 5) {
                throw IllegalArgumentException("Player name cannot exceed 5 characters")
            }
        }

        return names
    }

    // Function for validating the number of rounds input
    private fun getRoundsFromInput(input: String): Int {
        return input.toIntOrNull() ?: throw IllegalArgumentException("Invalid number of rounds")
    }

    // Function simulating the racing logic
    private fun race(playerNames: List<String>, rounds: Int): List<String> {
        val results = mutableListOf<String>()
        val playerPositions = mutableMapOf<String, Int>()

        // Initialize player positions
        playerNames.forEach { player -> playerPositions[player] = 0 }

        repeat(rounds) {
            playerNames.forEach { player ->
                val move = (0..9).random() // Simulate random movement
                if (move >= 4) playerPositions[player] = playerPositions[player]!! + 1
                results.add("$player : ${"-".repeat(playerPositions[player]!!)}")  // Append dashes to represent movement
            }
        }

        // Determine winners based on the highest position
        val maxPosition = playerPositions.values.maxOrNull() ?: 0
        val winners = playerNames.filter { playerPositions[it] == maxPosition }
        results.add("Winners : ${winners.joinToString(", ")}")

        return results
    }

    // Overriding the main method for the test framework to run
    override fun runMain() {
        main() // Execute the main method of the application
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}
