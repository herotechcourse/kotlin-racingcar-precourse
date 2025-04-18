package racingcar

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

class CarsTest {
    private lateinit var car1: Car
    private lateinit var car2: Car
    private lateinit var cars: Cars

    @BeforeEach
    fun setUp() {
        car1 = Car("test1", randomNumberGenerator = { 3 })  // don't move
        car2 = Car("test2", randomNumberGenerator = { 4 })  // move
        cars = Cars(listOf(car1, car2))
    }

    @Test
    fun `each car moves only when random number is 4 or more`() {
        cars.move()

        assertThat(car1.movement).isEqualTo(0)
        assertThat(car2.movement).isEqualTo(1)
    }

    @Test
    fun `returns all cars`() {
        val allCars = cars.getAll()

        assertThat(allCars).contains(car1, car2)
    }

    @Test
    fun `returns only winners with the highest movement`() {
        cars.move()

        val winners = cars.findWinners()
        assertThat(winners).containsExactly("test2")
    }
}