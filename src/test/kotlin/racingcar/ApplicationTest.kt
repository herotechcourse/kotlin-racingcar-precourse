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
    fun `feature test 2`() {
        assertRandomNumberInRangeTest(
                {
                    run("pobi,woni", "2")
                    assertThat(output()).contains("pobi : -", "woni : ", "Winners : pobi, woni")
                },
                MOVING_FORWARD,
                STOP,
                STOP,
                MOVING_FORWARD,
        )
    }

    @Test
    fun `exception test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }
    @Test
    fun `exception test b`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `test execution large number of rounds`() {
        assertSimpleTest {
            run("pobi, mobi", "300")
            assertThat(output()).contains("pobi", "mobi")
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
