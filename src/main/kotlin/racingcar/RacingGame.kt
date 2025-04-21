package racingcar

import camp.nextstep.edu.missionutils.Randoms

object CarRacing {

    fun initializeCars(carNames: List<String>): List<Car> {
        return carNames.map { Car(it) }
    }

    fun raceSingleRound(cars: List<Car>) {
        cars.forEach { car ->
            val number = Randoms.pickNumberInRange(0, 9)
            if (number >= 4) {
                car.moveForward()
            }
        }
    }

    fun runRace(carNames: List<String>, roundCount: Int) {
        val cars = initializeCars(carNames)

        println("\nRace Results")

        repeat(roundCount) { round ->
//            println("Round ${round + 1}")
            raceSingleRound(cars)
            cars.forEach { car ->
                println("${car.name} : ${"-".repeat(car.getPosition())}")
            }
            println()
        }

        val maxPosition = cars.maxOf { it.getPosition() }
        val winners = cars.filter { it.getPosition() == maxPosition }.map { it.name }

        println("Winners : ${winners.joinToString(", ")}")
    }
}
