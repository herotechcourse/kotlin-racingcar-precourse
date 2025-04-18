package racingcar

import racingcar.backend.controller.RacingController
import racingcar.backend.dto.CarNameRequest
import racingcar.backend.service.RacingService
import racingcar.frontend.InputView
import racingcar.frontend.OutputView

fun main() {
    val racingService = RacingService()
    val racingController = RacingController(racingService)

    OutputView.printCarNamesRequest()
    val carNames = InputView.getCarNames()

    val carNameRequest = CarNameRequest(carNames = carNames)
    val carList = racingController.inputCarNames(carNameRequest)
}
