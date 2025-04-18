package racingcar.backend.domain

class Race(
    val car: Car,
    val position: MutableList<String> = mutableListOf(),
) {
    private val lastPosition: String
        get() = this.position.lastOrNull() ?: ""

    fun move() {
        this.position.add("$lastPosition-")
    }

    fun stay() {
        this.position.add(lastPosition)
    }
}