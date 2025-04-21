package racingcar

class RaceOutput {
    fun raceDisplay(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }

    fun announceWinners(cars: List<Car>) {
        val maxPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPosition }.map { it.name }

        println("Winners : ${winners.joinToString(", ")}")
    }
}