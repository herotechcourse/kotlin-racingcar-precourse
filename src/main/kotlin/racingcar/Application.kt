package racingcar

import racingcar.generator.DefaultRandomNumberGenerator
import racingcar.io.Input
import racingcar.template.ConsoleRacingGameTemplate

fun main() {
    // TODO: Implement the program

    val carNames = Input.promptCarNames()
    val roundCount = Input.promptNumberOfRound()

    val racingGame = RacingGame(carNames)
    val gameRunner = ConsoleRacingGameTemplate(racingGame, roundCount)

    gameRunner.execute(DefaultRandomNumberGenerator)
}
