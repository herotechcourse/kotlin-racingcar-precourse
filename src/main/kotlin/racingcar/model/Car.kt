package racingcar.model

import racingcar.util.RandomsWrapper

data class Car(
    val name: String,
    var position: Int = 0
) {
    fun tryMove() {
        if (RandomsWrapper.next() >= 4) {
            position++
        }
    }
}
