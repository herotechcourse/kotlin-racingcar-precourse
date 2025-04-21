package racingcar.formatter

import racingcar.domain.Car

class OutputFormatter {
    fun formatRoundStatus(cars: List<Car>): String =
        cars.joinToString("\n") { car ->
            "${car.name} : ${"-".repeat(car.position)}"
        }

    fun formatWinners(winners: List<String>): String =
        "Winners : ${winners.joinToString(", ")}"
}