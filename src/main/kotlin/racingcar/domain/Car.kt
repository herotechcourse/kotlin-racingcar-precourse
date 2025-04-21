package racingcar.domain

import racingcar.util.RandomUtils

class Car(
    val name: String,
    var position: Int = 0
) {
    fun race(){
        val num = RandomUtils.randomNumber(0, 9)
        if (num >= 4) {
            position += 1
        }
    }
}