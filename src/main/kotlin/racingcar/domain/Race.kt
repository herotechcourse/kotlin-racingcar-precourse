package racingcar.domain

class Race(val cars: List<Car>) {
    fun moveAll() {
        cars.forEach { it.moveIfPossible() }
    }

    fun findWinners(): List<String> {
        val max = cars.maxOf { it.position }
        return cars.filter { it.position == max }.map { it.name }
    }

    companion object {
        fun fromNames(names: List<String>): Race {
            return Race(names.map { Car(it) })
        }
    }
}
