package racingcar.model

class RacingGame(
    private val cars: List<Car>,
) {

    fun play() {
        cars.forEach { it.move() }
    }

    fun getWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }

}
