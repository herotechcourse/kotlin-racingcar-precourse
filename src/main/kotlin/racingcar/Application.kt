package racingcar

import racingcar.generator.DefaultRandomNumberGenerator
import racingcar.io.Input
import racingcar.template.ConsoleRacingGameTemplate

fun main() {
    // TODO: Implement the program

    val carNames = Input.readCarNames()
    val roundCount = Input.readNumberOfRound()

    val racingGame = RacingGame(carNames, roundCount)
    val gameRunner = ConsoleRacingGameTemplate(racingGame)

    gameRunner.execute(DefaultRandomNumberGenerator)
}
