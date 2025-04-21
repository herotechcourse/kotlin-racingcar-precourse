package racingcar.model

data class Car(val name: String, val position: Int = 0) {
    init {
        require(name.length <= 5) { "Car name must be 5 characters or fewer." }
    }

    fun move(number: Int): Car {
        return if (number >= 4) this.copy(position = position + 1) else this
    }
}
