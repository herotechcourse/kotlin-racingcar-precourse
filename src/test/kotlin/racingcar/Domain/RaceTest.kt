package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RaceTest {

    @Test
    @DisplayName("Race should require at least one car")
    fun raceShouldRequireAtLeastOneCar() {
        // When & Then
        assertThatThrownBy { Race(emptyList(), 5) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("At least one car is required")
    }

    @Test
    @DisplayName("Race should require a positive number of rounds")
    fun raceShouldRequirePositiveRounds() {
        // Given
        val cars = listOf(Car("pobi"))

        // When & Then
        assertThatThrownBy { Race(cars, 0) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Number of rounds must be positive")
    }

    @Test
    @DisplayName("executeRound should move all cars according to their movement rules")
    fun executeRoundShouldMoveAllCars() {
        // Given
        val car1 = TestCar("car1")
        val car2 = TestCar("car2")
        val race = Race(listOf(car1, car2), 3)

        // When
        race.executeRound()

        // Then
        assertThat(car1.moveWasCalled).isTrue()
        assertThat(car2.moveWasCalled).isTrue()
    }

    @Test
    @DisplayName("findWinners should return cars with maximum position")
    fun findWinnersShouldReturnCarsWithMaxPosition() {
        // Given
        val car1 = Car("car1")
        val car2 = Car("car2")
        val car3 = Car("car3")

        // Use reflection to set positions (for testing purposes only)
        setCarPosition(car1, 3)
        setCarPosition(car2, 5)
        setCarPosition(car3, 5)

        val race = Race(listOf(car1, car2, car3), 1)

        // When
        val winners = race.findWinners()

        // Then
        assertThat(winners).hasSize(2)
        assertThat(winners).contains(car2, car3)
        assertThat(winners).doesNotContain(car1)
    }

    @Test
    @DisplayName("findWinners should return all cars when they have the same position")
    fun findWinnersShouldReturnAllCarsWhenAllHaveSamePosition() {
        // Given
        val car1 = Car("car1")
        val car2 = Car("car2")

        val race = Race(listOf(car1, car2), 1)

        // When
        val winners = race.findWinners()

        // Then
        assertThat(winners).hasSize(2)
        assertThat(winners).contains(car1, car2)
    }

    // Helper method to set car position using reflection
    private fun setCarPosition(car: Car, position: Int) {
        val positionField = Car::class.java.getDeclaredField("position")
        positionField.isAccessible = true
        positionField.set(car, position)
    }

    // TestCar for verifying move() calls
    private class TestCar(name: String) : Car(name) {
        var moveWasCalled = false

        override fun move() {
            moveWasCalled = true
        }
    }
}