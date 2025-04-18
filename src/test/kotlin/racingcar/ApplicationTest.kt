package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `should determine winner correctly for single round`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "Winners : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `should throw exception for invalid car names`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `should handle multiple rounds correctly`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "3")
                assertThat(output()).contains(
                    "pobi : -",
                    "woni : -",
                    "jun : -",
                    "Winners : pobi, woni, jun"
                )
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `should handle single car race`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi", "2")
                assertThat(output()).contains("pobi : --", "Winners : pobi")
            },
            MOVING_FORWARD, MOVING_FORWARD
        )
    }

    @Test
    fun `should throw exception for invalid input format`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,,woni", "2") }
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}