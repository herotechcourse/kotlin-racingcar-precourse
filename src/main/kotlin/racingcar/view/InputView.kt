package racingcar.view

// using object = only one instance (like singleton)
// this one doesn't need to store any data, just handles input
object InputView {

    // messages to show before getting input
    // using const so it's easier to manage later
    private const val INPUT_CAR_NAMES_MESSAGE = "Enter the names of the cars (comma-separated):"
    private const val INPUT_ROUND_COUNT_MESSAGE = "How many rounds will be played?"

    // get car names from user input
    // returns the raw input as a string
    fun readCarNames(): String {
        println(INPUT_CAR_NAMES_MESSAGE)
        return readln()
    }

    // get number of rounds from user input
    // returns the input as a string (will parse later)
    fun readNumberOfRounds(): String {
        println(INPUT_ROUND_COUNT_MESSAGE)
        return readln()
    }
}
