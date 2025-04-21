package racingcar.domain

class RacingGame(
    private val cars: Cars,
    private val round: Round,
    private val moveStrategy: RandomMoveStrategy
) {

    fun play(): List<List<Pair<String, Int>>> {
        val roundPositions = mutableListOf<List<Pair<String, Int>>>()

        repeat(round.round) {
            cars.cars.forEach {
                    car ->
                car.move(moveStrategy.getDistance())
            }

            roundPositions += cars.cars.map { it.name to it.getPosition() }
        }

        return roundPositions
    }
}
