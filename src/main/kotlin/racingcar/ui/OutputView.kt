package racingcar.ui

import racingcar.car.Car

class OutputView {
    public fun printCarsAndPositions(carList: List<Car>) {
        carList.forEach { car ->
            println("${car.carName} : ${car.position}")
        }
        println()
    }

    fun printRaceStartMessage() {
        println("\nRace Results")
    }

    fun printWinners(winners: String) {
        println("Winners : $winners")
    }
}