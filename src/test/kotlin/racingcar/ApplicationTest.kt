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
    fun `lenghtOfName test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobiiiii", "1")  }
        }
    }

    @Test
    fun `duplicate test`() {
        assertSimpleTest{
            assertThrows<IllegalArgumentException> { runException("pobi,pobi", "1")  }
        }
    }

    @Test
    fun `empty test`() {
        assertSimpleTest{
            assertThrows<IllegalArgumentException> { runException("pobi,,woni", "1")  }
        }
    }

    @Test
    fun `notIntegerRound test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "abc") }
        }
    }

    @Test
    fun `negativeRound test`() {
        assertSimpleTest{
            assertThrows<IllegalArgumentException> { runException("pobi", "-1")  }
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
