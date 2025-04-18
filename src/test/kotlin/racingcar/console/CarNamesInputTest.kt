package racingcar.console

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Test
import support.IOTest

class CarNamesInputTest : IOTest() {
    @Test
    fun `should return car names when input is valid`() {
        // Given
        val input = "pobi,woni,jun"

        // When
        val carNames = run(input) { Input.readNamesOfTheCars() }

        // Then
        assertThat(carNames).isEqualTo(listOf("pobi", "woni", "jun"))
    }

    @Test
    fun `should throw exception when car name is too long`() {
        // Given
        val input = "pobi,javaji"

        // When & Then
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            assertInvalidCarNamesFor(input)
        }
    }

    @Test
    fun `should throw exception when car names are duplicated`() {
        // Given
        val input = "pobi,pobi"

        // When & Then
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            assertInvalidCarNamesFor(input)
        }
    }

    @Test
    fun `should throw exception when input is blank`() {
        // Given
        val input = "   "

        // When & Then
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            assertInvalidCarNamesFor(input)
        }
    }

    @Test
    fun `should throw exception when input is empty`() {
        // Given
        val input = "\n"

        // When & Then
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            assertInvalidCarNamesFor(input)
        }
    }

    private fun assertInvalidCarNamesFor(input: String) {
        assertThrows<IllegalArgumentException> {
            runException(input) { Input.readNamesOfTheCars() }
        }
    }
}