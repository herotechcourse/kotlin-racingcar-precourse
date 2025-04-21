package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class RacingCarTest {
    @Test
    fun `car does not move when generated number is less than 4`() {
        val car = RacingCar("pobi", 2)
        car.moveForwardIfPossible(3)
        assertThat(car.progress).isEqualTo(2)
    }

    @Test
    fun `car moves forward when generated number is 4 or greater`() {
        val car = RacingCar("pobi", 1)
        car.moveForwardIfPossible(5)
        assertThat(car.progress).isEqualTo(2)
    }

    @Test
    fun `car name must not exceed 5 characters`() {
        assertThatThrownBy { RacingCar("byunhaekwang") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `car name must not be blank`() {
        assertThatThrownBy { RacingCar("   ") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `car name must not be empty`() {
        assertThatThrownBy { RacingCar("") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
