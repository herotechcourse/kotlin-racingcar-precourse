package racingcar

data class Car(
    val name: String,
    val position: Int = 0
) {
    fun movedForward(): Car = copy(position = position + 1)

    override fun toString(): String = "$name : ${"-".repeat(position)}"
}