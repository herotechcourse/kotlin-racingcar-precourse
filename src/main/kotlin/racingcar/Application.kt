package racingcar

fun main() {
    // read input from the user
    val carNames = InputView.readCarNames()
    val numberOfRounds = InputView.readNumberOfRounds()

    // validate input
    val validatedCarNames = InputValidator.validateCarNames(carNames)
}
