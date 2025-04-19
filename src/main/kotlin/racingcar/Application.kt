package racingcar

import racingcar.gameflow.Game
import racingcar.input.ConsoleInputModule
import racingcar.output.ConsoleOutputModule

fun main() {
    val input = ConsoleInputModule()
    val output = ConsoleOutputModule()
    val game = Game(input, output)
    game.start()
}