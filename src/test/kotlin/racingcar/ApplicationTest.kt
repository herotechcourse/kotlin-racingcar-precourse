package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `feature test`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "Winners : pobi")
            },
            MOVING_FORWARD,
            STOP,
        )
    }

    @Test
    fun `exception test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `exception test for blank car name`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi, ", "1")
            }
        }
    }

    @Test
    fun `tie case when both cars move equally`() {
        assertRandomNumberInRangeTest(
            {
                run("car1,car2", "2")
                assertThat(output()).contains("Winners : car1, car2")
            },
            MOVING_FORWARD, MOVING_FORWARD,  // round 1
            MOVING_FORWARD, MOVING_FORWARD   // round 2
        )
    }

    @Test
    fun `single car scenario should print that car as winner`() {
        assertRandomNumberInRangeTest(
            {
                run("solo", "3")
                assertThat(output()).contains("Winners : solo")
            },
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
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
