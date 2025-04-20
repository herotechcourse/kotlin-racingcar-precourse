package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `moves when random number is 4 or greater`() {
        val car = Car("pobi", 0)
        car.testMoveForward(4)
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `does not move when random number is less than 4`() {
        val car = Car("pobi", 0)
        car.testMoveForward(3)
        assertThat(car.position).isEqualTo(0)
    }

    private fun Car.testMoveForward(number: Int) {
        if (number >= 4) {
            this.position++
        }
    }
}