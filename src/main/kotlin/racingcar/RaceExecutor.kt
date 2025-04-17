package racingcar

import camp.nextstep.edu.missionutils.Randoms

const val FORWARD = "Forward"
const val STAY = "Stay"

object RaceExecutor {
    fun execute(carList: List<Car>, numberOfRounds: Int) {
       startRace(carList, numberOfRounds)
       displayWinners(carList)
    }

    fun startRace(carList: List<Car>, numberOfRounds: Int) {
        print("Race Results")

        repeat(numberOfRounds) {
            carList.forEach { car ->
                moveCar(car)
                dispalyStats(car)
            }
        }
    }

    fun moveCar(car: Car) {
        if (randomCarMovement() == FORWARD) {
            car.moveForward()
        }
    }

    fun dispalyStats(car: Car) {
        print("${car.name} : ${car.getPositionBar()}")
    }

    fun displayWinners(carList: List<Car>) {
        val maxPosition = carList.maxOf { it.position }
        val winners = carList.filter { it.position == maxPosition }
        val winnersName = winners.joinToString(", ") { it.name }
        
        print("Winners : $winnersName")
    }

    fun randomCarMovement(): String{
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        return if (randomNumber >= 4) {
            FORWARD
        } else {
            STAY
        }
    }


}