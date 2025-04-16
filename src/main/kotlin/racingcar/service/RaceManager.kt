package racingcar.service

import racingcar.model.Car

object RaceManager {
    fun createCars(names: List<String>): List<Car> = names.map { Car(it) }

    fun simulateRace(cars: List<Car>, rounds: Int) {
        repeat(rounds) {
            cars.forEach { it.move() }
            cars.forEach { println("${it.name} : ${it.getProgress()}") }
            println()
        }
    }

    fun determineWinners(cars: List<Car>): List<Car> {
        val maxProgress = cars.maxOf { it.progress }
        return cars.filter { it.progress == maxProgress }
    }
}