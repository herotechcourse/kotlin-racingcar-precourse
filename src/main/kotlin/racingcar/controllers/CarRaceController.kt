package racingcar.controllers

import camp.nextstep.edu.missionutils.Console
import racingcar.service.CarRaceService

class CarRaceController {

    private val carRaceService = CarRaceService()
    fun startCarRace() {

        val carNames = readCarNames()
        val roundCount = readRoundCount()
        carRaceService.runCarRace(carNames, roundCount)

    }

    private fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        val names = input.split(",").map { it.trim() }

        if (names.any { it.isEmpty() || it.length > 5 }) {
            throw IllegalArgumentException("Each car name must be 1–5 characters.")
        }

        return names
    }

    private fun readRoundCount(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()
        return input.toIntOrNull()?.takeIf { it > 0 }
            ?: throw IllegalArgumentException("Round count must be a positive number.")
    }
}
