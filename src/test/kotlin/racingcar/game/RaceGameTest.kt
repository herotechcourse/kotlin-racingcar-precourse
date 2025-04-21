package racingcar.game

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class RaceGameTest {

    @Test
    fun `playRound should apply transformation to elements that meet condition`() {
        // Given
        val raceGame = RaceGame<Int>()
        val condition: (Int) -> Boolean = { it > 3 }
        val transform: (Int) -> Int = { it + 1 }
        val initialList = listOf(1, 2, 3, 4, 5)

        // When
        val playRound = raceGame.playRound(condition, transform)
        val result = playRound(initialList)

        // Then
        assertThat(result).containsExactly(1, 2, 3, 5, 6)
    }

    @Test
    fun `playRound should return empty list when given empty list`() {
        // Given
        val raceGame = RaceGame<Int>()
        val condition: (Int) -> Boolean = { it > 3 }
        val transform: (Int) -> Int = { it + 1 }
        val emptyList = emptyList<Int>()

        // When
        val playRound = raceGame.playRound(condition, transform)
        val result = playRound(emptyList)

        // Then
        assertThat(result).isEmpty()
    }

    @Test
    fun `simulateRounds should correctly simulate multiple rounds`() {
        // Given
        val raceGame = RaceGame<Int>()
        val initialList = listOf(1, 2, 3)
        val roundFunction: (List<Int>) -> List<Int> = { list -> list.map { it + 1 } }

        // When
        val simulateRounds = raceGame.simulateRounds()
        val result = simulateRounds(3, initialList, roundFunction)

        // Then
        assertThat(result).hasSize(3)
        assertThat(result[0]).containsExactly(2, 3, 4)
        assertThat(result[1]).containsExactly(3, 4, 5)
        assertThat(result[2]).containsExactly(4, 5, 6)
    }

    @Test
    fun `simulateRounds should return empty list when rounds is zero`() {
        // Given
        val raceGame = RaceGame<Int>()
        val initialList = listOf(1, 2, 3)
        val roundFunction: (List<Int>) -> List<Int> = { list -> list.map { it + 1 } }

        // When
        val simulateRounds = raceGame.simulateRounds()
        val result = simulateRounds(0, initialList, roundFunction)

        // Then
        assertThat(result).isEmpty()
    }

    @Test
    fun `findWinners should return elements with maximum value`() {
        // Given
        val raceGame = RaceGame<String>()
        val entries = listOf("car1", "car2", "car3", "car4")
        val scores = mapOf(
            "car1" to 3,
            "car2" to 5,
            "car3" to 5,
            "car4" to 2
        )
        val scoreFunction = { car: String -> scores.getOrDefault(car, 0) }

        // When
        val findWinners = raceGame.findWinners()
        val winners = findWinners(entries, scoreFunction)

        // Then
        assertThat(winners).containsExactly("car2", "car3")
    }

    @Test
    fun `findWinners should return empty list when input list is empty`() {
        // Given
        val raceGame = RaceGame<String>()
        val emptyList = emptyList<String>()
        val scoreFunction: (String) -> Int = { it.length }

        // When
        val findWinners = raceGame.findWinners()
        val winners = findWinners(emptyList, scoreFunction)

        // Then
        assertThat(winners).isEmpty()
    }
}
