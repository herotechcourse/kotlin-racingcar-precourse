package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

data class Car(
    val name: String,
    var position: Int = 0
) {
    fun tryMove() {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        if (randomNumber >= 4) {
            position++
        }
    }
}
