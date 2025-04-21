package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import racingcar.domain.ErrorMessages.ROUND_LESS_THAN_ONE

class RoundTest {

    @Test
    fun `initialization succeeds when round is one or greater`() {
        // given
        val input = 3

        // when
        val round = Round(input)

        // then
        assertThat(round.round).isEqualTo(input)
    }
    
    @Test
    fun `initialization fails when round is less than one`() {
        // given
        val input = 0
        
        // when
        
        //then
        assertThatThrownBy { Round(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ROUND_LESS_THAN_ONE)
    }
}
