package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    try {
        runRace()
    } catch (e: IllegalArgumentException) {
        throw e
    }
}

fun runRace() {
    println("Enter the names of the cars (comma-separated):")
    val carNamesInput = Console.readLine()
    val carNames = Input.parseCarNames(carNamesInput)

    val cars = carNames.map { carName -> Car(carName) }

    println("How many rounds will be played?")
    val roundsInput = Console.readLine()
    val numberOfRounds = Input.parseNumberOfRounds(roundsInput)

    val raceResults = GameLogic.logicRace(cars, numberOfRounds)

    Output.printResultsRound(raceResults)

    val winners = GameLogic.searchWinners(cars)

    Output.printWinners(winners)
}
