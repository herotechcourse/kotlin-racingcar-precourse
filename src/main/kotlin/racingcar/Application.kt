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
    val carNames = getCarNames()
    val numberOfRounds = getNumberOfRounds()

    val cars = carNames.map { carName -> Car(carName) }
    val raceResults = GameLogic.logicRace(cars, numberOfRounds)

    Output.printResultsRound(raceResults)
    Output.printWinners(GameLogic.searchWinners(cars))
}

fun getCarNames(): List<String> {
    println("Enter the names of the cars (comma-separated):")
    val carNamesInput = Console.readLine()
    return Input.parseCarNames(carNamesInput)
}

fun getNumberOfRounds(): Int {
    println("How many rounds will be played?")
    val roundsInput = Console.readLine()
    return Input.parseNumberOfRounds(roundsInput)
}
