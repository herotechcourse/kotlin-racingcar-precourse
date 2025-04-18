package racingcar.validator

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class RacingValidatorTest {

    private val racingValidator = RacingValidator()

    @ParameterizedTest
    @MethodSource("validCarNames")
    fun `valid car names should not throw an exception`(names: List<String>) {
        assertDoesNotThrow { racingValidator.validateCarNames(names) }
    }

    @ParameterizedTest
    @MethodSource("invalidCarNames")
    fun `invalid car names should throw an exception`(names: List<String>) {
        assertThrows<IllegalArgumentException> {
            racingValidator.validateCarNames(names)
        }
    }
    
    companion object {
        @JvmStatic
        fun validCarNames(): Stream<Arguments> = Stream.of(
            Arguments.of(listOf("car1", "car2", "queen", "test")),
            Arguments.of(listOf("a", "ab", "abc", "abcd")),
            Arguments.of(listOf("Jane"))
        )

        @JvmStatic
        fun invalidCarNames(): Stream<Arguments> = Stream.of(
            Arguments.of(listOf("123456")),
            Arguments.of(listOf("1", "2", "verylongname")),
        )
    }
}