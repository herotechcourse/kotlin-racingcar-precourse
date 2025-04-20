package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingGame(
    private val cars: Cars,
    private val rounds: Int,
    private val randomFunc: () -> Int = { Randoms.pickNumberInRange(0, 9) }
) {
    fun play(): List<List<Car>> {
        val history = mutableListOf<List<Car>>()
        repeat(rounds) {
            cars.moveAll(randomFunc)
            history.add(cars.getCars().map { it.copy() })
        }
        return history
    }
}
