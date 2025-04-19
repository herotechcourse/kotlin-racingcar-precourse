package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun readCarNames(): List<String> {
    println("Enter the names of the cars (comma-separated):")
    val input = Console.readLine()
    val names = input.split(",")
    val isInvalid = names.any { it.isBlank() || it.length > 5 }

    if (isInvalid) {
        throw IllegalArgumentException("Each car name must be 1–5 characters long.")
    }
    if (names.size < 2) {
        throw IllegalArgumentException("Number of cars must be more than 1")
    }
    return names
}

fun readRound(): Int {
    println("How many rounds will be played?")
    val input = Console.readLine()
    val round: Int
    try {
        round = input.toInt()
    } catch (_: NumberFormatException) {
        throw IllegalArgumentException("Round must be an integer.")
    }

    if (round <= 0) {
        throw IllegalArgumentException("Round must be positive.")
    }
    return round
}

fun printResult(names: List<String>, round: Int): MutableList<Int> {
    val winTimes = MutableList(names.size) { 0 }
    repeat(round) {
        for ((i, name) in names.withIndex()) {
            if (racingResult()) {
                winTimes[i] += 1
            }

            print("$name : ")
            repeat(winTimes[i]) { print("-") }
            println()
        }
        println()
    }
    return winTimes
}

fun racingResult(): Boolean {
    val number = Randoms.pickNumberInRange(0, 9)
    return number >= 4
}

fun findWinner(winTimes: MutableList<Int>, names: List<String>): List<String> {
    // do the comparison of each car winTimes to get who is the winner
    // save the name of the winner in a list for later printing
    val maxScore = winTimes.maxOrNull() ?: 0
    return names.filterIndexed { index, _ -> winTimes[index] == maxScore }
}

fun printWinner(winners: List<String>){
    // print the Winners list
    println("Winners : ${winners.joinToString(", ")}")
}

fun main() {
    val carNames = readCarNames()
    val round = readRound()
    println()
    println("Race Results")
    val winTimes = printResult(carNames, round)
    val winners = findWinner(winTimes, carNames)
    printWinner(winners)
}
