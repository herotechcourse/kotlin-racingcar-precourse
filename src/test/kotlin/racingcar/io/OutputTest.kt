package racingcar.io

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.util.TestCarFactory
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputTest {

    private val outputStream = ByteArrayOutputStream()

    @BeforeEach
    fun before() {
        System.setOut(PrintStream(outputStream))
    }

    @AfterEach
    fun after() {
        System.setOut(System.out)
        outputStream.reset()
    }

    @Test
    fun `should print start message with line break`() {
        Output.printStartMessage()

        val expected = "\nRace Results\n"
        assertEquals(expected, outputStream.toString())
    }

    @Test
    fun `should print car positions correctly`() {
        val cars = listOf(
            TestCarFactory.buildCar("pobi", 3),
            TestCarFactory.buildCar("woni", 2)
        )

        Output.printGame(cars)

        val expected = """
            pobi : ---
            woni : --
        """.trimIndent()

        assertEquals(expected, outputStream.toString().trim())
    }

    @Test
    fun `should print single winner name`() {
        val winners = listOf(
            TestCarFactory.buildCar("pobi", 3),
        )

        Output.printWinner(winners)

        val expected = "Winners : pobi"
        assertEquals(expected, outputStream.toString())
    }

    @Test
    fun `should print winner names separated by comma`() {
        val winners = listOf(
            TestCarFactory.buildCar("pobi", 3),
            TestCarFactory.buildCar("woni", 3)
        )

        Output.printWinner(winners)

        val expected = "Winners : pobi, woni"
        assertEquals(expected, outputStream.toString())
    }

}