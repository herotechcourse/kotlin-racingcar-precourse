package racingcar.storage

import racingcar.storage.exception.CarNotFoundException
import racingcar.storage.exception.DuplicateCarException

private const val DEFAULT_POSITION = 0;

class MapCarRepository : CarRepository {

    private val storage = mutableMapOf<String, Int>();

    override fun addCar(name: String) {
        if (storage[name] != null)
            throw DuplicateCarException(name);
        storage[name] = DEFAULT_POSITION;
    }

    override fun addMultipleCars(cars: Array<String>) {
        cars.forEach { car -> addCar(car) }
    }

    override fun moveCar(name: String) {
        var current = storage[name];
        if (current == null)
            throw CarNotFoundException(name);
        storage[name] = current + 1;
    }
}