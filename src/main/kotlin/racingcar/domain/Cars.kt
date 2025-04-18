package racingcar.domain

class Cars(private val cars: List<Car>) {

    fun raceOnce() {
        cars.forEach { it.moveForward() }
    }
    fun getCarStates(): List<Pair<String, Int>> {
        return cars.map { it.name to it.position }
    }
    fun getWinners(): List<Car> {
        val maxPosition = cars.maxOfOrNull { it.position } ?: return emptyList()
        return cars.filter { it.position == maxPosition }
    }
    fun printAllCars() {
        cars.forEach { car ->
            println("name: ${car.name}, position: ${car.position}")
        }
    }

    companion object {
        fun from(names: List<String>): Cars {
            validateDuplicate(names)
            val cars = names.map { name ->
                Car.validateCar(name)
                Car(name)
            }
            return Cars(cars)
        }

        private fun validateDuplicate(names: List<String>) {
            if (names.size != names.toSet().size) {
                throw IllegalArgumentException("Duplicate car names are not allowed.")
            }
        }
    }
}