package racingcar

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class CarTest {

    @Test
    fun `test car does not move if a random number is less than 4`() {
        val car = Car("yugo")
        car.moveCar { 3 }
        assertThat(car.getPosition()).isEqualTo(0)
    }

    @Test
    fun `test car moves if a random number is more than 4`() {
        val car = Car("yugo")
        car.moveCar { 7 }
        assertThat(car.getPosition()).isEqualTo(1)
    }

    @Test
    fun `test car moves multiple times correctly`() {
        val car = Car("yugo")
        repeat(3) { car.moveCar { 6 } }
        assertThat(car.getPosition()).isEqualTo(3)
    }
}
