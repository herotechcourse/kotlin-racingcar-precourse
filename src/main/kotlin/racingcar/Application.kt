package racingcar

import racingcar.controller.Game
import racingcar.view.ConsoleInputModule
import racingcar.view.ConsoleOutputModule

fun main() {
    val input = ConsoleInputModule()
    val output = ConsoleOutputModule()
    val game = Game(input, output)
    game.start()
}