package racingcar

object OutputView {
    fun printRound(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
    }
    fun printWinners(winners: List<String>) {
        println("Winners : ${winners.joinToString(", ")}")
    }
}
