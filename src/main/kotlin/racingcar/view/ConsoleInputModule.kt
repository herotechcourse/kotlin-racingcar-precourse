package racingcar.view

class ConsoleInputModule : InputModule {
    // 1. Read carNames
    override fun readCarNames(): String {
        println("Enter the names of the cars (comma-separated):")
        val carNames = readLine()
        if (carNames == null) {
            return ""
        }
        return carNames
    }
    // 2. Read rounds
    override fun readRounds(): String {
        println("How many rounds will be played?")
        val nRounds = readLine()
        if (nRounds == null) {
            return ""
        }
        return nRounds
    }
}