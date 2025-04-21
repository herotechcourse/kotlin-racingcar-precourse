package racingcar.model

data class Car(val name: String, var position: Int = 0) {

    fun move(shouldMove: Boolean) {
        if (shouldMove) position++
    }

    fun getProgress(): String {
        return "-".repeat(position)
    }

}