package racingcar

class Race(private val cars: List<Car>) {
    fun runRound(randomProvider: () -> Int) {
        cars.forEach { car ->
            car.move(randomProvider() >= 4)
        }
    }
}