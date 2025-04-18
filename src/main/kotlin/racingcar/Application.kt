package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.input.RaceInputHandler

fun main() {

    print(" Enter the names of the cars (comma-separated):")
    val carNamesInput = Console.readLine()

    print (" How many rounds will be played?")
    val roundsInput = Console.readLine()

    val race = RaceInputHandler.createRace(carNamesInput, roundsInput)
    val raceResult = race.start()

    println("\nRace Results")
    raceResult.printProgress()
    raceResult.printWinners()

}