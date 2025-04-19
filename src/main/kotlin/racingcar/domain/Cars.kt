package racingcar.domain

class Cars(private val cars: List<Car>) {
    init {
        validateUniqueNames()
    }

    private fun validateUniqueNames() {
        require(cars.map { it.name }.distinct().size == cars.size) {
            "Car names must be unique."
        }
    }

    fun move() {
        cars.forEach { it.move() }
    }

    fun winners(): List<Car> {
        val maxPosition = cars.maxOf { it.position.value }
        return cars.filter { it.position.value == maxPosition }
    }

    fun getCarStatuses(): List<CarStatus> {
        return cars.map { CarStatus(it.name, it.position) }
    }
}
