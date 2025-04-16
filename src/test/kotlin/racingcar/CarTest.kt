package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `car starts at position 0`() {
        val car = Car("pobi")
        assertThat(car.getPosition()).isEqualTo(0)
    }

    @Test
    fun `car moves forward when number is 4 or more`() {
        val car = Car("pobi")
        car.move(4)
        assertThat(car.getPosition()).isEqualTo(1)
    }

    @Test
    fun `car does not move when number is less than 4`() {
        val car = Car("pobi")
        car.move(3)
        assertThat(car.getPosition()).isEqualTo(0)
    }

    @Test
    fun `car returns correct name`() {
        val car = Car("pobi")
        assertThat(car.getName()).isEqualTo("pobi")
    }
}
