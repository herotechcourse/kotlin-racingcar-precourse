package racingcar.console

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Test
import support.IOTest

class RoundInputTest : IOTest() {
    @Test
    fun `should return round number when input is valid`() {
        // Given
        val input = "5"

        // When
        val round = run(input) { Input.readNumberOfRounds() }

        // Then
        assertThat(round).isEqualTo(5)
    }

    @Test
    fun `should throw IllegalArgumentException when round number is zero`() {
        // Given
        val input = "0"

        // When & Then
        assertSimpleTest {
            assertInvalidRoundFor(input)
        }
    }

    @Test
    fun `should throw IllegalArgumentException when round number is negative`() {
        // Given
        val input = "-1"

        // When & Then
        assertSimpleTest {
            assertInvalidRoundFor(input)
        }
    }

    @Test
    fun `should throw IllegalArgumentException when input is a decimal number`() {
        // Given
        val input = "3.14"

        // When & Then
        assertSimpleTest {
            assertInvalidRoundFor(input)
        }
    }

    @Test
    fun `should throw IllegalArgumentException when input is not a number`() {
        // Given
        val input = "abc"

        // When & Then
        assertSimpleTest {
            assertInvalidRoundFor(input)
        }
    }

    @Test
    fun `should throw IllegalArgumentException when input is blank`() {
        // Given
        val input = "   "

        // When & Then
        assertSimpleTest {
            assertInvalidRoundFor(input)
        }
    }

    @Test
    fun `should throw IllegalArgumentException when input is empty`() {
        // Given
        val input = "\n"

        // When & Then
        assertSimpleTest {
            assertInvalidRoundFor(input)
        }
    }

    private fun assertInvalidRoundFor(input: String) {
        assertThrows<IllegalArgumentException> {
            runException(input) { Input.readNumberOfRounds() }
        }
    }
}