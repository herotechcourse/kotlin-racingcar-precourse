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

    fun all(): List<Car> = cars.toList()

    fun roundResult(): Cars {
        val copied = cars.map { copyCar(it) }
        return Cars(copied)
    }

    companion object {
        fun of(carNames: List<CarName>): Cars {
            val cars = carNames.map { Car.from(it) }
            return Cars(cars)
        }
    }

    private fun copyCar(original: Car): Car {
        return Car.from(CarName.from(original.name())).apply {
            repeat(original.position()) { forward() }
        }
    }
}
