package racingcar.controller

import racingcar.domain.RacingGame
import racingcar.view.InputView
import racingcar.view.ResultView
import camp.nextstep.edu.missionutils.Randoms

class RacingGameController(
    private val inputView: InputView,
    private val resultView: ResultView
) {

    fun race(){
        //input values
        val carNames = inputView.inputCarNames()
        val roundCount = inputView.inputRoundCount()

        val racingGame = RacingGame(carNames)

        //repeat based on round count
        repeat(roundCount) {
            racingGame.moveCars { Randoms.pickNumberInRange(0, 9)}
            resultView.progress(racingGame.cars)
        }

        // winner!
        val winner = racingGame.getWinners()
        resultView.winners(winner)
    }

}