package racingcar

import racingcar.backend.controller.RacingController
import racingcar.backend.dto.CarNameRequest
import racingcar.backend.dto.RaceRequest
import racingcar.backend.dto.RoundRequest
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

    OutputView.printRaceCountRequest()
    val round = InputView.getRoundCount()

    val roundRequest = RoundRequest(round = round)
    val roundCount = racingController.convertRoundToNum(roundRequest)

    val raceRequest = RaceRequest(carList = carList, roundCount = roundCount)
    val raceResult = racingController.outputRaceResults(raceRequest)

    OutputView.printRaceResultResponse(raceResult)
}
