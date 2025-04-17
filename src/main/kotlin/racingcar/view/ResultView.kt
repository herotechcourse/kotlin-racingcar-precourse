package racingcar.view

import racingcar.domain.Car

class ResultView {

    /**
    * show current state of cars after one round
    **/
    fun progress(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}") //repeat "-" based on position count
        }
        println()
    }

    /**
     * print the winner after the game ends
     * e.g. Winners : pobi, jun
     */
    fun winners(winners: List<String>) {
        println("Winners : ${winners.joinToString(", ")}")
    }
}