package racingcar

import racingcar.view.InputView

fun main() {
    val carNames = InputView.readNames()
    val rounds =InputView.readRoundNumber()
    println("Car names: $carNames")
    println("Number of rounds: $rounds")
}
