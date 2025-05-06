package racingcar

class InputHandler {

    companion object {
        val CARS_NAME_REQUEST_MESSAGE = "Enter the names of the cars (comma-separated):"
        val ROUND_REQUEST_MESSAGE = "How many rounds will be played?"
    }

    fun getCarsName(): List<String> {
        println(CARS_NAME_REQUEST_MESSAGE)
        val input = readln()
        val carsName = input.split(",").map {it.trim()}
        return carsName
    }

    fun getRound(): String {
        println(ROUND_REQUEST_MESSAGE)
        val round = readln()
        return round
    }
}