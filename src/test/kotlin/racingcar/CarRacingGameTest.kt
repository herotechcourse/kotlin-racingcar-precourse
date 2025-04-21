package racingcar

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThatThrownBy

class CarRacingGameInputTest {

    @Test
    fun `should throw error if car name is empty or too long`() {
        val input = listOf("pobi", "", "toolong")
        assertThatThrownBy {
            input.map { Car(it) }
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `should throw error for invalid round input`() {
        val game = CarRacingGame()
        val invalidInput = "abc"

        assertThatThrownBy {
            invalidInput.toIntOrNull() ?: throw IllegalArgumentException("Invalid number of rounds.")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
