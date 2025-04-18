package racingcar.view

import racingcar.Car


fun printRoundResult(cars: List<Car>) {
    cars.forEach {
        println("${it.name} : ${"-".repeat(it.position)}")
    }
    println()
}

fun printResult(winners: String) {
    println("Winners : $winners")
}

