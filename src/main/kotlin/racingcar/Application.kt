package racingcar

import racingcar.service.InputHandler.inputCars
import racingcar.service.InputHandler.inputRounds
import racingcar.model.Race
import racingcar.service.Formatter

fun main() {
    val cars = inputCars()
    val rounds = inputRounds()
    val race = Race(cars, rounds)
    race.run()
    val winners = race.findWinners()
    println(Formatter.winners(winners))
}
