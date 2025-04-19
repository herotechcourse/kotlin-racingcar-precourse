package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    @DisplayName("Car should be initialized with position 0")
    fun initialPositionShouldBeZero() {
        val car = Car("joko")

        assertThat(car.position).isEqualTo(0)
    }

    @Test
    @DisplayName("Car should move forward by one position when move() is called")
    fun moveShouldIncreasePositionByOne() {
        val car = Car("joko")
        val initialPosition = car.position

        car.move()

        assertThat(car.position).isEqualTo(initialPosition + 1)
    }

    @Test
    @DisplayName("Car should move forward according to how many times move() is called")
    fun moveMultipleTimesShouldIncreasePositionAccordingly() {
        val car = Car("joko")
        val moveTimes = 3

        repeat(moveTimes) {
            car.move()
        }

        assertThat(car.position).isEqualTo(moveTimes)
    }

    @Test
    @DisplayName("Car should display progress correctly with position 0")
    fun displayProgressWithPositionZero() {
        val car = Car("joko")

        val progress = car.displayProgress()

        assertThat(progress).isEqualTo("joko : ")
    }

    @Test
    @DisplayName("Car should display progress correctly with position greater than 0")
    fun displayProgressWithPositionGreaterThanZero() {
        val car = Car("joko")
        car.move()
        car.move()

        val progress = car.displayProgress()

        assertThat(progress).isEqualTo("joko : --")
    }
}