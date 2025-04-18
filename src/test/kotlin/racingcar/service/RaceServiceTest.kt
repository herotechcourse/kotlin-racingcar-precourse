package racingcar.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import racingcar.domain.Race
import racingcar.service.movement.MovementStrategy

class RaceServiceTest {
    
    @Test
    fun `play should run race for specified number of rounds`() {
        // Given
        val cars = listOf(Car("car1"), Car("car2"))
        val race = Race(cars)
        val alwaysMoveStrategy = object : MovementStrategy {
            override fun shouldMove() = true
        }
        val raceService = RaceService(alwaysMoveStrategy)
        
        // When
        val history = raceService.play(race, 3)
        
        // Then
        assertThat(history).hasSize(3) // 3 rounds
        
        // First round: each car moved once
        assertThat(history[0]).containsExactly("car1 : -", "car2 : -")
        
        // Second round: each car moved twice
        assertThat(history[1]).containsExactly("car1 : --", "car2 : --")
        
        // Third round: each car moved three times
        assertThat(history[2]).containsExactly("car1 : ---", "car2 : ---")
    }
    
    @Test
    fun `play should return empty history for zero rounds`() {
        // Given
        val cars = listOf(Car("car1"), Car("car2"))
        val race = Race(cars)
        val strategy = object : MovementStrategy {
            override fun shouldMove() = true
        }
        val raceService = RaceService(strategy)
        
        // When
        val history = raceService.play(race, 0)
        
        // Then
        assertThat(history).isEmpty()
    }
    
    @Test
    fun `play should use movement strategy to determine car movement`() {
        // Given
        val cars = listOf(Car("car1"), Car("car2"))
        val race = Race(cars)
        
        // Create a predictable strategy that follows a specific pattern:
        // First round: car1 moves (true), car2 doesn't (false)
        // Second round: car1 doesn't move (false), car2 moves (true)
        val predictableStrategy = object : MovementStrategy {
            private var callCount = 0
            
            override fun shouldMove(): Boolean {
                val result = when (callCount) {
                    0 -> true   // First car in first round moves
                    1 -> false  // Second car in first round doesn't move
                    2 -> false  // First car in second round doesn't move
                    3 -> true   // Second car in second round moves
                    else -> false
                }
                callCount++
                return result
            }
        }
        
        val raceService = RaceService(predictableStrategy)
        
        // When
        val history = raceService.play(race, 2)
        
        // Then
        // First round: first car moves, second car doesn't
        assertThat(history[0]).containsExactly("car1 : -", "car2 : ")
        
        // Second round: first car doesn't move further, second car moves
        // So car1 still has position 1, and car2 now has position 1 too
        assertThat(history[1]).containsExactly("car1 : -", "car2 : -")
    }
}
