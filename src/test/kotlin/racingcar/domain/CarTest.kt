package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.service.movement.MovementStrategy

class CarTest {
    
    @Test
    fun `car should move when strategy returns true`() {
        // Given
        val car = Car("test")
        val alwaysMoveStrategy = object : MovementStrategy {
            override fun shouldMove() = true
        }
        
        // When
        val movedCar = car.move(alwaysMoveStrategy)
        
        // Then
        assertThat(movedCar.position).isEqualTo(1)
    }
    
    @Test
    fun `car should not move when strategy returns false`() {
        // Given
        val car = Car("test")
        val neverMoveStrategy = object : MovementStrategy {
            override fun shouldMove() = false
        }
        
        // When
        val movedCar = car.move(neverMoveStrategy)
        
        // Then
        assertThat(movedCar.position).isEqualTo(0)
    }
    
    @Test
    fun `car name should not exceed 5 characters`() {
        // When & Then
        assertThrows<IllegalArgumentException> {
            Car("toolong")
        }
    }
    
    @Test
    fun `car name should not be empty`() {
        // When & Then
        assertThrows<IllegalArgumentException> {
            Car("")
        }
    }
    
    @Test
    fun `display should show car name and position`() {
        // Given
        val car = Car("pobi", 3)
        
        // When
        val display = car.display()
        
        // Then
        assertThat(display).isEqualTo("pobi : ---")
    }
}
