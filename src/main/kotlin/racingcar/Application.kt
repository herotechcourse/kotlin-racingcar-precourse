package racingcar

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        print("Enter the names of the cars (comma-separated):\n")
        val players = readlnOrNull() ?: ""
        val names = players.split(",").map {
            val name = it.trim()
            if (name.length > 5) {
                throw IllegalArgumentException("Car name '$name' is too long. Max 5 characters allowed.")
            }
            name
        }
        print("How many rounds will be played?\n")
        val rounds = readlnOrNull() ?: ""
        val laps = rounds.toInt()
    }
}


