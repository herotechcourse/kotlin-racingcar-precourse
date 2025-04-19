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
                assertThat(output()).contains(
                    "Race Results",
                    "pobi : -",
                    "woni : ",
                    "Winner : pobi"
                )
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
    fun `feature test - both cars move and tie`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains(
                    "pobi : -",
                    "woni : -",
                    "Winners : pobi, woni"
                )
            },
            MOVING_FORWARD,
            MOVING_FORWARD
        )
    }

    @Test
    fun `exception test - negative rounds`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                run("pobi, woni", "-2")
            }
        }
    }

    @Test
    fun `exception test - empty inputs`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                run("", "")
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
