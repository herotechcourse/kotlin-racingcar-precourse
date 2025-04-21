package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @packageName    : racingcar
 * @fileName       : CartTest
 * @author         : yong
 * @date           : 4/16/25
 */
class CarTest {
    @Test
    @DisplayName("Move foward when random value is equal or greater than 4")
    fun moveForwardTest() {
        val car = Car("pobi")
        car.move(MOVING_FORWARD)
        assertThat(car.getPositionBar()).isEqualTo("-")
    }

    @Test
    @DisplayName("Stay when random value is less than 4")
    fun stayTest() {
        val car = Car("pobi")
        car.move(STOP)
        assertThat(car.getPositionBar()).isEqualTo("")
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}


