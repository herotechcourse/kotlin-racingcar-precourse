package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    /**
     * Collect input from the user, remove spaces, run required validations.
     */
    println("Enter the names of the cars (comma-separated):")
    val carNames = Console.readLine().split(",").map { it.trim() }
    validateDuplicates(carNames)
    for (name in carNames) {
        validateNameLength(name)
        validateEmptyName(name)
        validateAllowedCharacters(name)
    }

    /**
     * Collect input from the user, throw immediately if input is not an integer number, run required validations
     */
    println("How many rounds will be played?")
    val rounds = Console.readLine()?.toIntOrNull()
        ?: throw IllegalArgumentException("The number of rounds should be a valid number.")
    validateRounds(rounds)

    /**
     * Create list of cars based on user's input.
     */
    val cars = carNames.map { name -> Car(name) }

    /**
     * Move cars n times where n is user's input of rounds.
     */
    println("\nRace results")
    repeat(rounds) {
        for (car in cars) {
            car.move()
            println("${car.name} : ${car.distance}")

        }
        println()
    }

    /**
     * Find the winner or winners and print the result to the console.
     */
    println("Winners : ${findWinners(cars).joinToString(", ") { it.name }}")
}
