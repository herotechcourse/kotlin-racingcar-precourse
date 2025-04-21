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
    fun outputsRaceResultsCorrectlyForEachRound() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,jun", "2")
                val lines = output().lines().filter { it.contains("pobi") || it.contains("jun") }

                assertThat(lines.count { it.contains("pobi") }).isEqualTo(3)
                assertThat(lines.count { it.contains("jun") }).isEqualTo(3)
            },
            MOVING_FORWARD, STOP,
            STOP, MOVING_FORWARD
        )
    }

    @Test
    fun outputsSingleWinnerCorrectly() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,jun", "1")
                assertThat(output()).contains("Winners : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun outputsMultipleWinnersWhenTied() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,jun", "1")
                assertThat(output()).contains("Winners : pobi, jun")
            },
            MOVING_FORWARD, MOVING_FORWARD
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
