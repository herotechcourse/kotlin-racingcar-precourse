package racingcar

/**
 * Represents a group of racing cars.
 *
 * @property cars the list of all participating cars
 */
class Cars(private val cars: List<Car>) {

    /**
     * Moves each car if it meets the movement condition.
     */
    fun move() {
        cars.forEach { it.moveIfPossible() }
    }

    /**
     * Returns the list of all cars.
     *
     * @return the list of cars
     */
    fun getAll(): List<Car> = cars
}