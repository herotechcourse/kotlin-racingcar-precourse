package racingcar.io

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.model.Car
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class RaceDisplayTest {

    private val standardOut = System.out
    private val outputStream = ByteArrayOutputStream()

    @BeforeEach
    fun setUp(){
        System.setOut(PrintStream(outputStream))
    }

    @AfterEach
    fun tearDown(){
        System.setOut(standardOut)
    }

    @Test
    fun `displayLapProgress should show correct car progress`(){
        val pobi = Car("pobi")
        val woni = Car("woni")
        val jun = Car("jun")
        val cars = listOf<Car>(pobi, woni, jun)
        val rounds = 3

        pobi.moveForward()
        pobi.moveForward()
        woni.moveForward()

        RaceDisplay.displayLapProgress(cars, rounds)

        val output = outputStream.toString()
        assertThat(output).contains("Cars progress after round $rounds:")
        assertThat(output).contains("pobi : --")
        assertThat(output).contains("woni : -")
    }

    @Test
    fun `displayRaceWinners should show winners correctly`(){
        val pobi = Car("pobi")
        val woni = Car("woni")
        val jun = Car("jun")
        val cars = listOf<Car>(pobi, woni, jun)
        val leadPositon = 2

        pobi.moveForward()
        pobi.moveForward()
        woni.moveForward()

        RaceDisplay.displayRaceWinners(cars, leadPositon)

        val output = outputStream.toString()
        assertThat(output).contains("Winners : pobi")
        assertThat(output).doesNotContain("Winners : woni")
        assertThat(output).doesNotContain("Winners : jun")
    }

    @Test
    fun `displayRaceWinners should show multiple winners correctly`(){
        val pobi = Car("pobi")
        val woni = Car("woni")
        val jun = Car("jun")
        val cars = listOf<Car>(pobi, woni, jun)
        val leadPositon = 2

        pobi.moveForward()
        pobi.moveForward()
        woni.moveForward()
        woni.moveForward()

        RaceDisplay.displayRaceWinners(cars, leadPositon)

        val output = outputStream.toString()
        assertThat(output).contains("Winners : pobi, woni")
        assertThat(output).doesNotContain("Winners : jun")
    }
}