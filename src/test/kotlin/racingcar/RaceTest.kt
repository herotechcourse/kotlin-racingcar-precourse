package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceTest : NsTest()   {
    @Test
    fun `run race, all cars moving`() {
        assertRandomNumberInRangeTest(
            {
                val cars = listOf(Car("pobi"), Car("woni"), Car("jido"))
                val race = Race(cars, 1)
                assertThat(cars.all { it.position == 0 }).isTrue()
                race.runRace()
                assertThat(cars.all { it.position == 1 }).isTrue()
            },
            MOVING_FORWARD,
            MOVING_FORWARD,
            MOVING_FORWARD
        )
    }

    @Test
    fun `run race, 2 cars won, check print progress (exact match), winners`() {
        assertRandomNumberInRangeTest(
            {
                val cars = listOf(Car("pobi"), Car("woni"), Car("jido"))
                val race = Race(cars, 2)
                race.runRace()
                assertThat(output()).contains("pobi : -\r\nwoni : -\r\njido :")
                assertThat(output()).contains("pobi : --\r\nwoni : --\r\njido :")
                race.printResult()
                assertThat(output()).endsWith("Winners : pobi, woni")
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
    fun `run race, 2 cars moved, check print round result`() {
        assertRandomNumberInRangeTest(
            {
                val cars = listOf(Car("pobi"), Car("woni"), Car("jido"))
                val race = Race(cars, 1)
                race.runRace()
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