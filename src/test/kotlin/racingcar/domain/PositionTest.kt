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
            val next = position.forwarded()
            assertThat(next.value()).isEqualTo(1)
            assertThat(position.value()).isEqualTo(0)
        }

        @Test
        fun `it should increase by 3 after calling forwarded 3 times`() {
            val position = Position.from()
            val moved = (1..3).fold(position) { acc, _ -> acc.forwarded() }
            assertThat(moved.value()).isEqualTo(3)
            assertThat(position.value()).isEqualTo(0)
        }
    }
}
