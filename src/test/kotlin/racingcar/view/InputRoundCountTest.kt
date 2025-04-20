package racingcar.view

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputRoundCountTest {

    @Test
    fun `throws exception when input is blank`() {
        val input = " "
        assertThrows<IllegalArgumentException> {
            invokeValidateNotEmpty(input)
        }
    }

    @Test
    fun `throws exception when input is not a number`() {
        val input = "abc"
        assertThrows<IllegalArgumentException> {
            invokeValidateIsNumeric(input)
        }
    }

    @Test
    fun `throws exception when input is zero or negative`() {
        val input = "-1"
        assertThrows<IllegalArgumentException> {
            invokeValidateIsPositive(input)
        }
    }

    private fun invokeValidateNotEmpty(input: String) {
        val method = InputRoundCount::class.java.getDeclaredMethod("validateNotEmpty", String::class.java)
        method.isAccessible = true
        method.invoke(InputRoundCount, input)
    }

    private fun invokeValidateIsNumeric(input: String) {
        val method = InputRoundCount::class.java.getDeclaredMethod("validateIsNumeric", String::class.java)
        method.isAccessible = true
        method.invoke(InputRoundCount, input)
    }

    private fun invokeValidateIsPositive(input: String) {
        val method = InputRoundCount::class.java.getDeclaredMethod("validateIsPositive", String::class.java)
        method.isAccessible = true
        method.invoke(InputRoundCount, input)
    }
}