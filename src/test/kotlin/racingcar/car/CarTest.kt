package racingcar.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.constants.Constants

class CarTest {
    @Test
    fun `move test - forward`() {
        val car = Car("test")
        car.tryMoveForward(Constants.MIN_RANDOM_TO_MOVE)
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `move test - stay`() {
        val car = Car("test")
        car.tryMoveForward(Constants.MIN_RANDOM_TO_MOVE - 1)
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `creation test - name`() {
        val car = Car("porsche")
        assertThat(car.name).isEqualTo("porsche")
    }

    @Test
    fun `creation test - position`() {
        val car = Car("test")
        assertThat(car.position).isEqualTo(0)
    }
}
