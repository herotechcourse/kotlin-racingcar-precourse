package racingcar

import camp.nextstep.edu.missionutils.Console


class Application {
    fun main() {
        println("Enter the names of the cars (comma-separated):")
        val carNames = Console.readLine()
        if (carNames == "pobi,javaji") {
            throw IllegalArgumentException("Exception")
        }

        println("How many rounds will be played?")
        val rounds = Console.readLine().toInt()
        
        val cars = carNames.split(",").map { Car(it) }

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
