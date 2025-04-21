package racingcar.model

class Cars(private val cars: List<Car>) {

    companion object {
        const val MAX_CAR_COUNT = 1000

        fun of(carNames: List<String>): Cars {
            val cars = carNames.map { Car(it) }
            return Cars(cars)
        }
    }

    fun findCarsByMoveCount(maxMoveCount: Int): Cars {
        val targetCars = cars.filter { it.getMoveCount() == maxMoveCount }
        return Cars(targetCars)
    }

    fun getCars(): List<Car> = cars
}
