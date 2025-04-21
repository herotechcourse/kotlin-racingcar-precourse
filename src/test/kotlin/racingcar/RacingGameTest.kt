package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameTest {

    @Test
    fun `startRace should move all cars for each round`() {
        val cars = listOf(Car("car1"), Car("car2"))
        val game = RacingGame(cars, 2)

        assertRandomNumberInRangeTest(
            {
                game.startRace()
                cars.forEach {
                    assertThat(it.getPosition()).isEqualTo(2)
                }
            },
            4, 4, // Round 1
            4, 4  // Round 2
        )
    }

    @Test
    fun `getWinners should return car with the farthest position`() {
        val car1 = Car("a")
        val car2 = Car("b")
        val game = RacingGame(listOf(car1, car2), 1)

        assertRandomNumberInRangeTest(
            {
                game.startRace()
                val winners = game.getWinners()
                assertThat(winners).containsExactly(car2)
            },
            3, 4 // car1 doesn't move, car2 moves
        )
    }

    @Test
    fun `getWinners should return multiple cars if there's a tie`() {
        val car1 = Car("x")
        val car2 = Car("y")
        val game = RacingGame(listOf(car1, car2), 1)

        assertRandomNumberInRangeTest(
            {
                game.startRace()
                val winners = game.getWinners()
                assertThat(winners).containsExactlyInAnyOrder(car1, car2)
            },
            4, 4
        )
    }
}
