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
    fun `should handle multiple winners correctly`(){
        assertRandomNumberInRangeTest(
            {
                run("bmw,audi,benz","3")
                assertThat(output()).contains(
                    "bmw : -",
                    "audi : -",
                    "benz : -",
                    "bmw : --",
                    "audi : --",
                    "benz : -",
                    "bmw : --",
                    "audi : --",
                    "benz : --",
                    "Winners : bmw, audi, benz"
                )
            },
            // Round 1: All cars move
            MOVING_FORWARD,
            MOVING_FORWARD,
            MOVING_FORWARD,
            // Round 2: bmw & audi move, benz stays
            MOVING_FORWARD,
            MOVING_FORWARD,
            STOP,
            // Round 3: benz moves, others stay
            STOP,
            STOP,
            MOVING_FORWARD
        )
    }

    @Test
    fun `should immediately declare winner with only one car without racing`() {
        assertSimpleTest {
            run("test", "5")

            // Check that proper initial message is displayed
            assertThat(output()).contains("Race results by round:")

            // Check that only the initial position is shown (no racing)
            assertThat(output()).contains("test : ")

            // Check that no additional positions are shown (would have dashes)
            assertThat(output()).doesNotContain("test : -")

            // Check that ferrari is declared winner
            assertThat(output()).contains("Winners : test")
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
