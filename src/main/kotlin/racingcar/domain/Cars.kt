package racingcar.domain

class Cars private constructor(private val cars: List<Car>) {
    companion object {
        private const val DELIMITER = ","
        private const val MAXIMUM_COUNT = 10

        fun from(names: String): Cars {
            val carNames: List<String> = names.split(DELIMITER).map { it.trim() }
            require(isUnique(carNames)) { "car names must be unique." }
            require(carNames.size <= MAXIMUM_COUNT) { "The number of cars must not exceed $MAXIMUM_COUNT" }
            val cars = carNames.map { name -> Car(name) }.toList()

            return Cars(cars)
        }

        private fun isUnique(carNames: List<String>): Boolean {
            return carNames.size == carNames.distinct().size
        }
    }
}