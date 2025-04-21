package racingcar.view
import camp.nextstep.edu.missionutils.Console

class ConsoleInputModule : InputModule {
    // 1. Read carNames
    override fun readCarNames(): String {
        println("Enter the names of the cars (comma-separated):")
        val carNames = Console.readLine()
        return carNames
    }

    // 2. Read rounds
    override fun readRounds(): String {
        println("How many rounds will be played?")
        val nRounds = Console.readLine()
        return nRounds
    }
}