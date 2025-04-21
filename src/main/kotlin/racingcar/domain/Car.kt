package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms
import kotlin.random.Random

data class Car(
    val name: String,
    var position: Int = 0,
    private val randomPick: () -> Int = { Randoms.pickNumberInRange(0, 9) }
) {
    init {
        require(name.isNotBlank() && name.length <= 5) {
            "Car name must be 1-5 characters long"
        }
    }

    fun move() {
        if (randomPick() >= 4) {
            position++
        }
    }

    fun progress(): String = "-".repeat(position)
}
