package racingcar.view

import racingcar.domain.RacingCar
import javax.swing.text.Position

object OutputView {

    fun printCarPos(name : String, position: Int) {
        println("$name : ${"-".repeat(position)}")
    }

    fun printCarRound(cars : List<RacingCar>) {
        cars.forEach {
            car -> printCarPos(car.name, car.pos)
        }
        println()
    }

}

