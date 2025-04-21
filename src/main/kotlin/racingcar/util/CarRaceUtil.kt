package racingcar.util

import racingcar.player.Car

class CarRaceUtil : RaceUtil() {
    fun readCars(inputProvider: () -> String?, validator: (List<String>?) -> Result<List<String>>): List<Car> {
        println("Enter the names of the cars (comma-separated):")
        val cars = inputProvider()?.split(",")?.map(String::trim)?.filter { it.isNotEmpty() }
        return validator(cars).getOrElse { throw it }.map { Car(it, 0) }
    }
}
