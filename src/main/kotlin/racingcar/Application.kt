package racingcar

fun main() {
    // Ask user to input car names
    println("Enter the names of the cars (comma-separated): ")
    val carInput = readLine() ?: throw IllegalArgumentException("Input cannot be null")

    // Ask user to input number of rounds
    println("How many rounds will be played?")
    val noOfRoundsInput = readLine()?.toInt() ?: throw IllegalArgumentException("Input cannot be null")

    // Validate inputs
    val validator = InputValidator(carInput, noOfRoundsInput)
    val carNames = validator.validateCarNames()
    val noOfRounds = validator.validateRound()

    // Start the game
    val game = RacingGame(carNames, noOfRounds)
    game.startGame()
}
