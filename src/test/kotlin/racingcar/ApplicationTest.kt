package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class ApplicationTest : NsTest() {
    // Mock implementation of InputHandler for testing purposes
    class MockInputHandler(private val inputs: List<String>) : InputHandler {
        private var index = 0
        override fun readLine(): String {
            return inputs[index++]
        }
    }

    // Mock implementation of RandomNumberGenerator for testing purposes
    class MockRandomNumberGenerator(private val numbers: List<Int>) : RandomNumberGenerator {
        private var index = 0
        override fun generate(min: Int, max: Int): Int {
            return numbers[index++ % numbers.size]
        }
    }

    @Test
    fun `main should simulate the race and display progress per round`() {
        // Arrange: Mock input for car names and number of rounds
        val mockRandomNumberGenerator = MockRandomNumberGenerator(listOf(4, 3, 5, 6, 2, 4))
        val cars = listOf(Car("pobi"), Car("woni"), Car("java"))

        // Redirect standard output to capture printed output
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        // Act: Simulate the race
        simulateRace(cars, 3, mockRandomNumberGenerator)

        // Assert: Verify the printed output
        val expectedOutput = """
            pobi : -
            woni : 
            java : -

            pobi : --
            woni : 
            java : --

            pobi : ---
            woni : 
            java : ---
        """.trimIndent()
        assertThat(expectedOutput).isEqualTo(outputStream.toString().trim())
    }

    @Test
    fun `determineWinners should return the names of the car(s) with the maximum position`() {
        // Arrange: Create a list of cars with predefined positions
        val cars = listOf(
            Car("pobi", 3),
            Car("woni", 2),
            Car("java", 3)
        )

        // Act: Determine the winners
        val winners = determineWinners(cars)

        // Assert: Verify the winners
        assertThat("pobi, java").isEqualTo(winners)
    }

    @Test
    fun `determineWinners should return a single winner if only one car has the maximum position`() {
        // Arrange: Create a list of cars with predefined positions
        val cars = listOf(
            Car("pobi", 4),
            Car("woni", 2),
            Car("java", 3)
        )

        // Act: Determine the winners
        val winners = determineWinners(cars)

        // Assert: Verify the winner
        assertThat("pobi").isEqualTo(winners)
    }

    @Test
    fun `determineWinners should return all cars if they have the same maximum position`() {
        // Arrange: Create a list of cars with the same position
        val cars = listOf(
            Car("pobi", 3),
            Car("woni", 3),
            Car("java", 3)
        )

        // Act: Determine the winners
        val winners = determineWinners(cars)

        // Assert: Verify all cars are winners
        assertThat("pobi, woni, java").isEqualTo(winners)
    }

    @Test
    fun `getCarNames should return valid car names`() {
        // Test valid input for car names
        val inputHandler = MockInputHandler(listOf("pobi,woni,java"))
        val carNames = getCarNames(inputHandler)
        assertThat(carNames).containsExactly("pobi", "woni", "java")
    }

    @Test
    fun `getCarNames should throw exception for empty car name`() {
        // Test invalid input where one car name is empty
        val inputHandler = MockInputHandler(listOf("pobi,,java"))
        assertThrows<IllegalArgumentException> {
            getCarNames(inputHandler)
        }
    }

    @Test
    fun `getCarNames should throw exception for car name exceeding 5 characters`() {
        // Test invalid input where one car name exceeds 5 characters
        val inputHandler = MockInputHandler(listOf("pobi,javaji"))
        assertThrows<IllegalArgumentException> {
            getCarNames(inputHandler)
        }
    }

    @Test
    fun `getNumberOfRounds should return valid number of rounds`() {
        // Test valid input for the number of rounds
        val inputHandler = MockInputHandler(listOf("3"))
        val rounds = getNumberOfRounds(inputHandler)
        assertThat(rounds).isEqualTo(3)
    }

    @Test
    fun `getNumberOfRounds should throw exception for invalid input`() {
        // Test invalid input where the number of rounds is negative
        val inputHandler = MockInputHandler(listOf("-1"))
        assertThrows<IllegalArgumentException> {
            getNumberOfRounds(inputHandler)
        }
    }

    @Test
    fun `getNumberOfRounds should throw exception for non-integer input`() {
        // Test invalid input where the number of rounds is not an integer
        val inputHandler = MockInputHandler(listOf("abc"))
        assertThrows<IllegalArgumentException> {
            getNumberOfRounds(inputHandler)
        }
    }

    @Test
    fun `feature test`() {
        // Simulate a race with two cars and one round
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                // Verify the output contains expected results
                assertThat(output()).contains("pobi : -", "woni : ", "Winners : pobi")
            },
            MOVING_FORWARD, // Simulate random number for moving forward
            STOP            // Simulate random number for stopping
        )
    }

    @Test
    fun `exception test`() {
        // Test invalid input (car name exceeding 5 characters)
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,javaji", "1")
            }
        }
    }

    override fun runMain() {
        // Call the main function of the application
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4 // Threshold for moving forward
        private const val STOP: Int = 3          // Threshold for stopping
    }
}