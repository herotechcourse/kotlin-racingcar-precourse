package racingcar.domain

class Cars(private val cars: List<Car>) {
    init {
        validateUniqueNames()
    }

    private fun validateUniqueNames() {
        val names = cars.map { it.name }
        if (names.size != names.toSet().size) {
            throw IllegalArgumentException("Car names must be unique.")
        }
    }

    fun move() {
        for (car in cars) {
            car.move()
        }
    }

    fun winners(): List<Car> {
        val maxPosition = cars.maxOf { it.position.toInt() }
        return cars.filter { car -> car.position.toInt() == maxPosition }.toList()
    }

    fun getCarStatuses(): List<CarStatus> {
        return cars.map { CarStatus(it.name, it.position) }.toList()
    }
}
