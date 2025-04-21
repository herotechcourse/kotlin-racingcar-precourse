package racingcar.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.RepeatedTest
import org.assertj.core.api.Assertions.assertThat

class CarTest {

    @RepeatedTest(10)
    fun `car should move only when random number is 4 or greater`() {
        val car = Car("pobi")
        val initial = car.position
        car.move()
        assertThat(car.position).isGreaterThanOrEqualTo(initial)
    }

    @Test
    fun `toString should return a string composed of the car's name and position`() {
        val car = Car("pobi", 3)
        assertThat(car.toString()).isEqualTo("pobi : ---")
    }
}
