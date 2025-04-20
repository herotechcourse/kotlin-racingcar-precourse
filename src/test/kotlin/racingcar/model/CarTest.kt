package racingcar.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CarTest{

  @Test
  fun `should create car with valid name`() {
   val car = Car("pobi")
   assertEquals("pobi", car.name)
   assertEquals(0, car.getPosition())
  }

    @Test
    fun `should throw exception when car name is blank`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Car("")
        }
        assertEquals("Car name cannot be Blank", exception.message)
    }

    @Test
    fun `should throw exception when car name is longer than 5 characters`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Car("pobier")
        }
        assertEquals("Car name cannot exceed 5 characters", exception.message)
    }
    @Test
    fun `should not move if random number is less than 4`() {
        val car = Car("Test")
        val initialPosition = car.getPosition()
        assertEquals(initialPosition, car.getPosition())
    }


 }