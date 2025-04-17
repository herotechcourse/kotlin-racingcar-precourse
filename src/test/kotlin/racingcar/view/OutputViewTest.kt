package racingcar.view

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.model.Fuel
import racingcar.model.GasStation
import racingcar.model.Round
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.io.PrintStream

class OutputViewTest {

    private lateinit var round: Round
    private lateinit var car1: Car
    private lateinit var car2: Car
    private lateinit var car3: Car
    private lateinit var fuel: Fuel
    private lateinit var outputView: OutputView

    private lateinit var outputStream: OutputStream

    @BeforeEach
    fun setUp() {
        fuel = GasStation()
        car1 = Car("pobi", fuel = fuel)
        car2 = Car("woni", fuel = fuel)
        car3 = Car("jun", fuel = fuel)

        outputView = OutputView()
        round = Round(1, listOf(car1, car2, car3))

        outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))
    }

    fun output(): String {
        return outputStream.toString()
    }

    @AfterEach
    fun printOutput() {
        System.setOut(System.out)
        println(output())
    }

    @Test
    fun printRoundResultTest() {
        round.race()
        outputView.printRoundResult(round)
        assertEquals(output(), "pobi : -\nwoni : -\njun : -\n")

    }
}