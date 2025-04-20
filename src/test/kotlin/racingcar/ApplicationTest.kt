package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.assertj.core.api.Assertions.assertThatThrownBy

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

    // New tests for Input Car Names feature

    @Test
    fun `accepts valid comma-separated car names`() {
        assertSimpleTest {
            run("pobi,woni,jun", "1")
            assertThat(output()).contains("pobi : ", "woni : ", "jun : ")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", ",", "pobi,,jun", "pobi, ,jun"])
    fun `rejects empty car names`(input: String) {
        assertSimpleTest {
            assertThatThrownBy { runException(input, "1") }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("Car names must be between 1 and 5 characters long")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["verylong", "pobi,abcdef", "123456"])
    fun `rejects car names longer than 5 characters`(input: String) {
        assertSimpleTest {
            assertThatThrownBy { runException(input, "1") }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("Car names must be between 1 and 5 characters long")
        }
    }

    // New tests for Input Number of Rounds feature
    @ParameterizedTest
    @ValueSource(strings = ["0", "-1"])
    fun `rejects non-positive round numbers`(input: String) {
        assertSimpleTest {
            assertThatThrownBy { runException("pobi,woni", input) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("Number of rounds must be at least 1")
        }
    }



    @Test
    fun `accepts valid positive round numbers`() {
        assertSimpleTest {
            run("pobi,woni", "5")
            assertThat(output()).contains("the expected rounds 5")
        }
    }

    // New tests for Race Simulation feature
    @Test
    fun `cars move forward when random number is 4 or higher`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi", "1")
                assertThat(output()).contains("pobi : -")
            },
            MOVING_FORWARD
        )
    }

    @Test
    fun `cars do not move when random number is less than 4`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi", "1")
                assertThat(output()).contains("pobi : ")
            },
            STOP
        )
    }

    @Test
    fun `displays correct progress after each round`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "2")
                assertThat(output())
                    .contains("Race Results:")
                    .contains("pobi : -", "woni : ")  // Round 1
                    .contains("pobi : --", "woni : -") // Round 2
            },
            MOVING_FORWARD, // pobi moves round 1
            STOP,          // woni stops round 1
            MOVING_FORWARD, // pobi moves round 2
            MOVING_FORWARD  // woni moves round 2
        )
    }

    // New tests for Determine Winners feature
    @Test
    fun `declares single winner correctly`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("Winners : pobi")
            },
            MOVING_FORWARD, // pobi moves
            STOP            // woni stops
        )
    }

    @Test
    fun `declares multiple winners correctly when tied`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "1")
                assertThat(output()).contains("Winners : pobi,woni,jun")
            },
            STOP, // pobi stops
            STOP, // woni stops
            STOP  // jun stops
        )
    }

    @Test
    fun `handles multiple rounds correctly for winner determination`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "3")
                assertThat(output()).contains("Winners : woni")
            },
            MOVING_FORWARD, // pobi moves round 1
            STOP,           // woni stops round 1
            STOP,           // pobi stops round 2
            MOVING_FORWARD, // woni moves round 2
            STOP,           // pobi stops round 3
            MOVING_FORWARD  // woni moves round 3
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
