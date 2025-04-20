package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(
    val name: String,
    private var distance: Int = 0,
    private val numberGenerator: () -> Int = { Randoms.pickNumberInRange(0, 9) }
) {
    fun move() {
        if (numberGenerator() >= 4) distance++
    }

    fun getDistance() = distance

    fun displayPosition() {
        println("$name : ${"-".repeat(distance)}")
    }
}