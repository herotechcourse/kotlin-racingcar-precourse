package racingcar.view

import racingcar.domain.RacingCar
import javax.swing.text.Position

object OutputView {

    fun printCarPos(name : String, position: Int) {
        println("$name$NAME_POSITION_SEPARATOR${CAR_POSITION_DELIMITER.repeat(position)}")
    }

    fun printCarRound(cars : List<RacingCar>) {
        cars.forEach {
            car -> printCarPos(car.name, car.pos)
        }
        println()
    }

    fun printWinners(winners : List<RacingCar>) {
        val winner = winners.joinToString(WIN_COMMA_DELIMITER) { it.name }
        println("Winners : $winner")
    }

    private const val WIN_COMMA_DELIMITER = ", "
    private const val CAR_POSITION_DELIMITER = "-"
    private const val NAME_POSITION_SEPARATOR = " : "
}

