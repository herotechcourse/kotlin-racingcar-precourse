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
    fun `(TEST_1) car name contains whitespace`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException>{
                runException("pobi, woni", "1")
            }
        }
    }

    @Test
    fun `(TEST_2) multiple winner scenario`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : -")
                assertThat(output()).contains("Winners : pobi, woni")
            },
            MOVING_FORWARD,
            MOVING_FORWARD
        )
    }

    @Test
    fun `(TEST_3) round count is zero`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException>{
                runException("pobi,woni", "0")
            }
        }
    }

    @Test
    fun `(TEST_4) round count is negative`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException>{
                runException("pobi,woni", "-3")
            }
        }
    }

    @Test
    fun `(TEST_5) round count is non-numeric`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException>{
                runException("pobi,woni", "one")
            }
        }
    }

    @Test
    fun `(TEST_6) round count is blank`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException>{
                runException("pobi,woni", " ")
            }
        }
    }

    @Test
    fun `(TEST_7) car name contains invalid character`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException>{
                runException("p@bi,woni", "1")
            }
        }
    }

    @Test
    fun `(TEST_8) duplicated car names`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException>{
                runException("pobi,pobi", " ")
            }
        }
    }

    @Test
    fun `(TEST_9) round count exceed upper limit`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException>{
                runException("pobi,woni", "501")
            }
        }
    }

    @Test
    fun `(TEST_10) number of cars exceed maximum`() {
        val cars = (1..101).joinToString(",") { "car$it" }
        assertSimpleTest {
            assertThrows<IllegalArgumentException>{
                runException(cars, "1")
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
