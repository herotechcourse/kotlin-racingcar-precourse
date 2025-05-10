package racingcar

class Cars(private val cars: List<Car>) {

    fun move() {
        cars.forEach { it.moveIfPossible() }
    }

    fun getAll(): List<Car> = cars

    fun findWinners(): List<String> {
        val max = cars.maxOf { it.movement }
        return cars.filter { it.movement == max }.map { it.name }
    }
}