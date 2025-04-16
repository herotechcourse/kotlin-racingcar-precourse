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
    fun `race with only one car`() {
        assertRandomNumberInRangeTest(
            {
                run("solo", "2")
                assertThat(output()).contains("solo : ", "Winners : solo")
            },
            STOP, STOP
        )
    }

    @Test
    fun `all cars stop and never move`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,john", "3")
                assertThat(output()).contains("Winners : pobi, woni, john")
            },
            STOP, STOP, STOP, STOP, STOP, STOP, STOP, STOP, STOP
        )
    }

    @Test
    fun `car name with one character`() {
        assertRandomNumberInRangeTest(
            {
                run("a,b", "1")
                assertThat(output()).contains("Winners : a", "b : ")
            },
            MOVING_FORWARD,
            STOP
        )
    }

    @Test
    fun `car name too long`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("superman,batman", "1") }
        }
    }

    @Test
    fun `multiple winners`() {
        assertRandomNumberInRangeTest(
            {
                run("aaa,bbb,ccc", "1")
                assertThat(output()).contains("Winners : aaa, bbb")
            },
            MOVING_FORWARD, MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `non-numeric round input`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "abc") }
        }
    }

    @Test
    fun `throws exception for newline in round input`() {
        val input = "\n"
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", input) }
        }
    }

    @Test
    fun `throws exception for empty round input`() {
        val input = ""
        assertThrows<IllegalArgumentException> { Input.parseNumberOfRounds(input) }
    }

    @Test
    fun `throws exception for empty string in rounds input`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("", "10") }
        }
    }

    @Test
    fun `throws exception for spaces in number`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "   ") }
        }
    }

    @Test
    fun `throws exception for spaces in car`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("           ", "5") }
        }
    }

    @Test
    fun `more then maximum int value for round`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "2147483648") }
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
