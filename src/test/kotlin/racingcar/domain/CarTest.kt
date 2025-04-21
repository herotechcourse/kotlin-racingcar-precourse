package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `RandNum larger than 4 is Go`() {
        val car = Car("Pobi")
        car.move(4)
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `RandNum lower than 3 is Stay`() {
        val car = Car("Pororo")
        car.move(2)
        assertThat(car.position).isEqualTo(0)
    }
}