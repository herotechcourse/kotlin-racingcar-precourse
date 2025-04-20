package racingcar.view

import racingcar.model.Car
import racingcar.model.RacingGame

class OutputView {
    fun printRaceResultsMessage() {
        println("Race Results")
    }

    fun printRaceResults(cars: List<Car>) {
        cars.forEach { car ->
            print("${car.name} : ")
            printProgress(car)
            print("\n")
        }
        print("\n")
    }

    private fun printProgress(car: Car) {
        repeat(car.position) {
            print("-")
        }
    }

    fun printWinners(winners: List<Car>) {
        val winnersOutput = winners.joinToString(", ") { it.name }
        println("Winners : ${winnersOutput}")
    }
}
