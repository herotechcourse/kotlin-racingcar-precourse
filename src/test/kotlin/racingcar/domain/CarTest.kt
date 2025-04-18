package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    
    @DisplayName("Car should not move when random number is less than 4")
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun shouldNotMoveWhenRandomNumberLessThanFour(randomNumber: Int) {
        // given
        val car = Car("test")
        
        // when
        car.move(randomNumber)
        
        // then
        assertThat(car.getPosition()).isEqualTo(0)
    }
    
    @DisplayName("Car should move when random number is greater than or equal to 4")
    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun shouldMoveWhenRandomNumberGreaterThanOrEqualToFour(randomNumber: Int) {
        // given
        val car = Car("test")
        
        // when
        car.move(randomNumber)
        
        // then
        assertThat(car.getPosition()).isEqualTo(1)
    }
    
    @Test
    @DisplayName("Car can move multiple times")
    fun shouldMoveMultipleTimes() {
        // given
        val car = Car("test")
        
        // when
        car.move(4)
        car.move(5)
        car.move(3)
        car.move(9)
        
        // then
        assertThat(car.getPosition()).isEqualTo(3)
    }
} 