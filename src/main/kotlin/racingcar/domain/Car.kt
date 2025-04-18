package racingcar.domain

import racingcar.InputValidator

class Car(
    private val name: String,
    private var position: Int,
    private val engine: Engine
) {
    init {
        InputValidator.validateCarName(name)
    }

    fun getPosition(): Int = position
    fun getName(): String = name

    fun goForward() {
        position += engine.move()
    }
}