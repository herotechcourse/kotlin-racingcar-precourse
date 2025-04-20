package racingcar

import camp.nextstep.edu.missionutils.Randoms

// Move and change randomNumber to randomGenerator to be more reliable for tests
class CarRacing (private val randomGenerator: () -> Int = { Randoms.pickNumberInRange(0, 9) }) {
    private val raceResult = RaceOutput()

    fun race(carNames: List<String>, rounds: Int) {
        val cars = initializeCars(carNames)

         println("Race Results")

        repeat(rounds) {
            println("Round: ${it + 1}")
            raceSingleRound(cars)
            raceResult.raceDisplay(cars)
        }

        raceResult.announceWinners(cars)
    }

    // remove private for tests
    fun initializeCars(carNames: List<String>): List<Car> {
        return carNames.map { Car(it) }
    }

    fun raceSingleRound(cars: List<Car>) {
        cars.forEach { car ->
            if (randomGenerator() >= 4) {
                car.moveForward()
            }
        }
    }
}