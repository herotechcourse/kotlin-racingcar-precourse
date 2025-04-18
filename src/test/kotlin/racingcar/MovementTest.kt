package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MovementRandomTest : NsTest() {
    @Test
    fun `shouldMove returns true when random ≥ threshold and false otherwise`() {
        assertRandomNumberInRangeTest(
            {
                assertThat(Movement.shouldMove()).isTrue()
                assertThat(Movement.shouldMove()).isFalse()
            },
            MOVING_FORWARD,
            STOP
        )
    }

    override fun runMain() {}

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
