package racingcar.domain

class CarRaceExecutor(
    private val numberGenerator: NumberGenerator,
    private val cars: Cars,
    private val round: Int,
    private val racePolicy: RacePolicy
) {
    fun runRace(): List<Cars> {
        val snapshots = mutableListOf<Cars>()
        repeat(round) {
            cars.moveIf(this::canMoveCar)
            snapshots.add(cars.snapshot())
        }
        return snapshots
    }

    private fun canMoveCar(car: Car): Boolean {
        val number = numberGenerator.generate()
        return racePolicy.canMove(number)
    }
}
