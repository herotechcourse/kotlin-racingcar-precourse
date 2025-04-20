package racingcar.service

import racingcar.repository.CarRepository

class CarService {
    val carRepository = CarRepository();

    fun checkRandomNumber(randomNumber: Int, carName: String) {
        if (randomNumber >= 4) {
            carRepository.updateScore(carName);
        }
    }
}