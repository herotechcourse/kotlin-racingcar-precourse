package racingcar

fun main() {
    // read input from the user
    val carNames = InputView.readCarNames()
    val numberOfRounds = InputView.readNumberOfRounds()
    println("Car names: $carNames")
    println("Number of rounds: $numberOfRounds")
}
