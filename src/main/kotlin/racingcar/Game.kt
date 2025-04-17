package racingcar

import camp.nextstep.edu.missionutils.Randoms

object Game {
    fun playOneRound(cars: List<Car>): List<Car> {
        val moveThreshold = 4
        val minRandom = 0
        val maxRandom = 9

        return cars.map {
            val randomNumber = Randoms.pickNumberInRange(minRandom, maxRandom)
            if (randomNumber >= moveThreshold) it.movedForward() else it
        }
    }

    fun getWinners(cars: List<Car>): List<Car> = cars.filter { it.position == cars.maxOf { it.position } }
}