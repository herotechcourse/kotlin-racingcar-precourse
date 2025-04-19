package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Racetrack(cars: List<Car>) {
    fun generateRandomNumber(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }
}
