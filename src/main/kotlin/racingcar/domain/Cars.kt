package racingcar.domain

data class Cars(
    private val cars: List<Car> = listOf(),
) {

    init {
        require(cars.distinctBy { it.name }.size == cars.size) { "Car names must be unique." }
    }

    fun moveRandomly(): List<Car> {
        return cars.map { it.moveRandomly() }
    }

    fun getMostMovedCar(): Cars {
        val maxPosition = cars.maxOf { it.position }
        return Cars(cars.filter { it.position == maxPosition })
    }

    fun forEach(action: (Car) -> Unit) {
        cars.forEach(action)
    }

    fun createRound(index: Int): Round {
        return Round(index, Cars(cars.map { it.copy() }))
    }

    fun getCarNames(): List<String> {
        return cars.map { it.name }
    }
}