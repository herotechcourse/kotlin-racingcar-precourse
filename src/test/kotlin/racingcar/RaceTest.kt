package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceTest : NsTest() {

    @Test
    fun `print round data`() {
        val carData = mapOf("car1" to 1, "car2" to 2, "car3" to 0, "car4" to 4)
        printRound(carData)
        assertThat(output()).contains("car1 : -", "car2 : --", "car3 : ", "car4 : ----")
    }

    @Test
    fun `get cars move `() {
        for (i in 0 .. 3) {
            val move: Int = getCarMove(i)
            assertThat(move == 0)
        }
        for (i in 4 .. 9) {
            val move: Int = getCarMove(i)
            assertThat(move == 1)
        }
    }

    @Test
    fun `run round on mocked Random data`() {
        assertRandomNumberInRangeTest(
            {
                val carsData = mapOf("pobi" to 0, "woni" to 0, "elly" to 0)
                val round = startRound(carsData)
                assertThat(output()).contains("pobi : -", "woni : ", "elly : -")
                assertThat(round.contains("phobi") && round["phobi"] == 1)
            },
            MOVING_FORWARD,
            STOP,
            MOVING_FORWARD,
        )
    }

    @Test
    fun `get winners of race`() {
        val carsData = mapOf("pobi" to 0, "woni" to 1, "elly" to 1)
        getWinners(carsData)
        assertThat(output()).contains("Winners : woni, elly")
    }

    @Test
    fun `run race on mocked Random data 1 round`() {
        assertRandomNumberInRangeTest(
            {
                val carsData = mapOf("pobi" to 0, "woni" to 0, "elly" to 0)
                val rounds = 1
                race(carsData, rounds)
                assertThat(output()).contains("Race Results", "pobi : -", "woni : ", "elly : -", "Winners : pobi, elly")
            },
            MOVING_FORWARD,
            STOP,
            MOVING_FORWARD,
        )
    }

    @Test
    fun `race 2 round mocked random`() {
        assertRandomNumberInRangeTest(
            {
                val carsData = mapOf("pobi" to 0, "woni" to 0, "elly" to 0)
                race(carsData, 2)
                assertThat(output()).contains("Race Results", "pobi : -", "woni : ", "elly : -", "Winners : pobi, elly")
            },
            MOVING_FORWARD,
            STOP,
            MOVING_FORWARD,
            STOP,
            STOP,
            STOP,

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