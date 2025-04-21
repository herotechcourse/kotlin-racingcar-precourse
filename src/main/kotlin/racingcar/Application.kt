package racingcar

import racingcar.controller.RacingController
import racingcar.input.ConsoleInput
import racingcar.view.ConsoleOutput

fun main() {
    // TODO: Implement the program
    val racingController = RacingController(ConsoleInput, ConsoleOutput)
    racingController.run()
}

