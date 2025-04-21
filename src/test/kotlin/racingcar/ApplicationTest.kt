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
    fun `Throw when name is longer than 5 characters`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji") }
        }
    }

    @Test
    fun `Throw when input is empty`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("\n") }
        }
    }

    @Test
    fun `Throw when an empty name exists`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,,kim") }
        }
    }

    @Test
    fun `Throw when there are duplicate names`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,pobi") }
        }
    }

    @Test
    fun `Throw when round input is non-Integer`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1a") }
        }
    }

    @Test
    fun `Throw when round input is empty`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "") }
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
