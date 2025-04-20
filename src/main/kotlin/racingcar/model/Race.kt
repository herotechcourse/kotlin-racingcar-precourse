package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Race(
    var cars: List<Car>,
    var totalRound: Int,
    var results: MutableList<List<CarPosition>> = mutableListOf(),
) {
    fun runRace() {
        for (i in 1..totalRound) {
            runEachRound()
            saveRoundResult()
        }
    }

    private fun runEachRound() {
        for (i in cars.indices) {
            moveCarsRandomly(cars[i])
        }
    }

    private fun moveCarsRandomly(car: Car) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            car.moveForward()
        }
    }

    private fun saveRoundResult() {
        val roundSnapshot = cars.map { car -> CarPosition(car, car.position) }
        results.add(roundSnapshot)
    }

    fun getWinner(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }
}