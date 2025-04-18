package racingcar

import racingcar.view.InputView

//object Application {
//    @JvmStatic
//    fun main(args: Array<String>) {
//        val car = InputView.readCarName()
//        val rounds = InputView.readRoundCount()
//
//        val game = RacingGame(car)
//        game.play(rounds)
//    }
//}

fun main() {
    val car = InputView.readCarName()
    val rounds = InputView.readRoundCount()

    val game = RacingGame(car)
    game.play(rounds)
}



