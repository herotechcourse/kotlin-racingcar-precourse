package racingcar

data class Race(
    val cars: List<Car>,
    val round: Int,
    val shouldMove: Boolean
) {
    fun runRound(): List<Car> {
        return cars.map { it -> it.move({ shouldMove }) }
    }

    // val shouldMove: Boolean = Randoms.pickNumberInRange(0, 9) >= 4 // Use later
}
