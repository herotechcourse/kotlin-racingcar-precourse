package racingcar

import camp.nextstep.edu.missionutils.Randoms

class CarRacing {
    private val inputParser = InputParser()
    private val raceResult = RaceOutput()

    fun race() {
        val carNames = inputParser.getCarNames()
        val rounds = inputParser.getRounds()

        val cars = initializeCars(carNames)

         println("Race Results")

        repeat(rounds) {
            println("Round: ${it + 1}")
            raceSingleRound(cars)
            raceResult.raceDisplay(cars)
        }

        raceResult.announceWinners(cars)
    }

    private fun initializeCars(carNames: List<String>): List<Car> {
        return carNames.map { Car(it) }
    }

    private fun raceSingleRound(cars: List<Car>) {
        cars.forEach { car ->
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            if (randomNumber >= 4) {
                car.moveForward()
            }
        }
    }
}

