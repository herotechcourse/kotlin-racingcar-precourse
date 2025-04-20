package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RaceTest {

    @Test
    fun `should run the race and update car positions with randomizer control` () {
        assertRandomNumberInRangeTest(
            {
                val cars = listOf(Car("pobi"), Car("woni"))
                val race = Race(cars, 2)
                race.runTheRace()
                assertThat(cars[0].roundPoints).isEqualTo(2)
                assertThat(cars[1].roundPoints).isEqualTo(0)
            },
            Race.MOVING_FORWARD,
            Race.STOP,
            Race.MOVING_FORWARD,
            Race.STOP,
        )
    }
}