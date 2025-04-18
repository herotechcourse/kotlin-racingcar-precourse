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
    @DisplayName("one round test")
    fun oneRoundTest() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,duc", "1")
                assertThat(output()).contains("pobi : -", "duc : ", "Winners : pobi")
            },
            MOVING_FORWARD,
            STOP
        )
    }

    @Test
    @DisplayName("multiple rounds test")
    fun multipleRoundsTest() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,duc", "2")
                assertThat(output()).contains(
                    "pobi : -",
                    "duc : ",
                    "pobi : --",
                    "duc : ",
                    "Winners : pobi"
                )
            },
            MOVING_FORWARD,
            STOP,
            MOVING_FORWARD,
            STOP
        )
    }

    // test name empty
    @Test
    @DisplayName("exception if name empty")
    fun exceptionIfNameEmpty() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("", "1")
            }
        }
    }

    @Test
    @DisplayName("exception if name too long")
    fun exceptionIfNameTooLong() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,javaji", "1")
            }
        }
    }

    @Test
    @DisplayName("exception if round non integer")
    fun exceptionIfRoundNonInteger() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,duc", "one")
            }
        }
    }

    @Test
    @DisplayName("exception if round less than 1")
    fun exceptionIfRoundLessThan1() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,duc", "0")
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
