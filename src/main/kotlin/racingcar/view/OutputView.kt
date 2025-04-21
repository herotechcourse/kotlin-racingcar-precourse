package racingcar.view

import racingcar.model.Car

interface OutputView {
    fun printResultPerRound(round: Int, cars: List<Car>)
    fun displayWinners(winners: List<Car>)
}