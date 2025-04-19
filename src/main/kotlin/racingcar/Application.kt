package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val game = RacingGame()
    game.play()
}

class RacingGame {
    companion object {
        private const val MAX_NAME_LENGTH = 5
        private const val MOVE_FORWARD = 4
    }

    fun play() {
        val cars = inputCars()
        val rounds = inputRounds()
        val positions = race(cars, rounds)
        printWinners(cars, positions)
    }

    private fun inputCars(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        val carNames = input.split(",").map { it.trim() }
        validateCarNames(carNames)
        return carNames
    }

    private fun validateCarNames(carNames: List<String>) {
        if (carNames.isEmpty()) {
            throw IllegalArgumentException("Car names cannot be empty.")
        }
        carNames.forEach { name ->
            if (name.isEmpty()) {
                throw IllegalArgumentException("Car name cannot be empty.")
            }
            if (name.length > MAX_NAME_LENGTH) {
                throw IllegalArgumentException("Car name cannot exceed $MAX_NAME_LENGTH characters.")
            }
        }
    }

    private fun inputRounds(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()
        try {
            val rounds = input.toInt()
            if (rounds <= 0) {
                throw IllegalArgumentException("Number of rounds must be a positive integer.")
            }
            return rounds
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Invalid input. Please enter a positive integer.")
        }
    }

    private fun race(cars: List<String>, rounds: Int): List<Int> {
        val positions = MutableList(cars.size) { 0 }
        println("\nRace Results")

        for (round in 1..rounds) {
            moveAllCars(positions)
            printRoundResult(cars, positions)
            if (round < rounds) {
                println()
            }
        }
        return positions
    }

    private fun moveAllCars(positions: MutableList<Int>) {
        for (i in positions.indices) {
            if (Randoms.pickNumberInRange(0, 9) >= MOVE_FORWARD) {
                positions[i]++
            }
        }
    }

    private fun printRoundResult(cars: List<String>, positions: List<Int>) {
        for (i in cars.indices) {
            val car = cars[i]
            val result = "-".repeat(positions[i])
            println("$car : $result")
        }
    }

    private fun printWinners(cars: List<String>, positions: List<Int>) {
        val maxPosition = positions.maxOrNull() ?: return
        val winners = cars.filterIndexed { index, _ -> positions[index] == maxPosition }
        println("\nWinners : ${winners.joinToString(", ")}")
    }
}
