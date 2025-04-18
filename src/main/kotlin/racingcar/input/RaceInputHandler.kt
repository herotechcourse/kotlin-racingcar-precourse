package racingcar.input

import racingcar.domain.Car
import racingcar.domain.Race
import racingcar.service.Game

object RaceInputHandler {

    fun createRace (carNamesInput: String, roundsInput: String): Game {
        val carNames = parseCarNames(carNamesInput)
        val rounds = parseRounds(roundsInput)
        val cars = carNames.map { Car(it) }
        val race = Race(cars)
        return Game(race, rounds)
    }

    fun validateCarNames(input: String) {
        parseCarNames(input)
    }


    private fun parseCarNames(input: String): List<String> {
        val names = input.split(",").map { it.trim() }
        if (names.any { it.isEmpty() || it.length > 5 }) {
            throw IllegalArgumentException ("Car names must be 1 to 5 characters long.")
        }
        return names
    }

    private fun parseRounds(input: String): Int {
        return input.toIntOrNull()?.takeIf { it > 0 }
            ?: throw IllegalArgumentException("Number of rounds must be a positive integer.")
    }



}