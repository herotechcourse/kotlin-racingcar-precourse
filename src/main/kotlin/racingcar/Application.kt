package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.input.RaceInputHandler

fun main() {
    val carNamesInput = readCarNamesInput()
    val roundsInput = readRoundsInput()

    val race = RaceInputHandler.createRace(carNamesInput, roundsInput)
    val raceResult = race.start()

    println("\nRace Results")
    raceResult.printProgress()
    raceResult.printWinners()
}

fun readCarNamesInput(): String {
    print("Enter the names of the cars (comma-separated): ")
    val input = Console.readLine()
    RaceInputHandler.validateCarNames(input)
    return input
}

fun readRoundsInput(): String {
    print("How many rounds will be played? ")
    return Console.readLine()
}
