package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class RoundInputCheckTest {

    @Test
    fun `roundsFromInput should return the number of rounds when input is a valid positive integer`() {
        val input = "5"
        val roundInputCheck = RoundInputCheck()
        val rounds = roundInputCheck.roundsFromInput(input)
        assertThat(rounds).isEqualTo(5)
    }

    @Test
    fun `roundsFromInput should throw IllegalArgumentException when input contains non-digit characters`() {
        val input = "abc"
        val roundInputCheck = RoundInputCheck()
        assertThatThrownBy { roundInputCheck.roundsFromInput(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Only input digits, please")
    }

    @Test
    fun `roundsFromInput should throw IllegalArgumentException when input is zero`() {
        val input = "0"
        val roundInputCheck = RoundInputCheck()
        assertThatThrownBy { roundInputCheck.roundsFromInput(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("The number of rounds has to be at least 1")
    }

    @Test
    fun `roundsFromInput should throw IllegalArgumentException when input is a negative number`() {
        val input = "-3"
        val roundInputCheck = RoundInputCheck()
        assertThatThrownBy { roundInputCheck.roundsFromInput(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Only input digits, please") // Because toInt() will throw NumberFormatException first
    }
}