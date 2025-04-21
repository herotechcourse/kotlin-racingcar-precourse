package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RaceTest {

    private lateinit var cars: Cars;
    private val powerGenerator = PowerGenerator { 9 }

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
        val result = race.play(powerGenerator)

        // Assert
        assertThat(result.raceLog).hasSize(count)
    }

    @Test
    fun `each LapReport should contain all cars`() {
        // Arrange
        val race = Race(cars, Rounds(3))

        // Act
        val result = race.play(powerGenerator)

        // Assert
        result.raceLog.forEach { lap ->
            assertThat(lap.statuses).hasSize(3) // audi, benz, bmw
        }
    }

    @Test
    fun `should determine the correct winner after multiple rounds`() {
        // Arrange
        val powerGenerator: PowerGenerator = ListPowerGenerator(listOf(9, 4, 0, 9, 4, 0, 9, 4, 0))
        val cars = Cars(
            listOf(
                Car(Name("a")), // 3
                Car(Name("b")), // 3
                Car(Name("c")) // 0
            )
        )
        val race = Race(cars, Rounds(3))

        // Act
        val result = race.play(powerGenerator)

        // Assert
        SoftAssertions.assertSoftly {
            assertThat(result.raceLog).hasSize(3)
            assertThat(result.winners).containsExactlyInAnyOrder(Name("a"), Name("b"))
        }
    }
}
