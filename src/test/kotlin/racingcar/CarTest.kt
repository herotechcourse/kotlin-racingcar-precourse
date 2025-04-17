package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @packageName    : racingcar
 * @fileName       : CartTest
 * @author         : yong
 * @date           : 4/16/25
 * @description    :
 */
class CarTest {
    @Test
    @DisplayName("Move foward when random value is equal or greater than 4")
    fun moveForwardTest() {
        val car = Car("pobi")
        car.move(5)
        assertThat(car.getPositionBar()).isEqualTo("-")
    }

    @Test
    @DisplayName("Stay when random value is less than 4")
    fun stayTest() {
        val car = Car("pobi")
        car.move(3)
        assertThat(car.getPositionBar()).isEqualTo("")
    }
}


