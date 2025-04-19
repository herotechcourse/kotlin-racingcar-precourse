package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Race {
    fun executeOneRound(cars: List<Car>) {
        cars.forEach { car ->
            if (shouldMove())
                car.move()
        }
    }

    private fun shouldMove(): Boolean {
        return Randoms.pickNumberInRange(0, 9) >= 4
    }
}