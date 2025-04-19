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
    fun `two rounds one winner`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "2")
                val result = output()

                assertThat(result).containsSubsequence(
                    "pobi : -",
                    "woni : ",
                    "",
                    "pobi : --",
                    "woni : ",
                    "",
                    "Winners : pobi"
                )
            },
            MOVING_FORWARD, STOP,
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `three cars move together and tie`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "1")
                val result = output()

                assertThat(result).contains("pobi : -", "woni : -", "jun : -")
                assertThat(result).contains("Winners : pobi, woni, jun")
            },
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        )
    }

    @Test
    fun `car ties in second round`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "2")
                val result = output()

                assertThat(result).containsSubsequence(
                    "pobi : -",
                    "woni : ",
                    "",
                    "pobi : -",
                    "woni : -",
                    "",
                    "Winners : pobi, woni"
                )
            },
            MOVING_FORWARD, STOP,
            STOP, MOVING_FORWARD
        )
    }

    @Test
    fun `only one car moves at all`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "3")
                val result = output()

                assertThat(result).contains("pobi : ---", "woni : ")
                assertThat(result).contains("Winners : pobi")
            },
            MOVING_FORWARD, STOP,
            MOVING_FORWARD, STOP,
            MOVING_FORWARD, STOP
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
