package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarsTest {
    
    @Test
    @DisplayName("All cars should move according to random numbers")
    fun shouldMoveAllCarsAccordingToRandomNumbers() {
        // given
        val car1 = Car("car1")
        val car2 = Car("car2")
        val car3 = Car("car3")
        val cars = Cars(listOf(car1, car2, car3))
        
        // when
        cars.moveAll(listOf(3, 4, 9))
        
        // then
        assertThat(car1.getPosition()).isEqualTo(0)
        assertThat(car2.getPosition()).isEqualTo(1)
        assertThat(car3.getPosition()).isEqualTo(1)
    }
    
    @Test
    @DisplayName("Should return the correct winners")
    fun shouldReturnCorrectWinners() {
        // given
        val car1 = Car("car1")
        val car2 = Car("car2")
        val car3 = Car("car3")
        
        // Move cars to different positions
        car1.move(4) // position 1
        car2.move(4) // position 1
        car2.move(4) // position 2
        car3.move(4) // position 1
        
        val cars = Cars(listOf(car1, car2, car3))
        
        // when
        val winners = cars.getWinners()
        
        // then
        assertThat(winners).hasSize(1)
        assertThat(winners[0].name).isEqualTo("car2")
    }
    
    @Test
    @DisplayName("Should return multiple winners when tied for first place")
    fun shouldReturnMultipleWinnersWhenTied() {
        // given
        val car1 = Car("car1")
        val car2 = Car("car2")
        val car3 = Car("car3")
        
        // Move cars to same positions
        car1.move(4) // position 1
        car1.move(4) // position 2
        car2.move(4) // position 1
        car2.move(4) // position 2
        car3.move(4) // position 1
        
        val cars = Cars(listOf(car1, car2, car3))
        
        // when
        val winners = cars.getWinners()
        
        // then
        assertThat(winners).hasSize(2)
        assertThat(winners.map { it.name }).containsExactlyInAnyOrder("car1", "car2")
    }
} 