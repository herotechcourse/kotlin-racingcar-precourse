package racingcar

import camp.nextstep.edu.missionutils.Randoms

object GameLogic {
    fun logicRace(cars: List<Car>, rounds: Int): List<RaceResult> {
        val results =   mutableListOf<RaceResult>()

        repeat(rounds) {
            playOneRound(cars, results)
        }
        return results
    }

    private fun playOneRound(cars: List<Car>, allResults: MutableList<RaceResult>) {
        val roundResult = mutableListOf<RaceResult>()

        for (car in cars) {
            moveCar(car)
        }
        for (car in cars) {
            val currentResult = RaceResult(car.name, car.position)
            roundResult.add(currentResult)
        }
        allResults.addAll(roundResult)
    }

    fun moveCar(car: Car): Unit {
        val randomNumber =  Randoms.pickNumberInRange(0, 9)

        if (randomNumber >= 4) {
            car.move()
        }
    }

    fun searchWinners(cars: List<Car>): List<String> {
        val maxPosition = cars.maxOf { car -> car.position }
        val winner = mutableListOf<String>()

        for (car in cars) {
            if (car.position == maxPosition) {
                winner.add(car.name)
            }
        }
        return winner
    }
}