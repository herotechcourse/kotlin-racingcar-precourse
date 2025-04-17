package racingcar.domain

class Race(carNames: List<String>) {
    private val cars = carNames.map { Car(it) }

    fun runRound() {
        cars.forEach { it.move() }
    }

    fun getCars(): List<Car> = cars

    fun getWinners(): List<String> {
        val max = cars.maxOf { it.position }
        return cars.filter { it.position == max }.map { it.name }
    }
}