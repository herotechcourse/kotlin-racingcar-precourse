package racingcar

import racingcar.model.Car
import racingcar.view.InputHandler
import racingcar.controller.Race

/**
 * Ask user for car names input
 * Ask user for number of rounds input
 * Initialize and start race
 */
fun main() {
    // TODO: Implement the program
    val cars: List<Car> = InputHandler.getCars()
    val numOfRounds = InputHandler.getNumberOfRounds()
    Race(cars, numOfRounds).start()
}
