package racingcar.domain

object CarManager {
    private val _cars = mutableListOf<Car>()

    val cars: List<Car>
        get() = _cars

    fun addCar(car: Car) {
        _cars.add(car)
    }

    fun raceAllCars() {
        _cars.forEach { it.race() }
    }

    private fun winners(): List<Car> {
        val maxPos = _cars.maxOf { it.position }
        return _cars.filter { it.position == maxPos }
    }

    fun winnerNames() : List<String> = winners().map { it.name }
}