package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val carNames = Console.readLine().split(",")
    for (car in carNames) {
        validateNameLength(car)
        validateEmptyName(car)
    }

    println("How many rounds will be played?")
    val rounds = Console.readLine()?.toIntOrNull()
        ?: throw IllegalArgumentException("The number of rounds should be a valid number.")
    validateRounds(rounds)

    val cars = carNames.map { name -> Car(name) }

    println()
    println("Race results")
    repeat(rounds) {
        for (car in cars) {
            car.move()
            println("${car.name}: ${car.distance}")

        }
        println()
    }

    println("Winners: ${findWinners(cars).joinToString(", ") { it.name }}")
}
