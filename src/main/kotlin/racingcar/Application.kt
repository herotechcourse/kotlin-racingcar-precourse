package racingcar

import racingcar.view.InputView
import racingcar.view.readRoundCount

//object Application {
//    @JvmStatic
//    fun main() {
//        val car = InputView.readCarName()
//        val rounds = InputView.readRoundCount()
//
//        val game = RacingGame(car)
//        game.play(rounds)
//    }
//}

//fun main() {
//    val car = InputView.readCarName()
//    val rounds = InputView.readRoundCount()
//
//    val game = RacingGame(car)
//    game.play(rounds)
//}

class Application {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val car = InputView.readCarName()
            val rounds = readRoundCount()

            val game = RacingGame(car)
            game.play(rounds)
        }
    }
}

fun main() {
    Application.main(emptyArray())
}

