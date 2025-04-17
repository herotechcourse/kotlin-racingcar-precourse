package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun move_testIfMovesWhenTrue() {
        val car = Car("car1", 0)

        car.move(true)
        assertThat(car.position).isEqualTo(1)
        car.move(false)
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun toString_testIfPrintsTheCorrectFormat() {
        val car = Car("car1", 3)

        val out = car.toString()
        assertThat(out).isEqualTo("car1 : ---")
    }
}