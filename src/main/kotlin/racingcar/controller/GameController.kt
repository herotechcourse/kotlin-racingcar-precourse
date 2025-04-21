package racingcar.controller

import racingcar.controller.response.RaceResultDto
import racingcar.controller.response.WinnersDto
import racingcar.domain.Cars
import racingcar.service.GameService
import racingcar.view.InputView
import racingcar.view.OutputView

class GameController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val racingService: GameService
) {
    fun run() {
        val cars: Cars = Cars.from(inputView.askCarNames())
        val round: Int = inputView.askRounds()
        playRace(round, cars)
        printWinners(cars)
    }

    private fun playRace(round: Int, cars: Cars) {
        val raceResult: RaceResultDto = racingService.raceAll(round, cars)
        outputView.printRaceResult(raceResult)
    }

    private fun printWinners(cars: Cars) {
        val winners: WinnersDto = racingService.findWinners(cars)
        outputView.printRaceWinners(winners)
    }
}