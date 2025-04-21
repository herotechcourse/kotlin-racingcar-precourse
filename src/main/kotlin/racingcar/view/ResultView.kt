package racingcar.view

import racingcar.model.Car

object ResultView {
    fun displayWinners(winners: List<Car>) {
        print("Winners : " + winners.joinToString(", ") { it.name })
    }
}