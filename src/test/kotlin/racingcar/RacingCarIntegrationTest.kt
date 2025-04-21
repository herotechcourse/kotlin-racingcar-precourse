package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import camp.nextstep.edu.missionutils.Console
import racingcar.domain.Car
import racingcar.domain.Race
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class RacingCarIntegrationTest {
    private val standardOut = System.out
    private val outputStream = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStream))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
        Console.close()
    }

    @Test
    fun `should run car racing game successfully`() {
        // Given
        val input = "pobi,woni,jun\n5\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        // When
        main()

        // Then
        val output = outputStream.toString()
        assertThat(output).contains("Enter the names of the cars (comma-separated):")
        assertThat(output).contains("How many rounds will be played?")
        assertThat(output).contains("Race Results")
        assertThat(output).contains("Winners :")
    }

    @ParameterizedTest
    @ValueSource(strings = ["", ",", "car1,", ",car2"])
    fun `should throw exception for invalid car names input`(invalidInput: String) {
        // Given
        val input = "$invalidInput\n5\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        // When/Then
        assertThatThrownBy { main() }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `should throw exception when car name exceeds 5 characters`() {
        // Given
        val input = "car1,toolong,car3\n5\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        // When/Then
        assertThatThrownBy { main() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car name cannot exceed 5 characters")
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "-1", "abc"])
    fun `should throw exception for invalid round count`(invalidRound: String) {
        // Given
        val input = "car1,car2,car3\n$invalidRound\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        // When/Then
        assertThatThrownBy { main() }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `should correctly determine multiple winners`() {
        // Given
        val car1 = Car("car1")
        val car2 = Car("car2")
        val car3 = Car("car3")
        val cars = listOf(car1, car2, car3)

        // Directly set positions to ensure predictable results
        // Both car1 and car2 will have moved 3 times, car3 only 2 times
        repeat(3) { car1.move(5) } // Will move 3 times
        repeat(3) { car2.move(5) } // Will move 3 times
        repeat(2) { car3.move(5) } // Will move 2 times

        // When
        val race = Race(cars, 3)
        val winners = race.determineWinners()

        // Then
        assertThat(winners).hasSize(2)
        assertThat(winners.map { it.name }).containsExactlyInAnyOrder("car1", "car2")
    }

    @Test
    fun `should correctly determine single winner`() {
        // Given
        val car1 = Car("car1")
        val car2 = Car("car2")
        val car3 = Car("car3")
        val cars = listOf(car1, car2, car3)

        // Directly set positions to ensure predictable results
        // car1 has moved more than the others
        repeat(4) { car1.move(5) } // Will move 4 times
        repeat(2) { car2.move(5) } // Will move 2 times
        repeat(3) { car3.move(5) } // Will move 3 times

        // When
        val race = Race(cars, 3)
        val winners = race.determineWinners()

        // Then
        assertThat(winners).hasSize(1)
        assertThat(winners[0].name).isEqualTo("car1")
    }

    @Test
    fun `car should move only when random number is 4 or greater`() {
        // Given
        val car = Car("test")

        // When
        for (i in 0..3) {
            car.move(i)
        }
        val positionAfterLowNumbers = car.getPosition()

        for (i in 4..9) {
            car.move(i)
        }
        val finalPosition = car.getPosition()

        // Then
        assertThat(positionAfterLowNumbers).isEqualTo(0)
        assertThat(finalPosition).isEqualTo(6)
    }

    @Test
    fun `should correctly format output for multiple winners`() {
        // Given
        val cars = listOf(
            Car("pobi").apply { repeat(3) { move(5) } },
            Car("woni").apply { repeat(2) { move(5) } },
            Car("jun").apply { repeat(3) { move(5) } }
        )

        // When
        val race = Race(cars, 3)
        val winners = race.determineWinners()

        // Then
        assertThat(winners).hasSize(2)
        assertThat(winners.map { it.name }).containsExactlyInAnyOrder("pobi", "jun")

        // Check output formatting
        System.setOut(PrintStream(outputStream))
        val outputView = racingcar.ui.OutputView()
        outputView.printWinners(winners)

        val output = outputStream.toString()
        assertThat(output).contains("Winners : ")
        assertThat(output).contains("pobi, jun")
    }

    @Test
    fun `car toString should format name and position correctly`() {
        // Given
        val car = Car("test")

        // When
        repeat(3) { car.move(5) }

        // Then
        assertThat(car.toString()).isEqualTo("test : ---")
    }
}