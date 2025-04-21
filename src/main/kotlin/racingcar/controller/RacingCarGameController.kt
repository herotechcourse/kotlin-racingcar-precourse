package racingcar.controller

import racingcar.model.RacingCar
import racingcar.model.RacingCars
import racingcar.view.InputView

class RacingCarGameController(
    private val inputView: InputView
) {
    fun run() {
        val carNames = inputView.readCarNames()
        val rounds = inputView.readNumberOfRounds()
        val racingCars = RacingCars.fromNames(carNames)

        val histories = buildHistories(racingCars, rounds)
        val winners = racingCars.findWinners()
    }

    private fun buildHistories(racingCars: RacingCars, rounds: Int): List<List<RacingCar>> {
        val result = mutableListOf<List<RacingCar>>()
        repeat(rounds) {
            racingCars.moveAll()
            result.add(racingCars.all())
        }
        return result
    }
}