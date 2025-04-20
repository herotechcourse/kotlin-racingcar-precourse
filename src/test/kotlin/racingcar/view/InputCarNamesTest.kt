package racingcar.view

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputCarNamesTest {

    @Test
    fun `throws exception when car name is blank`() {
        val names = listOf("pobi", " ", "jun")
        assertThrows<IllegalArgumentException> {
            invokeValidateEmptyInput(names)
        }
    }

    @Test
    fun `throws exception when car name exceeds 5 characters`() {
        val longName = "longname"
        assertThrows<IllegalArgumentException> {
            invokeValidateNameLength(longName)
        }
    }

    private fun invokeValidateEmptyInput(names: List<String>) {
        val method = InputCarNames::class.java.getDeclaredMethod("validateEmptyInput", List::class.java)
        method.isAccessible = true
        method.invoke(InputCarNames, names)
    }

    private fun invokeValidateNameLength(name: String) {
        val method = InputCarNames::class.java.getDeclaredMethod("validateNameLength", String::class.java)
        method.isAccessible = true
        method.invoke(InputCarNames, name)
    }
}