package racingcar.view

interface ResultView {
    fun printResultHeader(): Unit
    fun printResultRounds(): Unit
    fun printResultWinner(): Unit
}