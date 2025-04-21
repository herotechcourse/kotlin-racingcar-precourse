package racingcar.model

import org.assertj.core.api.Assertions.assertThat
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
    fun `should generate raceLog with size equal to rounds`() {
        // Arrange
        val count = 5
        val race = Race(cars, Rounds(count))

        // Act
        val result = race.play()

        // Assert
        assertThat(result.raceLog).hasSize(count)
    }

    @Test
    fun `each LapReport should contain all cars`() {
        val race = Race(cars, Rounds(3))
        val result = race.play()

        result.raceLog.forEach { lap ->
            assertThat(lap.statuses).hasSize(3) // audi, benz, bmw
        }
    }

    @Test
    fun `should determine at least one winner`() {
        // Arrange
        val race = Race(cars, Rounds(4))

        // Act
        val result = race.play()

        // Assert
        assertThat(result.winners).isNotEmpty
    }
}
