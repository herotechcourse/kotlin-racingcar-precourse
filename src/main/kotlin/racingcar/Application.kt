package racingcar

import racingcar.config.RaceConfig

fun main() {
    val game = RaceConfig().raceRunner()
    game.run()
}

