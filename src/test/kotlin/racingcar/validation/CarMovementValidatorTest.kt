import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*

import racingcar.movement.CarAdapter
import racingcar.validation.CarMovementValidator
import racingcar.model.Car

class CarMovementValidatorTest {

    @Test
    fun `should move car when random value is equal to 4`() {
        // Initialize CarAdapter with a car at position 0 and pass a random value of 4
        val carAdapter = CarAdapter(Car(name = "audi", position = 0), randomValue = 4)
        val carMovementValidator = CarMovementValidator(carAdapter)

        // Simulate the case where the random value is 4
        carMovementValidator.validateCarMovement(1)   // Validate whether car can move to 1st position

        // Assert that the car moved and position is updated correctly
        assertThat(carAdapter.getCar().position).isEqualTo(1)
    }

    @Test
    fun `should not move car when random value is equal to 0`() {
        // Initialize CarAdapter with a car at position 0 and pass a random value of 0
        val carAdapter = CarAdapter(Car(name = "audi", position = 0), randomValue = 0)
        val carMovementValidator = CarMovementValidator(carAdapter)

        // Simulate the case where the random value is 0
        assertThatThrownBy {
            carMovementValidator.validateCarMovement(0)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car cannot move. Random number was less than 4.")  // Validate whether car can move

        // Assert that the car moved and position is updated correctly
        assertThat(carAdapter.getCar().position).isEqualTo(0)

    }

    @Test
    fun `should move car when random value is greater than 4`() {
        // Initialize CarAdapter with a car at position 0 and pass a random value of 5
        val carAdapter = CarAdapter(Car(name = "audi", position = 0), randomValue = 5)
        val carMovementValidator = CarMovementValidator(carAdapter)

        // Simulate the case where the random value is 5
        carMovementValidator.validateCarMovement(1)  // Validate whether car can move to 1st position

        // Assert that the car moved and position is updated correctly
        assertThat(carAdapter.getCar().position).isEqualTo(1)

        // Assert that the car has already moved to first position but checking 0 position
        assertThatThrownBy {
            carMovementValidator.validateCarMovement(0)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Expected position")

    }

    @Test
    fun `should not move car when random value is less than 4`() {
        // Initialize CarAdapter with a car at position 0 and pass a random value of 2
        val carAdapter = CarAdapter(Car(name = "audi", position = 0), randomValue = 2)
        val carMovementValidator = CarMovementValidator(carAdapter)

        // Simulate the case where the random value is 2
        assertThatThrownBy {
            carMovementValidator.validateCarMovement(0)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car cannot move. Random number was less than 4.")

    }
}