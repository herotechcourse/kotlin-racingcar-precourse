package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.AfterEach
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputFormattingTest {
    private val standardOut = System.out
    private val outputStream = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStream))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
    }

    @Test
    fun `displayWinners should format output correctly with single winner`() {
        val car = Car("pobi")
        car.position = 3

        val race = Race(listOf(car), 1)

        // Using reflection to access the private method for testing
        val displayWinnersMethod = Race::class.java.getDeclaredMethod("displayWinners")
        displayWinnersMethod.isAccessible = true

        displayWinnersMethod.invoke(race)

        assertThat(outputStream.toString().trim()).isEqualTo("Winners : pobi")
    }

    @Test
    fun `displayWinners should format output correctly with multiple winners`() {
        val car1 = Car("pobi")
        car1.position = 3

        val car2 = Car("woni")
        car2.position = 3

        val race = Race(listOf(car1, car2), 1)

        // Using reflection to access the private method for testing
        val displayWinnersMethod = Race::class.java.getDeclaredMethod("displayWinners")
        displayWinnersMethod.isAccessible = true

        displayWinnersMethod.invoke(race)

        assertThat(outputStream.toString().trim()).isEqualTo("Winners : pobi, woni")
    }

    @Test
    fun `car position display should show correct format`() {
        val car = Car("pobi")
        car.position = 3

        assertThat(car.getPositionDisplay()).isEqualTo("---")
    }
}