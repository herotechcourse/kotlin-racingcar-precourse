package racingcar.domain

import racingcar.domain.ErroMessages.NAME_BLANK
import racingcar.domain.ErroMessages.NAME_TOO_LONG

class Car(name: String) {
    val name: String
    private var position: Int = 0

    init {
        validateName(name)
        this.name = name
    }

    fun getPosition(): Int = position

    private fun validateName(name: String) {
        if(name.isBlank()) {
            throw IllegalArgumentException(NAME_BLANK)
        }

        if(name.length > 5) {
            throw IllegalArgumentException(NAME_TOO_LONG)
        }
    }
}
