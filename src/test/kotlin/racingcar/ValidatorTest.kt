package racingcar

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class ValidatorTest {

    @Test
    fun `should throw exception when names list is empty`() {
        val names = emptyList<String>()
        assertThrows(IllegalArgumentException::class.java) {
            Validator.validateNames(names)
        }
    }

    @Test
    fun `should throw exception when a name is blank`() {
        val names = listOf("pobi", "", "java")
        assertThrows(IllegalArgumentException::class.java) {
            Validator.validateNames(names)
        }
    }

    @Test
    fun `should throw exception when a name exceeds max length`() {
        val names = listOf("pobiii", "java")
        assertThrows(IllegalArgumentException::class.java) {
            Validator.validateNames(names)
        }
    }

    @Test
    fun `should pass when all names are valid`() {
        val names = listOf("pobi", "java", "car")
        Validator.validateNames(names) // 예외 발생 안 하면 성공
    }
}