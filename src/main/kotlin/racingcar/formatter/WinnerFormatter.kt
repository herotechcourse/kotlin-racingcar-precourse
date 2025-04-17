package racingcar.formatter

import racingcar.domain.Cars

class WinnerFormatter {
    fun format(cars: Cars): String {
        val winnerNames = cars.winners().map { it.name() }
        return "Winners : ${winnerNames.joinToString(", ")}"
    }
}
