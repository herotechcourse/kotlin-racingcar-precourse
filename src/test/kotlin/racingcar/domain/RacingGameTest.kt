package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RacingGameTest {
    
    @Test
    @DisplayName("Should correctly determine multiple winners")
    fun shouldDetermineMultipleWinners() {
        // Given
        val car1 = Car("car1")
        val car2 = Car("car2")
        repeat(3) {
            car1.move(4)
            car2.move(4)
        }
        val cars = Cars(listOf(car1, car2))
        val game = RacingGame(cars, 3)
        
        // When
        game.race()
        val winners = game.getWinners()
        
        // Then
        assertThat(winners).hasSize(2)
        assertThat(winners.map { it.name }).containsExactlyInAnyOrder("car1", "car2")
    }
} 