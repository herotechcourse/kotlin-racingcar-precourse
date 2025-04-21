package racingcar.view

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
}