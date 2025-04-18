package racingcar.io

import racingcar.Car

object Output {

    fun printGame(cars: List<Car>) {
        for(car in cars) {
            printPosition(car)
        }
        println()
    }

    fun printWinner(cars: List<Car>) {
        val winners = cars.joinToString(", ") { car -> car.name }
        print("Winners : $winners")
    }

    fun printStartMessage() {
        println()
        println("Race Results")
    }

    private fun printPosition(car: Car) {
        print("${car.name} : ")
        repeat(car.position) {
            print("-")
        }
        println()
    }

}