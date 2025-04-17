package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import support.IOTest

class OutputTest : IOTest() {
    @Test
    fun `should print progress lines correctly when cars have different positions`() {
        // Given
        val cars: List<Car> = listOf(Car("pobi", 1), Car("woni", 2), Car("jun", 3))

        // When
        val output = run { Output.printProgress(cars) }

        // Then
        assertThat(output).contains("pobi : -", "woni : --", "jun : ---")
    }

    @Test
    fun `should print single winner when only one car is in the lead`() {
        // Given
        val winners: List<Car> = listOf(Car("pobi"))

        // When
        val output = run { Output.printWinners(winners) }

        // Then
        assertThat(output).isEqualTo("Winners : pobi")
    }

    @Test
    fun `should print multiple winners when more than one car shares the lead`() {
        // Given
        val winners: List<Car> = listOf(Car("woni"), Car("jun"))

        // When
        val output = run { Output.printWinners(winners) }

        // Then
        assertThat(output).isEqualTo("Winners : woni, jun")
    }
}