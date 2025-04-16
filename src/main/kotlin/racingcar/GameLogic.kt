package racingcar

import camp.nextstep.edu.missionutils.Randoms

object GameLogic {
    fun logicRace(cars: List<Car>, rounds: Int): List<List<RaceResult>> {
        val results =   mutableListOf<List<RaceResult>>()

        repeat(rounds) {
            results.add(playOneRound(cars))
        }
        return results
    }

    private fun playOneRound(cars: List<Car>): List<RaceResult> {
        for (car in cars) {
            moveCar(car)
        }

        val roundResults = mutableListOf<RaceResult>()
        for (car in cars) {
            roundResults.add(RaceResult(car.name, car.position))
        }

        return roundResults
    }

    fun moveCar(car: Car) {
        val randomNumber =  Randoms.pickNumberInRange(0, 9)

        if (randomNumber >= 4) {
            car.move()
        }
    }

    fun searchWinners(cars: List<Car>): List<String> {
        var maxPosition = 0
        for (car in cars) {
            if (car.position > maxPosition) {
                maxPosition = car.position
            }
        }

        val winner = mutableListOf<String>()
        for (car in cars) {
            if (car.position == maxPosition) {
                winner.add(car.name)
            }
        }
        return winner
    }
}