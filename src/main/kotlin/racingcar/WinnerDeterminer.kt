package racingcar

class WinnerDeterminer : WinnerDeterminerInterface {
    override fun findWinners(cars: List<Car>): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
            .map { it.name }
    }
}