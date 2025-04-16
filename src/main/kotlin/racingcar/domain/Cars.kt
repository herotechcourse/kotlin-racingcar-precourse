package racingcar.domain

class Cars(val cars: List<Car>) {
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
}
