package racingcar

class Car(
        private val name: String,
        private var movesMade: Int = 0,
) {
    // implicitly throws IllegalArgumentException
    init {
        require(name.isNotBlank()) { "Each car must have a name" }
        require(name.length <= MAX_NAME_LENGTH) { "Names can't exceed $MAX_NAME_LENGTH characters" }
    }

    fun getName(): String = name
    fun getMovesMade(): Int = movesMade

    fun move() {
        movesMade++
    }

    fun printRoundStatus() {
        println("${name} : ${MOVE_SYMBOL.repeat(movesMade)}")
    }

    companion object {
        private const val MAX_NAME_LENGTH: Int = 5
        private val MOVE_SYMBOL: String = "-"
    }
}
