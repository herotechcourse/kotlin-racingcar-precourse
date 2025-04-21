package racingcar.domain

import racingcar.domain.race.RaceResult

class Referee(private val raceResult: RaceResult) {

    fun determineWinner(): List<String> {
        return raceResult.findCarsAtMaxPosition()
            .map { it.getName() }
    }
}
