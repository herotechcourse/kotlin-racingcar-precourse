package racingcar.domain

import racingcar.domain.ErrorMessages.CAR_NAME_MISSING
import racingcar.domain.ErrorMessages.CAR_NAME_TOO_LONG

class Car(name: String) {
    val name: String
    private var position: Int = 0

    init {
        validateName(name)
        this.name = name
    }

    fun move(d: Int) {
        position += d
    }

    fun getPosition(): Int = position

    private fun validateName(name: String) {
        if(name.isBlank()) {
            throw IllegalArgumentException(CAR_NAME_MISSING)
        }

        if(name.length > 5) {
            throw IllegalArgumentException(CAR_NAME_TOO_LONG)
        }
    }
}
