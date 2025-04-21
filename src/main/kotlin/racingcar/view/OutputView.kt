package racingcar.view

import racingcar.controller.response.RaceResultDto
import racingcar.controller.response.WinnersDto
import racingcar.domain.dto.RoundResultDto

class OutputView {
    fun printRaceResult(raceResult: RaceResultDto) {
        raceResult.roundResults.forEach { eachRoundRacingResultDto ->
            printRoundResult(eachRoundRacingResultDto)
        }
    }

    private fun printRoundResult(roundResult: RoundResultDto) {
        roundResult.carResults.forEach { carRacingResult ->
            println("${carRacingResult.name} : ${DISTANCE_MARK.repeat(carRacingResult.distance)}")
        }
        println()
    }

    fun printRaceWinners(raceWinners: WinnersDto) {
        val winnerNames = raceWinners.winners.joinToString(JOIN_MARK) { it.name }
        println("$WINNER_ARE$winnerNames")
    }

    companion object {
        private const val DISTANCE_MARK = "-"
        private const val WINNER_ARE = "Winners : "
        private const val JOIN_MARK = ", "
    }
}