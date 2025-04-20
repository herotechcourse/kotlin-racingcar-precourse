package racingcar

fun main() {
    // test InputView
    val names = InputView.readCarNames()
    val rounds = InputView.readRoundCount()

    println("car names: $names")
    println("rounds: $rounds")
}
