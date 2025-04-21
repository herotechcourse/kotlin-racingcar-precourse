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

    // 🆕 Test: Car moves only when number is 4 or more
    @Test
    fun `car moves forward when random number is 4 or higher`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                val output = output()
                assertThat(output).contains("pobi : -")
                assertThat(output).contains("Winners : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    // 🆕 Test: Car does not move if number is below 4
    @Test
    fun `car does not move when random number is less than 4`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi", "1")
                assertThat(output()).contains("pobi : ")
                assertThat(output()).contains("Winners : pobi")
            },
            STOP
        )
    }

    // 🆕 Test: Multiple winners when positions are tied
    @Test
    fun `multiple winners are shown if tied`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : -")
                assertThat(output()).contains("Winners : pobi, woni")
            },
            MOVING_FORWARD, MOVING_FORWARD
        )
    }

    // 🆕 Test: Car name too long
    @Test
    fun `throws exception when car name is too long`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,toolongname", "3")
            }
        }
    }

    // 🆕 Test: Empty car name
    @Test
    fun `throws exception when car name is empty`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,", "3")
            }
        }
    }

    // 🆕 Test: Duplicate car names
    @Test
    fun `throws exception when duplicate car names exist`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,pobi", "3")
            }
        }
    }

    // 🆕 Test: Non-numeric round count
    @Test
    fun `throws exception when round count is not a number`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,woni", "abc")
            }
        }
    }

    // 🆕 Test: Zero or negative round count
    @Test
    fun `throws exception when round count is zero or negative`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,woni", "0")
            }
        }
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,woni", "-1")
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
