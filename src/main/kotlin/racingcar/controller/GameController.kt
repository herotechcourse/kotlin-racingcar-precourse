package racingcar.controller

import racingcar.model.Cars
import racingcar.model.Game
import racingcar.service.GameService
import racingcar.view.InputView
import racingcar.view.OutputView

class GameController {
    private val gameService: GameService = GameService()
    private val inputView: InputView = InputView()
    private val outputView: OutputView = OutputView()

    fun run() {
        val cars: Cars = gameService.createCars(inputView.carNamesInput())
        val gameRound: Int = gameService.getGameRoundInput(inputView.gameRoundInput())
        val game = Game(cars, gameRound)

        gameService.playGame(game, outputView)
    }
}
