package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `should print race result and winner when one round is played`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "Winners : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `should print final result and winner when multiple rounds are played`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "3")
                assertThat(output()).contains("pobi : --", "woni : -", "jun : ", "Winners : pobi")
            },
            MOVING_FORWARD, STOP, STOP,
            MOVING_FORWARD, STOP, STOP,
            STOP, MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `should print final result and winners when multiple rounds are played`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "3")
                assertThat(output()).contains("pobi : -", "woni : --", "jun : --", "Winners : woni, jun")
            },
            STOP, STOP, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, STOP,
            STOP, MOVING_FORWARD, MOVING_FORWARD
        )
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}
