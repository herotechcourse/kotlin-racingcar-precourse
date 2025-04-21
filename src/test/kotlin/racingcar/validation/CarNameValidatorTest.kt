package racingcar.validation

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarNameValidatorTest {
    @Test
    fun `duplicate names throw exception`() {
        assertThatThrownBy { CarNameValidator.validate(listOf("a", "a")) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Duplicate car names are not allowed.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "   ", "\n", "\t", "  \t\n  "])
    fun `blank names throw exception`(whitespaceName: String) {
        assertThatThrownBy { CarNameValidator.validate(listOf(whitespaceName)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Car name cannot be blank.")
    }

    @Test
    fun `long names throw exception`() {
        assertThatThrownBy { CarNameValidator.validate(listOf("abcdef", "woni", "pobi")) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Car name cannot exceed 5 characters: abcdef")
    }

    @Test
    fun `empty name list throws exception`() {
        assertThatThrownBy { CarNameValidator.validate(emptyList()) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("At least one car must be entered.")
    }

    @Test
    fun `names with max length and no duplicates are valid`() {
        val names = listOf("abcde", "fghij", "klmno")
        assertThatCode { CarNameValidator.validate(names) }
            .doesNotThrowAnyException()
    }
}
