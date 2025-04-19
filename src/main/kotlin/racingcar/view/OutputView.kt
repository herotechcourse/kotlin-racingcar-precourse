package racingcar.view

import racingcar.domain.Cars

object OutputView {

    fun showRacing(cars: Cars) {
        println("Race Results")
    }

    fun showResult(winnerNames: List<String>) {
        println("Winners : " + winnerNames.joinToString(", "))
    }
}