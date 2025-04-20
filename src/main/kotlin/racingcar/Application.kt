package racingcar
import racingcar.controller.GameController
import racingcar.domain.Cars
import racingcar.service.InputService
import racingcar.service.OutputService


fun main() {
    val inputService = InputService()
    val outputService = OutputService()

    val carNames = inputService.readCarNames()
    val cars = Cars(carNames)
    val roundCount = inputService.readRoundCount()

    val gameController = GameController(cars, roundCount, outputService)
    gameController.startGame()
}