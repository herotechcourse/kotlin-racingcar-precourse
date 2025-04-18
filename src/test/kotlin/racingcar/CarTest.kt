package racingcar

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `should be able to name a car`() {
        val car = Car()
        car.setCarName("pobi")
        assertThat(car.name).isEqualTo("pobi")
    }

    @Test
    fun `progress should be 0 when initialized`() {
        val car = Car()
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `progress should be 1 when increased once`() {
        val car = Car()
        car.increasePosition()
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `progress should be 3 when increased 3 times`() {
        val car = Car()
        car.increasePosition()
        car.increasePosition()
        car.increasePosition()
        assertThat(car.position).isEqualTo(3)
    }
}