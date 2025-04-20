package racingcar.view

import racingcar.model.Car

// using object = only one instance (singleton)
// this object just handles output, no data is stored
object OutputView {

    // prints the result of one round
    // for each car, show the name and how far it moved using dashes
    fun printRoundResult(cars: List<Car>) {
        for (car in cars) {
            val bar = "-".repeat(car.position)
            println("${car.name} : $bar")
        }
        println() // extra line between rounds
    }

    fun printStartMessage() {
        println("\nRace Results")
    }

    // prints the winner(s) after the race is over
    fun printWinners(winners: List<Car>) {
        val winnerNames = winners.joinToString(", ") { it.name }
        println("Winners : $winnerNames")
    }

}
