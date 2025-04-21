package racingcar.domain

class Car(
    private val name: String,
    private var position: Int = 0
) {
    fun getPosition(): Int = position

    fun getName(): String = name
}