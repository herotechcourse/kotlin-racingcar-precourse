package racingcar.service

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import racingcar.domain.Car
import racingcar.domain.Race


class GameTest {

    @Test
    fun `start repeats rounds and prints progress`() {
        val cars = listOf(Car("a") { 4 }, Car("b") { 4 })
        val race = Race(cars)
        val game = Game(race, 3)

        game.start()
        assertThat(cars.all { it.getPosition() == 3 }).isTrue()
    }

    @Test
    fun `printWinners prints correct output`() {
        val cars = listOf(Car("z") { 4 })
        val race = Race(cars)
        val game = Game(race, 1)

        game.start()

        val output = java.io.ByteArrayOutputStream().also {
         System.setOut(java.io.PrintStream(it))}

        game.printWinners()

        val printed = output.toString().trim()
        assertThat(printed).isEqualTo("Winners : z")
    }
}