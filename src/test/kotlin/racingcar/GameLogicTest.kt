package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameLogicTest {

    @Test
    fun startRace_singleRound_movesCarsCorrectly() {
        val cars = listOf(Car("pobi"), Car("jun"))
        assertRandomNumberInRangeTest(
            {
                GameLogic.startRace(cars, 1)
                assertThat(cars[0].position).isEqualTo(1)
                assertThat(cars[1].position).isEqualTo(0)
            },
            4, 3
        )
    }

    @Test
    fun startRace_multipleRounds_accumulatesMovement() {
        val cars = listOf(Car("pobi"))
        assertRandomNumberInRangeTest(
            {
                GameLogic.startRace(cars, 3)
                assertThat(cars[0].position).isEqualTo(2)
            },
            4, 3, 4
        )
    }
}
