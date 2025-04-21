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

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }

    @Test
    fun `determine winner test`() {
        val car1 = Car("san", 5)
        val car2 = Car("river", 4)
        val car3 = Car("wind", 3)

        val game = RacingGame(listOf())
        val winners = game.determineWinner(listOf(car1, car2, car3))

        assertThat(winners).containsOnly("san")
    }

    @Test
    fun `determine multiple winner test`() {
        val car1 = Car("san", 5)
        val car2 = Car("river", 4)
        val car3 = Car("wind", 5)

        val game = RacingGame(listOf())
        val winners = game.determineWinner(listOf(car1, car2, car3))

        assertThat(winners).containsOnly("san", "wind")
    }
}
