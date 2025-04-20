package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows


class UserPromptTest {
    @Test
    fun `validateCarName should not throw for valid names`() {
        assertDoesNotThrow {
            UserPrompt.validateCarName("pobi")
            UserPrompt.validateCarName("tech1")
            UserPrompt.validateCarName(" abc ")
        }
    }

    @Test
    fun `validateCarName should throw for names longer than 5 characters`() {
        val exception = assertThrows<IllegalArgumentException> {
            UserPrompt.validateCarName("herotechcourse")
        }
        assertEquals("Each name should be up to 5 characters", exception.message)
    }

    @Test
    fun `parseRound should return integer when valid number is passed`() {
        val result = UserPrompt.parseRounds("5")
        assertEquals(5, result)
    }

    @Test
    fun `parseRound should throw when input is not a number`() {
        val exception = assertThrows<IllegalArgumentException> {
            UserPrompt.parseRounds("hero")
        }
        assertEquals("The number of rounds should be a valid number", exception.message)
    }

    @Test
    fun `parseRound should throw when number is zero or negative`() {
        val inputs = listOf("0", "-1")
        inputs.forEach {
            val exception = assertThrows<IllegalArgumentException> {
                UserPrompt.parseRounds(it)
            }
            assertEquals("The number of rounds should be a valid number", exception.message)
        }
    }

}