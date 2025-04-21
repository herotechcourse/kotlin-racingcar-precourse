package racingcar.input

object ConsoleView : InputView {
    override fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated): ")
        val carInput = readln()
        return carInput.split(",")
    }

    override fun readRound(): String {
        println("How many rounds will be played?")
        return readln()
    }
}