package racingcar

import racingcar.console.Input
import racingcar.domain.Game

fun main() {
    val settings = Input.readSettings()
    Game.play(settings)
}