package racingcar

val CARS_NAME_REQUEST_MESSAGE = "Enter the names of the cars (comma-separated):"

/**
 * Handles user input for the racing game.
 */
class InputHandler {

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
}