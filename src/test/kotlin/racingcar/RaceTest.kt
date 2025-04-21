package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import racingcar.model.Car
import racingcar.service.Race

class RaceTest {
    @Test
    fun `race validation should pass for valid parameters`() {
        val cars = listOf(Car("car1"), Car("car2"))
        assertDoesNotThrow { Race.validate(cars, 5) }
    }

    @Test
    fun `race validation should fail for empty car list`(): Unit {
        assertThrows<IllegalArgumentException> { Race.validate(emptyList(), 5) }
    }

    @Test
    fun `race validation should fail for non-positive rounds` () {
        assertThrows<IllegalArgumentException> { Race.validate(listOf(Car("CAR1")), 0) }
    }
}