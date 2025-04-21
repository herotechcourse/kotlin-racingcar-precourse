package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.CarTest.Companion.MOVING_FORWARD

class CarsTest {
    @Test
    fun `select winner when position value is the largest`() {
        val cars = Cars.from(listOf("lose", "win"))

        val lose = cars.cars.first { it.name == "lose" }
        val win = cars.cars.first { it.name == "win" }
        lose.moveIfOverThreshold(STOP)
        win.moveIfOverThreshold(MOVING_FORWARD)

        val winners = cars.findWinners()
        assertThat(winners.map { it.name }).containsExactly("win")
    }

    @Test
    fun `select winners when position value is the largest`() {
        val cars = Cars.from(listOf("lose", "win1", "win2"))

        val lose = cars.cars.first { it.name == "lose" }
        val win1 = cars.cars.first { it.name == "win1" }
        val win2 = cars.cars.first { it.name == "win2" }
        lose.moveIfOverThreshold(STOP)
        win1.moveIfOverThreshold(MOVING_FORWARD)
        win2.moveIfOverThreshold(MOVING_FORWARD)

        val winners = cars.findWinners()
        assertThat(winners.map { it.name }).containsExactlyInAnyOrder("win1", "win2")
    }

    companion object {
        const val MOVING_FORWARD = 5
        const val STOP = 3
    }
}