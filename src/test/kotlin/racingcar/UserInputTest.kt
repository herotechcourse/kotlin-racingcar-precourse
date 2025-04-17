package racingcar

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class UserInputTest {
    @Nested
    inner class CarNameInputTests {
        @Test
        fun `should create a list of names`() {
            val userInput = UserInput()
            userInput.setCarNamesFromInput("pobi,woni,jun,12345")

            assertThat(userInput.carNames).isEqualTo(listOf("pobi", "woni", "jun", "12345"))
        }

        @Test
        fun `should throw IllegalArgumentException when a car has no name`() {
            val userInput = UserInput()
            val thrown = assertThrows<IllegalArgumentException> {
                userInput.setCarNamesFromInput("pobi,,jun")
            }

            assertThat(thrown)
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("Car names cannot be blank")
        }

        @Test
        fun `should throw IllegalArgumentException when a name is longer than 5 characters`() {
            val userInput = UserInput()
            val longName = "123456"
            val thrown = assertThrows<IllegalArgumentException> {
                userInput.setCarNamesFromInput("pobi,$longName,jun")
            }

            assertThat(thrown)
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("Car name '$longName' is too long (max 5 characters)")
        }
    }

    @Nested
    inner class RoundInputTests {
        @Test
        fun `should set the number of rounds`() {
            val userInput = UserInput()
            userInput.setRoundsFromInput("5")

            assertThat(userInput.rounds).isEqualTo(5)
        }

        @Test
        fun `should throw IllegalArgumentException when input is not a number`() {
            val userInput = UserInput()
            val thrown = assertThrows<IllegalArgumentException> {
                userInput.setRoundsFromInput("a")
            }

            assertThat(thrown)
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("Input must be a valid number")
        }

        @Test
        fun `should throw IllegalArgumentException when value is negative or zero`() {
            val userInput = UserInput()
            val thrown1 = assertThrows<IllegalArgumentException> {
                userInput.setRoundsFromInput("-42")
            }
            val thrown2 = assertThrows<IllegalArgumentException> {
                userInput.setRoundsFromInput("0")
            }

            assertThat(thrown1)
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("Round value must be at least 1")

            assertThat(thrown2)
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("Round value must be at least 1")
        }
    }
}