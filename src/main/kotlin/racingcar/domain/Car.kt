package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms


data class Car(val name: String, var position: Int = 0) {

    init {
        require(!name.contains(" ")) { "Car name cannot contain spaces." }
        require(name.isNotEmpty()) { "Car name cannot be empty." }
        require(name.length <= 5) { "Car name cannot exceed 5 characters." }
    }

    fun moveRandomly(): Car {
        return if (isMovable()) {
            position += 1
            this
        } else {
            this
        }
    }

    private fun isMovable(): Boolean {
        return Randoms.pickNumberInRange(0, 9) >= 4
    }
}