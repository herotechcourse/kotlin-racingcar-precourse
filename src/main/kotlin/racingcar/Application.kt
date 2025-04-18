package racingcar

/**
 * Entry point of the Racing Car game application.
 * Initializes dependencies and starts the game.
 */
fun main() {
    // Initialize necessary components
    val validator = Validator()
    val inputHandler = InputHandler()
    val outputHandler = OutputHandler()

    // Start the racing game
    val racingGame = RacingGame(inputHandler, outputHandler, validator)
    racingGame.startRace()
}