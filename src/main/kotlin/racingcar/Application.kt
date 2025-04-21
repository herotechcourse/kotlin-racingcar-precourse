package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val carNames = Console.readLine().split(",").map { it.trim() }
    validateDuplicates(carNames)
    for (name in carNames) {
        validateNameLength(name)
        validateEmptyName(name)
        validateAllowedCharacters(name)
    }

    println("How many rounds will be played?")
    val rounds = Console.readLine()?.toIntOrNull()
        ?: throw IllegalArgumentException("The number of rounds should be a valid number.")
    validateRounds(rounds)

    val cars = carNames.map { name -> Car(name) }

    println("\nRace results")
    repeat(rounds) {
        for (car in cars) {
            car.move()
            println("${car.name} : ${car.distance}")

        }
        println()
    }

    println("Winners : ${findWinners(cars).joinToString(", ") { it.name }}")
}
