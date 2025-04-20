package racingcar.view

import racingcar.domain.Car

object ResultView {
    fun printHeader() {
        println("=".repeat(30))
        println("      Race Results    ")
        println("=".repeat(30))
    }

    fun printProgress(cars: List<Car>) {
        cars.forEach{
            println("${it.getName()} : ${"-".repeat(it.getPosition())}")
        }
        println()
    }

    fun printWinners(names: List<String>) {
        println("Winners : ${names.joinToString(", ")}")
    }
}