package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
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

    @Test
    fun `should return true when round is remaining`() {
        // given
        val round = Round(1)
        // when
        val isRemaining = round.isRemaining()
        // then
        assertThat(isRemaining).isTrue()
    }

    @Test
    fun `should return false when round is not remaining`() {
        // given
        val round = Round(1)
        round.decrement()
        // when
        val isRemaining = round.isRemaining()
        // then
        assertThat(isRemaining).isFalse()
    }

    @Test
    fun `can decrement the round`() {
        // given
        val round = Round(1)
        // when
        round.decrement()
        // then
        assertThat(round.getLeftRound()).isEqualTo(0)
    }

    companion object {
        private const val MIN_ROUND: Int = 1
        private const val MAX_ROUND: Int = 10
    }
}
