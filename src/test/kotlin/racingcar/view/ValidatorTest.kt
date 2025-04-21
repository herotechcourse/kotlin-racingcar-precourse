package racingcar.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidatorTest {

    @Test
    fun `should return names if all are valid`() {
        val names = listOf("john", "bell", "steve")
        val result = Validator.validateNames(names)
        assertThat(result).isEqualTo(names)
    }

    @Test
    fun `should throw exception when names list is empty`() {
        val names = emptyList<String>()
        assertThrows<IllegalArgumentException> {
            Validator.validateNames(names)
        }
    }

    @Test
    fun `should throw exception when any name is blank`() {
        val names = listOf("pobi", "", "jun")
        assertThrows<IllegalArgumentException> {
            Validator.validateNames(names)
        }
    }

    @Test
    fun `should throw exception when any name is too long`() {
        val names = listOf("abcdef", "jun")
        assertThrows<IllegalArgumentException> {
            Validator.validateNames(names)
        }
    }

    @Test
    fun `should return rounds if valid`() {
        val rounds = 3
        val result = Validator.validateRounds(rounds)
        assertThat(result).isEqualTo(rounds)
    }

    @Test
    fun `should throw exception when rounds is less than minimum`() {
        val invalidRounds = 0
        assertThrows<IllegalArgumentException> {
            Validator.validateRounds(invalidRounds)
        }
    }
}