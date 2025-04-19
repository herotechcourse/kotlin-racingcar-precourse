package racingcar.model

data class Car(val name: String, val position: Int = 0) {
    fun move(random: Int): Car {
        return if (random >= 4) Car(name, position + 1) else this
    }

    fun progress(): String = "-".repeat(position)
}
