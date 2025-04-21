package racingcar

import camp.nextstep.edu.missionutils.Randoms

data class Car(val name: String, var position: Int = 0) {

    init {
        require(name.length <= 5) { "Car name cannot exceed 5 characters." }
        require(name.isNotBlank()) { "Car name cannot be blank." }
    }

    fun move() {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        if (randomNumber >= 4) {
            position++
        }
    }

    fun getPositionString(): String {
        return "-".repeat(position)
    }

    override fun toString(): String {
        return "$name : ${getPositionString()}"
    }
}
