package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class RaceTest : NsTest() {
    @Test
    fun `test no winners if none has moved`() {
        assertRandomNumberInRangeTest(
            {
                val config = FixedRoundsRaceConfiguration.from("alpha,beta", "1")
                val raceResult = FixedRoundsRace(config).run()

                assertThat(raceResult.winners).isEqualTo(emptyList<String>())
            },
            STOP, STOP,
        )
    }

    @Test
    fun `test race result`() {
        assertRandomNumberInRangeTest(
            {
                val config = FixedRoundsRaceConfiguration.from("alpha,beta", "5")
                val raceResult = FixedRoundsRace(config).run()

                assertThat(raceResult.rounds[0][0]).isEqualTo("alpha : ")
                assertThat(raceResult.rounds[0][1]).isEqualTo("beta : -")
                assertThat(raceResult.rounds[1][0]).isEqualTo("alpha : ")
                assertThat(raceResult.rounds[1][1]).isEqualTo("beta : --")
                assertThat(raceResult.rounds[2][0]).isEqualTo("alpha : -")
                assertThat(raceResult.rounds[2][1]).isEqualTo("beta : ---")
                assertThat(raceResult.rounds[3][0]).isEqualTo("alpha : --")
                assertThat(raceResult.rounds[3][1]).isEqualTo("beta : ---")
                assertThat(raceResult.rounds[4][0]).isEqualTo("alpha : ---")
                assertThat(raceResult.rounds[4][1]).isEqualTo("beta : ----")
                assertThat(raceResult.winners).isEqualTo(listOf("beta"))
            },
            STOP, MOVING_FORWARD,
            STOP, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, STOP,
            MOVING_FORWARD, MOVING_FORWARD,
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
