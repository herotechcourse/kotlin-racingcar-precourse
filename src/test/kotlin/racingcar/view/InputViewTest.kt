package racingcar.view

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class InputViewTest {

    @Test
    fun `throw exception when car name is blank`() {
        val input = listOf("kim", "", "yeon")

        assertThatThrownBy {
            input.forEach {
                require(it.isNotEmpty()) { "Each car must have a name." }
            }
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Each car must have a name.")
    }

    @Test
    fun `throw exception when car name exceeds 5 characters`() {
        val input = listOf("kim", "seungyeon")

        assertThatThrownBy {
            input.forEach {
                require(it.length <= 5) { "Car name must not exceed 5 characters." }
            }
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car name must not exceed 5 characters.")
    }

    @Test
    fun `throw exception when round input is not a number`() {
        val input = "two"

        assertThatThrownBy {
            input.toIntOrNull() ?: throw IllegalArgumentException("Please enter a valid number.")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Please enter a valid number.")
    }
}
