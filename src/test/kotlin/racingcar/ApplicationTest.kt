package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {

    @Test
    fun `throws exception when car name is too long`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,toolongname", "3")
            }
        }
    }

    @Test
    fun `throws exception when car name is empty`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,", "3")
            }
        }
    }

    @Test
    fun `throws exception when duplicate car names exist`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,pobi", "3")
            }
        }
    }

    @Test
    fun `throws exception when round count is not a number`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,woni", "abc")
            }
        }
    }

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

    // additions to previous version
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat

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

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
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


}
