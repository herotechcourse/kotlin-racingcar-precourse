package racingcar.service

import racingcar.domain.Cars
import racingcar.view.OutputRaceProgress
import racingcar.view.OutputResult

class OutputService {
    fun showRaceProgress(cars: Cars) {
        OutputRaceProgress.showRace(cars)
    }

    fun showResult(cars: Cars) {
        OutputResult.showResult(cars)
    }
}