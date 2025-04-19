package racingcar

import racingcar.controller.Executor
import racingcar.view.ConsoleDisplay

fun main() {
    val display = ConsoleDisplay()
    val executor = Executor(display)
    executor.start()
}
