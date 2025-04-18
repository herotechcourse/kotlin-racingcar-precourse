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

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}