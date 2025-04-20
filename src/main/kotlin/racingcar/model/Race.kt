package racingcar.model

class Race(
    private val cars: Cars,
    private val totalRounds: Int
) {
    fun play(): List<List<Car>> {
        val history = mutableListOf<List<Car>>()
        repeat(totalRounds) {
            cars.moveAll()
            history += cars.snapshot()
        }
        return history
    }

    fun winners(): List<String> = cars.findWinners()
}