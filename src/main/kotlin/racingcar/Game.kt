package racingcar

import camp.nextstep.edu.missionutils.Randoms

object Game {
    private const val MOVE_THRESHOLD = 4
    private const val MIN_RANDOM = 0
    private const val MAX_RANDOM = 9

    fun play(settings: Settings) {
        var cars = settings.carNames.map { Car(it) }

        Output.printRaceStartMessage()

        repeat(settings.round) {
            cars = playOneRound(cars)
            Output.printProgress(cars)
        }

        val winners = winnersFrom(cars)
        Output.printWinners(winners)
    }

    fun playOneRound(cars: List<Car>): List<Car> = cars.map { if (isMovable()) it.movedForward() else it }

    fun winnersFrom(cars: List<Car>): List<Car> = cars.filter { it.position == cars.maxOf { it.position } }

    fun isMovable(): Boolean = Randoms.pickNumberInRange(MIN_RANDOM, MAX_RANDOM) >= MOVE_THRESHOLD
}