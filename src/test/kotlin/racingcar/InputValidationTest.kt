package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidationTest {
    @Test
    fun `when input is blank or empty then validateCarNames throws IllegalArgumentException`() {
        assertThrows<IllegalArgumentException> {
            validateCarNames("")
        }
        assertThrows<IllegalArgumentException> {
            validateCarNames(" ")
        }
    }

    @Test
    fun `when any car name is blank then validateCarNames throws IllegalArgumentException`() {
        assertThrows<IllegalArgumentException> {
            validateCarNames("pobi, ,juni")
        }
        assertThrows<IllegalArgumentException> {
            validateCarNames("woni,,")
        }
    }

    @Test
    fun `when any car name length is greater than 5 then validateCarNames throws IllegalArgumentException`() {
        assertThrows<IllegalArgumentException> {
            validateCarNames("pobi,juni,volkswagen")
        }
    }

    @Test
    fun `when any car name has leading or trailing whitespaces then validateCarNames removes them`() {
        val expectedList = listOf("pobi", "woni", "jun")

        val actualList = validateCarNames("pobi , woni, jun ")

        assertThat(actualList).isEqualTo(expectedList)
    }

    @Test
    fun `when input is valid then validateCarNames returns valid list`() {
        val expectedList = listOf("pobi", "woni", "jun")

        val actualList = validateCarNames("pobi,woni,jun")

        assertThat(actualList).isEqualTo(expectedList)
    }

    @Test
    fun `when input is blank or empty then validateNumberOfRounds throws IllegalArgumentException`() {
        assertThrows<IllegalArgumentException> {
            validateNumberOfRounds(" ")
        }
        assertThrows<IllegalArgumentException> {
            validateNumberOfRounds("")
        }
    }

    @Test
    fun `when input is not valid integer string then validateNumberOfRounds throws IllegalArgumentException`() {
        assertThrows<IllegalArgumentException> {
            validateNumberOfRounds("abc")
        }
    }

    @Test
    fun `when input is less than 0 then validateNumberOfRounds throws IllegalArgumentException`() {
        assertThrows<IllegalArgumentException> {
            validateNumberOfRounds("-5")
        }
    }

    @Test
    fun `when input is valid integer string then validateNumberOfRounds returns valid integer`() {
        val expectedInteger = 5

        val actualInteger = validateNumberOfRounds("5")

        assertThat(actualInteger).isEqualTo(expectedInteger)
    }

}