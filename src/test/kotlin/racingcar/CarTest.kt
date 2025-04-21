package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `move should increase position by one`() {
        val car = Car("pobi")

        car.move()

        assertThat(car.position).isEqualTo(1)
    }
}
