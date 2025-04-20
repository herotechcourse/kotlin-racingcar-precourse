package racingcar

import game.Race
import input.Input

fun main() {
    val cars = Input.getCars()
    val totalRounds = Input.getTotalRounds()

    val race = Race(cars, totalRounds)
    race.playGame()
}
