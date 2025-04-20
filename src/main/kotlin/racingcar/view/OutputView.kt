package racingcar.view

import racingcar.model.Car
import racingcar.util.Constant.CAR_POSITION_SYMBOL
import racingcar.util.Constant.RACE_RESULT_MESSAGE

class OutputView {
    fun printProcess(cars: List<Car>) {
        println(RACE_RESULT_MESSAGE)
        cars.forEach { car ->
            println("${car.name} : ${CAR_POSITION_SYMBOL.repeat(car.position)}")
        }
    }
}