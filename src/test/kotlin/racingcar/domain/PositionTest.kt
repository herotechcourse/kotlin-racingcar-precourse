package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class PositionTest {

    @Nested
    inner class `When creating Position` {

        @Test
        fun `it should start from zero`() {
            val position = Position.from()
            assertThat(position.value()).isEqualTo(0)
        }
    }

    @Nested
    inner class `When moving forward` {

        @Test
        fun `it should increase by 1`() {
            val position = Position.from()
            position.forward()
            assertThat(position.value()).isEqualTo(1)
        }

        @Test
        fun `it should increase by 3 after calling forward 3 times`() {
            val position = Position.from()
            repeat(3) { position.forward() }
            assertThat(position.value()).isEqualTo(3)
        }
    }
}
