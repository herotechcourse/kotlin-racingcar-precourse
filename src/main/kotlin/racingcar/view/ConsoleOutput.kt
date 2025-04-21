package racingcar.view

import racingcar.model.Car

object ConsoleOutput : OutputView {
    override fun printResultPerRound(round: Int, cars: List<Car>) {
        println("Race Results")
        repeat(round) {
            for (car in cars) {
                car.move()
            }
            for (car in cars) {
                println("${car.name} : " + "-".repeat(car.position))
            }
            println()
        }
    }

    override fun displayWinners(winners: List<Car>) {
        print("Winners : " + winners.joinToString(", ") { it.name })
    }
}