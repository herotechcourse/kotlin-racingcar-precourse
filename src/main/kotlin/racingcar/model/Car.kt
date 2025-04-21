package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Car(
    val name: String,
    private val randomNumberGenerator : () -> Int = { Randoms.pickNumberInRange(0, 9) },
    ) {

    var position: Int = 0

    init {
        require(name.isNotBlank()) { "Car name cannot be blank" }
        require(name.length <= 5) { "Car name cannot be longer than 5 characters" }
    }

    fun move() {
        if (isMovable(randomNumberGenerator())) {
            position++
        }
    }

    private fun isMovable(number: Int): Boolean {
        return number >= 4
    }
}
