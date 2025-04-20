package racingcar


fun main() {
    // Get inputs from user
    val carNamesInput = InputReader.getCarName()
    val noOfRoundsInput = InputReader.getRound()

    // Validate inputs
    val validator = InputValidator(carNamesInput, noOfRoundsInput)
    val carNames = validator.validateCarNames()
    val noOfRounds = validator.validateRound()

    // Start the game
    val game = RacingGame(carNames, noOfRounds)
    game.startGame()
}
