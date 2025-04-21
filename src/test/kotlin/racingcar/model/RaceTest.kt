package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RaceTest {

    private lateinit var cars: Cars;

    @BeforeEach
    fun setUp() {
        cars = Cars(
            listOf(
                Car(Name("audi")),
                Car(Name("benz")),
                Car(Name("bmw"))
            )
        )
    }

    @Test
    fun `should throw exception when rounds is less than 1`() {
        // Act
        // Assert
        assertThatThrownBy { Race(cars, 0) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Round must be greater than or equal to 1")
    }

    @Test
    fun `should generate raceLog with size equal to rounds`() {
        // Arrange
        val rounds = 5
        val race = Race(cars, rounds)

        // Act
        val result = race.play()

        // Assert
        assertThat(result.raceLog).hasSize(rounds)
    }

    @Test
    fun `should determine at least one winner`() {
        // Arrange
        val race = Race(cars, 4)

        // Act
        val result = race.play()

        // Assert
        assertThat(result.winners).isNotEmpty
    }
}
