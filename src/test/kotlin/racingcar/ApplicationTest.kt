package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `should have pobi as winner`() {
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
    fun `should have 2 winners`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "2")
                assertThat(output()).contains("pobi : -", "woni : -", "Winners : pobi, woni")
            },
            MOVING_FORWARD,
            STOP,
            STOP,
            MOVING_FORWARD
        )
    }

    @Test
    fun `should throw exception for longer than 5 characters`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `should throw exception for negative nr of rounds`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,java", "-1") }
        }
    }

    @Test
    fun `should throw exception for nr of rounds equals to 0`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,java", "0") }
        }
    }

    @Test
    fun `should throw exception for invalid number`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,java", "ddd") }
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
