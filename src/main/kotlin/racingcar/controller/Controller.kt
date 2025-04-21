package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Cars
import racingcar.model.Racing
import racingcar.model.RacingResult
import racingcar.model.RandomIntGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

class Controller(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    private lateinit var cars: Cars
    private lateinit var racing: Racing

    fun run() {
        try {
            val carNames = inputView.getInputCarNames()
            val tryCount = inputView.getInputTryCount()

            initializeCars(carNames)
            initializeRacing(tryCount)
            outputView.printRacingStart()

            runRacingStages()
            concludeRacing()
        } finally {
            Console.close()
        }
    }

    private fun initializeCars(carNames: List<String>) {
        cars = Cars(carNames, RandomIntGenerator())
    }

    private fun initializeRacing(tryCount: Int) {
        racing = Racing()
        racing.saveTryCount(tryCount)
    }

    private fun runRacingStages() {
        while (racing.isProgress) {
            cars.requestCarMove()
            racing.minusTryCount()
            outputView.printStageResult(cars)
        }
    }

    private fun concludeRacing() {
        val racingResult = RacingResult()
        val winnersName = racingResult.getWinnerNames(cars)
        outputView.printWinners(winnersName)
    }
}
