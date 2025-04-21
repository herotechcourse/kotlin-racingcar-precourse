package racingcar

import racingcar.model.Car
import racingcar.view.InputHandler
import racingcar.controller.Race

fun main() {
    // TODO: Implement the program
    val cars: List<Car> = InputHandler.getCars()
    val numOfRounds = InputHandler.getNumberOfRounds()
    Race(cars, numOfRounds).start()
}
