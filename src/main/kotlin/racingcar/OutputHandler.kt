package racingcar

object OutputHandler {

    fun printRoundResults(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }

    fun printWinners(cars: List<Car>) {
        val maxPosition = cars.maxOf {it.position}
        val winners = cars
            .filter { it.position == maxPosition }
            .map { it.name }
        println("Winners : " + winners.joinToString(", "))
    }
}