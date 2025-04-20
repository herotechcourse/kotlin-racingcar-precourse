package racingcar.view

import racingcar.model.Car

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
}
