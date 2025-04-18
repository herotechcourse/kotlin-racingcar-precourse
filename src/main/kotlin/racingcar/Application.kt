package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("Enter the names of the cars (comma separated):")
    val carNamesInput = Console.readLine()
    val carNames = carNamesInput
        .split(",")
        .map { it.trim() }
    validateCarNames(carNames)
    println("How many rounds will be played?")
    val numOfRoundsInput = Console.readLine()
    val numOfRounds = numOfRoundsInput.toInt()
    validateRounds(numOfRounds)
    runRace(carNames, numOfRounds)
}

fun runRace(carNames: List<String>, numOfRounds: Int) {
    val distanceScores: MutableMap<String, Int> = carNames
        .associateWith { 0 }
        .toMutableMap()
    announceRace(carNames, numOfRounds)
    repeat(numOfRounds) {
        val movementThreshold = 4
        continueAnotherRound(distanceScores, movementThreshold)
    }
    announceWinner(distanceScores)
}

fun continueAnotherRound(distanceScores: MutableMap<String, Int>, movementThreshold: Int) {
    for ((name, score) in distanceScores) {
        val movementScore = Randoms.pickNumberInRange(0, 9)
        if (movementScore >= movementThreshold) distanceScores[name] = score + 1
    }
    printCurrentResults(distanceScores)
}

fun printCurrentResults(distanceScores: Map<String, Int>) {
    println("Race % Results")
    for ((carName, distance) in distanceScores) {
        val distanceString = "-".repeat(distance)
        println("$carName : $distanceString")
    }
    println()
}

fun validateCarNames(carNames: List<String>) {
    for (car in carNames) {
        if (car.isEmpty() || car.length > 5) {
            throw IllegalArgumentException("Car name must be 1-4 characters long")
        }
    }
}

fun validateRounds(numOfRounds: Int) {
    if (numOfRounds < 1) {
        throw IllegalArgumentException("Race rounds must be at least 1")
    }
}

fun announceRace(carNames: List<String>, numOfRounds: Int) {
    println("PREPARING ANOTHER EPIC CAR RACE")
    println("THE RACE WILL TAKE")
    println("=> $numOfRounds ROUND(S)")
    println("TODAY'S CARS ARE")
    println(carNames.joinToString(separator = "\n") { "=> $it" })
    println("GET READY!!\nAND..\nGOOO##")
}

fun announceWinner(distanceScores: Map<String, Int>) {
    if (distanceScores.isEmpty()) {
        println("No scores provided — cannot determine winner.")
        return
    }

    val maxScore = distanceScores.values.maxOrNull() ?: return
    val winners = distanceScores.filterValues { it == maxScore }.keys
    println("Winners : ${winners.joinToString(", ")}")
}
