package racingcar

fun main() {
    val carNames = InputHandler.readAndValidateCarNames()
    val rounds = InputHandler.readAndValidateRounds()
    val game = RacingGame(carNames, rounds, outputHandler = OutputHandler())
    game.run()
}





