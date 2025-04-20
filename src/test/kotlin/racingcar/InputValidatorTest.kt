package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows

@Disabled //disabled in order to not interfere with assignment submission
class InputValidatorTest {
    @Test
    fun `validateNames should accept valid names`() {
        val validNames = listOf("car1", "car2", "car3")
        validateNames(validNames)
    }

    @ParameterizedTest
    @ValueSource(strings = ["xxx,  ,xxxx", "  ,xxx", "xxx,         ,xxxx"])
    fun `validateNames should throw exception for empty name`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            getCarNames(input)
        }

        assertThat(exception).hasMessage("Car names should not be empty.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "  ", "         ", "\n"])
    fun `getCarNames should throw exception for empty input`(name: String) {
       val exception = assertThrows<IllegalArgumentException> {
            getCarNames(name)
        }

        assertThat(exception).hasMessage("Car names should be given.")
    }

    @Test
    fun `validateNames should throw exception for duplicate names`() {
        val names = listOf("car", "car", "car1", "car2", "car3")

        val exception = assertThrows<IllegalArgumentException> {
            validateNames(names)
        }

        assertThat(exception).hasMessageContaining("Duplicate car name found")
    }

    @Test
    fun `validateNames should throw exception for name longer than 5 chars`() {
        val names = listOf("xxxxxx", "xx")

        val exception = assertThrows<IllegalArgumentException> {
            validateNames(names)
        }

        assertThat(exception).hasMessage("Car names should not have more than 5 characters")
    }

    @ParameterizedTest
    @ValueSource(strings = ["xxx,    xx   ", "x        ,xx"])
    fun `empty spaces should be trimmed and not raise exception`(input: String) {
        getCarNames(input)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "0", "x", "1.1", "0.1"])
    fun `getNumberOfRounds should only parse valid positive integer`(round: String) {
       val exception = assertThrows<IllegalArgumentException> {
           getNumberOfRounds(round)
       }

        assertThat(exception).hasMessageContaining("Number of rounds must be an integer bigger than 0.")
    }
}
