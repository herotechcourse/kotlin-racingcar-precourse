package racingcar

class RaceOutput {
    fun announceWinners(cars: List<Car>) {
        val maxPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPosition }.map { it.name }

        println("Winner(s) : ${winners.joinToString(", ")}")
    }
}