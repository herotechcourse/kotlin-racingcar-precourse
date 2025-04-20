package racingcar

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `Car name is set correctly`() {
        val car = Car("abc")
        assertThat(car.name).isEqualTo("abc")
    }

    @RepeatedTest(10)
    fun `Car moves forward if random number is 4 or greater`() {
        val car = Car("test")

        // Simulate 100 moves to check if it ever moved forward
        repeat(100) { car.tryMove() }

        assertThat(car.position).isGreaterThan(0)
    }
}
