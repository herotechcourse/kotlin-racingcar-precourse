package racingcar.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RoundTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 11])
    fun `throw exception when the round is out of range`(round: Int) {
        // when & then
        assertThatThrownBy { Round(round) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Round range must be between ${MIN_ROUND} and ${MAX_ROUND}.")
    }

    companion object {
        private const val MIN_ROUND: Int = 1
        private const val MAX_ROUND: Int = 10
    }
}
