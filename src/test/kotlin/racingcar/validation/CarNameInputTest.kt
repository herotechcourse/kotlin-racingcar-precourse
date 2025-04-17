package racingcar.validation

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

import racingcar.input.processUserInput

class CarNameInputTest {

    @Test
    fun `test valid car names input`() {
        val input = "Tesla, BMW, Ford"
        val carNames = processUserInput(input)
        assertThat(carNames).containsExactly("Tesla", "BMW", "Ford")
    }

    @Test
    fun `test car names with extra spaces`() {
        val input = " Tesla , BMW , Ford "
        val carNames = processUserInput(input)
        assertThat(carNames).containsExactly("Tesla", "BMW", "Ford")
    }

    @Test
    fun `test single car name`() {
        val input = "Tesla"
        val carNames = processUserInput(input)
        assertThat(carNames).containsExactly("Tesla")
    }
}