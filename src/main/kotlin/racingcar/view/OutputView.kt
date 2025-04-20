package racingcar.view

class OutputView {
    fun printRoundResult(cars: List<Car>) {
        cars.forEach { println("${it.name} : ${"-".repeat(it.position)}") }
    }

    fun printWinners(winners: List<String>) {
        println("Winners : ${winners.joinToString(", ")}")
    }
}