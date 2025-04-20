package racingcar

import camp.nextstep.edu.missionutils.Randoms


class RacingGame(carNames: List<String>, private val noOfRounds: Int) {
    internal val cars: List<Car> = carNames.map { Car(it) }

    fun startGame() {
        println("Race Results")
        for (i in 1..noOfRounds) {
            executeRound()
            println()
        }
        val winnerNames = getWinners().joinToString(", ")
        println("Winners : $winnerNames")
    }

    fun getWinners(): List<String> {
        val maxPosition = cars.maxOf { it.getPosition() }
        return cars.filter { it.getPosition() == maxPosition }
            .map { it.getName() }
    }

    private fun executeRound() {
        for (car in cars){
            val randomNum = generateRandomNumber()
            car.moveForward(randomNum)
        }
        for (car in cars){
            println(car.getPositionStatus())
        }
    }

    private fun generateRandomNumber(): Int{
        return Randoms.pickNumberInRange(0, 9)
    }
}
