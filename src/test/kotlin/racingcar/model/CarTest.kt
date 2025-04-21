package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    @DisplayName("Move forward if number is 4 or more")
    fun moveForwardIfNumberIsFourOrMore() {
        val car = Car("pobi")
        car.moveRandomly(MOVING_FORWARD)
        assertThat(car.position).isEqualTo(MOVED_POSITION)
    }

    @Test
    @DisplayName("Stay if number is 3 or less")
    fun stayIfNumberIsThreeOrLess() {
        val car = Car("pobi")
        car.moveRandomly(STOP)
        assertThat(car.position).isEqualTo(INITIAL_POSITION)
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
        private const val INITIAL_POSITION: Int = 0
        private const val MOVED_POSITION: Int = 1
    }
}