package racingcar

import camp.nextstep.edu.missionutils.Console

object GameController {

    fun run() {
        val cars = readCarNames()
        val rounds = readRounds()
        val game = RacingGame(cars, rounds)

        game.startRace()

        val winners = game.getWinners()
        println("Winners : ${winners.joinToString(", ") { it.name }}")
    }

    private fun readCarNames(): List<Car> {
        println("Enter car names (comma-separated, max 5 characters each):")
        val input = Console.readLine()
        val names = input.split(",").map { it.trim() }

        if (names.isEmpty() || names.any { it.isBlank() || it.length > 5 }) {
            throw IllegalArgumentException("Invalid car names.")
        }

        return names.map { Car(it) }
    }

    private fun readRounds(): Int {
        println("Enter number of rounds:")
        val input = Console.readLine()
        return input.toIntOrNull()?.takeIf { it > 0 }
                ?: throw IllegalArgumentException("Invalid number of rounds.")
    }
}
