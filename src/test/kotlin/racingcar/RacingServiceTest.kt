package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @packageName    : racingcar
 * @fileName       : RacingServiceTest
 * @author         : yong
 * @date           : 4/18/25
 */
class RacingServiceTest {
    @Test
    fun carsMoveCorrectlyEachRoundAndWinnersAreCorrectlySelected() {
        // given
        val cars = listOf(Car("woni"), Car("jun"), Car("pobi"))
        val numberGenerator = listOf(
            listOf(MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD),
            listOf(STOP, MOVING_FORWARD, MOVING_FORWARD),
            listOf(MOVING_FORWARD, STOP, MOVING_FORWARD)
        )
        val service = RacingService(cars, numberGenerator)

        // when
        val (raceResult, winners) = service.play()

        // then
        assertThat(raceResult["woni"]).containsExactly("-", "-", "--")
        assertThat(raceResult["jun"]).containsExactly("-", "--", "--")
        assertThat(raceResult["pobi"]).containsExactly("-", "--", "---")
        assertThat(winners).isEqualTo("pobi")
    }

    @Test
    fun multipleWinnersPrintTheirNamesSeperatedByCommas() {
        // given
        val cars = listOf(Car("woni"), Car("jun"), Car("pobi"))

        //each round, cars move
        val numberGenerator = listOf(
            listOf(MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD),
            listOf(STOP, MOVING_FORWARD, STOP),
            listOf(MOVING_FORWARD, STOP, MOVING_FORWARD)
        )
        val service = RacingService(cars, numberGenerator)

        // when
        val (raceResult, winners) = service.play()

        // then
        assertThat(winners).isEqualTo("woni, jun, pobi")
    }

    companion object {
        private const val ROUND: Int = 3
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}