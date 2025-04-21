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
            MOVING_FORWARD ,
            STOP,
        )
    }

    @Test
    fun `two winners one round two move test`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,dado", "1")
                assertThat(output()).contains("pobi : -", "woni : -", "dado : ", "Winners : pobi, woni")
            },
            MOVING_FORWARD ,
            MOVING_FORWARD,
            STOP,
        )
    }

    @Test
    fun `two winners one round both stop test`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : ", "woni : ", "Winners : pobi, woni")
            },
            STOP ,
            STOP,
        )
    }

    @Test
    fun `one winner ten rounds test`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "10")
                assertThat(output()).contains("pobi : -----", "woni : ------", "Winners : woni")
            },
            STOP , MOVING_FORWARD,
            MOVING_FORWARD, STOP,
            STOP, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD,
            STOP, STOP,
            MOVING_FORWARD, STOP,
            STOP, MOVING_FORWARD,
            STOP, STOP,
            MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD,
        )
    }

    @Test
    fun `two winners ten rounds test`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "10")
                assertThat(output()).contains("pobi : -----", "woni : -----", "Winners : pobi, woni")
            },
            STOP, STOP,
            MOVING_FORWARD, MOVING_FORWARD,
            STOP, STOP,
            MOVING_FORWARD, MOVING_FORWARD ,
            MOVING_FORWARD, STOP,
            STOP, MOVING_FORWARD,
            STOP, STOP,
            MOVING_FORWARD, STOP,
            STOP, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD,
        )
    }

    @Test
    fun `three winners ten rounds test`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,one,two,three", "10")
                assertThat(output()).contains("pobi : -----", "woni : -----", "one : -----", "two : --", "three : ---", "Winners : pobi, woni, one")
            },
            STOP, STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD,
            STOP, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD , MOVING_FORWARD, STOP, STOP,
            MOVING_FORWARD, STOP, STOP, STOP, STOP,
            STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, STOP,
            STOP, STOP, STOP, STOP, STOP,
            MOVING_FORWARD, STOP, STOP, STOP, STOP,
            STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, STOP,
            MOVING_FORWARD, MOVING_FORWARD, STOP, STOP, STOP,
        )
    }

    @Test
    fun `two winners two rounds test`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : -", "Winners : pobi, woni")
            },
            MOVING_FORWARD ,
            MOVING_FORWARD,
            STOP,
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
    fun `invalid name input separator`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi:oni", "1") }
        }
    }

    @Test
    fun `invalid round input not int`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,oni", "one") }
        }
    }

    @Test
    fun `equal names one winner test`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,pobi", "1")
                assertThat(output()).contains("pobi : -", "pobi : ", "Winners : pobi")
            },
            MOVING_FORWARD ,
            STOP,
            STOP,
            STOP,
        )
    }

    @Test
    fun `empty list with separator test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(",", "1") }
        }
    }

    @Test
    fun `empty list without separator test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("", "1") }
        }
    }

    @Test
    fun `equal names both winners test`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,pobi", "1")
                assertThat(output()).contains("pobi : -", "pobi : -", "Winners : pobi, pobi")
            },
            MOVING_FORWARD ,
            MOVING_FORWARD,
            STOP,
            STOP,
        )
    }

    @Test
    fun `invalid round input zero`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,oni", "0") }
        }
    }

    @Test
    fun `invalid round input negative number`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,oni", "-1") }
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
