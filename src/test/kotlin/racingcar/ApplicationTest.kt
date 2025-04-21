package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.fixture.CarMovementFixtureBuilder

class ApplicationTest : NsTest() {
    @Test
    fun `Should print prints the Collect winner`() {
        // Given
        val carNames = "p1, p2"
        val roundCount = "3"
        val (first, rest) = CarMovementFixtureBuilder()
            .round(true, false)
            .round(true, false)
            .round(true, false)
            .build()

        // When & Then
        assertRandomNumberInRangeTest(
            {
                run(carNames, roundCount)
                assertThat(output()).contains("Winners : p1")
            },
            first, *rest,
        )
    }

    @Test
    fun `Correctly prints multiple winners`() {
        // Given
        val carNames = "p1, p2"
        val roundCount = "3"
        val (first, rest) =CarMovementFixtureBuilder()
            .round(true, true)
            .build()

        // When & Then
        assertRandomNumberInRangeTest(
            {
                run(carNames, roundCount)
                assertThat(output()).contains("Winners : p1, p2")
            },
            first, *rest,
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
            assertThrows<IllegalArgumentException> { runException("p1,p1", "1") }
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
        // Given
        val carNames = "pLose, pWin"
        val roundCount = 2
        val (first, rest) = CarMovementFixtureBuilder()
            .round(false, true)
            .round(false, true)
            .build()

        // When & Then
        assertRandomNumberInRangeTest({
            run(carNames, roundCount.toString())

            val outputText = output()
            val loserCount = countOccurrences(outputText, "pLose")
            // roundCount should equal to loserCount
            assertThat(loserCount).isEqualTo(roundCount)
        },
            first, *rest
        )
    }

    @Test
    fun `Should throws if number of rounds is not a number`() {
        assertSimpleTest() {
            assertThrows<IllegalArgumentException> {
                run("p1,p2", "a")
            }
        }
    }

    @Test
    fun `Should throws if number of rounds is not a positive number`() {
        assertSimpleTest() {
            assertThrows<IllegalArgumentException> {
                run("p1,p2", "-1")
            }
        }
    }

    private fun countOccurrences(text: String, keyword: String): Int {
        return Regex(Regex.escape(keyword)).findAll(text).count()
    }


    override fun runMain() {
        main()
    }
}
