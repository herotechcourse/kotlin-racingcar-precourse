package racingcar.ui

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.car.AlwaysMoveStrategy
import racingcar.car.Car
import racingcar.car.NeverMoveStrategy
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputViewTest {
    private val outputView = OutputView()
    private val standardOut = System.out
    private lateinit var outputStreamCaptor: ByteArrayOutputStream

    @BeforeEach
    fun setUp() {
        outputStreamCaptor = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
    }
    @Test
    fun printCarsAndPositions() {
        // given
        val cars = listOf(
            Car("car1", NeverMoveStrategy()),
            Car("car2", AlwaysMoveStrategy()),
            Car("car3", NeverMoveStrategy()),
        )
        cars.forEach{car->
            car.drive()
        }
        // when
        outputView.printCarsAndPositions(cars)
        val output = outputStreamCaptor.toString().trim()
        // then
        val expectedOutput = listOf(
            "car1 : ",
            "car2 : -",
            "car3 :",
        ).joinToString(System.lineSeparator())
        assertEquals(expectedOutput, output)
    }
    @Test
    fun printRaceStartMessage() {
        // given & when
        outputView.printRaceStartMessage()
        val output = outputStreamCaptor.toString().trim()
        // then
        assertEquals("Race Results", output)
    }
    @Test
    fun `printWinners singleWinner`() {
        // given & when
        outputView.printWinners("car1")
        val output = outputStreamCaptor.toString().trim()
        // then
        assertEquals("Winners : car1", output)
    }
    @Test
    fun `printWinners multipleWinners`() {
        // given & when
        outputView.printWinners("car1, car2")
        val output = outputStreamCaptor.toString().trim()
        // then
        assertEquals("Winners : car1, car2", output)
    }
}