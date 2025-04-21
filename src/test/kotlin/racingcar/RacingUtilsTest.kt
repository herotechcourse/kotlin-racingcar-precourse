import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.Car
import racingcar.findWinners

class RacingUtilsTest {
    @Test
    fun `should return a list of cars with maximal distance`() {
        assertRandomNumberInRangeTest(
            {
                val cars = listOf<Car>(Car("Jan"), Car("Chee"), Car("Sho"))
                for (car in cars) {
                    car.move()
                }
                val winners = findWinners(cars)
                assertThat(winners.size).isEqualTo(2)
                assertThat(winners[0].name).isEqualTo("Chee")
                assertThat(winners[1].name).isEqualTo("Sho")
            }, 2, 7, 6

        )
    }
}