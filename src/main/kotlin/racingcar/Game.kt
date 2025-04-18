package racingcar

import camp.nextstep.edu.missionutils.Randoms

object Game {
    private const val MOVE_THRESHOLD = 4
    private const val MIN_RANDOM = 0
    private const val MAX_RANDOM = 9

    fun playOneRound(cars: List<Car>): List<Car> = cars.map { if (isMovable()) it.movedForward() else it }

    fun getWinners(cars: List<Car>): List<Car> = cars.filter { it.position == cars.maxOf { it.position } }

    fun isMovable(): Boolean = Randoms.pickNumberInRange(MIN_RANDOM, MAX_RANDOM) >= MOVE_THRESHOLD
}