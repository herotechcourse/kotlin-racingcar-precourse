package racingcar.view

object InputView {
    fun readCarName(): List<String> {
        print("Enter the names of the cars (comma-separated):\n")
        val players = readlnOrNull() ?: ""
        return players.split(",").map {
            val name = it.trim()
            if (name.length > 5) {
                throw IllegalArgumentException("Car name '$name' is too long. Max 5 characters allowed.")
            }
            name
        }
    }

    fun readRoundCount(): Int {
        print("How many rounds will be played?\n")
        val rounds = readlnOrNull() ?: ""
        return rounds.toInt()
    }
}
