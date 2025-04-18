package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms
class Car (private val name: String) {
    init {
        require(name.length <=5) {"Car name cannot exceed 5 characters"}
    }
    private var position: Int = 0

    fun move() {
        if (Randoms.pickNumberInRange(0,9) >= 4) {
            position++
        }
    }
    fun getPosition(): Int = position

    fun getName(): String = name
}