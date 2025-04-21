package racingcar

import camp.nextstep.edu.missionutils.Console


fun getValidName(): List<String> {
    while (true) {
        println("Enter the names of the cars (comma-separated):")
        val carNamesInput = Console.readLine().trim()

        if(carNamesInput.isBlank()) {
            throw IllegalArgumentException("You didn't type anything!")
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

fun main() {
    val carNames = getValidName()

    println("How many rounds will be played?")
    val roundInput = Console.readLine()

    println("Car Names: ${carNames.joinToString(", ")}")
    println("Racing Round: $roundInput Round")
}
