package racingcar

import racingcar.controller.RacingGame

fun main() {
    val game = RacingGame()
    game.init()
    game.play()
    game.showWinners()
}