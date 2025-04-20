package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `should not move if generated number is less than 4`() {
        val car = Car(name = "hero", numberGenerator = { 3 })
        car.move()
        assertEquals(0, car.getDistance())
    }

    @Test
    fun `should move if generated number is 4 or higher`() {
        val car1 = Car(name = "hero", numberGenerator = { 4 })
        val car2 = Car(name = "hero", numberGenerator = { 5 })
        car1.move()
        car2.move()
        assertEquals(1, car1.getDistance())
        assertEquals(1, car2.getDistance())
    }

    @Test
    fun `move multiple times should accumulate position correctly`() {
        val car = Car(name = "hero", numberGenerator = { 6 })
        repeat(5) { car.move() }
        assertEquals(5, car.getDistance())
    }

    @Test
    fun `getPosition should return current distance`() {
        val car = Car(name = "hero", numberGenerator = { 9 })
        car.move()
        car.move()
        assertEquals(2, car.getDistance())
    }
}