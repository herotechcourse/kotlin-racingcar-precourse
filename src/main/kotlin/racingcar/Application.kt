package racingcar

import camp.nextstep.edu.missionutils.Console


class Application {
    fun main() {
        println("Enter the names of the cars (comma-separated):")
        val carNames = parseCarNamesInput(Console.readLine())
        val cars = carNames.map { Car(it) }

        println("How many rounds will be played?")
        val rounds = Console.readLine().toInt()

        // mock the winner
        // Replace this with actual race logic
        repeat(rounds) {
            val winner = cars.first() 
            winner.roundPoints += 1
        }
        val winners = listOf(cars.first())

        printRaceResults(cars)
        printRaceWinners(winners)
    }

    private fun parseCarNamesInput(input: String): List<String> {
        if (!input.contains(",")) {
            throw IllegalArgumentException("Car names should be comma-separated.")
        }
        val carNames = input.split(",").map { it.trim() }
        return carNames
    }

    private fun printRaceResults(results: List<Car>) {
        println("Race Results")
        results.forEach { println("${it.name} : ${"-".repeat(it.roundPoints)}") }
    }

    private fun printRaceWinners(winners: List<Car>) {
        println("Winners : ${winners.joinToString(", ") { it.name }}")
    }
}

fun main() {
    val game = Application()
    game.main()
}
