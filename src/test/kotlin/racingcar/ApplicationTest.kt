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
    fun `car name longer than 5 chars throws exception`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,javaji", "1")
            }
        }
    }

    @Test
    fun `multiple winners are displayed correctly`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("Winners : pobi, woni")
            },
            MOVING_FORWARD,
            MOVING_FORWARD
        )
    }

    @Test
    fun `cars move correctly over multiple rounds`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi", "3")
                assertThat(output()).contains("pobi : -")
                assertThat(output()).contains("pobi : --")
                assertThat(output()).contains("pobi : ---")
            },
            MOVING_FORWARD,
            MOVING_FORWARD,
            MOVING_FORWARD
        )
    }

    @Test
    fun `empty car name list throws exception`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("", "3")
            }
        }
    }

    @Test
    fun `blank name among inputs throws exception`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,,woni", "2")
            }
        }
    }

 
    @Test
    fun `non-numeric round throws exception`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,woni", "abc")
            }
        }
    }

    @Test
    fun `race progress prints correct number of lines per car`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "3")
                val raceLines = output().lines().filter { it.contains("pobi :") }
                assertThat(raceLines).hasSize(3)
            },
            MOVING_FORWARD, STOP,
            MOVING_FORWARD, STOP,
            MOVING_FORWARD, STOP
        )
    }

    override fun runMain() {
        main(arrayOf())
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}