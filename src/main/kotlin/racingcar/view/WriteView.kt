package racingcar.view

import racingcar.model.LapReport
import racingcar.model.Name
import racingcar.model.RaceResult

object WriteView {

    fun printRaceResult(result: RaceResult) {
        println()
        println("Race Results")
        result.raceLog.forEach { printLap(it) }
        printWinners(result.winners)
    }

    private fun printLap(lap: LapReport) {
        lap.statuses.forEach { status ->
            println("${status.name.name} : ${"-".repeat(status.position.value)}")
        }
        println()
    }

    private fun printWinners(winners: List<Name>) {
        val names = winners.joinToString(", ") { it.name }
        println("Winners : $names")
    }
}
