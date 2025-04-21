package racingcar.domain.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PositionTest {

    @Test
    fun `should increase position`() {
        // given
        val position = Position()
        // when
        val increasedPosition = position.increase()
        // then
        assertThat(increasedPosition.value).isEqualTo(1)
    }
}
