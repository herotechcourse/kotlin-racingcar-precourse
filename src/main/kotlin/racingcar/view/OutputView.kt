package racingcar.view

import racingcar.model.Car
import racingcar.util.Constant.CAR_POSITION_SYMBOL
import racingcar.util.Constant.RACE_RESULT_MESSAGE
import racingcar.util.Constant.WINNER_MESSAGE

class OutputView {
    fun printProcess(cars: List<Car>) {
        println(RACE_RESULT_MESSAGE)
        cars.forEach { car ->
            println("${car.name} : ${CAR_POSITION_SYMBOL.repeat(car.position)}")
        }
    }

    fun printWinner(winner: List<Car>) {
        println("$WINNER_MESSAGE ${winner.joinToString(", ") { it.name }}")
    }
}