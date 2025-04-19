package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    val names = getValidNames()
    val rounds = getValidRounds()
    val scores = runRace(names, rounds)
    printWinners(names, scores)
}

fun getValidNames(): List<String> {
    println("Enter the names of the cars (comma-separated):")
    val input = Console.readLine()
    val names = input.split(",")

    if (names.isEmpty()) {
        throw IllegalArgumentException("You must enter at least one name.")
    }

    val uniqueNames = mutableListOf<String>()

    for (name in names) {
        if (name.isEmpty()) {
            throw IllegalArgumentException("Names cannot be empty.")
        }
        if (name.length > 5) {
            throw IllegalArgumentException("The name '$name' is too long.")
        }
        if (name in uniqueNames) {
            throw IllegalArgumentException("The name '$name' is repeated.")
        }
        uniqueNames.add(name)
    }
    return uniqueNames
}

fun getValidRounds(): Int {
    println("How many rounds will be played?")
    val input = Console.readLine()

    if (input.isBlank()) {
        throw IllegalArgumentException("Number of rounds cannot be empty.")
    }

    if (!input.all { it.isDigit() }) {
        throw IllegalArgumentException("Number of rounds must be a number.")
    }

    val rounds = input.toInt()
    if (rounds <= 0) {
        throw IllegalArgumentException("Number of rounds must be greater than zero.")
    }
    return rounds
}

fun runRace(names: List<String>, rounds: Int): MutableList<Int> {
    val scores = MutableList(names.size) { 0 }

    println("\nRace Results")

    for (round in 1..rounds) {
        println()
        for (i in names.indices) {
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            if (randomNumber >= 4) {
                scores[i] += 1
            }
            val progress = "-".repeat(scores[i])
            println("${names[i]} : $progress")
        }
    }
    return scores
}

fun printWinners(names: List<String>, scores: List<Int>) {
    val maxScore = scores.maxOrNull() ?: 0
    val winners = mutableListOf<String>()

    for (i in scores.indices) {
        if (scores[i] == maxScore) {
            winners.add(names[i])
        }
    }

    println("\nWinners : ${winners.joinToString(", ")}")
}
