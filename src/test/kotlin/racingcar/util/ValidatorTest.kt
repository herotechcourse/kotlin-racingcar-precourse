package racingcar.util

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidatorTest {
    @Test
    fun `validateCarNames should throw exception when names are empty`() {
        val exception = assertThrows<IllegalArgumentException> {
            Validator.validateCarNames(emptyList())
        }
        assertEquals("Car names cannot be empty", exception.message)
    }

    @Test
    fun `validateCarNames should throw exception when name is longer than 5 characters`() {
        val exception = assertThrows<IllegalArgumentException> {
            Validator.validateCarNames(listOf("pobi", "cobra", "longname"))
        }
        assertEquals("Car name cannot be longer than 5 characters", exception.message)
    }

    @Test
    fun `validateCarNames should throw exception when names are duplicated`() {
        val exception = assertThrows<IllegalArgumentException> {
            Validator.validateCarNames(listOf("pobi", "pobi", "cobra"))
        }
        assertEquals("Car names must be unique", exception.message)
    }

    @Test
    fun `validateCarNames should throw exception when name contains comma`() {
        val exception = assertThrows<IllegalArgumentException> {
            Validator.validateCarNames(listOf("po,bi", "cobra"))
        }
        assertEquals("Car name cannot contain comma", exception.message)
    }

    @Test
    fun `validateCarNames should throw exception when name is blank`() {
        val exception = assertThrows<IllegalArgumentException> {
            Validator.validateCarNames(listOf("pobi", " ", "cobra"))
        }
        assertEquals("Car name cannot be blank", exception.message)
    }

    @Test
    fun `validateCarNames should not throw exception when names are valid`() {
        Validator.validateCarNames(listOf("pobi", "cobra", "woni"))
    }

    @ParameterizedTest
    @ValueSource(strings = ["abc", "1.2", "-1", "0.5"])
    fun `validateRoundCount should throw exception when input is not a valid number`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            Validator.validateRoundCount(input)
        }
        assertEquals("Invalid input. Please enter a valid number.", exception.message)
    }

    @Test
    fun `validateRoundCount should throw exception when input is blank`() {
        val exception = assertThrows<IllegalArgumentException> {
            Validator.validateRoundCount("")
        }
        assertEquals("Round count cannot be blank", exception.message)
    }

    @Test
    fun `validateRoundCount should throw exception when number is zero or negative`() {
        val exception = assertThrows<IllegalArgumentException> {
            Validator.validateRoundCount("0")
        }
        assertEquals("Round count must be greater than 0", exception.message)
    }

    @Test
    fun `validateRoundCount should return number when input is valid`() {
        val result = Validator.validateRoundCount("5")
        assertEquals(5, result)
    }
} 