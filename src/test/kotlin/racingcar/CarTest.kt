package racingcar

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.model.Car
import racingcar.strategy.MovementStrategy

class CarTest {
    internal class AlwaysMove : MovementStrategy {
        override fun shouldMove(): Boolean {
            return true
        }
    }

    internal class NeverMove : MovementStrategy {
        override fun shouldMove(): Boolean {
            return false
        }
    }

    @Test
    fun `car throws error when name too long`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Car("Speedy") // 6 characters
        }
        assertEquals("The car name must be at least 1 character and no more than 5 characters. Input value: 'Speedy'", exception.message)
    }

    @Test
    fun carMovesForwardWhenStrategyAllows() {
        val car = Car("Speed")
        car.move(AlwaysMove())
        Assertions.assertEquals(1, car.position)
    }

    @Test
    fun carStaysStillWhenStrategyDisallows() {
        val car = Car("Lazy")
        car.move(NeverMove())
        Assertions.assertEquals(0, car.position)
    }
}