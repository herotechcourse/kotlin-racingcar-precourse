package racingcar

import camp.nextstep.edu.missionutils.Console


fun getValidCarNames(): List<String> {
    while (true) {
        println("Enter the names of the cars (comma-separated):")
        val carNamesInput = Console.readLine().trim()

        if(carNamesInput.isBlank()) {
            throw IllegalArgumentException("You didn't type anything.")
        }

        val carNames = carNamesInput.split(",").map { it.trim() }

        if (carNames.any { it.isBlank() }) {
            throw IllegalArgumentException("Each car must have a name — no blanks allowed between commas.")
        }

        val invalidNames = carNames.filter { it.length > 5 }
        if (carNames.any { it.length > 5 }) {
            throw IllegalArgumentException("Car names must be 1–5 characters long. Problem with: ${invalidNames.joinToString()}")
        }

        return carNames

    }

}

fun getValidRoundCount(): Int {
    while (true) {
        println("How many rounds will be played?")
        val roundInput = Console.readLine().trim()
        val roundCount = roundInput.toIntOrNull()

        if (roundInput.isBlank()) {
            throw IllegalArgumentException("You didn't type anything. Please enter a positive integer")
        } else if (roundCount == null) {
            throw IllegalArgumentException("Only number is allowed. Please enter a positive integer")
        } else if (roundCount <= 0) {
            throw IllegalArgumentException("Number of rounds must be a positive integer.")
        } else {
            return roundCount
        }
    }

}

fun main() {
    val carNames = getValidCarNames()
    val roundCount = getValidRoundCount()

    println("Car Names: ${carNames.joinToString(", ")}")
    println("Racing Round: $roundCount Round")
}
