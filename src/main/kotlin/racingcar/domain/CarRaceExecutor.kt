package racingcar.domain

class CarRaceExecutor(
    private val numberGenerator: NumberGenerator,
    private val cars: Cars,
    private val round: Int,
    private val racePolicy: RacePolicy
) {
    fun runRace(): Cars {
        repeat(round) {
            cars.moveIf(this::canMoveCar)
        }
        return cars
    }

    private fun canMoveCar(car: Car): Boolean {
        val number = numberGenerator.generate()
        return racePolicy.canMove(number)
    }
}
