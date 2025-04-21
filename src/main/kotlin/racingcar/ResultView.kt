package racingcar

// ResultView - handles all game output formatting and display
object ResultView {

    // Print the current round and each car's position visually
    fun printRound(cars: List<Car>, round: Int = 1) {

        // Add a blank line before the round display for better visibility
        println()

        // Print round number
        println("Round $round")

        // Print each car's name and its position using '-' symbol
        cars.forEach { println("${it.name} : ${"-".repeat(it.position)}") }

    }

    // Print the final winner(s) of the race
    fun printWinners(winners: List<String>) {

        // Add a blank line before the winners display for better visibility
        println()

        // Display winner(s) as a comma-seperated string
        println("Winners : ${winners.joinToString(", ")}")
    }
}