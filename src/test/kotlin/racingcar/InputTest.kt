package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows

class InputParserTest {
    private lateinit var inputParser: InputParser

    @BeforeEach
    fun setUp() {
        inputParser = InputParser()
    }

    // Tests for validateCarNames()
    @Test
    @DisplayName("Valid car names should pass validation")
    fun validateValidCarNames() {
        val validNames = listOf("car1", "car2", "car3")
        inputParser.validateCarNames(validNames)
    }

    @Test
    @DisplayName("Empty car names list should throw exception")
    fun validateEmptyCarNamesList() {
        val exception = assertThrows<IllegalArgumentException> {
            inputParser.validateCarNames(emptyList())
        }
        assertThat(exception.message).isEqualTo("Car names cannot be empty")
    }

    @Test
    @DisplayName("Empty car name should throw exception")
    fun validateEmptyCarName() {
        val exception = assertThrows<IllegalArgumentException> {
            inputParser.validateCarNames(listOf("car1", "", "car3"))
        }
        assertThat(exception.message).isEqualTo("Car names cannot be empty")
    }

    @Test
    @DisplayName("Car name longer than 5 characters should throw exception")
    fun validateLongCarName() {
        val exception = assertThrows<IllegalArgumentException> {
            inputParser.validateCarNames(listOf("looongname"))
        }
        assertThat(exception.message).isEqualTo("Car names cannot exceed 5 characters")
    }

    @Test
    @DisplayName("Duplicate car names should throw exception")
    fun validateDuplicateCarNames() {
        val exception = assertThrows<IllegalArgumentException> {
            inputParser.validateCarNames(listOf("car1", "car1"))
        }
        assertThat(exception.message).isEqualTo("Car names must be unique")
    }
}