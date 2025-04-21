package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = ["bmw", "benz"])
    fun `should create Car when name is 5 characters or fewer`(name: String) {
        // Act
        val car = Car(name)

        // Assert
        SoftAssertions.assertSoftly {
            assertThat(car.name).isEqualTo(name)
            assertThat(car.position).isEqualTo(0)
        }
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = [" ", "   "])
    fun `should throw exception when name is null or blank`(invalidName: String) {
        // Act
        // Assert
        assertThatThrownBy { Car(invalidName) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Car must have a name.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["porsche", "lamborghini"])
    fun `should throw exception when name exceeds 5 characters`(invalidName: String) {
        // Act
        // Assert
        assertThatThrownBy { Car(invalidName) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Name cannot exceed 5 characters.")
    }

    @Test
    fun `should throw exception when initial position is negative`() {
        // Arrange
        val negativeValue: Int = -1

        // Act
        // Assert
        assertThatThrownBy { Car("audi", negativeValue) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Position cannot be negative.")
    }

    @Test
    fun `Car should move when power is greater than or equal to threshold`() {
        // Arrange
        val car = Car("audi")
        val power = 4

        // Act
        car.move(power)

        // Assert
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `Car should not move when power is less than threshold`() {
        // Arrange
        val car = Car("audi")
        val power = 3

        // Act
        car.move(power)

        // Assert
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `Car should be comparable by position`() {
        // Arrange
        val fast = Car("fast", 3)
        val slow = Car("slow", 1)

        // Act
        // Assert
        SoftAssertions.assertSoftly {
            assertThat(fast).isGreaterThan(slow)
            assertThat(slow).isLessThan(fast)
            assertThat(fast.compareTo(fast)).isZero()
        }
    }

    @Test
    fun `Cars with same position should be equal in comparison`() {
        // Arrange
        val car1 = Car("a", 3)
        val car2 = Car("b", 3)

        // Act
        // Assert
        assertThat(car1.compareTo(car2)).isZero()
    }
}
