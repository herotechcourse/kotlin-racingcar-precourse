package racingcar

import racingcar.view.InputView

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        val car = InputView.readCarName()
        val rounds = InputView.readRoundCount()
    }
}


