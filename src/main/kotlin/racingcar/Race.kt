package racingcar

class Race(
    val cars: List<Car>,
    val numberOfRounds: Int
) {
    companion object {
        fun createRaceSession(carNames: List<String>, numberOfRounds: Int): Race{
            return Race(carNames.map { carName -> Car(carName) }, numberOfRounds)
        }
    }
}