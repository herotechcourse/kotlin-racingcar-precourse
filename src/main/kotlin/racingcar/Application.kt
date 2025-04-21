package racingcar

import racingcar.controller.GameController
import racingcar.service.GameService
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val gameService = GameService()
    val racingGame = GameController(inputView, outputView, gameService)
    racingGame.run()
}
