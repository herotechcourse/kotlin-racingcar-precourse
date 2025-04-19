package racingcar.view
import racingcar.domain.Car


object OutputView {
    fun printRound(cars: List<Car>) {
        cars.forEach { println("${it.name} : ${it.progress()}") }
        println()
    }

    fun printWinners(winners: List<String>) {
        println("Winners : ${winners.joinToString(", ")}")
    }
}