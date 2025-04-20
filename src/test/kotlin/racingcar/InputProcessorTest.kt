package racingcar

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputProcessorTest {

    private val inputProcessor = InputProcessor()

    @ParameterizedTest
    @ValueSource(strings = ["pobi,woni", "pobi", "javaj", "crong,hyun"])
    fun `getCarNames should return a list of trimmed car names for valid input`(userInput: String) {
        val expected = userInput.split(",").map { it.trim() }
        assertEquals(expected, inputProcessor.getValidatedCarNames(userInput))
    }

    @Test
    fun `getCarNames should throw IllegalArgumentException for empty input`() {
        assertThrows(IllegalArgumentException::class.java) {
            inputProcessor.getValidatedCarNames("")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["abcdef", "tooLongName", "short,toolong"])
    fun `getCarNames should throw IllegalArgumentException for names exceeding 5 characters`(userInput: String) {
        assertThrows(IllegalArgumentException::class.java) {
            inputProcessor.getValidatedCarNames(userInput)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "10", "100"])
    fun `getNumberOfRounds should return the integer value for valid input`(input: String) {
        assertEquals(input.toInt(), inputProcessor.getValidatedNumberOfRounds(input))
    }

    @Test
    fun `getNumberOfRounds should throw IllegalArgumentException for empty input`() {
        assertThrows(IllegalArgumentException::class.java) {
            inputProcessor.getValidatedNumberOfRounds("")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "-1", "-10"])
    fun `getNumberOfRounds should throw IllegalArgumentException for non-positive input`(input: String) {
        assertThrows(IllegalArgumentException::class.java) {
            inputProcessor.getValidatedNumberOfRounds(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["abc", "1.5", "a12"])
    fun `getNumberOfRounds should throw IllegalArgumentException for non-numeric input`(input: String) {
        assertThrows(IllegalArgumentException::class.java) {
            inputProcessor.getValidatedNumberOfRounds(input)
        }
    }
}