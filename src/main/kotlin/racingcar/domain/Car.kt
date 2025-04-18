package racingcar.domain

import racingcar.io.InputValidator

class Car(
    private val name: String,
    private var position: Int,
    private val engine: Engine
) {
    init {
        InputValidator.validateCarName(name)
    }

    fun goForward() {
        position += engine.move()
    }

    fun getPosition(): Int {
        return position
    }

    fun getName(): String {
        return name
    }
}