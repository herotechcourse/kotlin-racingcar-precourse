package racingcar.controller

import racingcar.model.RacingCar
import racingcar.model.RacingCars
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarGameController(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun run() {
        val carNames = inputView.readCarNames()
        val rounds = inputView.readNumberOfRounds()
        val racingCars = RacingCars.fromNames(carNames)

        val histories = buildHistories(racingCars, rounds)
        val winners = racingCars.findWinners()

        outputView.printRaceResult(histories, winners)
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