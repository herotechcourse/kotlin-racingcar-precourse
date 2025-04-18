package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.service.movement.MovementStrategy

class RaceTest {
    
    @Test
    fun `moveAll should move all cars according to strategy`() {
        // Given
        val cars = listOf(Car("car1"), Car("car2"), Car("car3"))
        val race = Race(cars)
        val alternatingStrategy = object : MovementStrategy {
            private var count = 0
            override fun shouldMove(): Boolean {
                return (count++ % 2 == 0)
            }
        }
        
        // When
        val movedRace = race.moveAll(alternatingStrategy)
        
        // Then
        assertThat(movedRace.cars[0].position).isEqualTo(1) // First car moves
        assertThat(movedRace.cars[1].position).isEqualTo(0) // Second car doesn't move
        assertThat(movedRace.cars[2].position).isEqualTo(1) // Third car moves
    }
    
    @Test
    fun `winners should return cars with maximum position`() {
        // Given
        val car1 = Car("car1", 3)
        val car2 = Car("car2", 5)
        val car3 = Car("car3", 5)
        val race = Race(listOf(car1, car2, car3))
        
        // When
        val winners = race.winners()
        
        // Then
        assertThat(winners).containsExactly("car2", "car3")
    }
    
    @Test
    fun `display should return display strings for all cars`() {
        // Given
        val car1 = Car("car1", 1)
        val car2 = Car("car2", 2)
        val race = Race(listOf(car1, car2))
        
        // When
        val display = race.display()
        
        // Then
        assertThat(display).containsExactly("car1 : -", "car2 : --")
    }
}
