package racingcar

fun main() {
    val validator = Validator()
    val inputHandler = InputHandler()
    val outputHandler = OutputHandler()

    val racingGame = RacingGame(inputHandler, outputHandler, validator)
    racingGame.startRace()
}