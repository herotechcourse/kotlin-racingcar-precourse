package racingcar

/**
 * Handles user input for the racing game.
 */
class InputHandler {

    companion object {
        val CARS_NAME_REQUEST_MESSAGE = "Enter the names of the cars (comma-separated):"
        val ROUND_REQUEST_MESSAGE = "How many rounds will be played?"
    }

    /**
     * Prompts the user to enter car names and returns them as a list of strings.
     * The car names should be separated by commas.
     *
     * @return a list of car names entered by the user
     */
    fun getCarsName(): List<String> {
        println(CARS_NAME_REQUEST_MESSAGE)
        val input = readln()
        val carsName = input.split(",").map {it.trim()}
        return carsName
    }

    /**
     * Prompts the user to enter the number of rounds and returns it as a string.
     *
     * @return the number of rounds entered by the user
     */
    fun getRound(): String {
        println(ROUND_REQUEST_MESSAGE)
        val round = readln()
        return round
    }
}