package racingcar.repository

import racingcar.domain.Car

class CarRepository {
    private var memoryStore = LinkedHashMap<String, Car>()

    fun save(car: Car) {
        if (memoryStore.containsKey(car.name)) {
            throw IllegalArgumentException("Already exist name: $car.name")
        }
        memoryStore.put(car.name, car)
    }

    fun update(car: Car) {
        if (!memoryStore.containsKey(car.name)) {
            throw IllegalArgumentException("Not exist name: $car.name")
        }
        memoryStore.put(car.name, car)
    }

    fun fetchByName(name: String): Car {
        if (!memoryStore.containsKey(name)) {
            throw IllegalArgumentException("Not exist name: $name")
        }
        return memoryStore[name]!!
    }

    fun fetchAll(): List<Car> {
        return memoryStore.values.toList()
    }
}