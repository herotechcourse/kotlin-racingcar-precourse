package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarRacingTest {

    @Test
    @DisplayName("Initialize cars with their names")
    fun initialize() {
        val carNames = listOf("car1", "car2", "car3")
        val carRacing = CarRacing()
        val cars = carRacing.initializeCars(carNames)

        assertThat(cars).hasSize(3)
        assertThat(cars.map { it.name }).containsExactly("car1", "car2", "car3")
    }

    // Tests move forward or stay still during race
    @Test
    @DisplayName("Car moves when random number is 4 or more")
    fun moveForward() {
        val testCar = Car("move")
        val carRacing = CarRacing(randomGenerator = { 4 }) // Force value = 4

        carRacing.raceSingleRound(listOf(testCar))
        assertThat(testCar.position).isEqualTo(1)
    }

    @Test
    @DisplayName("Car does not move when random number is less than 4")
    fun notMoveForward() {
        val testCar = Car("stop")
        val carRacing = CarRacing(randomGenerator = { 3 }) // Force value = 3

        carRacing.raceSingleRound(listOf(testCar))
        assertThat(testCar.position).isZero()
    }
}