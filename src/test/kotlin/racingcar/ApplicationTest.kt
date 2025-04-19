package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `single winner case`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains(
                    "pobi : -", 
                    "woni : ", 
                    "",
                    "Winners : pobi"
                )
            },
            MOVING_FORWARD,
            STOP
        )
    }

    @Test
    fun `multiple winners case`() {
        assertRandomNumberInRangeTest(
            {
                run("a,b,c", "2")
                assertThat(output()).contains(
                    "a : -", 
                    "b : -", 
                    "c : -",
                    "",
                    "a : --", 
                    "b : --", 
                    "c : --",
                    "",
                    "Winners : a, b, c"
                )
            },
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        )
    }

    @Test
    fun `max length names test`() {
        assertRandomNumberInRangeTest(
            {
                run("abcde,fghij", "1")
                assertThat(output()).contains(
                    "abcde : -", 
                    "fghij : ", 
                    "",
                    "Winners : abcde"
                )
            },
            MOVING_FORWARD,
            STOP
        )
    }

    @Test
    fun `empty name test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,,jun", "1")
            }
        }
    }

    @Test
    fun `name too long test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("longname,short", "1")
            }
        }
    }

    @Test
    fun `invalid round number test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("a,b,c", "0")
            }
        }
    }

    @Test
    fun `invalid round format test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("a,b,c", "five")
            }
        }
    }

    @Test
    fun `duplicate names test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,pobi", "1")
            }
        }
    }

    @Test
    fun `no cars test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("", "1")
            }
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}