package racingcar

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class ValidatorTest {

    @ParameterizedTest
    @MethodSource("provideNameAndLimitForException")
    fun `exception occurs when car name length is greater than 5 or empty or blank`(
        name: String,
        limit: Int,
    ) {
        val validator = Validator()

        assertThrows<IllegalArgumentException> {
            validator.validateName(name, limit)
        }
    }

    @ParameterizedTest
    @MethodSource("provideNameAndLimitForNoException")
    fun `no exception occurs when car name length is 5 or less`(name: String, limit: Int) {
        val validator = Validator()

        assertDoesNotThrow {
            validator.validateName(name, limit)
        }
    }

    companion object {

        @JvmStatic
        private fun provideNameAndLimitForException(): List<Arguments> {
            return listOf(
                Arguments.of("juuuuun", 5),
                Arguments.of("", 5),
                Arguments.of(" ", 5),
                Arguments.of("     ", 5),
            )
        }

        @JvmStatic
        private fun provideNameAndLimitForNoException(): List<Arguments> {
            return listOf(
                Arguments.of("juuun", 5),
                Arguments.of("jun", 5),
                Arguments.of("j", 5),
            )
        }
    }
}
