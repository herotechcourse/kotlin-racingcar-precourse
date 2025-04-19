package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.input.RaceInputHandler

fun main() {
    val carNamesInput = readCarNamesInput()
    val roundsInput = readRoundsInput()

    val race = RaceInputHandler.createRace(carNamesInput, roundsInput)
    val raceResult = race.start()

1
    println("=".repeat(30))
    println("      Race Results    ")
    println("=".repeat(30))


    raceResult.printProgress()
    raceResult.printWinners()
}

fun readCarNamesInput(): String {
    print("Enter the names of the cars (comma-separated, each name 1-5 characters): ")
    val input = Console.readLine()
    RaceInputHandler.validateCarNames(input)
    return input
}

fun readRoundsInput(): String {
    print("How many rounds will be played? ")
    return Console.readLine()
}
