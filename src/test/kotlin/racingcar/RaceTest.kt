package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class RaceTest {
    private val standardOut = System.out
    private val outputStream = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStream))
    }

    @Test
    fun `findWinners should return cars with highest position`() {
        // Create test cars with different positions
        val car1 = Car("car1")
        car1.position = 3

        val car2 = Car("car2")
        car2.position = 5

        val car3 = Car("car3")
        car3.position = 5

        val race = Race(listOf(car1, car2, car3), 1)

        // Using reflection to access the private method for testing
        val findWinnersMethod = Race::class.java.getDeclaredMethod("findWinners")
        findWinnersMethod.isAccessible = true

        @Suppress("UNCHECKED_CAST")
        val winners = findWinnersMethod.invoke(race) as List<Car>

        assertThat(winners).hasSize(2)
        assertThat(winners.map { it.name }).containsExactlyInAnyOrder("car2", "car3")
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

        // Reset stdout
        System.setOut(standardOut)
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

        // Reset stdout
        System.setOut(standardOut)
    }
}