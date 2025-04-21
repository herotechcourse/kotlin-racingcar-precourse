package racingcar.domain

/**
 * Manages multiple cars
 * @property cars List of cars
 */
class Cars(private val cars: List<Car>) {

    /**
     * Moves all cars
     * @param randomNumbers Random numbers for each car
     */
    fun moveAll(randomNumbers: List<Int>) {
        cars.forEachIndexed { index, car ->
            car.move(randomNumbers[index])
        }
    }

    /**
     * Gets all cars
     * @return List of cars
     */
    fun getCars(): List<Car> {
        return cars.toList()
    }

    /**
     * Gets winners (cars that reached the farthest distance)
     * @return List of winner cars
     */
    fun getWinners(): List<Car> {
        val maxPosition = cars.maxOfOrNull { it.getPosition() } ?: 0
        return cars.filter { it.getPosition() == maxPosition }
    }
} 