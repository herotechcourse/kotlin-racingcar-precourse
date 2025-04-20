package racingcar.backend.domain

class Race(
    val car: Car,
    val position: MutableList<String> = mutableListOf(),
) {
    private val lastPosition: String
        get() = this.position.lastOrNull() ?: ""

    fun movingForward() {
        this.position.add("$lastPosition-")
    }

    fun stop() {
        this.position.add(lastPosition)
    }
}