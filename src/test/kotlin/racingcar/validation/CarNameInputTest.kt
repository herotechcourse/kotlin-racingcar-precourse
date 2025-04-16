package racingcar.validation

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class CarNameInputTest {

    @Test
    fun `test valid car names input`() {
        val input = "Tesla, BMW, Ford"
        val carNames = processUserInput(input)
        assertThat(carNames).containsExactly("Tesla", "BMW", "Ford")
    }

    @Test
    fun `test invalid car names input with special characters`() {
        val input = "Tesla. BMW. Ford"
        assertThatThrownBy { processUserInput(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid character detected")
    }

    @Test
    fun `test invalid car names input with spaces`() {
        val input = "Tes la, BMW, Ford Mustang"
        assertThatThrownBy { processUserInput(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("contains spaces in-between")
    }
}