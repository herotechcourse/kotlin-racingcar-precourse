package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val carNames = Console.readLine()
    val validCarNames = validateCarNames(carNames)

    println("How many rounds will be played?")
    val numberOfRounds = Console.readLine()
    val validNumberOfRounds = validateNumberOfRounds(numberOfRounds)

    println("\nRace Results")
    val carPositions = executeCarRace(validCarNames, validNumberOfRounds)

    val winners = determineWinners(validCarNames, carPositions)
    println("Winners : ${winners.joinToString(", ")}")

}