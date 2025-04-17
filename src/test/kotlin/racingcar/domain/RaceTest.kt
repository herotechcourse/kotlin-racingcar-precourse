package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.RepeatedTest

class RaceTest {

    @Test
    @DisplayName("Race should determine winner correctly when positions are known")
    fun testDetermineWinner() {
        // Given - Create cars with known positions by directly setting them through move()
        val car1 = Car("car1")
        val car2 = Car("car2")
        val car3 = Car("car3")

        // Manually move cars to set positions
        // car1: moves 2 times
        car1.move(4) // will move
        car1.move(4) // will move

        // car2: moves 1 time
        car2.move(4) // will move
        car2.move(3) // won't move

        // car3: moves 2 times
        car3.move(4) // will move
        car3.move(4) // will move

        val cars = listOf(car1, car2, car3)
        val race = Race(cars, 0) // 0 rounds because we manually moved cars

        // When
        val winners = race.run()

        // Then
        assertThat(car1.getPosition()).isEqualTo(2)
        assertThat(car2.getPosition()).isEqualTo(1)
        assertThat(car3.getPosition()).isEqualTo(2)
        assertThat(winners).hasSize(2)
        assertThat(winners).contains(car1, car3)
        assertThat(winners).doesNotContain(car2)
    }

    @Test
    @DisplayName("Race with no cars should return empty winners list")
    fun testEmptyRace() {
        // Given
        val cars = emptyList<Car>()
        val race = Race(cars, 5)

        // When
        val winners = race.run()

        // Then
        assertThat(winners).isEmpty()
    }

    @RepeatedTest(5)
    @DisplayName("Race should complete all rounds")
    fun testRaceCompleteAllRounds() {
        // Given
        val car = Car("test")
        val cars = listOf(car)
        val rounds = 10
        val race = Race(cars, rounds)

        // When
        race.run()

        // Then
        // We can't assert exact position since it's random,
        // but we can verify position is within possible range (0-10)
        val position = car.getPosition()
        assertThat(position).isGreaterThanOrEqualTo(0)
        assertThat(position).isLessThanOrEqualTo(rounds)
    }
}