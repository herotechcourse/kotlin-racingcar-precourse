package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceTest : NsTest()   {
    @Test
    fun `run round test`() {
        val cars = listOf(Car("pobi"), Car("woni"), Car("jido"))
        val race = Race(cars)
        race.runRound { MOVING_FORWARD }
        assertThat(cars.all { it.position == 1 })
    }

    @Test
    fun `winners finding test`() {
        assertRandomNumberInRangeTest(
            {
                val cars = listOf(Car("pobi"), Car("woni"), Car("jido"))
                val race = Race(cars)
                repeat(2) {
                    race.runRound { randomNumber() }
                }
                val winners = race.getWinners()
                assertThat(winners.containsAll(listOf("pobi", "woni")))
            },
            MOVING_FORWARD,
            MOVING_FORWARD,
            STOP,
            MOVING_FORWARD,
            MOVING_FORWARD,
            STOP
        )
    }

    @Test
    fun `round result test`() {
        assertRandomNumberInRangeTest(
            {
                val cars = listOf(Car("pobi"), Car("woni"), Car("jido"))
                val race = Race(cars)
                race.runRound { randomNumber() }
                race.printProgress()
                assertThat(output()).contains("pobi : -", "woni : -", "jido :")
            },
            MOVING_FORWARD,
            MOVING_FORWARD,
            STOP
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