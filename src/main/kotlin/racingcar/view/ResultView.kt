package racingcar.view

import racingcar.model.Car

interface ResultView {
    fun printResultHeader(): Unit
    fun printResultRounds(car: Car): Unit
    fun printResultWinner(carWinner: String): Unit
    fun printNewLine(): Unit
}