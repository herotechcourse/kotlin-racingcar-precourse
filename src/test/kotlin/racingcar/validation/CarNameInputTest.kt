package racingcar.validation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarNameInputTest {
    @Test
    fun `throw exception when entering only one car name`() {
        //given
        val input = listOf("jinny")

        // when & then
        assertThrows<IllegalArgumentException> {
            CarNamesValidator.validate(input)
        }
    }

    @Test
    fun `throw exception when a car name exceed 5 characters`() {
        //given
        val input = listOf("jinny", "bummyCar")

        // when & then
        assertThrows<IllegalArgumentException> {
            CarNamesValidator.validate(input)
        }
    }
}
