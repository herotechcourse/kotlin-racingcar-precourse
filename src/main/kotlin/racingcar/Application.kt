package racingcar

import racingcar.view.InputView

fun main() {
    val carNames = InputView.readNames()
    val rounds =InputView.readRounds()
    println("Car names: $carNames")
    println("Number of rounds: $rounds")
}
