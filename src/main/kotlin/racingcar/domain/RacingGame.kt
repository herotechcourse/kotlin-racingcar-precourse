package racingcar.domain

class RacingGame(
    carNames: List<String>
) {
    val cars: List<Car> = carNames.map { Car(it) }

    fun playRound() {
        cars.forEach { it.move() }
    }

    fun findWinners(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }
}