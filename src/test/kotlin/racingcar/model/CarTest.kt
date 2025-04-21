package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CarTest {

    private val name: Name = Name("audi")
    private lateinit var car: Car

    @BeforeEach
    fun setUp() {
        car = Car(name)
    }

    @Test
    fun `should create Car when name is valid`() {
        // Assert
        SoftAssertions.assertSoftly {
            assertThat(car.name).isEqualTo(name)
            assertThat(car.position).isEqualTo(Position(0))
        }
    }

    @Test
    fun `Car should move when power is greater than or equal to threshold`() {
        // Arrange
        val car = Car(name)
        val power = 4

        // Act
        car.move(power)

        // Assert
        assertThat(car.position).isEqualTo(Position(1))
    }

    @Test
    fun `Car should not move when power is less than threshold`() {
        // Arrange
        val car = Car(name)
        val power = 3

        // Act
        car.move(power)

        // Assert
        assertThat(car.position).isEqualTo(Position(0))
    }

}
