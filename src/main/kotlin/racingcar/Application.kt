package racingcar

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        print("Enter the names of the cars (comma-separated):\n")
        val players = readlnOrNull() ?: ""
        val names = players.split(",").map {it.trim()}

        print("How many rounds will be played?\n")
        val rounds = readlnOrNull() ?: ""
        val laps = rounds.toInt()
    }
}


