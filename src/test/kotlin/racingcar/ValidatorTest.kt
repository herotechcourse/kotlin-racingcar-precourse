package racingcar

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Nested

class ValidatorTest {
    val validator = Validator()

    @Nested
    inner class ValidateCarsName {
        var carsName = listOf("")

        @Test
        fun `valid cars name → pass validation`() {
            val carsName = listOf("pobi","woni", "1")
            validator.validateCarsName(carsName) // Should not throw an exception
        }

        @Test
        fun `cars name length with over 5 characters → throws IllegalArgumentException`() {
            carsName = listOf("666666", "7777777")

            assertThatThrownBy {
                validator.validateCarsName(carsName)
            }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("Each car name must contain 1 to 5 characters.")
        }

        @Test
        fun `car name is empty → throws IllegalArgumentException`() {
            assertThatThrownBy {
                validator.validateCarsName(carsName)
            }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("Each car name must contain 1 to 5 characters.")
        }

        @Test
        fun `fewer than two cars provided → throws IllegalArgumentException` () {
            carsName = listOf("1")

            assertThatThrownBy {
                validator.validateCarsName(carsName)
            }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("At least two car names must be provided to start the race.")
        }

        @Test
        fun `car names are duplicated → throws IllegalArgumentException` () {
            carsName = listOf("test", "test")

            assertThatThrownBy {
                validator.validateCarsName(carsName)
            }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("Car names must be unique to start the race.")
        }
    }

    @Nested
    inner class ValidateRoundInput {
        var round: String = ""

        @Test
        fun `valid car names → pass validation`() {
            round = "2"

            validator.validateRound(round)
        }

        @Test
        fun `round is not a number → throws IllegalArgumentException`() {
            round = "string"

            assertThatThrownBy {
                validator.validateRound(round)
            }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("Round must be a number.")
        }

        @Test
        fun `round is less than 1 → throws IllegalArgumentException`() {
            round = "0"

            assertThatThrownBy {
                validator.validateRound(round)
            }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("Number of rounds must be at least 1 to start the race.")
        }
    }
}