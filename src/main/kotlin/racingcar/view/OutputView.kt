package racingcar.view

import racingcar.model.Car

object OutputView {

    fun printResultMessage() = println("Race Results")

    fun printCarPositions(cars: List<Car>) {
        cars.forEach { println(formatCarPosition(it)) }
        println()
    }

    fun printWinner(winner: List<Car>) {
        println("Winners : ${winner.joinToString(", ") { it.name }}")
    }

    private fun formatCarPosition(car: Car): String {
        return "${car.name} : ${"-".repeat(car.position)}"
    }

}
