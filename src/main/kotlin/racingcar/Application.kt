package racingcar

import camp.nextstep.edu.missionutils.Console

private const val MAX_NAME_LENGTH = 5

fun main() {
    try {
        val carNames = readCarNames()
        val rounds = readRounds()

        // TODO: feature/car-model
        // TODO: feature/race-loop
        // TODO: feature/winner-determination
    } catch (e: IllegalArgumentException) {
        println(e.message)
        return
    }
}

fun readCarNames(): List<String> {
    println("Enter the names of the cars (comma-separated):")
    val inputLine = Console.readLine().orEmpty().trim()
    require(inputLine.isNotEmpty()) {
        "Car names cannot be blank."
    }

    return inputLine
        .split(',')
        .map { it.trim() }
        .also { names ->
            require(names.isNotEmpty()) {
                "At least one car name is required."
            }
        }
        .onEach { name ->
            require(name.isNotEmpty()) {
                "Car names must not be empty."
            }
            require(name.length <= MAX_NAME_LENGTH) {
                "Car name '$name' exceeds maximum length of $MAX_NAME_LENGTH characters."
            }
        }
}

fun readRounds(): Int {
    println("Enter the number of rounds:")
    val inputLine = Console.readLine().orEmpty().trim()
    val rounds = inputLine.toIntOrNull()
        ?: throw IllegalArgumentException("Rounds must be a number.")
    require(rounds > 0) {
        "Number of rounds must be greater than zero."
    }
    return rounds
}
