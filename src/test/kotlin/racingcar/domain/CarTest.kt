package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class CarTest {

    @Nested
    inner class `Success` {

        @Test
        fun `create a car with name and initial position`() {
            val car = Car.from(CarName.from("pobi"))
            assertThat(car.name()).isEqualTo("pobi")
            assertThat(car.position()).isEqualTo(0)
        }

        @Test
        fun `move forward once`() {
            val car = Car.from(CarName.from("pobi"))
            val moved = car.forwarded()
            assertThat(moved.position()).isEqualTo(1)
            assertThat(car.position()).isEqualTo(0)
        }

        @Test
        fun `move forward three times`() {
            val car = Car.from(CarName.from("pobi"))
            val moved = (1..3).fold(car) { acc, _ -> acc.forwarded() }
            assertThat(moved.position()).isEqualTo(3)
            assertThat(car.position()).isEqualTo(0)
        }
    }
}
