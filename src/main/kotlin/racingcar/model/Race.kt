package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Race {
    fun executeOneRound(cars: List<Car>) {
        cars.forEach { car ->
            if (shouldMove())
                car.move()
        }
    }

    private fun shouldMove(): Boolean {
        return Randoms.pickNumberInRange(0, 9) >= 4
    }

    fun initMap(cars: List<Car>): MutableMap<String, Int> {
        val map = mutableMapOf<String, Int>()
        cars.forEach { car ->
            map[car.name] = 0
        }
        return map
    }

    fun updateMap(cars: List<Car>, map: MutableMap<String, Int>) {
        val maxPosition = cars.maxOf { it.position }
        val roundWinners = cars.filter { it.position == maxPosition }
        roundWinners.forEach { car ->
            map[car.name] = map[car.name]!! + 1
        }
    }

    fun displayFinalWinners(map: MutableMap<String, Int>) {
        val maxWins = map.values.max()
        val overallWinners = map.filter { it.value == maxWins }.keys
        println("Winners : ${overallWinners.joinToString()}")
    }
}