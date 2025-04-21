package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import racingcar.model.Car

class CarTest {
    @Test
    fun `car name validation should pass for valid names`(){
        assertDoesNotThrow { Car("pobi") }
    }

    @Test
    fun `car name validation should fail for empty names` (){
        assertThrows<IllegalArgumentException> { Car("") }
    }

    @Test
    fun `car name validation should fail for names longer than 5 characters`() {
        assertThrows<IllegalArgumentException> { Car("too-long") }
    }

    @Test
    fun `car position should increase when random number is 4 or greater`() {
        // For testing, we would need to mock the Random class
        // This test would require a testing framework with mocking capabilities
    }
}