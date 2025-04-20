package racingcar.car.repository

import racingcar.car.Car
import racingcar.car.repository.exception.DuplicateCarException

class ListCarRepository : CarRepository {

    private val carList: MutableList<Car> = mutableListOf();
    private val existingCarNames: MutableSet<String> = mutableSetOf();

    override fun addCar(name: String) {
        if (existingCarNames.contains(name))
            throw DuplicateCarException(name);
        carList.add(Car(name));
    }

    override fun addMultipleCars(cars: Array<String>) {
        cars.forEach { car -> addCar(car) }
    }

    override fun getAllCars(): List<Car> {
        return carList.toList()
    }

}