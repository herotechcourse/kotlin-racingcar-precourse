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
    fun `should show multiple winners when tie occurs`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,jun", "1")
                assertThat(output()).contains("pobi : -", "jun : -", "Winners : pobi, jun")
            },
            MOVING_FORWARD, MOVING_FORWARD
        )
    }

    @Test
    fun `exception test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji" , "1") }
        }
    }

    @Test
    fun `should throw exception if car name is blank`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException(" ,jun", "1")
            }
        }
    }

    @Test
    fun `should throw exception if round is not a number`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,jun", "abc")
            }
        }
    }

    @Test
    fun `should throw exception if round is zero`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,jun", "0")
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
