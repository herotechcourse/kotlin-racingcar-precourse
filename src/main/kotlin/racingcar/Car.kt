package racingcar

class Car(
        private val name: String,
        private var movesMade: Int = 0,
) {
    companion object {
        private const val MAX_NAME_LENGTH: Int = 5
        private val MOVE_SYMBOL: String = "-"
    }

	//implicitly throws IllegalArgumentException
    init {
        require(name.isNotBlank()) { "Each car must have a name" }
        require(name.length <= MAX_NAME_LENGTH) { "Names can't exceed $MAX_NAME_LENGTH characters" }
    }

    fun move() {
        movesMade++
    }

    fun printRoundStatus()
    {
        var counter: Int = 0
        // print("${name} : ${MOVE_SYMBOL.repeat(movesMade)}")

        print("$name: ")
        while (counter < movesMade)
        {
            print("-")
            counter++;
        }
        println("")
    }

    fun getName(): String = name

    fun getMovesTotal(): Int = movesMade
}
