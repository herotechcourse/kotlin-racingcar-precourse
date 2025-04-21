package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarTest {

    companion object {
        const val MOVE_THRESHOLD = 4
        const val STAY_THRESHOLD = 3
        const val INITIAL_POSITION = 0
        const val MOVED_POSITION = 1
    }

    @Test
    @DisplayName("Move forward if number is 4 or more")
    fun moveForwardIfNumberIsFourOrMore() {
        val car = Car("pobi")
        car.moveRandomly(MOVE_THRESHOLD)
        assertThat(car.position).isEqualTo(MOVED_POSITION)
    }

    @Test
    @DisplayName("Stay if number is 3 or less")
    fun stayIfNumberIsThreeOrLess() {
        val car = Car("pobi")
        car.moveRandomly(STAY_THRESHOLD)
        assertThat(car.position).isEqualTo(INITIAL_POSITION)
    }
}