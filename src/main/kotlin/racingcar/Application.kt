package racingcar
import racingcar.controller.GameController
import racingcar.domain.Cars
import racingcar.view.InputCarNames
import racingcar.view.InputRoundCount


fun main() {
    val carNames = InputCarNames.invoke()
    val cars = Cars.from(carNames)
    val roundCount = InputRoundCount.invoke()

    val gameController = GameController(cars, roundCount)
    gameController.startGame()
}