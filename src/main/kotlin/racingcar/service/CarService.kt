package racingcar.service

import racingcar.repository.CarRepository

class CarService {
    val carRepository = CarRepository()

    fun canIncreaseScore(randomNumber: Int, carName: String): Boolean {
        return randomNumber >= 4
    }

    fun updateScore(carName: String) {
        carRepository.updateScore(carName)
    }

    fun retrieveScore(carName: String): Int {
        return carRepository.findScoreByCarName(carName)
    }
}