package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: Implement the program
    println("Names of the cars (comma-separated): ")
    val carNamesInput = Console.readLine() ?: ""
    println("Number of rounds:")
    val numberOfRounds = Console.readLine()?.toIntOrNull() ?: 0

    val carNames = carNamesInput.split(",").map { it.trim() }
    CarRace().raceCarsAndPrintResults(carNames, numberOfRounds)
}