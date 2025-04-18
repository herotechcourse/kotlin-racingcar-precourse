package racingcar.domain

import racingcar.service.movement.MovementStrategy

data class Car(val name: String, val position: Int = 0) {
    init {
        require(name.length <= 5) { "이름은 5자 이하여야 합니다" }
        require(name.isNotEmpty()) { "이름은 비어있을 수 없습니다" }
    }

    fun move(strategy: MovementStrategy): Car {
        return if (strategy.shouldMove()) {
            this.copy(position = position + 1)
        } else {
            this
        }
    }

    fun display(): String {
        return "$name : ${"-".repeat(position)}"
    }
}