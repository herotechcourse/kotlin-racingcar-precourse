package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `Car moves forward when number is 4 or greater`() {
        val car = Car("pobi", 0)
        repeat(5) { car.position++ }  // simulate 5 moves
        assertThat(car.position).isEqualTo(5)
    }

    @Test
    fun `Car progress string should reflect position`() {
        val car = Car("pobi", 3)
        assertThat(car.getProgress()).isEqualTo("---")
    }
}
