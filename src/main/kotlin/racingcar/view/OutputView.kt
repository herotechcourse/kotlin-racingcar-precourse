package racingcar.view

import racingcar.domain.RaceResults
import racingcar.domain.RoundResult

class OutputView {
    fun printRaceResults(raceResults: RaceResults) {
        println("\nRace Results")
        for (roundResult in raceResults.roundResults) {
            printRoundResult(roundResult)
        }
        printWinners(raceResults)
    }

    private fun printRoundResult(roundResult: RoundResult) {
        for (carStatus in roundResult.carStatuses) {
            print(carStatus.name.value + " : ")
            println("-".repeat(carStatus.position.value))
        }
        println()
    }

    private fun printWinners(raceResults: RaceResults) {
        val winners = raceResults.winners.joinToString(", ") { it.name.value }
        println("Winners : $winners")
    }
}
