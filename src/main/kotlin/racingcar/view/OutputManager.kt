package racingcar.view

import racingcar.domain.Car

object OutputManager {

    fun printRaceStatus(cars: List<Car>) {
        cars.forEach{car -> println("${car.name} : ${"-".repeat(car.position)}")}
    }

    fun printWinners(winners: List<String>) {
        println("Winners : ${winners.joinToString(", ")}")
    }
}