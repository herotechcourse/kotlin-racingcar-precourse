package racingcar

class OutputHandler {
    fun printRaceStart() {
        println("\nRace Results")
    }

    fun printRaceResult(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.getPosition())}")
        }
        println()
    }

    fun printWinners(cars: List<Car>) {
        val maxPosition = cars.maxOf { it.getPosition() }
        val winners = cars.filter { it.getPosition() == maxPosition }.map { it.name }
        println("Winners : ${winners.joinToString(", ")}")
    }
}