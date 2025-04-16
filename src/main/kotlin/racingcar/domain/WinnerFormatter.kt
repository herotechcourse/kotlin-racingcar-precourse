package racingcar.domain

class WinnerFormatter {
    fun format(cars: Cars): String {
        val winnerNames = cars.winners().map { it.name() }
        return "Winners : ${winnerNames.joinToString(", ")}"
    }
}
