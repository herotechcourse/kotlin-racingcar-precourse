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
    fun `exception test car name length exited 5`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `exception test empty input`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("", "1") }
        }
    }

    @Test
    fun `exception test blank input`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("           ", "1") }
        }
    }

    @Test
    fun `exception test empty car name`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,,jaji", "1") }
        }
    }

    @Test
    fun `exception test negative number`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,,jaji", "-1") }
        }
    }

    @Test
    fun `exception test 0 number`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,,jaji", "0") }
        }
    }

    @Test
    fun `exception test empty number input`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,,jaji", "") }
        }
    }

    @Test
    fun `exception test blank number input`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,,jaji", "           ") }
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
