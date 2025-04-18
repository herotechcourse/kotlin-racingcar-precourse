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
    fun `feature test 1`() {
        assertRandomNumberInRangeTest(
            {
                run("po bi,   ,woni ", "1")
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
    fun `exception test 1`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,java", "-1") }
        }
    }

    @Test
    fun `exception test 2`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,java", "a") }
        }
    }

    @Test
    fun `exception test 3`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,java", "0") }
        }
    }

    @Test
    fun `exception test 4`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("  ,   ,", "1") }
        }
    }

    @Test
    fun `exception test 5`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,java", " ") }
        }
    }

    @Test
    fun `exception test 6`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,pobi, java", "1") }
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
