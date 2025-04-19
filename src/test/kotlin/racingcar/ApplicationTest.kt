package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `Should print prints the Collect winner`() {
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
    fun `Correctly prints multiple winners`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : -", "Winners : pobi, woni")
            },
            MOVING_FORWARD,
            MOVING_FORWARD,
        )
    }


    @Test
    fun `Should throw exception when car names is empty`() {
        assertSimpleTest() {
            assertThrows<IllegalArgumentException> {
                run("", "1")
            }
        }
    }

    @Test
    fun `Should throw exception when car name is over 5 characters`() {
        assertSimpleTest() {
            assertThrows<IllegalArgumentException> {
                run("123456", "1")
            }
        }
    }

    @Test
    fun `Should throw exception when car name is duplicated`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,pobi", "1") }
        }
    }

    @Test
    fun `Car name cannot contain spaces`() {
        assertSimpleTest() {
            assertThrows<IllegalArgumentException> { runException("p obi", "1") }
        }
    }

    @Test
    fun `Whitespace between car names (comma-separated) is allowed`() {
        assertSimpleTest() {
            run("pobi, woni", "1")
            assertThat(output()).contains("pobi", "woni")
        }
    }

    @Test
    fun `Executes the race for the exact number of input rounds`() {
        assertRandomNumberInRangeTest({
            run("pobi, woni", "1")
            val outputText = output()
            val count = countOccurrences(outputText, "pobi")
            assertThat(count).isEqualTo(1)
        },
            // TODO: implement fixture(random number generator) for control winner easily
            STOP, MOVING_FORWARD,
        )
    }

    @Test
    fun `Should throws if number of rounds is not a number`() {
        assertSimpleTest() {
            assertThrows<IllegalArgumentException> {
                run("pobi,javaji", "a")
            }
        }
    }

    @Test
    fun `Should throws if number of rounds is not a positive number`() {
        assertSimpleTest() {
            assertThrows<IllegalArgumentException> {
                run("pobi,javaji", "-1")
            }
        }
    }

    private fun countOccurrences(text: String, keyword: String): Int {
        return Regex(Regex.escape(keyword)).findAll(text).count()
    }


    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}
