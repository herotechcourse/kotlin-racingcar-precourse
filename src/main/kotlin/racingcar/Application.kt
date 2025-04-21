package racingcar

fun main() {
    val carNames = InputHandler.readAndValidateCarNames()
    val rounds = InputHandler.readAndValidateRounds()
    val outputHandler = OutputHandler()
    val game = RacingGame(carNames, rounds, outputHandler)
    game.run()
}





