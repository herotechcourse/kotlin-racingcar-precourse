package racingcar.service

import racingcar.model.Car

object Formatter {

    fun currentPosition(car: Car): String {
        return "${car.name} : ${"-".repeat(car.position)}"
    }

    fun winners(winners: List<Car>): String {
        val names = winners.joinToString(", ") { it.name }
        return "Winners : $names"
    }
}