package domain

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.Car

class Race(carNames: List<String>) {
    companion object {
        private const val MOVE_THRESHOLD = 4
    }

    val cars: List<Car> = carNames.map { name -> Car(name) }

    fun playRound() {
        for(car in cars) {
            val moveCondition = (Randoms.pickNumberInRange(0, 9) >= MOVE_THRESHOLD) 
            if(moveCondition) car.move()
        }
    }

    fun getWinners(): List<String> {
        val winners = mutableListOf<String>()
        var winnerPosition = 0

        for(car in cars) {
            if(car.position > winnerPosition) {
                winners.clear()
                winners.add(car.name)
                winnerPosition = car.position
            } else if(car.position == winnerPosition) {
                winners.add(car.name)
            }
        }

        return winners
  }
}
