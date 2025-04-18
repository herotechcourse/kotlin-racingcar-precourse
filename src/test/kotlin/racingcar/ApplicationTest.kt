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
    fun `invalid car name longer than 5 characters throws exception`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,toolongname", "1")
            }
        }
    }

    @Test
    fun `empty car name throws exception`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,,woni", "1")
            }
        }
    }

    @Test
    fun `invalid round input throws exception`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,woni", "0")
            }
            assertThrows<IllegalArgumentException> {
                runException("pobi,woni", "-1")
            }
        }
    }

    @Test
    fun `car moves progressively each round`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi, woni", "3")

                val movementLines = output()
                    .lines()
                    .filter { it.startsWith("pobi :") }

                assertThat(movementLines)
                    .hasSizeGreaterThanOrEqualTo(3)

                val expectedDistances = listOf(1, 2, 3)
                expectedDistances.forEachIndexed { index, expected ->
                    assertThat(movementLines[index].count { it == '-' })
                        .describedAs("Round ${index + 1} dash count")
                        .isEqualTo(expected)
                }
            },
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        )
    }

    @Test
    fun `car does not move if random number is less than 4`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi", "1")
                assertThat(output()).contains("pobi : ")
            },
            STOP
        )
    }

    @Test
    fun `display progress after each round with car name and dashes`() {
        assertRandomNumberInRangeTest(
            {
                run("car1,car2", "2")

                val movementLines = output().lines().filter { it.contains(" : ") }

                val car1Lines = movementLines.filter { it.startsWith("car1 :") }
                val car2Lines = movementLines.filter { it.startsWith("car2 :") }

                assertThat(car1Lines).hasSize(2)
                assertThat(car2Lines).hasSize(2)

                val expectedCar1 = listOf(1, 1) // MOVING_FORWARD, STOP
                val expectedCar2 = listOf(0, 1) // STOP, MOVING_FORWARD

                expectedCar1.forEachIndexed { i, expected ->
                    assertThat(car1Lines[i].count { it == '-' })
                        .describedAs("car1 round ${i + 1} dashes")
                        .isEqualTo(expected)
                }

                expectedCar2.forEachIndexed { i, expected ->
                    assertThat(car2Lines[i].count { it == '-' })
                        .describedAs("car2 round ${i + 1} dashes")
                        .isEqualTo(expected)
                }
            },
            MOVING_FORWARD, STOP,
            STOP, MOVING_FORWARD
        )
    }

    @Test
    fun `multiple cars with same top score are all winners`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("Winners : pobi, woni")
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
