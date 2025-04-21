// CarTest.kt
package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `move foward when random number is 4 or more`() {
        val car = Car("pobi")
        car.move(4)
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `stop when random number is less than 4`() {
        val car = Car("pobi")
        car.move(3)
        assertThat(car.position).isEqualTo(0)
    }
}
