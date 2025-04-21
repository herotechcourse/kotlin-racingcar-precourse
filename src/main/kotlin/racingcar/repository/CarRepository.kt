package racingcar.repository

import racingcar.domain.Car

class CarRepository {
    val car = Car()

    fun updateScore(carName: String): Unit {
        car.addScore(carName)
    }

    fun findScoreByCarName(carName: String): Int {
        return car.getScore(carName)
    }
}