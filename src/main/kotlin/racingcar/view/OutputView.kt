package racingcar.view

import racingcar.constant.DisplayMessage.PROGRESS_MARK
import racingcar.constant.DisplayMessage.RESULT_TITLE
import racingcar.constant.DisplayMessage.WINNER_ANNOUNCEMENT
import racingcar.model.Car
import racingcar.model.CarPosition
import racingcar.model.Race

object OutputView {

    fun showAllRoundResult(race: Race) {
        println(RESULT_TITLE)
        race.results.forEach { printEachRoundResult(it) }
    }

    private fun printEachRoundResult(result: List<CarPosition>) {
        result.forEach {
            println("${it.car.name} : ${PROGRESS_MARK.repeat(it.position)}")
        }
    }

    fun announceWinner(winners: List<Car>) {
        print(WINNER_ANNOUNCEMENT)
        print(winners.joinToString { winner -> winner.name })
    }
}