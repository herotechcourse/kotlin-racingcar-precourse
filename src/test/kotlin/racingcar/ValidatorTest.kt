package racingcar

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class ValidatorTest {

    @Test
    fun `throws when name is blank`() {
        val names = listOf("pobi", "   ", "jun")
        assertThatThrownBy { validateCarNames(names) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Each car name must be non-empty")
    }

    @Test
    fun `throws when name is longer than 5 characters`() {
        val names = listOf("pobi", "jun", "toolongname")
        assertThatThrownBy { validateCarNames(names) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `does not throw when all names are valid`() {
        val names = listOf("pobi", "jun", "woni")
        validateCarNames(names)
    }
}
