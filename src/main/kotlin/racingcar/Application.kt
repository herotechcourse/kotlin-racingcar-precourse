package racingcar

import racingcar.input.InputView
import racingcar.factory.CarFactory
import racingcar.domain.RacingGame
import racingcar.view.OutputView

fun main() {

	// Read and validate input
	val names: List<String> = InputView.getValidateCarNames()
	val rounds: Int         = InputView.getValidateRound()

	// Initialize and run game
	val game = RacingGame(CarFactory.fromNames(names))
	val result = game.race(rounds)

	// Print result
	OutputView.printOutput(result)
}