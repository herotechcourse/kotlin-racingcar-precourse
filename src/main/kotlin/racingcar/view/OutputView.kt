package racingcar.view

import racingcar.controller.response.RaceResultDto
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

    companion object {
        private const val DISTANCE_MARK = "-"
    }
}