package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class Car (
    private val name: String,
    private val randomProvider: () -> Int = {Randoms.pickNumberInRange (0,9)}
) {
    init {
        require(name.isNotBlank() && name.length <= 5) { "Car name '$name' must be 1-5 characters" }
    }

    private var position = 0
    fun getPosition(): Int = position
    fun getName(): String = name


    fun move() {
        if (randomProvider() >= 4) {
            position++
        }
    }

        override fun toString(): String = "$name : ${"-".repeat(position)}"

}
