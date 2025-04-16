package racingcar.modelTest

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import racingcar.model.Car

class CarMovementTest {

    @Test
    fun `car moves forward when shouldMove is true`() {
        val car = Car("tini")
        car.move(true)
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `car does not move when shouldMove is false`() {
        val car = Car("toti")
        car.move(false)
        assertThat(car.position).isEqualTo(0)
    }
}