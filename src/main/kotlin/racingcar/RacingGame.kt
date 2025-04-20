package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingGame(carNames: List<String>, noOfRounds: Int) {
    private val cars: List<Car> = carNames.map { Car(it) }
    private val noOfRounds = noOfRounds

    fun startGame() {
        println("Race Results")
        for (i in 1..noOfRounds) {
            executeRound()
            println()
        }
        val maxPosition = cars.maxOf { it.getPosition() }
        val winnerCars = cars.filter { it.getPosition() == maxPosition }
        val winnerNames = winnerCars.joinToString(", ") { it.getName() }

        println("Winners : $winnerNames")
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
