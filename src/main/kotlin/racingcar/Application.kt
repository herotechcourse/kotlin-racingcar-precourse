package racingcar

import racingcar.io.Input
import racingcar.io.Output

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val nameInput: String = Input().input()
    val names: List<String> = Input().getNames(nameInput)

    println("How many rounds will be played?")
    val roundInput: String = Input().input()
    val round: Int = Input().getRound(roundInput)

    val (raceResultMap, winners) = RacingService(names, round).play()
    val output = Output()
    output.displayRaceResults(raceResultMap)
    output.displayWinners(winners)
}
