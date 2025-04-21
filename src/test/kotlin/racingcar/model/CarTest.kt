package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
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
            assertThat(car.position).isEqualTo(0)
        }
    }

    @Test
    fun `should throw exception when initial position is negative`() {
        // Arrange
        val negativeValue: Int = -1

        // Act
        // Assert
        assertThatThrownBy { Car(name, negativeValue) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Position cannot be negative.")
    }

    @Test
    fun `Car should move when power is greater than or equal to threshold`() {
        // Arrange
        val car = Car(name)
        val power = 4

        // Act
        car.move(power)

        // Assert
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `Car should not move when power is less than threshold`() {
        // Arrange
        val car = Car(name)
        val power = 3

        // Act
        car.move(power)

        // Assert
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `Car should be comparable by position`() {
        // Arrange
        val fast = Car(Name("fast"), 3)
        val slow = Car(Name("slow"), 1)

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
        val car1 = Car(Name("a"), 3)
        val car2 = Car(Name("b"), 3)

        // Act
        // Assert
        assertThat(car1.compareTo(car2)).isZero()
    }
}
