package racingcar.car

import camp.nextstep.edu.missionutils.Randoms

class Car(val carName: String) {
    init {
        require(carName.length < 5)
    }
    var position: String = ""

    fun drive(): String {
        val randomNumber = Randoms.pickNumberInRange(0,9)
        if (randomNumber > 3) {
            position += "-"
        }
        return position
    }
}