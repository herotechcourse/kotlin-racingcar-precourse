package racingcar.repository

import racingcar.car.Car
import racingcar.repository.exception.DuplicateCarException

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

    override fun moveEveryCarRandomly() {
        for (car in carList) {
            car.moveForwardRandomly();
        }
    }

    override fun getAllCars(): List<Car> {
        return carList.toList()
    }

    override fun moveCarById(id: Int) {
        var current = carList[id];
        current.moveForwardRandomly();
    }

}