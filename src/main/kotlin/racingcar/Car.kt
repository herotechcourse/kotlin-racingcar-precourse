package racingcar

import camp.nextstep.edu.missionutils.Randoms

data class Car(val name: String, val position: Int = 0) {
    init {
        require(isValidNameLength(name.length)) {
            "Car name cannot exceed 5 characters, current name length: ${name.length}"
        }
    }

    private fun isValidNameLength(nameLength: Int): Boolean = nameLength <= 5

    fun move(shouldMove: Boolean): Car = if (shouldMove) this.copy(position = position + 1) else this

    val shouldMove: Boolean = Randoms.pickNumberInRange(0, 9) >= 4
}
