package racingcar.controller

import racingcar.view.ConsoleDisplay
import racingcar.view.Display

class Executor(private val view: Display){
    fun start() {
        val cars = view.getValidNames()
    }
}