package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `car should not move when random number is less than 4`() {
        val car = Car("pobi")
        car.move(3)
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `car should move when random number is 4 or greater`() {
        val car = Car("pobi")
        car.move(4)
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `car should move multiple times`() {
        val car = Car("pobi")
        car.move(4)
        car.move(5)
        car.move(3)
        car.move(4)
        assertThat(car.position).isEqualTo(3)
    }

    @Test
    fun `car name should be correctly set`() {
        val car = Car("pobi")
        assertThat(car.name).isEqualTo("pobi")
    }
}