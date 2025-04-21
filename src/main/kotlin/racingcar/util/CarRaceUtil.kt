package racingcar.util

import racingcar.player.Car

class CarRaceUtil : RaceUtil() {
    fun readCars(inputProvider: () -> String?, validator: (List<String>?) -> Result<List<String>>): List<Car> {
        println("Enter the names of the cars (comma-separated):")
        val cars = inputProvider()?.split(",")?.map(String::trim)?.filter { it.isNotEmpty() }
        return validator(cars).getOrElse { throw it }.map { Car(it, 0) }
    }

    fun printRaceResult(result: List<List<Car>>, winners: List<Car>) {
        println("\nRace Results")
        result.joinToString("\n\n") { round ->
            round.joinToString("\n") { car -> "${car.name} : ${countToDashes(car.win)}" }
        }.let { println(it + "\n") }
        println("Winners : ${winners.joinToString(", ") { it.name }}")
    }

    private fun countToDashes(count: Int): String = List(count) { '-' }.joinToString("")
}
