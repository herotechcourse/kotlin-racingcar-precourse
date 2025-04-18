package racingcar

class MockRacingGame(val cars: List<Car>) {

    var moveCallCount = 0
        private set

    fun startGame() {
        for (car in cars) {
            moveCallCount++
        }
    }

    fun findWinner() : List<Car> {
        val max = cars.maxOf { car -> car.position }
        return cars.filter { car -> car.position == max }
    }

}