package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

import racingcar.exception.ExceptionMessage

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
    fun `(TEST_0) car name is blank`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException>{
                runException("", "1")
            }
            assertThat(exception.message).isEqualTo(ExceptionMessage.EMPTY_CAR_NAME.message)
        }
    }

    @Test
    fun `(TEST_1) car name contains whitespace`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException>{
                runException("pobi, woni", "1")
            }
            assertThat(exception.message).isEqualTo(ExceptionMessage.CAR_NAME_WITH_WHITESPACE.message)
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
            val exception = assertThrows<IllegalArgumentException>{
                runException("pobi,woni", "0")
            }
            assertThat(exception.message).isEqualTo(ExceptionMessage.INVALID_ROUND_COUNT.message)
        }
    }

    @Test
    fun `(TEST_4) round count is negative`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException>{
                runException("pobi,woni", "-3")
            }
            assertThat(exception.message).isEqualTo(ExceptionMessage.INVALID_ROUND_COUNT.message)
        }
    }

    @Test
    fun `(TEST_5) round count is non-numeric`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException>{
                runException("pobi,woni", "one")
            }
            assertThat(exception.message).isEqualTo(ExceptionMessage.INVALID_ROUND_COUNT.message)
        }
    }

    @Test
    fun `(TEST_6) round count is blank`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException>{
                runException("pobi,woni", " ")
            }
            assertThat(exception.message).isEqualTo(ExceptionMessage.INVALID_ROUND_COUNT.message)
        }
    }

    @Test
    fun `(TEST_7) car name contains invalid character`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException>{
                runException("p@bi,woni", "1")
            }
            assertThat(exception.message).isEqualTo(ExceptionMessage.INVALID_CHARACTER_IN_CAR_NAME.message)
        }
    }

    @Test
    fun `(TEST_8) duplicated car names`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException>{
                runException("pobi,pobi", " ")
            }
            assertThat(exception.message).isEqualTo(ExceptionMessage.DUPLICATE_CAR_NAME.message)
        }
    }

    @Test
    fun `(TEST_9) round count exceed upper limit`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException>{
                runException("pobi,woni", "501")
            }
            assertThat(exception.message).isEqualTo(ExceptionMessage.EXCEED_MAX_ROUND_COUNT.message)
        }
    }

    @Test
    fun `(TEST_10) number of cars exceed maximum`() {
        val cars = (1..101).joinToString(",") { "c$it" }
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException>{
                runException(cars, "1")
            }
            assertThat(exception.message).isEqualTo(ExceptionMessage.EXCEED_MAX_CAR_COUNT.message)
        }
    }

    @Test
    fun `(TEST_11) no cars move`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : ", "woni : ")
                assertThat(output()).contains("Winners : pobi, woni")
            },
            STOP,
            STOP
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
