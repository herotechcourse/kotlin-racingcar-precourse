package racingcar.domain

class Cars private constructor(
    private val cars: List<Car>
) {

    fun movedIfSatisfied(condition: (Car) -> Boolean): Cars {
        val movedCars = cars.map { car ->
            if (condition(car)) car.forwarded() else car
        }
        return Cars(movedCars)
    }

    fun names(): List<String> = cars.map { it.name() }

    fun positions(): List<Int> = cars.map { it.position() }

    fun winners(): List<Car> {
        require(cars.isNotEmpty()) { ERROR_NO_CARS }
        val max = cars.maxOf { it.position() }
        return cars.filter { it.position() == max }
    }

    fun formatEachCarWith(formatter: (String, Int) -> String): List<String> {
        return cars.map { formatter(it.name(), it.position()) }
    }

    fun copyOfCurrent(): Cars {
        return Cars(cars.map { Car.copyOf(it) })
    }

    companion object {
        const val ERROR_NO_CARS = "[ERROR] No cars available to determine winner."

        fun of(carNames: List<CarName>): Cars {
            val cars = carNames.map { Car.from(it) }
            return Cars(cars)
        }
    }
}
