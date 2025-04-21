package racingcar

import racingcar.models.Car
import racingcar.models.InputHandler
import racingcar.models.Race

fun main() {
    // TODO: Implement the program
    val cars : List<Car> = InputHandler.getCars()
    val numOfRounds = InputHandler.getNumberOfRounds()
    Race(cars, numOfRounds).start()
}
