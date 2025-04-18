package racingcar.game

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.Car
import racingcar.reader.InputParamsReader

class CarRacing {
    private val reader = InputParamsReader()

    fun start() {
        println(INPUT_CAR_MESSAGE)
        val cars = createCars(reader.retrieveCarNames())

        println(INPUT_ROUNDS_AMOUNT)
        val rounds = reader.retrieveRoundsAmount()

        println()
        println(RACE_RESULTS)

        makeRace(cars, rounds)
    }

    private fun createCars(carNames: List<String>): List<Car> =
         carNames.map { Car(it) }

    private fun makeRace(cars: List<Car>, rounds: Int) {
        repeat(rounds) {
            makeRound(cars)
            println()
        }
        val winners = getRaceWinners(cars)
        println("$WINNERS$winners")
    }

    private fun makeRound(cars: List<Car>) {
       cars.forEach { car ->
           if(shouldCarMoveForward()) {
               car.move()
           }
           println("${car.getName()} : ${car.racePosition}")
       }
    }

    private fun shouldCarMoveForward(): Boolean =
        Randoms.pickNumberInRange(0, 9) >= 4

    fun getRaceWinners(cars: List<Car>): String {
        val maxPosition = cars.maxOf { it.getPosition() }
        return cars.filter { it.getPosition() == maxPosition }
            .joinToString(", ") { it.getName() }
    }

    companion object {
        private const val INPUT_CAR_MESSAGE = "Enter names of the cars (comma-separated)"
        private const val INPUT_ROUNDS_AMOUNT = "How many rounds will be played?"
        private const val RACE_RESULTS = "Race results"
        private const val WINNERS = "Winners : "
    }
}