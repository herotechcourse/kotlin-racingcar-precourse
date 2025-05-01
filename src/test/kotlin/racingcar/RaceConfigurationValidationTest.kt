/**
 * Test for RaceConfiguration classes
 */

package racingcar

import java.util.stream.Stream

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.assertDoesNotThrow

class FixedRoundsRaceConfigurationValidatorTest {
    private val validator = FixedRoundsRaceConfigurationValidator

    @ParameterizedTest
    @MethodSource("provideArgumentsForValidateNamesSizeNoExceptionTest")
    fun `validateNamesSize no exception test`(names: List<String>) {
        assertDoesNotThrow("Should not throw an exception") { validator.validateNamesSize(names) }
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForValidateNamesSizeExceptionTest")
    fun `validateNamesSize exception test`(names: List<String>) {
        assertThrows<IllegalArgumentException> { validator.validateNamesSize(names) }
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForValidateNameNoExceptionTest")
    fun `validateName no exception test`(name: String, index: Int) {
        assertDoesNotThrow("Should not throw an exception") { validator.validateName(name, index) }
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForValidateNameExceptionTest")
    fun `validateName exception test`(name: String, index: Int) {
        assertThrows<IllegalArgumentException> { validator.validateName(name, index) }
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForValidateNoDuplicateNamesNoExceptionTest")
    fun `validateNoDuplicateNames no exception test`(names: List<String>) {
        assertDoesNotThrow("Should not throw an exception") { validator.validateNoDuplicateNames(names) }
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForValidateNoDuplicateNamesExceptionTest")
    fun `validateNoDuplicateNames exception test`(names: List<String>) {
        assertThrows<IllegalArgumentException> { validator.validateNoDuplicateNames(names) }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 100, 500])
    fun `validateNRounds no exception test`(nRounds: Int) {
        assertDoesNotThrow("Should not throw an exception") { validator.validateNRounds(nRounds) }
    }

    @ParameterizedTest
    @ValueSource(ints = [-100, -1, 0, 501, 1000, 2000])
    fun `validateNRounds exception test`(nRounds: Int) {
        assertThrows<IllegalArgumentException> { validator.validateNRounds(nRounds) }
    }

    companion object {
        @JvmStatic
        private fun provideArgumentsForValidateNamesSizeNoExceptionTest() : Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf("alpha", "beta")),
                Arguments.of(listOf("alpha", "beta", "gamma")),
                Arguments.of(listOf("alpha", "beta", "gamma", "delta")),
                Arguments.of(listOf("alpha", "beta", "gamma", "delta", "epsilon")),
            )
        }

        @JvmStatic
        private fun provideArgumentsForValidateNamesSizeExceptionTest() : Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf("")),
                Arguments.of(listOf("   ")),
                Arguments.of(listOf("alpha")),
                Arguments.of(listOf("beta")),
                Arguments.of(listOf("gamma")),
            )
        }

        @JvmStatic
        private fun provideArgumentsForValidateNameNoExceptionTest() : Stream<Arguments> {
            return Stream.of(
                Arguments.of("a", 0),
                Arguments.of("al", 0),
                Arguments.of("alp", 0),
                Arguments.of("alph", 0),
                Arguments.of("alpha", 0),
            )
        }

        @JvmStatic
        private fun provideArgumentsForValidateNameExceptionTest() : Stream<Arguments> {
            return Stream.of(
                Arguments.of("", 0),
                Arguments.of("alpha0", 0),
                Arguments.of("betagamma", 0),
            )
        }

        @JvmStatic
        private fun provideArgumentsForValidateNoDuplicateNamesNoExceptionTest() : Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf("alpha", "beta")),
                Arguments.of(listOf("alpha", "beta", "gamma")),
                Arguments.of(listOf("alpha", "beta", "gamma", "delta")),
                Arguments.of(listOf("alpha", "beta", "gamma", "delta", "epsilon")),
            )
        }

        @JvmStatic
        private fun provideArgumentsForValidateNoDuplicateNamesExceptionTest() : Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf("alpha", "beta", "alpha")),

                Arguments.of(listOf("alpha", "beta", "gamma", "alpha")),
                Arguments.of(listOf("alpha", "beta", "gamma", "beta")),
                Arguments.of(listOf("alpha", "beta", "gamma", "gamma")),

                Arguments.of(listOf("alpha", "beta", "gamma", "delta", "epsilon", "beta")),
                Arguments.of(listOf("alpha", "beta", "gamma", "delta", "epsilon", "alpha")),
                Arguments.of(listOf("alpha", "beta", "gamma", "delta", "epsilon", "gamma")),
                Arguments.of(listOf("alpha", "beta", "gamma", "delta", "epsilon", "delta")),
                Arguments.of(listOf("alpha", "beta", "gamma", "delta", "epsilon", "epsilon")),

                Arguments.of(listOf("alpha", "beta", "gamma", "delta", "epsilon", "alpha", "beta")),
                Arguments.of(listOf("alpha", "beta", "gamma", "delta", "epsilon", "alpha", "tau")),
            )
        }
    }
}
