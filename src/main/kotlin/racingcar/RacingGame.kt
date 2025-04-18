package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingGame(val carNames: List<String>, val round: Int) {
    private val cars: List<Car> = carNames.map { Car(it) }

    fun startGame() {
        println("Race Results")
        for (i in 1..round) {
            for (car in cars){
                val randomNum = generateRandomNumber()
                car.moveForward(randomNum)
            }
            for (car in cars){
                car.displayPosition()
            }
            println()
        }
        val maxPosition = cars.maxOf { it.getPosition() }
        val winnerCars = cars.filter { it.getPosition() == maxPosition }
        val winnerNames = winnerCars.joinToString(", ") { it.getName() }

        println("Winners : $winnerNames")
    }

    private fun generateRandomNumber(): Int{
        return Randoms.pickNumberInRange(0, 9)
    }
}
