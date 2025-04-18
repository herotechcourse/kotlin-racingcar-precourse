package racingcar

fun main() {
    // TODO: Implement the program

    // Start the car racing game

    // Get user input for car names
    val carNames = InputView.readCarNames()

    // Get user input for number of race rounds
    val roundCount = InputView.readRoundCount()

    // Initialise the racing game with the given car names
    val racingGame = RacingGame(carNames)

    // Run the game for the specified number of rounds
    repeat(roundCount) { round ->

        // Move all cars one step
        racingGame.move()

        // Display the result of the current round
        ResultView.printRound(racingGame.cars, round + 1)
    }

}
