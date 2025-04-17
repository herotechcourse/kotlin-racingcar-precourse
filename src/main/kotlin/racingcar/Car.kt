package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(
    val carName: String,
    private var position: Int = 0
) {

    fun moveCar(pickNumber: () -> Int = { Randoms.pickNumberInRange(0, 9) }) {
        val movingPace = pickNumber()
        if (movingPace >= 4) position++
    }

    fun getPosition(): Int = position
}
