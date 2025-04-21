package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
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
    fun `feature test2`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,kang,feel", "2")
                assertThat(output()).contains(
                    "pobi : ", "woni : ", "kang : -" ,"feel : -",
                    "pobi : -", "woni : -", "kang : --", "feel : --",
                    "Winners : kang, feel"
                )
            },
            STOP, STOP, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        )
    }



    @Test
    fun `exception test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    @DisplayName("round num input should be less than 1,000,000")
    fun `exception test2`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,java", "1000001") }
        }
    }

    @Test
    @DisplayName("round num input shouldn't be negative value")
    fun `exception test3`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,java", "-1") }
        }
    }

    @Test
    @DisplayName("round num should be integer type")
    fun `exception test4`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,java", "three") }
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
