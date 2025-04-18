package racingcar.domain

class Cars private constructor(private val cars: List<Car>) {
    companion object {
        private const val DELIMITER = ","

        fun from(names: String): Cars {
            val carNames: List<String> = names.split(DELIMITER).map { it.trim() }
            require(isUnique(carNames)) { "car names must be unique." }
            val cars = carNames.map { name -> Car(name) }.toList()

            return Cars(cars)
        }

        private fun isUnique(carNames: List<String>): Boolean {
            return carNames.size == carNames.distinct().size
        }
    }
}