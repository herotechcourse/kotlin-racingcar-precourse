package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    
    @Test
    fun `creates car with valid name`() {
        val car = Car(1, "boji")
        assertThat(car.name).isEqualTo("boji")
        assertThat(car.position).isEqualTo(0)
    }
    
    @ParameterizedTest
    @ValueSource(strings = ["", "      "])
    fun `throws exception when name is empty`(name: String) {
        assertThatThrownBy { Car(1, name) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car name cannot be empty")
    }
    
    @Test
    fun `throws exception when name exceeds max length`() {
        val longName = "bojiboji"
        assertThatThrownBy { Car(1, "bojiboji") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car name cannot have more then 5 characters")
    }
    
    @Test
    fun `car moves when random number is greater than or equal to threshold`() {
        val car = TestCar(1, "pobi", 4) 
        val initialPosition = car.position
        
        car.move()
        
        assertThat(car.position).isEqualTo(initialPosition + 1)
    }
    
    @Test
    fun `car does not move when random number is less than threshold`() {
        val car = TestCar(1, "pobi", 3) 
        val initialPosition = car.position
        
        car.move()
        
        assertThat(car.position).isEqualTo(initialPosition)
    }
    
    @Test
    fun `car position increases by one when it moves`() {
        val car = TestCar(1, "pobi", 9) 
        val initialPosition = car.position
        
        car.move()
        
        assertThat(car.position).isEqualTo(initialPosition + 1)
    }
    
    // "Test subclass of car so that we can control the random number"
    private class TestCar(id: Int, name: String, private val numberToReturn: Int) : Car(id, name) {
        override fun getRandomNumber(): Int {
            return numberToReturn
        }
    }
}
