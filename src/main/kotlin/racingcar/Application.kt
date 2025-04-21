package racingcar

import racingcar.controller.RaceGame
import racingcar.decider.WinnerDecider
import racingcar.formatter.OutputFormatter
import racingcar.generator.DefaultNumberGenerator
import racingcar.generator.NumberGenerator
import racingcar.validator.InputValidator

fun main() {
    val validator = InputValidator()
    val numberGenerator: NumberGenerator = DefaultNumberGenerator()
    val winnerDecider = WinnerDecider()
    val outputFormatter = OutputFormatter()

    val game = RaceGame(validator, numberGenerator, winnerDecider, outputFormatter)
    game.start()
}