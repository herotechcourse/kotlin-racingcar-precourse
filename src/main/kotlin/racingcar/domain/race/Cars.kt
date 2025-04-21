package racingcar.domain.race

import racingcar.domain.car.Car

class Cars(val cars: List<Car>) {

    init {
        require(cars.size in MIN_SIZE..MAX_SIZE) { SIZE_OUT_OF_RANGE_ERROR }
        require(isNotDuplicated()) { CAR_NAMES_DUPLICATED_ERROR }
    }

    private fun isNotDuplicated(): Boolean {
        return cars.distinct().size == cars.size
    }

    fun moveAll(): Cars {
        return Cars(cars.map { it.move() })
    }

    fun getMaxPosition() = cars.maxOf { it.getPosition() }

    fun findAllAtSamePosition(position: Int): List<Car> {
        return cars.filter { it.getPosition() == position }
    }

    companion object {
        private const val MIN_SIZE: Int = 2
        private const val MAX_SIZE: Int = 20

        private const val SIZE_OUT_OF_RANGE_ERROR: String =
            "[ERROR] Total number of cars range must be between $MIN_SIZE and $MAX_SIZE."
        private const val CAR_NAMES_DUPLICATED_ERROR: String = "[ERROR] Car names are duplicated."
    }
}
