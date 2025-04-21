package racingcar.service

import racingcar.controller.response.RaceResultDto
import racingcar.controller.response.WinnersDto
import racingcar.domain.Cars
import racingcar.domain.dto.RoundResultDto

class GameService {
    fun raceAll(round: Int, cars: Cars): RaceResultDto {
        val allRoundResults = mutableListOf<RoundResultDto>()
        for (i in 1..round) allRoundResults.add(cars.moveAll())

        return RaceResultDto(allRoundResults)
    }

    fun findWinners(cars: Cars): WinnersDto {
        val maxDistance = cars.findMaxDistance()
        val winners = cars.findCarsWithMaxDistance(maxDistance)

        return WinnersDto(winners)
    }
}