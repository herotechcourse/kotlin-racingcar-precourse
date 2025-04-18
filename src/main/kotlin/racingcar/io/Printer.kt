package racingcar.io

import racingcar.domain.Car

interface Printer {
    fun printCurrentCarPosition(car: List<Car>)
}