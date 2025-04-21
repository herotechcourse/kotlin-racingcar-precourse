package racingcar

import racingcar.model.Car

class CarService {
    fun moveForward(car: Car): Car {
        return car.copy(position = car.position + 1)
    }
}
