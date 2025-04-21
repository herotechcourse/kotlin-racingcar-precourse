package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.stub.StubNumberGenerator

class RandomMoveStrategyTest {

    @Test
    fun `getDistance returns 1 when stub returns 4`() {
        // given
        val strategy = RandomMoveStrategy(StubNumberGenerator(4))

        // when
        val distance = strategy.getDistance()
        
        //then
        assertThat(distance).isEqualTo(1)
    }

    @Test
    fun `getDistance returns 0 when stub returns 3`() {
        // given
        val strategy = RandomMoveStrategy(StubNumberGenerator(3))

        // when
        val distance = strategy.getDistance()

        //then
        assertThat(distance).isEqualTo(0)
    }
}
