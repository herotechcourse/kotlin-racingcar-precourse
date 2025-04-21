package racingcar.controller

import racingcar.model.Race
import racingcar.model.RaceFactory
import racingcar.model.RaceResult
import racingcar.model.RandomPowerGenerator
import racingcar.view.ReadView
import racingcar.view.WriteView

class Controller {

    fun process() {
        val race: Race = readInput()
        val result: RaceResult = race.play(RandomPowerGenerator)
        WriteView.printRaceResult(result)
    }

    private fun readInput(): Race {
        val names: List<String> = ReadView.readCarNames()
        val roundCount: Int = ReadView.readRoundCount()

        return RaceFactory.create(names, roundCount)
    }

}
