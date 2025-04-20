/**
 * Test for RaceConfiguration classes
 */

package racingcar

import java.util.stream.Stream

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.api.assertThrows

class FixedRoundsRaceConfigurationTest {
    @ParameterizedTest
    @MethodSource("provideArgumentsForFeatureTest")
    fun `factory method test`(namesString: String, expectedNames: List<String>, nRoundsString: String, expectedNRounds: Int) {
        val config = FixedRoundsRaceConfiguration.from(namesString, nRoundsString)
        assertThat(config.carNames).isEqualTo(expectedNames)
        assertThat(config.nRounds).isEqualTo(expectedNRounds)
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForExceptionTest")
    fun `exception test`(namesString: String, nRoundsString: String) {
        assertThrows<IllegalArgumentException> { FixedRoundsRaceConfiguration.from(namesString, nRoundsString) }
    }

    companion object {
        @JvmStatic
        private fun provideArgumentsForFeatureTest() : Stream<Arguments> {
            return Stream.of(
                Arguments.of("alpha,beta", listOf<String>("alpha", "beta"), "1", 1),
                Arguments.of("alpha,beta,gamma", listOf<String>("alpha", "beta", "gamma"), "100", 100),
                Arguments.of("alpha,beta,gamma,delta", listOf<String>("alpha", "beta", "gamma", "delta"), "200", 200),
                Arguments.of("alpha   ,beta ,  gamma,delta  ", listOf<String>("alpha", "beta", "gamma", "delta"), "200", 200),
            )
        }

        @JvmStatic
        private fun provideArgumentsForExceptionTest() : Stream<Arguments> {
            return Stream.of(
                Arguments.of("", ""), // Empty input
                Arguments.of("", "30"), // Empty input
                Arguments.of("alpha,beta", ""), // Empty input

                Arguments.of("alpha", ""), // Single car name
                Arguments.of("alpha,beta,,gamma", "50"), // Empty car name
                Arguments.of("alpha,    ,beta,gamma", "50"), // Space-only car name

                Arguments.of("alpha,beta,gamma,delta,epsilon,alpha", "50"), // Duplicate car names
                Arguments.of("alpha,beta,gamma,delta,epsilon,beta", "50"), // Duplicate car names
                Arguments.of("alpha,beta,gamma,delta,epsilon,gamma", "50"), // Duplicate car names
                Arguments.of("alpha,beta,gamma,delta,epsilon,delta", "50"), // Duplicate car names
                Arguments.of("alpha,beta,gamma,delta,epsilon,epsilon", "50"), // Duplicate car names
                Arguments.of("alpha,beta,gamma,delta,epsilon,alpha,beta", "50"), // Duplicate car names

                Arguments.of("alpha,beta,gamma", "-500"), // Number of rounds out of bounds
                Arguments.of("alpha,beta,gamma", "-1"), // Number of rounds out of bounds
                Arguments.of("alpha,beta,gamma", "0"), // Number of rounds out of bounds
                Arguments.of("alpha,beta,gamma", "500"), // Number of rounds out of bounds
                Arguments.of("alpha,beta,gamma", "5.12"), // Invalid number of rounds
            )
        }
    }
}
