package racingcar.app

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.assertj.core.api.Assertions.assertThat
import camp.nextstep.edu.missionutils.Console
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class CarRaceAppTest {
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
    @DisplayName("Single car racing with predetermined movement")
    fun testSingleCar() {
        // Arrange
        val input = "car1\n1"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        // Always moves (number > threshold)
        val fixedNumberGenerator = { 5 }
        val app = CarRaceApp(4, fixedNumberGenerator)

        // Act
        app.play()

        // Assert
        val output = outputStream.toString()
        assertThat(output).contains("car1 : -")
        assertThat(output).contains("Winners : car1")
    }

    @Test
    @DisplayName("Multiple cars with some winning and some not moving")
    fun testMultipleCarsWithSomeWinning() {
        // Arrange
        val input = "car1,car2,car3\n3"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        // Predefined sequence to make car1 and car3 win
        val numbers = listOf(5, 3, 5, 5, 3, 5, 5, 3, 5)
        val numberGenerator = numbers.iterator()::next

        val app = CarRaceApp(4, numberGenerator)

        // Act
        app.play()

        // Assert
        val output = outputStream.toString()
        assertThat(output).contains("car1 : ---")
        assertThat(output).contains("car2 : ")
        assertThat(output).contains("car3 : ---")
        assertThat(output).contains("Winners : car1, car3")
    }

    @Test
    @DisplayName("All cars not moving due to threshold")
    fun testAllCarsNotMoving() {
        // Arrange
        val input = "car1,car2\n2"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        // Always stay (number < threshold)
        val fixedNumberGenerator = { 3 }
        val app = CarRaceApp(4, fixedNumberGenerator)

        // Act
        app.play()

        // Assert
        val output = outputStream.toString()
        assertThat(output).contains("car1 : ")
        assertThat(output).contains("car2 : ")
        assertThat(output).contains("Winners : car1, car2")
    }

    @Test
    @DisplayName("Car race with complex movement pattern producing a single winner")
    fun testCarRaceComplexMovementSingleWinner() {
        // Arrange
        val input = "pobi,woni,jun\n5"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        // Predetermined sequence where pobi wins
        val movementPattern = listOf(
            5, 3, 3, // Round 1: pobi moves, others don't
            5, 5, 3, // Round 2: pobi and woni move, jun doesn't
            3, 5, 5, // Round 3: woni and jun move, pobi doesn't
            5, 3, 5, // Round 4: pobi and jun move, woni doesn't
            5, 3, 3  // Round 5: pobi moves, others don't
        )

        val numberGenerator = movementPattern.iterator()::next

        val app = CarRaceApp(4, numberGenerator)

        // Act
        app.play()

        // Assert
        val output = outputStream.toString()
        assertThat(output).contains("pobi : ----")
        assertThat(output).contains("woni : --")
        assertThat(output).contains("jun : --")
        assertThat(output).contains("Winners : pobi")
    }

    @Test
    @DisplayName("Car race with multiple winners having exact same score")
    fun testCarRaceExactTie() {
        // Arrange
        val input = "a,b,c,d\n3"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        // Pattern ensures a and c win with same number of moves
        val pattern = sequence {
            while (true) {
                yield(5) // a
                yield(3) // b
                yield(5) // c
                yield(3) // d
            }
        }
        val numberGenerator = pattern.iterator()::next

        val app = CarRaceApp(4, numberGenerator)

        // Act
        app.play()

        // Assert
        val output = outputStream.toString()
        assertThat(output).contains("a : ---")
        assertThat(output).contains("b : ")
        assertThat(output).contains("c : ---")
        assertThat(output).contains("d : ")
        assertThat(output).contains("Winners : a, c")
    }
}