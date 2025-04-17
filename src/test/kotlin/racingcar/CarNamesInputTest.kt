package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import support.IOTest

class CarNamesInputTest : IOTest() {
    @Test
    fun `should return car names when input is valid`() {
        // Given
        val input = "pobi,woni,jun"

        // When
        val carNames = run(input) { Input.readNamesOfTheCars() }

        // Then
        Assertions.assertThat(carNames).isEqualTo(listOf("pobi", "woni", "jun"))
    }

    @Test
    fun `should throw IllegalArgumentException when car name is too long`() {
        // Given
        val input = "pobi,javaji"

        // When & Then
        assertSimpleTest {
            assertInvalidCarNamesFor(input)
        }
    }

    @Test
    fun `should throw IllegalArgumentException when car names are duplicated`() {
        // Given
        val input = "pobi,pobi"

        // When & Then
        assertSimpleTest {
            assertInvalidCarNamesFor(input)
        }
    }

    @Test
    fun `should throw IllegalArgumentException when input is blank`() {
        // Given
        val input = "   "

        // When & Then
        assertSimpleTest {
            assertInvalidCarNamesFor(input)
        }
    }

    @Test
    fun `should throw IllegalArgumentException when input is empty`() {
        // Given
        val input = "\n"

        // When & Then
        assertSimpleTest {
            assertInvalidCarNamesFor(input)
        }
    }

    private fun assertInvalidCarNamesFor(input: String) {
        assertThrows<IllegalArgumentException> {
            runException(input) { Input.readNamesOfTheCars() }
        }
    }
}