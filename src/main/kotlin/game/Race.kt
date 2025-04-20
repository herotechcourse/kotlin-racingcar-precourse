package game

import car.Car
import camp.nextstep.edu.missionutils.Randoms;

private const val RANDOM_MIN_VALUE = 0
private const val RANDOM_MAX_VALUE = 9
private const val MOVE_THRESHOLD = 4
private const val MIN_TOTAL_ROUNDS = 1
private const val MIN_CAR_SIZE = MIN_TOTAL_ROUNDS

class Race(private val cars: Array<Car>, private val totalRounds: Int) {
    init {
        require(cars.size > MIN_CAR_SIZE) { "Minimum 2 cars needs to participate in the race" }
        require(cars.size <= Int.MAX_VALUE) { "Maximum number of cars that can  participate in the race should be less than $Int.MAX_VALUE" }
        require(totalRounds >= MIN_TOTAL_ROUNDS) { "Number of rounds should be greater than zero" }
    }

    fun playGame() {
        println()
        println("Race Results")
        // run the game for total rounds
        repeat(totalRounds) {
            playRound()
            println()
        }
        // announce winners
        announceWinners()
    }

    private fun playRound() {
        for (car in cars) {
            val random = Randoms.pickNumberInRange(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE)
            if (random >= MOVE_THRESHOLD) {
                car.moveForward()
            }
            println("${car.carName} : ${"-".repeat(car.progress)}")
        }
    }

    private fun announceWinners() {
        val winnerCar = cars.maxBy { car -> car.progress }
        println()
        if (winnerCar.progress != 0) {
            val winners = cars.filter { car -> car.progress == winnerCar.progress }.map { car -> car.carName }
            println("Winners : ${winners.joinToString(",")}")
        } else {
            println("None of the cars ran in the race. Hence no winner")
        }

    }
}

