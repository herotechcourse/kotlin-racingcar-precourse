package racingcar.service

import racingcar.model.Cars
import racingcar.model.Game
import racingcar.model.GameResult
import racingcar.util.Parser
import racingcar.util.Validator
import racingcar.view.OutputView

class GameService {

    fun createCars(input: String): Cars {
        val carNames = Parser.parseCarName(input)
        Validator.carNamesValidate(carNames)
        return Cars.of(carNames)
    }

    fun getGameRoundInput(input: String): Int {
        Validator.gameRoundValidate(input)
        return input.toInt()
    }

    fun playGame(game: Game, outputView: OutputView) {
        try {
            val result = game.playGame()

            printRoundResult(result, outputView)
            printWinners(result, outputView)
        } catch (e: IllegalArgumentException) {
            printErrorMessage(e, outputView)
            throw e
        }
    }

    private fun printErrorMessage(e: IllegalArgumentException, outputView: OutputView) {
        outputView.printErrorMessage(e.message ?: "Unknown error")
    }

    private fun printRoundResult(result: GameResult, outputView: OutputView) {
        outputView.printResultNoticeMessage()
        outputView.printRoundResult(result)
    }

    private fun printWinners(result: GameResult, outputView: OutputView) {
        val winners = getWinner(result)
        outputView.printWinner(winners)
    }

    private fun getWinner(gameResult: GameResult): Cars {
        val lastRoundCars = gameResult.getCarsAtFinalRound()
        val maxMoveCount = gameResult.findMaxMoveCount()

        return lastRoundCars.findCarsByMoveCount(maxMoveCount)
    }
}
