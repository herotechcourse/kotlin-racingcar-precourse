package racingcar.util

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import racingcar.util.Parser.parseCarName
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ParserTest {

    @ParameterizedTest
    @MethodSource("provideCarNames")
    @DisplayName("사용자 입력 콤마로 split")
    fun parseCarsTest(input: String?, expected: List<String?>?) {
        Assertions.assertThat(parseCarName(input)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        private fun provideCarNames(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("polar,bear,pop,pep", listOf("polar", "bear", "pop", "pep")),
                Arguments.of("a,b,c,d", listOf("a", "b", "c", "d")),
                Arguments.of("apple,banana,grape", listOf("apple", "banana", "grape"))
            )
        }
    }
}
