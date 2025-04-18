package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `car should move true`() {
        val car = Car("pobi")
        car.move(true)
        assertThat(car.getPosition()).isEqualTo(1)
    }

    @Test
    fun `car should move false`() {
        val car = Car("pobi")
        car.move(false)
        assertThat(car.getPosition()).isEqualTo(0)
    }

    @Test
    fun `car should render`() {
        val car = Car("pobi")
        repeat(3) { car.move(true) }
        assertThat(car.render()).isEqualTo("pobi : ---")
    }
}