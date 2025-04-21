package racingcar.view

import racingcar.domain.Car
import racingcar.domain.Cars

object OutputView {
    fun printRaceHeader() {
        println("\nRace Results")
    }

    fun printRound(cars: Cars) {
        cars.cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }

    fun printWinners(cars: List<Car>) {
        val names = cars.joinToString(", ") { it.name }
        println("Winners : $names")
    }
}