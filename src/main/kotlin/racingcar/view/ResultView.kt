package racingcar.view

import racingcar.model.Car


fun printRoundResult(cars: List<Car>) {
    cars.forEach {
        println("${it.name} : ${"-".repeat(it.position)}")
    }
    println()
}

fun printResult(winners: String) {
    println("Winners : $winners")
}

