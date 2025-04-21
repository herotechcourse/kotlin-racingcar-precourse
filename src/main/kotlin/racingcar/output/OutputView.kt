package racingcar.output

import racingcar.domain.Car

class OutputView {

    fun printCarPosition(cars: List<Car>) {
        for (car in cars) {
            val name = car.getName()
            val position = "-".repeat(car.getPosition())
            println("$name : $position")
        }
        println()
    }
}