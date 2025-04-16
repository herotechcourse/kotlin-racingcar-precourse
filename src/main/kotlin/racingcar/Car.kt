package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(name: String) {
    init {
        fun isValidNameLength(nameLength : Int) : Boolean = nameLength <= 5

        require(isValidNameLength(name.length)) {
            "Car name cannot exceed 5 characters, current name length: ${name.length} "
        }
    }

    private var position = 0

    fun move(randomNumber: Int = Randoms.pickNumberInRange(0, 9)) {
        if (randomNumber >= 4) {
          position++
        }
    }

    fun position() : Int = position
}
