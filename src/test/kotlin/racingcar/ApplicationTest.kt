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
    fun `multiple winners test`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "2")
                assertThat(output()).contains("pobi : --", "woni : --", "jun : ", "Winners : pobi, woni")
            },
            MOVING_FORWARD, MOVING_FORWARD, STOP, // 1st round
            MOVING_FORWARD, MOVING_FORWARD, STOP  // 2nd round
        )
    }

    @Test
    fun `exception test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `no player name test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(" ", "1") }
        }
    }

    @Test
    fun `not a number test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,java", "abc") }
        }
    }
    @Test
    fun `negative number test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,java", "-1") }
        }
    }
    @Test
    fun `empty number test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,java", " ") }
        }
    }


    @Test
    fun `no player name test 2`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(",,", "1") }
        }
    }

    @Test
    fun `zero attempt test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,woni", "0")
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
