package racingcar


import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun readCarNames(): List<String> {
    print("Enter names of cars (max 5 chars):e.g mike,mary,mo")
    val input = Console.readLine()
    if (input.isNullOrBlank()) {
        throw IllegalArgumentException("Input is Empty")
    }
    val names = input.split(",").map { it.trim() }
    names.forEach { name ->
        if (name.length !in 1..5) {
            throw IllegalArgumentException("Name must be between 1 and 5")
        }
    }
    return names
}

fun readRounds(): Int {
    print("Enter number of rounds to race:")
    val roundsInput = Console.readLine()
    val rounds = roundsInput?.toInt() ?: throw IllegalArgumentException("Input is not a valid number.")
    if (rounds <= 0) {
        throw IllegalArgumentException("Rounds must be a positive number.")
    }
    return rounds
}

fun main() {
    val names = readCarNames()
    val rounds = readRounds()

    names.forEach { name ->
        println(name)
    }
    println(rounds)
}