package racingcar

import racingcar.controller.GameController

class Application {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val gameController = GameController()
            gameController.start()
        }
    }
}

fun main() {
    Application.main(arrayOf())
}
