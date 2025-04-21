package racingcar.observer

import racingcar.model.Car

/**
 * Logs race output to the console.
 */
class ConsoleListener : RaceListener {
    override fun onRound(round: Int, cars: List<Car>) {
        println()
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
    }

    override fun onFinish(cars: List<Car>, winners: List<String>) {
        println()
        println("Winners : ${winners.joinToString(", ")}")
    }
}
