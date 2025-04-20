package racingcar


import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    val carNames = readCarNames()
    val rounds = readNumberOfRounds()
    val cars = carNames.map { Car(it) }
    val game = Game(cars, rounds)
    game.start()
}

fun readCarNames(): List<String> {
    println("Enter the names of the cars (comma-separated, max 5 characters):")
    val input = Console.readLine()
    return input.split(",").map { it.trim() }.also { names ->
        require(names.all { it.isNotBlank() && it.length <= 5 }) {
            "All car names must be non-empty and at most 5 characters long."
        }
    }
}

fun readNumberOfRounds(): Int {
    println("Enter the number of rounds:")
    val input = Console.readLine()
    return input.toIntOrNull()?.also {
        require(it > 0) { "The number of rounds must be greater than zero." }
    } ?: throw IllegalArgumentException("Invalid input: not a number.")
}



