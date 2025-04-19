package racingcar.view
import camp.nextstep.edu.missionutils.Console

interface Display {
    fun getValidNames(): List<String>
    fun getValidRounds(): Int
}

class ConsoleDisplay : Display {
    private val validator = Validator()
    override fun getValidNames(): List<String> {
        while (true) {
            println("Enter the names of the cars (comma-separated):")
            val input = Console.readLine()
            val names = input.split(",").map { it.trim() }
            try {
                validator.validateNames(names)
                return names
            } catch (err: IllegalArgumentException) {
                println(err.message)
            }
        }
    }
    override fun getValidRounds(): Int {
        while (true) {
            println("How many rounds will be played?")
            val rounds = Console.readLine()
            try {
                validator.validateRounds(rounds)
                val roundsInt = rounds.toInt()
                return roundsInt
            } catch (err: IllegalArgumentException) {
                println(err.message)
            }
        }
    }

}
