package racingcar.domain

class Cars private constructor(
    private val cars: List<Car>
) {

    fun moveIf(condition: (Car) -> Boolean): Cars {
        cars.filter(condition).forEach { it.forward() }
        return this
    }

    fun names(): List<String> = cars.map { it.name() }

    fun positions(): List<Int> = cars.map { it.position() }

    fun winners(): List<Car> {
        val maxPosition = cars.maxOfOrNull { it.position() } ?: return emptyList()
        return cars.filter { it.position() == maxPosition }
    }

    companion object {
        fun of(names: List<String>): Cars {
            val cars = names.map { Car.from(CarName.from(it)) }
            return Cars(cars)
        }
    }
}
