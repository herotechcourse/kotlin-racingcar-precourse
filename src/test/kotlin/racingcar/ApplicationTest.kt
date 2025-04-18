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
    fun `feature test2`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,phan", "2")
                assertThat(output()).contains(
                    "pobi : -", "woni : ", "phan : -",
                    "pobi : --", "woni : ", "phan : -",
                    "Winners : pobi"
                )
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD,
            MOVING_FORWARD, STOP, STOP
        )
    }

    @Test
    fun `feature test3`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,phan", "2")
                assertThat(output()).contains(
                    "pobi : -", "woni : ", "phan : -",
                    "pobi : --", "woni : -", "phan : --",
                    "Winners : pobi, phan"
                )
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        )
    }

    @Test
    fun `exception test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `round num is too large number`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,woni", "10001")
            }
        }
    }

    @Test
    fun `round num is under then 1`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,woni", "0")
            }
        }
    }

    @Test
    fun `round num is not integer`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,woni", "one")
            }
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
