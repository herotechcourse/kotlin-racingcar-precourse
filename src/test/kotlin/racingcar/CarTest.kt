package racingcar

import racingcar.domain.Car
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest

class CarTest {

    @Test
    @DisplayName("Should increase position by 1 when random number is 4 or higher")
    fun `moveIfPossible should move forward when random number is greater than or equal to 4`() {
        // We simulate a random number of 4
        assertRandomNumberInRangeTest(
            {
                val car = Car(name = "pobi", position = 0)
                car.moveIfPossible() // Move the car
                assertThat(car.position).isEqualTo(1) // Position should increase by 1
            },
            4 // Simulate the random value of 4
        )
    }

    @Test
    @DisplayName("Should not change position when random number is less than 4")
    fun `moveIfPossible should not move when random number is less than 4`() {
        // We simulate a random number of 3
        assertRandomNumberInRangeTest(
            {
                val car = Car(name = "pobi", position = 0)
                car.moveIfPossible() // Attempt to move the car
                assertThat(car.position).isEqualTo(0) // Position should not change
            },
            3 // Simulate the random value of 3
        )
    }

    @Test
    @DisplayName("Should create a car successfully with a valid name")
    fun `constructor should create car when name is valid`() {
        val car = Car("pobi") // Create a car with a valid name
        assertThat(car.name).isEqualTo("pobi")
        assertThat(car.position).isEqualTo(0) // Default position is 0
    }
}
