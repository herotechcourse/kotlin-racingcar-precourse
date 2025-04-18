package racingcar

import racingcar.domain.Car

interface Printer {
    fun printCurrentCarPosition(car: List<Car>)
}