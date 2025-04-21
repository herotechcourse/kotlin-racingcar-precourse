package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {

    // Feature 1: Takes and validates car names
    @Test
    fun `should validate car names and not accept names longer than 5 characters or empty names`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("too_long_name,valid", "1") // Should throw exception due to a name longer than 5 characters
            }
        }
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,,woni", "1") // Should throw exception due to an empty name
            }
        }
    }

    // Feature 2: Takes and validates the number of rounds
    @Test
    fun `should validate number of rounds and not accept negative or zero values`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,woni", "-1") // Should throw exception due to negative number of rounds
            }
        }
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,woni", "0") // Should throw exception due to zero rounds
            }
        }
        
    }

    // Feature 3: Moves cars based on random numbers
    @Test
    fun `should move cars based on random number and print progress`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "3") // Run with two car names and 3 rounds
                assertThat(output()).contains("pobi : -", "woni : ", "Winners : pobi") // Assert the progress and winner output
            },
            MOVING_FORWARD, STOP
        )
    }

    // Feature 4: Prints progress and winner(s)
    @Test
    fun `should print progress of the cars and the winner(s)`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "3")
                // Assert that progress is printed and the correct winner is displayed
                assertThat(output()).contains("pobi : -", "woni : ", "Winners : pobi")
            },
            MOVING_FORWARD,
            STOP
        )
    }

    // Feature 5: Includes error handling and basic tests
    @Test
    fun `should handle errors gracefully and print appropriate messages`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException(",,", "3") // Empty car names should throw an exception
            }
        }
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,woni", "-5") // Invalid rounds should throw an exception
            }
        }
    }

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

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}
