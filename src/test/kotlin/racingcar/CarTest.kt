package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `car should move forward when number is 4 or more`() {
        val car = Car("pobi")
        car.move(4)
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `car should not move when number is less than 4`() {
        val car = Car("pobi")
        car.move(3)
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `car position display shows hyphens`() {
        val car = Car("jun")
        repeat(3) { car.move(5) }
        assertThat(car.getPositionDisplay()).isEqualTo("---")
    }
    @Test
    fun `car should only move on valid numbers`() {
        val car = Car("mix")
        car.move(3)
        car.move(7)
        car.move(2)
        car.move(8)
        assertThat(car.position).isEqualTo(2)
    }

}
