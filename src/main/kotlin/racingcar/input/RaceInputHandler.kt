package racingcar.input

import racingcar.domain.Car
import racingcar.domain.Race
import racingcar.service.Game

object RaceInputHandler {

    fun createRace (carNamesInput: String, roundsInput: String): Game {
        val carNames = parseCarNames(carNamesInput)
        val rounds = parseRounds(roundsInput)
        val cars = carNames.map { Car(it) }
        return Game(Race(cars), rounds)
    }

    fun validateCarNames(input: String) {
       val names = parseCarNames(input)

        if (names.size < 2) {
            throw IllegalArgumentException(
                "At least two cars are required - what a race if you're racing alone? :)"
            )
        }

        if (names.distinct().size != names.size) {
            throw IllegalArgumentException(
                "Identity crisis on the track: every car needs its own name. :)"
            )
        }
        names.forEach { Car(it)}
    }


    internal fun parseCarNames(input: String): List<String>  =
         input.split(",").map { it.trim() }


    private fun parseRounds(input: String): Int {
        return input.toIntOrNull()?.takeIf { it > 0 }
            ?: throw IllegalArgumentException("Number of rounds must be a positive integer.")
    }
}