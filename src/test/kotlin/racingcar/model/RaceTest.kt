package racingcar.model

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class RaceTest {

    @Test
    fun `race runs for specified number of rounds`() {
        val cars = listOf(Car("car1"), Car("car2"))
        val race = Race(cars, 1)

        assertRandomNumberInRangeTest(
            {
                race.run()
                val winners = race.findWinners()

                assertThat(winners).containsOnly(cars[0])

            },
            MOVING_FORWARD,
            STOP,
        )
    }

    @Test
    fun `both cars move and win`() {
        val cars = listOf(Car("car1"), Car("car2"))
        val race = Race(cars, 1)

        assertRandomNumberInRangeTest(
            {
                race.run()
                val winners = race.findWinners()

                assertThat(winners).containsExactlyInAnyOrder(cars[0], cars[1])
            },
            MOVING_FORWARD,
            MOVING_FORWARD
        )
    }

    @Test
    fun `no cars move and both remain winners`() {
        val cars = listOf(Car("car1"), Car("car2"))
        val race = Race(cars, 1)

        assertRandomNumberInRangeTest(
            {
                race.run()
                val winners = race.findWinners()

                assertThat(winners).containsExactlyInAnyOrder(cars[0], cars[1])
            },
            STOP,
            STOP
        )
    }

    @Test
    fun `second car overtakes in second round`() {
        val cars = listOf(Car("car1"), Car("car2"))
        val race = Race(cars, 2)

        assertRandomNumberInRangeTest(
            {
                race.run()
                val winners = race.findWinners()

                assertThat(winners).containsAll(cars)
            },

            MOVING_FORWARD,
            STOP,
            STOP,
            MOVING_FORWARD
        )
    }

    @Test
    fun `three cars and one clear winner`() {
        val cars = listOf(Car("car1"), Car("car2"), Car("car3"))
        val race = Race(cars, 3)

        assertRandomNumberInRangeTest(
            {
                race.run()
                val winners = race.findWinners()

                assertThat(winners).containsOnly(cars[2])
            },
            STOP, STOP, MOVING_FORWARD,
            STOP, STOP, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, STOP
        )
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}