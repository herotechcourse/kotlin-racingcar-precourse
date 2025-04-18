package racingcar.backend.controller

import racingcar.backend.dto.*
import racingcar.backend.service.RacingService

class RacingController(
    private val racingService: RacingService
) {
    fun inputCarNames(carNameRequest: CarNameRequest): List<CarDto> {
        return racingService.inputCarNames(carNameRequest)
    }

    fun convertRoundToNum(roundRequest: RoundRequest) : Int{
        return racingService.convertRoundToNum(roundRequest)
    }

    fun outputRaceResults(raceRequest: RaceRequest) : RaceResponse {
        return racingService.outputRaceResults(raceRequest)
    }
}